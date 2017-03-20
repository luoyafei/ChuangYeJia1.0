package com.chuangyejia.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserTempShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getUserInIdAction")
@Scope("prototype")
public class GetUserInIdAction extends ActionSupport {

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
	
	
	private String mark;
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(mark != null && mark.trim().hashCode() != 0) {
			
			UserTempShow uts = us.getUserTempShowInId(mark);
			
			if(uts != null) {
				ServletActionContext.getRequest().setAttribute("uts", uts);
				if(phone != null && phone.equals("0"))
						return "successPhone";
				return SUCCESS;
			} else 
				return NONE;
			
		} else {
			return NONE;
		}
	}

	
	/**
	 * 跨域字段
	 */
	private String callback;
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public void getUserDetailForPhone() {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		
		if(mark != null && mark.trim().hashCode() != 0) {
			
			UserTempShow uts = us.getUserTempShowInId(mark);
		
			if(uts != null) {
				jo.addProperty("success", true);
				jo.add("uts", gson.toJsonTree(uts));	
			} else {
				jo.addProperty("success", false);
				jo.addProperty("reason", "查无此人!");
			}
		} else {
			jo.addProperty("success", false);
			jo.addProperty("reason", "mark is null !");
		}
		
		try {
			if(callback != null && callback.equals("userDetailJsonpCallback")) {
				response.getWriter().print(callback + "(" + jo.toString() + ")");
			} else
				response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
