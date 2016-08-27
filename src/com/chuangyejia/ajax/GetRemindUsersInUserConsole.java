package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IChatMessageService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="getRemindUsers")
@Scope("prototype")
public class GetRemindUsersInUserConsole extends ActionSupport {






	private IChatMessageService cms;
	
	public IChatMessageService getCms() {
		return cms;
	}
	@Resource(name="cms")
	public void setCms(IChatMessageService cms) {
		this.cms = cms;
	}

	
	public void getRemindUsers() {
		
		User user = (User)ServletActionContext.getRequest().getSession();
		Gson gson = new Gson();
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
			List<User> users = cms.getAllNotReadChatMessages(user.getUserId(), 0);
			if(users != null && users.size() != 0) {
				
				String[] userCount = new String[users.size()];
				for(int i = 0; i < users.size(); i++) {
					userCount[i] = cms.getNotReadChatMessagesCount(user.getUserId(), users.get(i).getUserId(), 0).toString();
				}
				jo.add("remindUsers", gson.toJsonTree(users));
				jo.add("userCount", gson.toJsonTree(userCount));
				jo.addProperty("remindSuccess", true);
			}
		} else
			jo.addProperty("remindSuccess", false);
		
		out.println(jo.toString());
			
		out.flush();
		out.close();
		
		return;
	}
}
