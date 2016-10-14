package com.chuangyejia.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="uploadUserPicture")
@Scope("prototype")
public class UploadUserPicture extends ActionSupport {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	/**
	 * 图片存入数据库中的地址
	 */
	private static final String DB = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlVir");
	private static final String IDENTIFY_DB = ServletActionContext.getServletContext().getInitParameter("userRealPhotoVir");
	/**
	 * 图片实际存入硬盘的地址
	 */
	private static final String DISK = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDisk");
	private static final String IDENTIFY_DISK = ServletActionContext.getServletContext().getInitParameter("userRealPhotoDisk");
	/**
	 * 图片的默认地址
	 */
	private static final String DEFAULT = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDef");
	
	
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
	
	/**
	 * 用来处理上传认证图片
	 */
	public void uploadIdentify() {
		
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
			String url = IDENTIFY_DISK + pictureFileName;
			/**
			 * 根据全路径，将文件创建出来。
			 */
			File file = new File(url);
			
			/**
			 * 标识，创建文件是否成功
			 * 使用上传文件工具类
			 */
			boolean create = UploadFileUtil.justDoIt(picture, file);

			/**
			 * 如果创建成功，则进行往数据库用户表中更新
			 */
			if(create) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute("user");
				
				/**
				 * 先将之前的认证图片保存出来
				 */
				String oldPictureUrl = user.getUserRealPhoto();
				String oldIsVerify = user.getIsVerify();
				/*
				 * 将刚上传的认证图片进行set入user
				 */
				user.setUserRealPhoto(IDENTIFY_DB + pictureFileName);
				user.setIsVerify("3");//正在认证
				boolean result = us.updateUser(user);

				if(result) {
					session.setAttribute("user", user);
					jo.addProperty("status", true);
					jo.addProperty("pictureUrl", IDENTIFY_DB + pictureFileName);
					/**
					 * 插入成功后，将原图像删除
					 */
					if(oldPictureUrl.hashCode() != 0) {
						String oldPictureName = oldPictureUrl.split("/")[4];//将名字截取出来

						String oldPictureDisk = IDENTIFY_DISK + oldPictureName;
						File oldFile = new File(oldPictureDisk);
						if(oldFile.exists())
							oldFile.delete();
					}
					
				} else {
					user.setUserPhoto(oldPictureUrl);
					user.setIsVerify(oldIsVerify);
					jo.addProperty("status", false);
					if(file.exists())
						file.delete();
				}
					
			} else
				jo.addProperty("status", false);
			
		} else
			jo.addProperty("status", false);
		
		out.println(jo.toString());
		out.flush();
		out.close();
	}
	
	
	
	
	/**
	 * 处理用户上传头像操作
	 */
	public void uploadPicture() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		
		JsonObject jo = new JsonObject();
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
System.out.println("用户上传头像时，获取输出的管道出错");
			e.printStackTrace();
		}
		
		
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
			 */
			boolean create = UploadFileUtil.justDoIt(picture, file);
			
			/**
			 * 如果创建成功，则进行往数据库用户表中更新
			 */
			if(create) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute("user");
				
				/**
				 * 先将之前的头像保存出来
				 */
				String oldPictureUrl = user.getUserPhoto();
				
				user.setUserPhoto(DB + pictureFileName);
				
				boolean result = us.updateUser(user);

				if(result) {
					session.setAttribute("user", user);
					jo.addProperty("status", true);
					jo.addProperty("pictureUrl", DB + pictureFileName);
					/**
					 * 插入成功后，将原图像删除
					 */
					if(!oldPictureUrl.equals(DEFAULT)) {
						String oldPictureName = oldPictureUrl.split("/")[3];
						String oldPictureDisk = DISK + oldPictureName;
						File oldFile = new File(oldPictureDisk);
						if(oldFile.exists())
							oldFile.delete();
					}
					
				} else {
					user.setUserPhoto(oldPictureUrl);
					jo.addProperty("status", false);
					if(file.exists())
						file.delete();
				}
					
			} else
				jo.addProperty("status", false);
			
		} else
			jo.addProperty("status", false);
		
		out.println(jo.toString());
		out.flush();
		out.close();
		
	}
	
}
