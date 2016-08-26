package com.chuangyejia.ajax;

import java.io.IOException;
import java.util.List;

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

@Component(value="supportFourStartupsAction")
@Scope("prototype")
public class SupportFourStartupsAction extends ActionSupport {


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
	
	
	private String sort = "startupsCreateDate";
	private String start = "0";
	private String length = "4";
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void getStartups() {
		
		/**
		 * 暂时前台尚未提供该功能，先直接赋值，
		 */
		
		int startTrue = 0;
		int lengthTrue = 4;
		try {
			startTrue = Integer.parseInt(start);
			lengthTrue = Integer.parseInt(length);
		} catch (Exception e) {
			startTrue = 0;
			lengthTrue = 4;
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		
		
		List<StartupsTempShow> startupsTempList = ss.getStartupTempShows(startTrue, lengthTrue, sort);
		int count = ss.getAllStartupsCount();
		
		for(int i = 0; i < startupsTempList.size(); i++) {
			startupsTempList.get(i).setCopartner(null);
			startupsTempList.get(i).getStartupsLeader().setAllJoinStartups(null);
			startupsTempList.get(i).getStartupsLeader().setAllLeaderStartups(null);
		}
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		jo.add("stl", gson.toJsonTree(startupsTempList));
		jo.addProperty("count", count);

		try {
			response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
