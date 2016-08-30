package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IChatMessageService;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getAllNotReadCount")
@Scope("prototype")
public class GetAllNotReadCountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IChatMessageService cms;
	public IChatMessageService getCms() {
		return cms;
	}
	@Resource(name="cms")
	public void setCms(IChatMessageService cms) {
		this.cms = cms;
	}
	
	public void getAllNotReadCount() {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		JsonObject jo = new JsonObject();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(user != null) {
			Long count = cms.getAllNotReadChatMessageCounts(user.getUserId(), 0);
			jo.addProperty("remindAllCount", count.toString());
		} else
			jo.addProperty("remindAllCount", 0);
		
		out.println(jo.toString());
			
		out.flush();
		out.close();
		
		return;
	}

}
