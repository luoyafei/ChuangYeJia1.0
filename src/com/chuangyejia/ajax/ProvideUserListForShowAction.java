package com.chuangyejia.ajax;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserTempShowOnlyUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="provideUserListForShowAction")
@Scope("prototype")
public class ProvideUserListForShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] copartnerCategory = {
			 "其他"						//0 其他
			,"资金"						//1 资金
			,"技术"						//2技术
			,"推广"						//3推广
			,"运营"						//4运营
			,"null"						//5综合
	};
	
	/**
	 * 用来进行排序方式的操作
	 */
	private String sort;
	private String start;
	private String length;
	
	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}


	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	
	public void getUsers() {
		


		/**
		 * 暂时前台尚未提供该功能，先直接赋值，
		 */
		sort = "userId";
		int category;
		int startTrue;
		int lengthTrue;

		try {
			category = Integer.parseInt(start.split(",")[0]);
			startTrue = Integer.parseInt(start.split(",")[1]);
			lengthTrue = Integer.parseInt(length);
		} catch(NumberFormatException e) {
			category = 5;
			startTrue = 0;
			lengthTrue = 5;
		}

		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();

		switch(category) {
		case 0:
			int otherCount = us.getAllUsersCount(copartnerCategory[0]);
			if(startTrue < 0 || startTrue > otherCount)
				startTrue = 0;
			List<UserTempShowOnlyUser> other = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[0], sort);
			jo.add("other", gson.toJsonTree(other));
			jo.addProperty("otherCount", otherCount);
			break;
		case 1:
			int fundCount = us.getAllUsersCount(copartnerCategory[1]);
			if(startTrue < 0 || startTrue > fundCount)
				startTrue = 1;
			List<UserTempShowOnlyUser> fund = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[1], sort);
			jo.add("fund", gson.toJsonTree(fund));
			jo.addProperty("fundCount", fundCount);
			break;
		case 2:
			int technologyCount = us.getAllUsersCount(copartnerCategory[2]);
			if(startTrue < 0 || startTrue > technologyCount)
				startTrue = 1;
			List<UserTempShowOnlyUser> technology = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[2], sort);
			jo.add("technology", gson.toJsonTree(technology));
			jo.addProperty("technologyCount", technologyCount);
			break;
		case 3:
			int popularizeCount = us.getAllUsersCount(copartnerCategory[3]);
			if(startTrue < 0 || startTrue > popularizeCount)
				startTrue = 1;
			List<UserTempShowOnlyUser> popularize = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[3], sort);
			jo.add("popularize", gson.toJsonTree(popularize));
			jo.addProperty("popularizeCount", popularizeCount);
			break;
		case 4:
			int operationCount = us.getAllUsersCount(copartnerCategory[4]);
			if(startTrue < 0 || startTrue > operationCount)
				startTrue = 1;
			List<UserTempShowOnlyUser> operation = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[4], sort);
			jo.add("operation", gson.toJsonTree(operation));
			jo.addProperty("operationCount", operationCount);
			break;
		case 5:
			int allCount = us.getAllUsersCount(copartnerCategory[5]);
			if(startTrue < 0 || startTrue > allCount)
				startTrue = 1;
			List<UserTempShowOnlyUser> all = us.getUserTempShowOnlyUser(startTrue-1, lengthTrue, copartnerCategory[5], sort);
			jo.add("all", gson.toJsonTree(all));
			jo.addProperty("allCount", allCount);
			break;
		}
		
		try {
			response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
