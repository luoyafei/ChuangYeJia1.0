package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="sendEmailAction")
@Scope("prototype")
public class SendEmailAction extends ActionSupport {

	private final static String emailPattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	
	
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void sendEmail() {
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession httpSession = ServletActionContext.getRequest().getSession();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean success = false;
		if(email != null && email.trim().hashCode() != 0 && email.matches(emailPattern)) {
	        
			Properties prop = new Properties();
			prop.setProperty("mail.host", "smtp.mxhichina.com");
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
	        prop.setProperty("mail.smtp.port", "25");
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
				ts.connect("smtp.mxhichina.com", "mailregister@chuangyejia.top", "yanchenguang123456..");
		      //4、创建邮件
		        String uuid = UUID.randomUUID().toString().replace("-", "");
		        String mailContent = "请将该串加密字符序列全部复制入创业加注册页面的邮箱验证码输入框内：" + uuid;
		        Message message = createSimpleMail(session, mailContent);
		      //5、发送邮件
		        ts.sendMessage(message, message.getAllRecipients());
		        ts.close();
		        success = true;
		        /**
		         * 将email和uuid设置如session中！
		         */
		        httpSession.setAttribute("emailCode", email + "#" + uuid);
		        
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
		} else {
			success = false;
		}
		JsonObject jo = new JsonObject();
        jo.addProperty("success", success);
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
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //邮件的标题
        message.setSubject("来自创业加网站的注册邮箱验证码");
        //邮件的文本内容
        message.setContent(uuid, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }
	
}
