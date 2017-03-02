package com.chuangyejia.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IOrderService;
import com.chuangyejia.tools.SendMessageUtil;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="dealOrder")
@Scope(value="prototype")
public class DealOrder extends ActionSupport {

	private IOrderService ios;
	public IOrderService getIos() {
		return ios;
	}
	@Resource(name="iosi")
	public void setIos(IOrderService ios) {
		this.ios = ios;
	}
	
	private String createdOrderId;
	public String getCreatedOrderId() {
		return createdOrderId;
	}
	public void setCreatedOrderId(String createdOrderId) {
		this.createdOrderId = createdOrderId;
	}
	
	
	/**
	 * 图片存入数据库中的地址
	 */
	private static final String Certificate_DB = ServletActionContext.getServletContext().getInitParameter("userRealPhotoVir");
	/**
	 * 图片实际存入硬盘的地址
	 */
	private static final String Certificate_DISK = ServletActionContext.getServletContext().getInitParameter("userRealPhotoDisk");
	
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	
	private String receivedOrderId;
	public String getReceivedOrderId() {
		return receivedOrderId;
	}
	public void setReceivedOrderId(String receivedOrderId) {
		this.receivedOrderId = receivedOrderId;
	}
	
	
	/**
	 * 更新订单的卖家服务凭证
	 */
	public void uploadCertificate() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		
		JsonObject jo = new JsonObject();
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
System.out.println("用户上传认证图片时，获取输出的管道出错");
			e.printStackTrace();
		}
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		Order order = ios.getOrder(receivedOrderId);
		/**
		 * 保证传输过来的是图片
		 */
		if(pictureContentType.split("/")[0].equals("image") && user != null && order != null) {
			/**
			 * 自定义上传的图像名
			 */
			pictureFileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
			
			/**
			 * 获取存入硬盘的具体地址
			 */
			String url = Certificate_DISK + user.getUserId() + File.separator + pictureFileName;
			/**
			 * 根据全路径，将文件创建出来。
			 */
			File file = new File(url);
			file.getParentFile().mkdirs();
			/**
			 * 标识，创建文件是否成功
			 * 使用上传文件工具类
			 */
			boolean create = UploadFileUtil.justDoIt(picture, file);

			/**
			 * 如果创建成功，则进行往数据库用户表中更新
			 */
			if(create) {
				/*
				 * 将刚上传的凭证设入订单
				 */
				order.setCertificate(Certificate_DB + user.getUserId() + File.separator + pictureFileName);
				order.setIsSigned("2");
				boolean result = ios.updateOrders(new Order[]{order});
				jo.addProperty("status", result);
					
			} else
				jo.addProperty("status", false);
			
		} else
			jo.addProperty("status", false);
		
		out.println(jo.toString());
		out.flush();
		out.close();
	}
	
	
	/**
	 * 订单进行的更新状态
	 * @return
	 */
	public String execute() {
		
		Order[] orders = (Order[]) ServletActionContext.getRequest().getSession().getAttribute("orders");
		boolean up = ios.updateOrders(orders);//进行订单的更新
//System.out.println(up + "  , " + orders[0].getStatus());
		if(orders[0].getStatus().equals("2")) {
			SendMessageUtil send = SendMessageUtil.newInstance();
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			if(send.sendSeller(user.getUserTel())) {
				System.out.println("成功发送短信给卖家！");
			}
			return SUCCESS;
		} else
			return ERROR;
	}
	
	public void overService() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		
		User user = (User) request.getSession().getAttribute("user");
		PrintWriter out = null; 
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		boolean success = true;
		
		if(user != null) {
			Order o = ios.getOrder(createdOrderId);
			if(o.getUserid().getUserId().equals(user.getUserId())) {
				/**
				 * 将订单设置为已签收
				 */
				o.setIsSigned("1");
				if(!ios.updateOrders(new Order[]{o})) {
					success = false;
				}
			} else
				success = false;
		} else
			success = false;
		jo.addProperty("success", success);
		out.print(jo.toString());
		out.flush();
		out.close();
		
		return;
	}
	
	
}
