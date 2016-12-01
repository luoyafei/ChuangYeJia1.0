package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.DownLineChat;
import com.chuangyejia.bean.User;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("downLineAction")
@Scope("prototype")
public class DownLineAction extends ActionSupport {

	private String toUserId;
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
	public void justDoit() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		boolean success = true;
		String reason = "";
		
		if(toUserId != null && toUserId.length() == 32) {
			
			User fromUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			if(fromUser != null) {
				User toUser = hibernateTemplate.get(User.class, toUserId);
				if(toUser != null) {
					DownLineChat downLineChat = new DownLineChat();
					downLineChat.setFromUserId(fromUser);
					downLineChat.setToUserId(toUser);
					downLineChat.setCreateDate(new Timestamp(System.currentTimeMillis()));

					try {
						hibernateTemplate.saveOrUpdate(downLineChat);
					} catch(DataAccessException e) {
						success = false;
						reason = "线下邀谈出错！请刷新重试！谢谢合作！";
						e.printStackTrace();
					}
					
				} else {
					success = false;
					reason = "被请求用户不存在！请刷新重试！谢谢合作！";
				}
			} else {
				success = false;
				reason = "请您先进行登陆操作！谢谢合作！";
			}
		} else {
			success = false;
			reason = "被请求用户Id出错！请刷新重试！谢谢合作！";
		}
		
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		out.print(jo.toString());
		out.flush();
		out.close();
	}
}
