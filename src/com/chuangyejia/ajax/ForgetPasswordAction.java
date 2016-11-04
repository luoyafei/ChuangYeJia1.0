package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="forgetPasswordAction")
@Scope("prototype")
public class ForgetPasswordAction extends ActionSupport {

	private final static String emailPattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	private final static String telPattern = "[\\d]{11}";
	
	private String email;
	private String tel;
	private IUserService us;
	
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
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	public void justDoIt() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		
		if(tel != null && tel.matches(telPattern) && us.getUserInTel(tel) != null) {
			boolean success = true;
			
			/**
			 * 暂时尚未提供短信服务
			 */
			success = false;
			String reason = "暂时尚未提供短信服务";
			
			if(success) {
				jo.addProperty("success", success);
			} else {
				jo.addProperty("success", success);
//				jo.addProperty("reason", "短信发送失败！请重试！");
				jo.addProperty("reason", reason);
			}
			
		} else {
			jo.addProperty("success", false);
			jo.addProperty("reason", "该电话号码尚未注册！请输入您忘记密码的电话号码！谢谢！");
		}
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * 过时的方法，使用邮箱找回密码
	 */
	@SuppressWarnings("unused")
	private void justDoIt_email() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		
		if(email != null && email.matches(emailPattern) && us.checkEmail(email)) {
			boolean success = true;
			
			Properties prop = new Properties();
			prop.setProperty("mail.host", "smtp.mxhichina.com");
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
//	        prop.setProperty("mail.smtp.port", "25");
	        //使用JavaMail发送邮件的5个步骤
	        //1、创建session
	        Session session = Session.getInstance(prop);
	        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	        //2、通过session得到transport对象
	        Transport ts = null;
			try {
				ts = session.getTransport();
				//3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
//				ts.connect("smtp.mxhichina.com", 587, "mailregister@chuangyejia.top", "yanchenguang123456..");
				ts.connect("smtp.mxhichina.com", "mailregister@chuangyejia.top", "yanchenguang123456..");
		      //4、创建邮件
				User user = us.getUserInEmail(email);
				
		        String mailContent = "您好！您在创业加平台，请求找回密码服务！现在将您的账号密码找回，请注意保存！您的密码为：" + user.getUserPassword() + "。感谢您的使用！祝您事业顺利！";
		        Message message = createSimpleMail(session, mailContent);
		      //5、发送邮件
		        ts.sendMessage(message, message.getAllRecipients());
		        ts.close();
		        
			} catch (NoSuchProviderException e) {
				success = false;
				e.printStackTrace();
			} catch (MessagingException e) {
				success = false;
				e.printStackTrace();
			} catch (Exception e) {
				success = false;
				e.printStackTrace();
			} finally {
				 try {
					if(ts != null)
						ts.close();	
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			
			if(success) {
				jo.addProperty("success", success);
			} else {
				jo.addProperty("success", success);
				jo.addProperty("reason", "邮件发送失败！请重试！");
			}
			
		} else {
			jo.addProperty("success", false);
			jo.addProperty("reason", "该邮箱尚未注册！请输入您忘记密码的邮箱！谢谢！");
		}
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	
	private MimeMessage createSimpleMail(Session session, String uuid)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("mailregister@chuangyejia.top"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //邮件的标题
        message.setSubject("来自创业加网站的注册邮箱验证码");
        //邮件的文本内容
        message.setContent(uuid, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }
}
