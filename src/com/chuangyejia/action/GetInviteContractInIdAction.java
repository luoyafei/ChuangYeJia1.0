package com.chuangyejia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.InviteContract;
import com.chuangyejia.service.IInviteContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getInviteContractInIdAction")
@Scope("prototype")
public class GetInviteContractInIdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IInviteContractService ics;
	private IStartupsService ss;
	private IUserService us;
	
	public IInviteContractService getIcs() {
		return ics;
	}
	@Resource(name="ics")
	public void setIcs(IInviteContractService ics) {
		this.ics = ics;
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
	
	
	private String inviteId;
	
	public String getInviteId() {
		return inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}


	public String JustDoIt() {
		if(ServletActionContext.getRequest().getSession().getAttribute("user") != null && inviteId != null && inviteId.trim().hashCode() != 0) {
			
			InviteContract inviteContract = ics.getInviteContractInInviteId(inviteId);
			
			if(inviteContract == null) 
				return NONE;
			else {
				String startupsId = inviteContract.getInviteOrganiserStartupsId();
				String userId = inviteContract.getInviteUserId();

				StartupsTempShow inviteStartups = ss.getStartupsTempShowInId(startupsId);
				UserTempShow inviteUser = us.getUserTempShowInId(userId);
				
				ServletActionContext.getRequest().setAttribute("inviteContract", inviteContract);
				ServletActionContext.getRequest().setAttribute("inviteStartups", inviteStartups);
				ServletActionContext.getRequest().setAttribute("inviteUser", inviteUser);
				return SUCCESS;
			}
			
		} else {
			return NONE;
		}
	}
	
	
}
