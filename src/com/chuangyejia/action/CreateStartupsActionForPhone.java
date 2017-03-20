package com.chuangyejia.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.dto.StartupsCreateDTO;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsUtil;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="createStartupsForPhoneAction")
@Scope("prototype")
public class CreateStartupsActionForPhone extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStartupsService ss;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}

	
	
	/**
	 * 公司封面存入数据库中的地址
	 */
	private static final String DB_COVER = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlVir") + "startups/cover/";
	/**
	 * 公司封面实际存入硬盘的地址
	 */
	private static final String DISK_COVER = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDisk") + "startups\\cover\\";
	
	/**
	 * 公司照片存入数据库中的地址
	 */
	private static final String DB_PHOTO = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlVir") + "startups/photo/";
	/**
	 * 公司照片实际存入硬盘的地址
	 */
	private static final String DISK_PHOTO = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDisk") + "startups\\photo\\";
	
	/**
	 * Logo图片的默认地址
	 */
	@SuppressWarnings("unused")
	private static final String DEFAULT = ServletActionContext.getServletContext().getInitParameter("defaultLogo");
	
	private StartupsCreateDTO sd;
	
	private HttpServletRequest request = null;
	private HttpSession session = null;
	
	
	private File imgForPhone;
	private String imgForPhoneFileName;
	private String imgForPhoneContentType;
	private String name;
	private String brief;
	private String detail;
	private String stage;
	
	public CreateStartupsActionForPhone() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
	}

	private boolean imgCanUse(File cover) {
		
		/**
		 * 保证传过来的是图片
		 */
		if(imgForPhoneContentType.split("/")[0].equals("image")) {
		
			/**
			 * 保证图片传过来是完整的图片
			 */
			if(cover.length() != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 当出现图片上传失败时，将已经上传上去的图片删除！
	 */
	public void removeImg(File cover) {
		if(cover.exists())
			cover.delete();
	}
	
	public File getImgForPhone() {
		return imgForPhone;
	}
	public void setImgForPhone(File imgForPhone) {
		this.imgForPhone = imgForPhone;
	}
	public String getImgForPhoneFileName() {
		return imgForPhoneFileName;
	}
	public void setImgForPhoneFileName(String imgForPhoneFileName) {
		this.imgForPhoneFileName = imgForPhoneFileName;
	}
	public String getImgForPhoneContentType() {
		return imgForPhoneContentType;
	}
	public void setImgForPhoneContentType(String imgForPhoneContentType) {
		this.imgForPhoneContentType = imgForPhoneContentType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	private boolean checkPhoneData() {
		return (name != null && name.trim() != "" && brief != null && brief.trim() != "" && detail != null && detail .trim() != "" && stage != null && stage.trim() != "");
	}
	/**
	 * 手机端的上传公司页面
	 */
	public void createStartupsForPhone() {

		User user = (User)session.getAttribute("user");
		String error = "";
		boolean success = false;
		if(user != null) {
			if(!checkPhoneData()) {
				error = "请按要求填写数据！";
			} else {
				File cover = imgForPhone;
				
				Startups startups = new Startups();
				
				startups.setStartupsName(name.trim());
				startups.setStartupsServiceType("其他");
				startups.setStartupsCopartnerRequire("暂无");
				String operationS = null;
				try {
					operationS = StartupsUtil.OperationStage[Integer.parseInt(stage)];
				} catch(NumberFormatException e) {
					operationS = "暂无";
				}
				startups.setStartupsOperationStage(operationS);
				startups.setStartupsBrief(brief.trim());
				startups.setStartupsDetail(detail.trim());
				
				if(imgCanUse(cover)) {
					/**
					 * 自定义上传的图像名
					 */
					String imgCover = UUID.randomUUID().toString().replace("-", "") + ".jpg";
					
					/**
					 * 获取存入硬盘的具体地址
					 */
					String coverUrl = DISK_COVER + imgCover;
					
					/**
					 * 根据全路径，将文件创建出来。
					 */
					File fileCover = new File(coverUrl);
					
					/**
					 * 标识，创建文件是否成功
					 * 使用上传文件工具类
					 */
					boolean create_cover = UploadFileUtil.justDoIt(cover, fileCover);
					
					/**
					 * 如果创建成功，则进行往数据库用户表中更新
					 */
					if(create_cover) {
						/**
						 * 获取存入数据库的地址
						 */
						String db_cover = DB_COVER + imgCover;
						
						startups.setStartupsCover(db_cover);
						
						/**
						 * 将用户user对象传入
						 */
						startups.setStartupsLeader(user);
						/**
						 * 进行公司的存储
						 */
						if(ss.saveStartups(startups)) {
							
							success = true;
						} else {
							error = "创建失败！请刷新重试";
							removeImg(fileCover);
							success = false;
						}
						
					} else {
						error = "图片上传出错！请刷新重试";
						/**
						 * 将已经上传到硬盘上的图片删除
						 */
						removeImg(fileCover);
						success = false;
					}
					
					
				} else {
					error = "图片输入错误！请换张图片";
					success = false;
				}
			}
		} else {
			error = "请登录后再进行创建！";
			success = false;
		}
		JsonObject jo = new JsonObject();
		jo.addProperty("success", success);
		jo.addProperty("error", error);
		
		try {
			ServletActionContext.getResponse().getWriter().print(jo.toString());;
		} catch(IOException e) {}
	}
}
