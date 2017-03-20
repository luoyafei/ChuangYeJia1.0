package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="validateAction")
@Scope("prototype")
public class ValidateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String IsLogin = "validateIsLoginJsonpCallback";//用于手机端的底栏我的，进行验证是否登陆
	private static final String LoginValidate = "validateJsonpCallback";//进行手机端的用户登陆的验证
	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	private String tel;
	private String email;
	private String password;
	private String identifyCode;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	
	public void checkTel() {
		boolean flag = false;
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println("异步验证电话号码时，获取输出管道出错！");
			e.printStackTrace();
		}
		
		/**
		 * 检测数据库中是否存在该email
		 * true 存在，
		 * false 不存在
		 */
		User user = us.getUserInTel(tel);
		if(user != null) {
			flag = true;
			/**
			 * 将该验证用户的userTemp存入session，以备后面提交时验证，防止二次加载，浪费性能
			 */
			ServletActionContext.getRequest().getSession().setAttribute("userTemp", user);
		} else
			flag = false;
		
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 过时的方法；使用邮箱验证
	 */
	@SuppressWarnings("unused")
	private void checkEmail_email() {
		boolean flag = false;
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println("异步验证邮箱时，获取输出管道出错！");
			e.printStackTrace();
		}
		
		/**
		 * 检测数据库中是否存在该email
		 * true 存在，
		 * false 不存在
		 */
		flag = us.checkEmail(email);
		
		out.print(flag);
		out.flush();
		out.close();
	}
	
	public void checkEandP() {}
	
	public void checkIdentifyCode() {
		
		boolean flag = false;
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println("异步验证验证码时，获取输出管道出错！");
			e.printStackTrace();
		}
		
		/**
		 * 使用正则表达式来匹配，收到的identifyCode必须是数字！
		 */
		flag = identifyCode.matches("[-]?[0-9]*");
		if(flag) {
			flag = identifyCode.equals(ServletActionContext.getRequest().getSession().getAttribute("code").toString());
		}
		
		out.print(flag);
		
		out.flush();
		out.close();
	}
	
	/**
	 * 跨域字段
	 */
	private String callback;
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	/**
	 * 手机端的登陆
	 */
	public void loginForPhone() {
		
		boolean flag = false;
		String reason = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {}
		
		/**
		 * 使用正则表达式来匹配，收到的identifyCode必须是数字！
		 */
		flag = identifyCode.matches("[-]?[0-9]*");
		if(flag) {
			flag = identifyCode.equals(ServletActionContext.getRequest().getSession().getAttribute("code").toString());
			if(flag) {
				User user = new User();
				user.setUserTel(tel);
				user.setUserPassword(password);
				user = us.checkTelAndPassword(user);
				if(user == null) {
					flag = false;
					reason = "密码错误";
				} else
					ServletActionContext.getRequest().getSession().setAttribute("user", user);
			} else
				reason = "验证码错误";
		} else
			reason = "验证码错误";
		JsonObject jo = new JsonObject();
		jo.addProperty("flag", flag);
		jo.addProperty("reason", reason);
		/**
		 * 增加手机端跨域跳转
		 */
		try {
			if(callback != null && callback.equals(LoginValidate)) {
				response.getWriter().print(callback + "(" + jo.toString() + ")");
			} else
				response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}
	
	
	/**
	 * 手机端验证是否登陆 的action
	 */
	public void isLogin() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {}

		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		if(user != null)
			jo.add("user", gson.toJsonTree(user.toUserTempShowOnlyUser()));
		jo.addProperty("flag", user != null);
		if(callback != null && callback.equals(IsLogin)) {
			out.print(callback + "(" + jo.toString() + ")");
		} else
			out.print(jo.toString());
		
		out.flush();
		out.close();
	}
	/**
	 * 手机端的登出
	 */
	public void signOut() {
		ServletActionContext.getRequest().getSession().setAttribute("user", null);		
	}
}
