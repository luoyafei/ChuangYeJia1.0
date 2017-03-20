package com.chuangyejia.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsTempShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供根据用户Id，获取整个Startups对象，放入request中
 * @author Diamond
 */
@Component(value="getStartupsInIdAction")
@Scope("prototype")
public class GetStartupsInIdAction extends ActionSupport {

	

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
	
	
	private String item;
	private String phone;
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(item != null && item.trim().hashCode() != 0) {
			
			StartupsTempShow sts = ss.getStartupsTempShowInId(item);
			if(sts != null) {
				ServletActionContext.getRequest().setAttribute("sts", sts);
				if(phone != null && phone.equals("0")) {
					return "successPhone";
				}
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
	public void getStartupsDetailForPhone() {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		if(item != null && item.trim().hashCode() != 0) {
			StartupsTempShow sts = ss.getStartupsTempShowInId(item);
			if(sts != null) {
				jo.addProperty("success", true);
				jo.add("sts", gson.toJsonTree(sts));	
			} else {
				jo.addProperty("success", false);
				jo.addProperty("reason", "无此公司!");
			}
		} else {
			jo.addProperty("success", false);
			jo.addProperty("reason", "item is null !");
		}
		
		try {
			if(callback != null && callback.equals("startupsDetailJsonpCallback")) {
				response.getWriter().print(callback + "(" + jo.toString() + ")");
			} else
				response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
