package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IOrderService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="getMyOrderConsoleAction")
@Scope(value="prototype")
public class GetMyOrderConsoleAction extends ActionSupport {

	private IOrderService ios;
	public IOrderService getIos() {
		return ios;
	}
	@Resource(name="iosi")
	public void setIos(IOrderService ios) {
		this.ios = ios;
	}

	public void fetchMyOrders() throws UnsupportedEncodingException {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		User user = (User) request.getSession().getAttribute("user");
		PrintWriter out = null; 
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		boolean success = true;
		
		Order[] createdOrders = null;
		Order[] receivedOrders = null;
		
		if(user != null) {
			/**
			 * 获取所有成功创建到的的订单
			 * 隐藏字段
			 */
			createdOrders = ios.getOrdersByUserId(user.getUserId(), "2");
			receivedOrders = ios.getOrdersBySellerId(user.getUserId(), "2", "0");
		} else
			success = false;
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		jo.addProperty("success", success);
		jo.add("createdOrders", gson.toJsonTree(createdOrders));
		jo.add("receivedOrders", gson.toJsonTree(receivedOrders));
		
		out.println(jo.toString());
		out.flush();
		out.close();
		return;
	}
	
}
