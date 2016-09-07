package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IProductService;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="removeProductInIdAction")
@Scope("prototype")
public class RemoveProductInIdAction extends ActionSupport {

	private String item;
	
	private User user;
	private JsonObject jo;
	private HttpServletResponse response;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	private IProductService ps;
	
	public IProductService getPs() {
		return ps;
	}
	@Resource(name="ps")
	public void setPs(IProductService ps) {
		this.ps = ps;
	}
	
	
	public RemoveProductInIdAction() {
		super();
		user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		jo = new JsonObject();
		response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
	}

	public void justDoIt() {
		
		PrintWriter out = null;
		boolean success = false;
		try {out = response.getWriter();} catch(IOException e) {e.printStackTrace();}
		Product product = ps.getProductInId(item);
		if(item != null && item.trim().hashCode() != 0 && user != null && product != null && user.getUserId().equals(product.getProductStartups().getStartupsLeader().getUserId())) {
			if(ps.deleteProduct(product)) {
				success = true;
			}
		}
		
		jo.addProperty("success", success);
		out.print(jo.toString());
		out.flush();
		out.close();
		
	}
}
