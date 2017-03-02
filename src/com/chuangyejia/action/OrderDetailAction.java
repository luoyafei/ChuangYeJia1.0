package com.chuangyejia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IOrderService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="orderDetail")
@Scope(value="prototype")
public class OrderDetailAction extends ActionSupport {

	private String citem;
	private String ritem;
	public String getCitem() {
		return citem;
	}
	public void setCitem(String citem) {
		this.citem = citem;
	}
	public String getRitem() {
		return ritem;
	}
	public void setRitem(String ritem) {
		this.ritem = ritem;
	}

	private IOrderService ios;
	public IOrderService getIos() {
		return ios;
	}
	@Resource(name="iosi")
	public void setIos(IOrderService ios) {
		this.ios = ios;
	}
	
	private final String CREATE_DETAIL = "create";
	private final String RECEIVE_DETAIL = "receive";
	@Override
	public String execute() {
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(user != null) {
			if(citem != null && citem.length() == 32) {
				Order o = ios.getOrder(citem);
				ServletActionContext.getRequest().setAttribute("citem", o);
			
				return CREATE_DETAIL;
			} else if(ritem != null && ritem.length() == 32) {
				Order o = ios.getOrder(ritem);
				ServletActionContext.getRequest().setAttribute("ritem", o);				
				return RECEIVE_DETAIL;
			}
		} 
		return ERROR;
	}
}
