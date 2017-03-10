package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IProductService;
import com.chuangyejia.service.IStartupsService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getProductsInStartupsIdAction")
@Scope("prototype")
public class GetProductsInStartupsIdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IProductService ps;
	private IStartupsService ss;
	public IProductService getPs() {
		return ps;
	}
	@Resource(name="ps")
	public void setPs(IProductService ps) {
		this.ps = ps;
	}
	
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	
	
	private String startupsId = null;//获取从展示Startups的页面的请求
	private boolean fromConsole = false;//用来获取从控制台来的请求
	
	public String getStartupsId() {
		return startupsId;
	}
	public void setStartupsId(String startupsId) {
		this.startupsId = startupsId;
	}
	
	public boolean isFromConsole() {
		return fromConsole;
	}
	public void setFromConsole(boolean fromConsole) {
		this.fromConsole = fromConsole;
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
	public void getProductsInStartups() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("GetProductInStartupsIdAction中获取输出管道出错！");
		}
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		
		boolean success = false;
		
		if(startupsId != null && startupsId.trim().hashCode() != 0 && !fromConsole) {
			List<Product> prs = ps.getProductsInStartupsId(startupsId);
			for(int i = 0; i < prs.size(); i++)
				prs.get(i).setProductStartups(null);
			jo.add("ps", gson.toJsonTree(prs));
			success = true;
		}
		jo.addProperty("success", success);
		
		/**
		 * 增加手机端跨域跳转
		 */
		if(callback != null && callback.equals("productsJsonpCallback")) {
			out.print(callback + "(" + jo.toString() + ")");
		} else
			out.print(jo.toString());
		
		out.flush();
		out.close();
	}
	
	public void getProductsInConsoleForUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("GetProductInStartupsIdAction中获取输出管道出错！");
		}
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		
		boolean success = false;
		if(user != null && startupsId == null && fromConsole) {
			
			List<Startups> startups = ss.getStartupsInLeaderId(user.getUserId());
			List<Product> psList = new ArrayList<Product>();
			if(startups != null && startups.size() > 0) {
				for(int i = 0; i < startups.size(); i++) {
					List<Product> prs = ps.getProductsInStartupsId(startups.get(i).getStartupsId());
					if(prs != null && prs.size() > 0)
						psList.addAll(prs);
				}
				for(int i = 0; i < psList.size(); i++)
					psList.get(i).setProductStartups(null);
				jo.add("ps", gson.toJsonTree(psList));
				success = true;
				
			}
			
			
		}
		
		jo.addProperty("success", success);
		out.print(jo.toString());
		
		out.flush();
		out.close();
	}
}
