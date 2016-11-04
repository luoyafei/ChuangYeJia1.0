package com.chuangyejia.dto;

import com.chuangyejia.bean.User;

public class UserSignDTO {
	
	private boolean isLogin;//是登录还是注册操作
	private String nickname;//昵称
	private String email;//邮箱
	private String tel;//电话
	private String password;//密码
	private String validatePassword;//重新输入密码
	private String identifyCode;//验证码
	private String errorInfo;//出错信息
	
	private final static String emailPattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	private final static String telPattern = "[\\d]{11}";
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getValidatePassword() {
		return validatePassword;
	}
	public void setValidatePassword(String validatePassword) {
		this.validatePassword = validatePassword;
	}
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	
	/**
	 * 验证用户登录时的字段格式问题
	 * @return
	 */
	private boolean checkLogin() {

//		boolean rightEmailFormat = email.matches(emailPattern);
		boolean rightTelFormat = tel.matches(telPattern);
		if(rightTelFormat && password.trim().hashCode() != 0 && identifyCode.trim().hashCode() != 0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * 验证用户注册时的字段格式问题
	 * @return
	 */
	private boolean checkRegister() {

//		boolean rightEmailFormat = email.matches(emailPattern);
		boolean rightTelFormat = tel.matches(telPattern);
		
		if(nickname.trim().hashCode() != 0 && rightTelFormat && password.trim().equals(validatePassword.trim()) && password.trim().hashCode() != 0 && identifyCode.trim().hashCode() != 0)
			return true;
		else
			return false;
	}
	
	/**
	 * 在外层直接调用该接口而无须知道具体实现
	 * @return
	 */
	public boolean checkDataDispatchor() {
//System.out.println("isLogin :" + isLogin);
		if(isLogin)
			return checkLogin();
		else
			return checkRegister();
	}
	
	private User toLoginUser() {
		User user = new User();
//		user.setUserEmail(email);
		user.setUserTel(tel);
		user.setUserPassword(password);
		return user;
	}
	private User toRegisterUser() {
		User user = new User();
		user.setUserNickName(nickname);
//		user.setUserEmail(email);
		user.setUserTel(tel);
		user.setUserPassword(password);
		return user;
	}
	
	/**
	 * 将UserSignDTO对象转换为User对象
	 * @return
	 */
	public User toUser() {
		if(isLogin)
			return toLoginUser();
		else
			return toRegisterUser();
	}
}
