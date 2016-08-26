package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.dto.UserInfoDTO;
import com.chuangyejia.jsonbean.UserModifyAjaxReturnBean;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="userInfoModifyAction")
@Scope("prototype")
public class UserInfoModifyAction extends ActionSupport {

	

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
	
	
	UserInfoDTO uid;
	
	public UserInfoDTO getUid() {
		return uid;
	}

	public void setUid(UserInfoDTO uid) {
		this.uid = uid;
	}

	/**
	 * 异步修改用户的密码
	 */
	public void modifyPassword() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json; charset=utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
System.out.println("用户修改密码，通过ajax,UserInfoModifyAction的modifyPassword()方法，获取输出管道出错！");
			e.printStackTrace();
		}
		
		/**
		 * 通知dto对象，这个用户修改密码所接收的信息
		 */
		uid.setModifyPassword(true);
		/**
		 * 使用uto对象，进行简单的数据校验
		 * 获取通过json返回的bean对象，用来提供错误信息
		 */
		 UserModifyAjaxReturnBean error = uid.checkData();

		if(error.isSuccess()) {
			User user = (User)session.getAttribute("user");
			if(!user.getUserPassword().equals(uid.getPassword().trim())) {
				
				error.setPassword("原始密码输入错误！");
				error.setSuccess(false);
			} else {
				user.setUserPassword(uid.getNewPassword().trim());
				
				boolean result = us.updateUser(user);
				if(!result) {
					error.setUpdate("更新失败！");
					error.setSuccess(false);
				} else {
					error.setSuccess(true);
					session.setAttribute("user", user);
				}
			}
			
		} else
			error.setSuccess(false);
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		jo.add("error", gson.toJsonTree(error));
		
		out.print(jo.toString());
		
		out.flush();
		out.close();

	}
	
	/**
	 * 修改用户的基本信息
	 */
	public void modifyInfo() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");  
		HttpSession session = ServletActionContext.getRequest().getSession();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
System.out.println("用户修改信息，通过ajax,UserInfoModifyAction的modifyInfo()方法，获取输出管道出错！");
			e.printStackTrace();
		}
		
		/**
		 * 通知dto对象，这是用户修改资料接收来的数据
		 */
		uid.setModifyPassword(false);
		/**
		 * 使用uto对象，进行简单的数据校验
		 * 获取通过json返回的bean对象，用来提供错误信息
		 */
		 UserModifyAjaxReturnBean error = uid.checkData();

		if(error.isSuccess()) {
			
			
			User user = (User)session.getAttribute("user");
			
			User userToSave = user;
			
			String copartnerCategory = UserUtil.copartnerCategory[Integer.parseInt(uid.getCategory())];
			String userField = UserUtil.userField[Integer.parseInt(uid.getField())];
			
			userToSave.setUserNickName(uid.getNickname().trim());
			userToSave.setUserAddress(uid.getAddress().trim());
			userToSave.setUserIntroduce(uid.getProfile().trim());
			
			userToSave.setCopartnerCategory(copartnerCategory);
			userToSave.setUserField(userField);
			userToSave.setStartAbility(uid.getAbility());
			userToSave.setIntroduceVideo(uid.getVideo().trim());
			
			boolean result = us.updateUser(userToSave);
			if(!result) {
				error.setUpdate("更新失败！");
				error.setSuccess(false);
			} else {
				error.setSuccess(true);
				session.setAttribute("user", userToSave);
			}
			
		} else
			error.setSuccess(false);
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		jo.add("errorInfo", gson.toJsonTree(error));
		
		out.print(jo.toString());
		
		out.flush();
		out.close();
		
	}

}
