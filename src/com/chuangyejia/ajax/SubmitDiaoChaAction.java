package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Created by Diamond on 2016-11-21.
 */

@SuppressWarnings("serial")
@Component(value="submitDiaoCha")
@Scope("prototype")
public class SubmitDiaoChaAction extends ActionSupport {

	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	private String field;
    private String undergo;
    private String category;
    private String name;
    private String school;
    private String tel;
	
    public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getUndergo() {
		return undergo;
	}
	public void setUndergo(String undergo) {
		this.undergo = undergo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
/**
 * private String field;
    private String undergo;
    private String category;
    private String name;
    private String school;
    private String tel;
 */
	
	
	private boolean checkData() {
		if(name != null && name.length() < 16 && name.length() > 2 && tel.length() == 11 && tel.matches("[1]{1}[3-8]{1}\\d{9}")) {
			if(field.matches("\\d")) {
				try {
					field = UserUtil.userField[Integer.parseInt(field)];
				} catch(NumberFormatException e) {
					field = "其他";
				}
			}
			if(undergo != null && undergo.trim().hashCode() != 0 && !undergo.contains("<") && !undergo.contains(">") && undergo.length() < 255) {
				if(category != null && category.trim().hashCode() != 0 && !category.contains("<") && !category.contains(">") && category.length() < 255) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void justDoIt() {
		boolean success = false;
		
		if(checkData()) {
			User user = new User();
			user.setUserNickName(name);
			user.setUserTel(tel);
			user.setUserPassword(UUID.randomUUID().toString().replace("-", "").substring(0, 6));
			user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
			user.setUserIntroduce(undergo);
			user.setStartAbility(category);
			user.setUserField(field);
			
			try {
				if(us.saveUser(user))  {//将User对象存入数据库中。
					success = true;
				}
			} catch(Exception e) {
				success = false;				
			}
		}
		
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        out.print(success);
        
        out.flush();
        out.close();
	}
	
}
