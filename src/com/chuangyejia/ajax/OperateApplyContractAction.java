package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ApplyContract;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IApplyContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.StartupsTempShow;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="operateApplyContractAction")
@Scope("prototype")
public class OperateApplyContractAction extends ActionSupport {


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

	
	
	private ApplyContract ac;
	private String applyId;
	
	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/**
	 * 在操纵之前，先得确保得到的申请合同中的公司，必须是操作者所创建的！
	 * @return
	 */
	private boolean checkApplyIdCanOperate() {
		
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null) {
			return false;
		}
		
		ac = acs.getApplyContractInApplyId(applyId);
		
		StartupsTempShow sts = ss.getStartupsTempShowInId(ac.getApplyStartupsId());
		if(sts == null || !user.getUserId().equals(sts.getStartupsLeader().getUserId())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 接收合同的操作
	 */
	public void receiveUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("OperateApplyContractAction.java处理用户申请，接受的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean operateSuccess = false;
		
		if(checkApplyIdCanOperate()) {
			
			ac.setApplyStatus("已接受");
			if(acs.updateApplyContract(ac)) {
				/**
				 * 如果更新申请合同成功后，就进行将该合伙人加入公司！
				 */
				Startups startups = ss.getStartupsInId(ac.getApplyStartupsId());
				startups.getCopartner().add(us.getUserInId(ac.getApplyOrganiserId()));
				
				/**
				 * 如何加入公司成功，则success设为true
				 * 反之，将申请合同打回原形！
				 */
				if(ss.updateStartups(startups)) {
					operateSuccess = true;
				} else {
					ac.setApplyStatus("正在审核");
					acs.updateApplyContract(ac);
				}
			}
		}
		jo.addProperty("operateSuccess", operateSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 拒绝合同的操作
	 */
	public void refuseUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("OperateApplyContractAction.java处理用户拒绝，拒绝的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean operateSuccess = false;
			
		if(checkApplyIdCanOperate()) {
			ac.setApplyStatus("已拒绝");
			if(acs.updateApplyContract(ac)) {
				operateSuccess = true;
			}
		}
		jo.addProperty("operateSuccess", operateSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	/**
	 * 我创建的申请合同，取消合同的操作
	 */
	public void quitApply() {
		ac = acs.getApplyContractInApplyId(applyId);
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
		boolean operateSuccess = false;
		
		/**
		 * 必须得确保准备删除的申请合同，是自己所创建的！
		 */
		if(ac.getApplyOrganiserId().equals(user.getUserId())) {
			if(acs.deleteApplyContract(ac)) {
				operateSuccess = true;
			}
		}		
			
		jo.addProperty("operateSuccess", operateSuccess);
		
		out.print(jo.toString());
		out.flush();
		out.close();
		
	}
}
