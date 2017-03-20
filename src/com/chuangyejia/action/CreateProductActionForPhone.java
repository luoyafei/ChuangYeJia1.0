package com.chuangyejia.action;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IProductService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="createProductActionForPhone")
@Scope("prototype")
public class CreateProductActionForPhone extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStartupsService ss;
	private IProductService ps;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	public IProductService getPs() {
		return ps;
	}
	@Resource(name="ps")
	public void setPs(IProductService ps) {
		this.ps = ps;
	}

	
	
	/**
	 * 图片存入数据库中的地址
	 */
	private static final String DB = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlVir") + "product/";
	/**
	 * 图片实际存入硬盘的地址
	 */
	private static final String DISK = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDisk") + "product\\";
	/**
	 * 图片的默认地址
	 */
	@SuppressWarnings("unused")
	private static final String DEFAULT = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDef");
	private String productId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	private String name;
	private String address;
	private String detail;
	private String startups;
	private String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStartups() {
		return startups;
	}
	public void setStartups(String startups) {
		this.startups = startups;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		if(!price.contains("."))
			this.price = price + ".00";
		else
			this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
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
	
	private User user;
	
	public CreateProductActionForPhone() {
		super();
		user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	private String uploadPicture() {
		
		/**
		 * 保证传输过来的是图片
		 */
		if(pictureContentType.split("/")[0].equals("image")) {
			/**
			 * 自定义上传的图像名
			 */
			pictureFileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
			
			/**
			 * 获取存入硬盘的具体地址
			 */
			String url = DISK + pictureFileName;
			/**
			 * 根据全路径，将文件创建出来。
			 */
			File file = new File(url);
			
			/**
			 * 标识，创建文件是否成功
			 * 使用上传文件工具类
			 * 如果创建成功，则进行往数据库用户表中更新
			 */
			if(UploadFileUtil.justDoIt(picture, file)) {
				return pictureFileName;
			} else {
				if(file.exists())
					file.delete();
				return "false";
			}
		}
		return "false";
					
	}
	
	
	private boolean notNull(String data) {
		return data != null && data.trim().hashCode() !=0 ;
	}
	
	private boolean rightPriceFormat() {
		return price != null && price.length() < 13 && price.matches("\\d+\\.\\d+");
	}
	private boolean dataValidate() {
		
		return notNull(name) && notNull(address) && notNull(detail) && notNull(startups) && notNull(price) && rightPriceFormat(); 
	}
	public void createProduct() {
		
		Startups sS = ss.getStartupsInId(startups);
		boolean success = false;
		String error = "";
		if(user != null && dataValidate() && startups != null && sS.getStartupsLeader().getUserId().equals(user.getUserId())) {
			String result = uploadPicture();
			if(!result.equals("false")) {
				Product product = new Product();
				product.setProductName(name);
				product.setProductAddress(address);
				product.setProductCover(DB + result);
				product.setProductCreateDate(new Timestamp(System.currentTimeMillis()));
				product.setProductDetail(detail);
				product.setProductStartups(sS);
				product.setProductPrice(price);
				
				if(ps.saveProduct(product)) {
					this.productId = product.getProductId();
					success = true;
				} else
					error = "保存出错！请刷新重试！";
			} else
				error = "图片保存上传错误！请刷新重试！";
		} else 
			error = "数据填写出错！请刷新重试！";
		
		JsonObject jo = new JsonObject();
		jo.addProperty("success", success);
		jo.addProperty("error", error);
		
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().print(jo.toString());;
		} catch(IOException e) {}
	}
}
