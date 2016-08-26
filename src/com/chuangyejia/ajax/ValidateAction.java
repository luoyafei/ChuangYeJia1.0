package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
	
	private String email;
	private String password;
	private String identifyCode;
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
	
	public void checkEmail() {
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
