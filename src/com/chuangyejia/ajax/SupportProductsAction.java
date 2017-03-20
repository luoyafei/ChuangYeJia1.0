package com.chuangyejia.ajax;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.service.IProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="supportProductsAction")
@Scope("prototype")
public class SupportProductsAction extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IProductService ips;
	public IProductService getIps() {
		return ips;
	}
	@Resource(name="ps")
	public void setIps(IProductService ips) {
		this.ips = ips;
	}
	
	
	private String sort = "productCreateDate";
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
	public void getproducts() {
		
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
		
		
		List<Product> ps = ips.getProductsListToShow(startTrue, lengthTrue, sort);
		for(int i = 0; i < ps.size(); i++) {
			ps.get(i).setProductStartups(null);
		}
		int count = ips.getAllProductsCount();
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		jo.add("ps", gson.toJsonTree(ps));
		jo.addProperty("count", count);

		
		/**
		 * 增加手机端跨域跳转
		 */
		try {
			if(callback != null && callback.equals("productJsonpCallback")) {
				response.getWriter().print(callback + "(" + jo.toString() + ")");
			} else
				response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
