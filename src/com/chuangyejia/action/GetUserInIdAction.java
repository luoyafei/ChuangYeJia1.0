package com.chuangyejia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserTempShow;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getUserInIdAction")
@Scope("prototype")
public class GetUserInIdAction extends ActionSupport {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(mark != null && mark.trim().hashCode() != 0) {
			
			UserTempShow uts = us.getUserTempShowInId(mark);
			
			if(uts != null) {
				ServletActionContext.getRequest().setAttribute("uts", uts);
				return SUCCESS;
			} else 
				return NONE;
			
		} else {
			return NONE;
		}
	}

}
