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
import com.chuangyejia.tools.StartupsTempShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="getStartupsInUserConsole")
@Scope("prototype")
public class GetStartupsInUserConsole  extends ActionSupport{


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
	
	
	public void getStartupsList() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		boolean success = false;
		
		if(user != null) {
			try {
				out = response.getWriter();
			} catch(IOException e) {
System.out.println("GetStartupsInUserConsole.java 中获取输出管道出错");
				e.printStackTrace();
			}
			
			
			List<Startups> leaderS = ss.getStartupsInLeaderId(user.getUserId());
			List<StartupsTempShow> joinS = ss.getStartupsInCopartnerId(user.getUserId());
			for(int i = 0; i < joinS.size(); i++) {
				joinS.get(i).getStartupsLeader().setAllJoinStartups(null);
				joinS.get(i).getStartupsLeader().setAllLeaderStartups(null);
				joinS.get(i).setCopartner(null);
			}
			for(int i = 0; i < leaderS.size(); i++) {
				leaderS.get(i).setCopartner(null);
				leaderS.get(i).getStartupsLeader().setAllJoinStartups(null);
				leaderS.get(i).getStartupsLeader().setAllLeaderStartups(null);
			}
			
			success = true;
			
			jo.add("leaderS", gson.toJsonTree(leaderS));
			jo.add("joinS", gson.toJsonTree(joinS));
		}
		jo.addProperty("success", success);
		
//System.out.println(jo.toString());
		out.print(jo);
		out.flush();
		out.close();
	}

}
