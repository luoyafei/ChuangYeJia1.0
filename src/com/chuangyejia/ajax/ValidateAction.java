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
import com.opensymphony.xwork2.ActionSupport;

@Component(value="validateAction")
@Scope("prototype")
public class ValidateAction extends ActionSupport {

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
	
}
