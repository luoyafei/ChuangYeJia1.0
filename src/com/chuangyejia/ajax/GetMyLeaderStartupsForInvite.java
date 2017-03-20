package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IStartupsService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getMyLeaderStartupsForInvite")
@Scope("prototype")
public class GetMyLeaderStartupsForInvite extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IStartupsService ss;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	
	public void justDoIt() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		boolean success = false;
		try {
			out = response.getWriter();
		} catch(IOException e) {
System.out.println("GetMyLeaderStartupsForInvite.java 中获取输出管道出错");
			e.printStackTrace();
		}
		
		if(user != null) {
			List<Startups> leaderS = ss.getStartupsInLeaderId(user.getUserId());
			
			for(int i = 0; i < leaderS.size(); i++) {
				leaderS.get(i).setStartupsLeader(null);
				leaderS.get(i).setCopartner(null);
				leaderS.get(i).setStartupsCreateDate(null);
				leaderS.get(i).setStartupsBrief(null);
				leaderS.get(i).setStartupsDetail(null);
				leaderS.get(i).setStartupsServiceType(null);
				leaderS.get(i).setStartupsAddress(null);
				leaderS.get(i).setStartupsAccount(null);
				leaderS.get(i).setStartupsPassword(null);
				leaderS.get(i).setStartupsCopartnerRequire(null);
				leaderS.get(i).setStartupsOperationStage(null);
				leaderS.get(i).setStartupsCover(null);
				leaderS.get(i).setStartupsPhoto1(null);
				leaderS.get(i).setStartupsPhoto2(null);
				leaderS.get(i).setStartupsPhoto3(null);
			}
			success = true;
			jo.add("leaderS", gson.toJsonTree(leaderS));
		}
		jo.addProperty("success", success);
		
		out.print(jo);
		out.flush();
		out.close();
	}

}
