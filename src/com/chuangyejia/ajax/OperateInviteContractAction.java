package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.InviteContract;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IInviteContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.service.IUserService;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="operateInviteContractAction")
@Scope("prototype")
public class OperateInviteContractAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IInviteContractService ics;
	private IUserService us;
	private IStartupsService ss;
	public IInviteContractService getIcs() {
		return ics;
	}
	@Resource(name="ics")
	public void setIcs(IInviteContractService ics) {
		this.ics = ics;
	}
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	
	
	
	private InviteContract ic;
	
	private String inviteId;
	

	public String getInviteId() {
		return inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}

	/**
	 * 在操纵之前，先得确保得到的邀请合同，被邀请人是自己
	 * @return
	 */
	private boolean checkInviteIdCanOperate() {
		
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null) {
			return false;
		}
		
		
		ic = ics.getInviteContractInInviteId(inviteId);
		
		if(ic == null || !user.getUserId().equals(ic.getInviteUserId())) {
			return false;
		}

		return true;
	}
	
	/**
	 * 接收邀请合同的操作
	 */
	public void receiveStartups() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("OperateInviteContractAction.java处理公司邀请，接受的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean operateInviteSuccess = false;
		
		if(checkInviteIdCanOperate()) {

			ic.setInviteStatus("已接受");
			if(ics.updateInviteContract(ic)) {

				/**
				 * 如果更新邀请合同成功后，就进行将该合伙人加入公司！
				 */
				Startups startups = ss.getStartupsInId(ic.getInviteOrganiserStartupsId());
				startups.getCopartner().add(us.getUserInId(ic.getInviteUserId()));
				
				/**
				 * 如何加入公司成功，则operateInviteSuccess设为true
				 * 反之，将邀请合同打回原形！
				 */
				if(ss.updateStartups(startups)) {

					operateInviteSuccess = true;
				} else {
					ic.setInviteStatus("正在审核");
					ics.updateInviteContract(ic);
				}
			}
		}
		jo.addProperty("operateInviteSuccess", operateInviteSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 拒绝邀请合同的操作
	 */
	public void refuseStartups() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("OperateInviteContractAction.java处理公司邀请，拒绝的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean operateInviteSuccess = false;
			
		if(checkInviteIdCanOperate()) {

			ic.setInviteStatus("已拒绝");
			if(ics.updateInviteContract(ic)) {

				operateInviteSuccess = true;
			}
		}
		jo.addProperty("operateInviteSuccess", operateInviteSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	/**
	 * 我创建的邀请合同，取消合同的操作
	 */
	public void quitInvite() {
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("OperateApplyContractAction.java处理用户拒绝，拒绝的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean operateInviteSuccess = false;
		
		ic = ics.getInviteContractInInviteId(inviteId);
		
		
		if(user == null || ic == null || !user.getUserId().equals(ss.getStartupsTempShowInId(ic.getInviteOrganiserStartupsId()).getStartupsLeader().getUserId()))
			operateInviteSuccess = false;
		else
			operateInviteSuccess = ics.deleteInviteContract(ic);
		
		jo.addProperty("operateInviteSuccess", operateInviteSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
		
	}
}
