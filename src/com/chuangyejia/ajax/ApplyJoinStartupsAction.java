package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ApplyContract;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IApplyContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="applyJoinStartupsAction")
@Scope("prototype")
public class ApplyJoinStartupsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStartupsService ss;
	private IApplyContractService acs;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	public IApplyContractService getAcs() {
		return acs;
	}
	@Resource(name="acs")
	public void setAcs(IApplyContractService acs) {
		this.acs = acs;
	}
	
	
	
	private String name;
	private String content;
	private String startups;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartups() {
		return startups;
	}
	public void setStartups(String startups) {
		this.startups = startups;
	}

	public void applyJoin() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("ApplyJoinStartupsAction.java处理用户申请的ajaxAction出错！获取输出管道出错！");
			e.printStackTrace();
		}
		
		JsonObject jo = new JsonObject();
		boolean success = false;
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		User user = (User)session.getAttribute("user");
		

		if(user == null || name == null || content == null || startups == null ||name.trim().hashCode() == 0 || content.trim().hashCode() == 0 || startups.trim().hashCode() == 0) {
			success = false;
			jo.addProperty("success", success);
			jo.addProperty("reason", "所填信息不能为空！");
			out.print(jo.toString());
			out.flush();
			out.close();
			return;
		}
		
		
		/**
		 * 确保用户想要加入的公司，与该用户没有任何直接联系！
		 * 用既不是该公司的总监，也不能已经是该公司的成员了！
		 */
		StartupsTempShow sts = ss.getStartupsTempShowInId(startups);
		boolean repeat = false;
		if(sts.getStartupsLeader().getUserId().equals(user.getUserId()))
			repeat = true;
		else {
			Set<UserTempShow> utss = sts.getCopartner();
			Iterator<UserTempShow> iterUtss = utss.iterator();
			while(iterUtss.hasNext()) {
				if(iterUtss.next().getUserId().equals(user.getUserId()))
					repeat = true;
			}
		}
		
		if(repeat) {
			success = false;
			jo.addProperty("success", success);
			jo.addProperty("reason", "您已经加入了该公司！请不要重复操作！");
			out.print(jo.toString());
			out.flush();
			out.close();
			return;
		}
		
		/**
		 * 当用户有一个申请还未被公司拒绝时(注：当公司接受时，用户会自动成为该公司的成员，所有不用考虑)
		 * 用户的申请合同正处于  "正在审核" 状态时
		 * 用户不可以再次向该公司投放申请
		 */
		boolean secondary = acs.canApplyContract(user.getUserId(), startups, "正在审核");
		
		if(!secondary) {
			success = false;
			jo.addProperty("success", success);
			jo.addProperty("reason", "你尚有一份申请合同正在审核！待审核结束后再发！谢谢合作！");
			out.print(jo.toString());
			out.flush();
			out.close();
			return;
		}
		
		ApplyContract ac = new ApplyContract();
		
		ac.setApplyOrganiserId(user.getUserId());
		ac.setApplyStartupsId(startups);
		ac.setApplyTitle(name);
		ac.setApplyContent(content);
		
		if(acs.saveApplyContract(ac))
			success = true;
		else {
			success = false;
			jo.addProperty("reason", "申请状态出错！请刷新重试！");
		}
		jo.addProperty("success", success);
		out.print(jo.toString());
		out.flush();
		out.close();
		return;
		
	}
	
	
}
