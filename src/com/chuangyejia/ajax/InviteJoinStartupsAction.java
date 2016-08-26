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

import com.chuangyejia.bean.InviteContract;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IInviteContractService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="inviteJoinStartupsAction")
@Scope("prototype")
public class InviteJoinStartupsAction extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStartupsService ss;
	private IInviteContractService ics;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	public IInviteContractService getIcs() {
		return ics;
	}
	@Resource(name="ics")
	public void setIcs(IInviteContractService ics) {
		this.ics = ics;
	}

	
	
	
	
	private String name;
	private String content;
	private String startups;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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

	public void inviteJoin() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("InviteJoinStartupsAction.java处理用户申请的ajaxAction出错！获取输出管道出错！");
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
		 * 确保邀请的该用户并不是准备邀请加入的公司的成员。
		 */
		
		StartupsTempShow sts = ss.getStartupsTempShowInId(startups);
		boolean repeat = false;
		Set<UserTempShow> uts = sts.getCopartner();
		Iterator<UserTempShow> iterUts = uts.iterator();
		while(iterUts.hasNext()) {
			if(iterUts.next().getUserId().equals(userId)) {
				repeat = true;
				break;
			}
		}
		
		if(repeat) {
			success = false;
			jo.addProperty("success", success);
			jo.addProperty("reason", "该合伙人加入了该公司！请不要重复操作！");
			out.print(jo.toString());
			out.flush();
			out.close();
			return;
		}
		
		/**
		 * 当用户有一个该公司的邀请还未被该公司拒绝时(注：当公司接受时，用户会自动成为该公司的成员，所有不用考虑)
		 * 用户的邀请合同正处于  "正在审核" 状态时
		 * 该用户不能作为该公司的邀请对象
		 */
		
		boolean secondary = ics.canInviteContract(startups, userId, "正在审核");
		
		if(!secondary) {
			success = false;
			jo.addProperty("success", success);
			jo.addProperty("reason", "该合伙人于该公司尚有一份邀请合同正在审核！待审核结束后再操作！谢谢合作！");
			out.print(jo.toString());
			out.flush();
			out.close();
			return;
		}
		
		InviteContract ic = new InviteContract();
		
		ic.setInviteOrganiserStartupsId(startups);
		ic.setInviteTitle(name);
		ic.setInviteContent(content);
		ic.setInviteStatus("正在审核");
		ic.setInviteUserId(userId);
		
		
		if(ics.saveInviteContract(ic))
			success = true;
		else {
			success = false;
			jo.addProperty("reason", "邀请状态出错！请刷新重试！");
		}
		jo.addProperty("success", success);
		out.print(jo.toString());
		
		out.flush();
		out.close();
		return;
		
	}
	
	
}
