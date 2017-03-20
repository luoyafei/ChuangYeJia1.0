package com.chuangyejia.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供根据产品Id，获取整个Product对象，放入request中
 * @author Diamond
 */
@Component(value="getProductInIdAction")
@Scope("prototype")
public class GetProductInIdAction extends ActionSupport {
	
	@Override
	public String toString() {
		return "GetProductInIdAction [item=" + item + ", upD=" + upD + ", toUpD=" + toUpD + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProductService ps;
	
	public IProductService getPs() {
		return ps;
	}
	@Resource(name="ps")
	public void setPs(IProductService ps) {
		this.ps = ps;
	}
	
	private String item;
	private String upD;//为了区分是从控制台传输过来的
	private String toUpD;//为了区分是从修改按钮传来的
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	private String flag;//用来接收action的重定向后修改的结果。
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getToUpD() {
		return toUpD;
	}
	public void setToUpD(String toUpD) {
		this.toUpD = toUpD;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public String getUpD() {
		return upD;
	}
	public void setUpD(String upD) {
		this.upD = upD;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(item != null && item.trim().hashCode() != 0 && upD == null && toUpD == null) {
			
			Product product = ps.getProductInId(item);
			if(product != null) {
				ServletActionContext.getRequest().setAttribute("product", product);
				if(phone != null && phone.equals("0"))
					return "successPhone";
				return SUCCESS;
			} else 
				return NONE;
			
		} else if(item != null && item.trim().hashCode() != 0 && upD != null && upD.trim().hashCode() != 0 && upD.equals("0") && toUpD == null) {
			User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
			Product product = ps.getProductInId(item);
			if(user.getUserId().equals(product.getProductStartups().getStartupsLeader().getUserId())) {
				ServletActionContext.getRequest().setAttribute("product", product);
				ServletActionContext.getRequest().setAttribute("update", true);
				return SUCCESS;
			} else
				return NONE;
		} else if(item != null && item.trim().hashCode() != 0 && toUpD != null && toUpD.trim().hashCode() != 0 && toUpD.equals("0") && upD == null) {
			User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
			Product product = ps.getProductInId(item);
			if(product != null && user != null &&  user.getUserId().equals(product.getProductStartups().getStartupsLeader().getUserId())) {
				ServletActionContext.getRequest().setAttribute("product", product);
				return "toupdate";
			} else
				return NONE;
		} else
			return NONE;
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
	/**
	 * 手机端获取产品信息
	 */
	public void getProductItemForPhone() {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		boolean success = false;
		String reason = "";
		if(item != null && item.trim().hashCode() != 0) {
			Product product = ps.getProductInId(item);
			//product.setProductStartups(null);
			if(product != null) {
				success = true;
				jo.add("product", gson.toJsonTree(product));
			} else {
				reason = "产品不存在";
			}
		} else {
			reason = "产品出错";
		}
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		
		try {
			if(callback != null && callback.equals("productDetailJsonpCallback")) {
				response.getWriter().print(callback + "(" + jo.toString() + ")");
			} else
				response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
