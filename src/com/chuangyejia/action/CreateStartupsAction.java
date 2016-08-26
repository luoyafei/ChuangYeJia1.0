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
				File cover = img[0];
				File photo1 = img[1];
				File photo2 = img[2];
				File photo3 = img[3];
				
				Startups startups = sd.toStartups();
				
				if(imgCanUse(cover, photo1, photo2, photo3)) {
					/**
					 * 自定义上传的图像名
					 */
					String imgCover = UUID.randomUUID().toString().replace("-", "") + ".jpg";
					String imgPhoto1 = UUID.randomUUID().toString().replace("-", "") + ".jpg";
					String imgPhoto2 = UUID.randomUUID().toString().replace("-", "") + ".jpg";
					String imgPhoto3 = UUID.randomUUID().toString().replace("-", "") + ".jpg";
					
					/**
					 * 获取存入硬盘的具体地址
					 */
					String coverUrl = DISK_COVER + imgCover;
					String photo1Url = DISK_PHOTO + imgPhoto1;
					String photo2Url = DISK_PHOTO + imgPhoto2;
					String photo3Url = DISK_PHOTO + imgPhoto3;
					
					/**
					 * 根据全路径，将文件创建出来。
					 */
					File fileCover = new File(coverUrl);
					File filePhoto1 = new File(photo1Url);
					File filePhoto2 = new File(photo2Url);
					File filePhoto3 = new File(photo3Url);
					
					/**
					 * 标识，创建文件是否成功
					 * 使用上传文件工具类
					 */
					boolean create_cover = UploadFileUtil.justDoIt(cover, fileCover);
					boolean create_photo1 = UploadFileUtil.justDoIt(photo1, filePhoto1);
					boolean create_photo2 = UploadFileUtil.justDoIt(photo2, filePhoto2);
					boolean create_photo3 = UploadFileUtil.justDoIt(photo3, filePhoto3);
					
					
					/**
					 * 如果创建成功，则进行往数据库用户表中更新
					 */
					if(create_cover && create_photo1 && create_photo2 && create_photo3) {
						/**
						 * 获取存入数据库的地址
						 */
						String db_cover = DB_COVER + imgCover;
						String db_photo1 = DB_PHOTO + imgPhoto1;
						String db_photo2 = DB_PHOTO + imgPhoto2;
						String db_photo3 = DB_PHOTO + imgPhoto3;
						
						startups.setStartupsCover(db_cover);
						startups.setStartupsPhoto1(db_photo1);
						startups.setStartupsPhoto2(db_photo2);
						startups.setStartupsPhoto3(db_photo3);
						
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
							removeImg(fileCover, filePhoto1, filePhoto2, filePhoto3);
							return INPUT;
						}
						
					} else {
						this.addFieldError("error", "图片上传出错！请刷新重试");
						/**
						 * 将已经上传到硬盘上的图片删除
						 */
						removeImg(fileCover, filePhoto1, filePhoto2, filePhoto3);
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
	
	private boolean imgCanUse(File cover, File photo1, File photo2, File photo3) {
		
		/**
		 * 保证传过来的是图片
		 */
		if(imgContentType[0].split("/")[0].equals("image") && imgContentType[1].split("/")[0].equals("image") && imgContentType[2].split("/")[0].equals("image") && imgContentType[3].split("/")[0].equals("image")) {
		
			/**
			 * 保证图片传过来是完整的图片
			 */
			if(cover.length() != 0 && photo1.length() != 0 && photo2.length() != 0 && photo3.length() != 0) {
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
	public void removeImg(File cover, File photo1, File photo2, File photo3) {
		if(cover.exists())
			cover.delete();
		if(photo1.exists())
			photo1.delete();
		if(photo2.exists())
			photo2.delete();
		if(photo3.exists())
			photo3.delete();
	}
	
}
