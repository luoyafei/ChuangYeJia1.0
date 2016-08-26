package com.chuangyejia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ApplyContract;
import com.chuangyejia.service.IApplyContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getApplyContractInIdAction")
@Scope("prototype")
public class GetApplyContractInIdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IApplyContractService acs;
	private IStartupsService ss;
	private IUserService us; 
	public IApplyContractService getAcs() {
		return acs;
	}
	@Resource(name="acs")
	public void setAcs(IApplyContractService acs) {
		this.acs = acs;
	}
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}


	private String applyId;
	
	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}


	public String JustDoIt() {
		if(ServletActionContext.getRequest().getSession().getAttribute("user") != null && applyId != null && applyId.trim().hashCode() != 0) {
			
			ApplyContract applyContract = acs.getApplyContractInApplyId(applyId);
			
			if(applyContract == null) 
				return NONE;
			else {
				
				String startupsId = applyContract.getApplyStartupsId();
				String userId = applyContract.getApplyOrganiserId();
				
				StartupsTempShow applyStartups = ss.getStartupsTempShowInId(startupsId);
				UserTempShow applyOrganiser = us.getUserTempShowInId(userId);
				
				ServletActionContext.getRequest().setAttribute("applyContract", applyContract);
				ServletActionContext.getRequest().setAttribute("applyStartups", applyStartups);
				ServletActionContext.getRequest().setAttribute("applyOrganiser", applyOrganiser);
				return SUCCESS;
			}
			
		} else {
			return NONE;
		}
	}
	
	
}
