package com.chuangyejia.action;

import java.io.File;
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
import com.chuangyejia.tools.UploadFileUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="createStartupsAction")
@Scope("prototype")
public class CreateStartupsAction extends ActionSupport {

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
	
	private String startupsId;
	
	private StartupsCreateDTO sd;
	
	private File[] img;
	private String[] imgFileName;
	private String[] imgContentType;
	
	private HttpServletRequest request = null;
	private HttpSession session = null;
	
	
	
	public CreateStartupsAction() {
		
		request = ServletActionContext.getRequest();
		session = request.getSession();
	}

	public File[] getImg() {
		return img;
	}

	public void setImg(File[] img) {
		this.img = img;
	}

	public String[] getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String[] getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String[] imgContentType) {
		this.imgContentType = imgContentType;
	}

	public StartupsCreateDTO getSd() {
		return sd;
	}

	public void setSd(StartupsCreateDTO sd) {
		this.sd = sd;
	}

	public String getStartupsId() {
		return startupsId;
	}

	public void setStartupsId(String startupsId) {
		this.startupsId = startupsId;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);

		User user = (User)session.getAttribute("user");
		if(user != null) {
			if(!sd.checkData()) {
				this.addFieldError("error", "请按要求填写数据！");
				return INPUT;
			} else {
				
				Startups startups = sd.toStartups();
				
				if(imgCanUse(img)) {
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
					boolean create_cover = UploadFileUtil.justDoIt(img[0], fileCover);
					
					//同上
					String[] imgPhotos = null;
					String[] photosUrl = null;
					File[] photoFiles = null;
					if(img.length > 1) {
						imgPhotos = new String[img.length - 1];
						photosUrl = new String[img.length - 1];
						photoFiles = new File[img.length - 1];
						for(int i = 0; i < imgPhotos.length; i++) {
							imgPhotos[i] = UUID.randomUUID().toString().replace("-", "") + ".jpg";
							photosUrl[i] = DISK_PHOTO + imgPhotos[i];
							photoFiles[i] = new File(photosUrl[i]);
							UploadFileUtil.justDoIt(img[i+1], photoFiles[i]);
						}
					}
					
					/**
					 * 如果封面创建成功，则进行往数据库用户表中更新
					 */
					if(create_cover) {
						/**
						 * 获取存入数据库的地址
						 */
						String db_cover = DB_COVER + imgCover;
						startups.setStartupsCover(db_cover);
						
						if(img.length == 2) {
							startups.setStartupsPhoto1(DB_PHOTO + imgPhotos[0]);
						} else if(img.length == 3) {
							startups.setStartupsPhoto1(DB_PHOTO + imgPhotos[0]);
							startups.setStartupsPhoto2(DB_PHOTO + imgPhotos[1]);
						} else if(img.length == 4) {
							startups.setStartupsPhoto1(DB_PHOTO + imgPhotos[0]);
							startups.setStartupsPhoto2(DB_PHOTO + imgPhotos[1]);
							startups.setStartupsPhoto3(DB_PHOTO + imgPhotos[3]);
						}
						
						/**
						 * 将用户user对象传入
						 */
						startups.setStartupsLeader(user);
						/**
						 * 进行公司的存储
						 */
						if(ss.saveStartups(startups)) {
							
							startupsId = startups.getStartupsId();
							return SUCCESS;
						} else {
							this.addFieldError("error", "创建失败！请刷新重试");
							removeImg(fileCover, photoFiles);
							return INPUT;
						}
						
					} else {
						this.addFieldError("error", "图片上传出错！请刷新重试");
						/**
						 * 将已经上传到硬盘上的图片删除
						 */
						removeImg(fileCover, photoFiles);
						return INPUT;
					}
					
					
				} else {
					this.addFieldError("error", "图片输入错误！请换张图片");
					return INPUT;
				}
			}
		} else {
			this.addFieldError("error", "请登录后再进行创建！");
			return INPUT;
		}
			
	}
	
	private boolean imgCanUse(File[] img) {
		
		if(img == null)
			return false;
		for(int j = 0; j < img.length; j++) {
			if(imgContentType[j].split("/")[0].equals("image")) {
				if(img[j].length() == 0 )
					return false;
			} else 
				return false;
		}
		return true;
	}
	
	/**
	 * 当出现图片上传失败时，将已经上传上去的图片删除！
	 */
	public void removeImg(File cover, File[] photos) {
		if(cover.exists())
			cover.delete();
		if(photos != null) {
			for(File f : photos) {
				if(f.exists())
					f.delete();
			}
		}
	}
}
