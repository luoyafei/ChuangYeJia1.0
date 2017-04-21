package com.chuangyejia.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.MicroRecord;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.dao.impl.MicroDaoImpl;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("submitData")
@Scope("prototype")
public class SubmitDataForMicroAction extends ActionSupport {

	
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
	
	
	private String startupsId;
	private IStartupsService ss;
	private MicroDaoImpl md;
	public String getStartupsId() {
		return startupsId;
	}
	public void setStartupsId(String startupsId) {
		this.startupsId = startupsId;
	}
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	public MicroDaoImpl getMd() {
		return md;
	}
	@Resource(name="md")
	public void setMd(MicroDaoImpl md) {
		this.md = md;
	}
	
	public void submit() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		JsonObject jo = new JsonObject();
		boolean success = false;
		String reason = "";
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null) {
			if(startupsId != null) {
				Startups s = ss.getStartupsInId(startupsId);
				if(s != null && s.getStartupsLeader().getUserId().equals(user.getUserId())) {
					
					if(uploadPic() != null) {
						MicroRecord mr = new MicroRecord();
						mr.setCreateDate(new Timestamp(System.currentTimeMillis()));
						mr.setDataAddress(uploadPic());
						mr.setStartupsId(s.getStartupsId());
						
						if(md.saveMicro(mr)) {
							success = true;
						} else
							reason = "存入失败";
					} else
						reason = "文件上传失败";
				} else
					reason = "公司为空";
			} else
				reason = "请选择公司";
		} else
			reason = "请先进行登陆";
		
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		
		out.print(jo.toString());
		
		out.flush();
		out.close();	
	}
	
	/**
	 * 存入数据库中的地址
	 */
	private static final String DB = ServletActionContext.getServletContext().getInitParameter("uploadDataVir");
	/**
	 * 实际存入硬盘的地址
	 */
	private static final String DISK = ServletActionContext.getServletContext().getInitParameter("uploadData");
	private String uploadPic() {
		File file = new File(DISK + pictureFileName);
		if(UploadFileUtil.justDoIt(picture, file))
			return DB + pictureFileName;
		else
			return null;
	}
}
