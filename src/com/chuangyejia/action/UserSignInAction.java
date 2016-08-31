package com.chuangyejia.action;

import java.io.ByteArrayInputStream;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.dto.UserSignDTO;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.IdentifyCode;
import com.opensymphony.xwork2.ActionSupport;

@Component(value="userSignInAction")
@Scope("prototype")
public class UserSignInAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "login";//验证登录失败后，返回登录页面
	private static final String REGISTER = "register";//验证注册失败后，返回注册页面
	private static final String BACK = "back";//从哪个登录登录的，成功后就返回那个页面
	private static final String SIGNOUT = "signout";//用户注销处理
	private static final String RDA_BACK_ITEM = "rdactionforitem";//当用户是从show_startups.jsp来的时候，进行redirectAction的跳转，跳入getStartupsItem
	private static final String RDA_BACK_MARK = "rdactionformark";//当用户是从show_startups.jsp来的时候，进行redirectAction的跳转，跳入getStartupsItem
	private boolean fromShowStartups = false;//标志，说明是不是来自show_startups.jsp
	private boolean fromUserProfile = false;//标志，说明是不是来自user_profile.jsp
	
	private IUserService us;
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	private UserSignDTO ud;
	private String registerEmailCode;//邮箱验证码
	private ByteArrayInputStream imageStream;//输出的图片流
	private String backUrl;//从哪里进行登陆时url
	public UserSignDTO getUd() {
		return ud;
	}
	public void setUd(UserSignDTO ud) {
		this.ud = ud;
	}
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		if(backUrl.trim().hashCode() == 0)
			this.backUrl = "/index.jsp";
		else {
			if(backUrl.contains("/ChuangYeJia") && backUrl.startsWith("/ChuangYeJia") && !backUrl.contains("/login.jsp") && !backUrl.contains("/register.jsp")) {
				this.backUrl = backUrl.substring(12);
			} else {
				this.backUrl = "/index.jsp";
			}
		}
	}
	
	public String getRegisterEmailCode() {
		return registerEmailCode;
	}
	public void setRegisterEmailCode(String registerEmailCode) {
		this.registerEmailCode = registerEmailCode;
	}

	
	/**
	 * 用来生成验证码的
	 * @return "identifyCode"
	 */
	public String identifyCode() {
		IdentifyCode ic = new IdentifyCode();
		imageStream = ic.createCode();
		Integer code = ic.getResult();
		
		//将验证码的结果存入session
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
		return "identifyCode";
	}
	/**
	 * 用来处理用户注册的action
	 * @return
	 */
	public String register() {
		
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		String emailSessionCode = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("emailCode"));//将session中的邮箱验证码结果取出
		String sessionMail = null;
		String sessionCode = null;
System.out.println(emailSessionCode);
		if(emailSessionCode != null && emailSessionCode.contains("#")) {
			sessionMail = emailSessionCode.trim().split("#")[0];
			sessionCode = emailSessionCode.trim().split("#")[1];
		}
		
		if(ud.getIdentifyCode().equals(code) && registerEmailCode != null && registerEmailCode.trim().length() == 32 && registerEmailCode.equals(sessionCode)) {//如果判断相等，则继续执行
			ud.setIsLogin(false);
			if(ud.checkDataDispatchor()) {
				boolean emailIsExisted = us.checkEmail(ud.getEmail());//判断数据库中是否存在该email
				if(!emailIsExisted && ud.getEmail().trim().equals(sessionMail)) {
					User user = ud.toUser();
//System.out.println("register() : " + user.toString());
					/**
					 * 将ip存入user
					 */
					user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
					if(us.saveUser(user))  {//将User对象存入数据库中。
						HttpSession session = ServletActionContext.getRequest().getSession(); 
						session.setAttribute("user", user);//将插入成功的User对象放入Session中
						if(fromShowStartups)
							return RDA_BACK_ITEM;
						else if(fromUserProfile)
							return RDA_BACK_MARK;
						else
							return BACK;
					}
				}
			}
		}
		return REGISTER;
	}
	
	/**
	 * 用来处理用户登录的action
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
System.out.println("backUrl :" + backUrl);
		
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		if(ud.getIdentifyCode().equals(code)) {//如果判断相等，则继续执行
			ud.setIsLogin(true);
			if(ud.checkDataDispatchor()) {
				
				User user = us.checkEmailAndPassword(ud.toUser());//判断数据库中是否存在该email和password
				
				if(user != null) {
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("user", user);//将User对象放入Session中
					if(fromShowStartups)
						return RDA_BACK_ITEM;
					else if(fromUserProfile)
						return RDA_BACK_MARK;
					else
						return BACK;
				} else {
					this.addFieldError("error", "邮箱或登录密码错误！");
				}
			} else
				this.addFieldError("error", "邮箱格式错误！");
		} else
			this.addFieldError("error", "验证码错误！");
		
		return LOGIN;
	}
	
	@Override
	public void validate() {

		/**
		 * 如果是来自show_startups.jsp，则将item的参数保留，为redirectAction做准备
		 * 如果来自user_profile.jsp，则将mark的参数保留，为redirectionAction做准备
		 */
		if(backUrl != null && backUrl.trim().contains("/pages/startups/show_startups.jsp")) {
			backUrl = backUrl.split("item=")[1];
			fromShowStartups = true;
		} else if(backUrl != null && backUrl.trim().contains("/pages/home/user_profile.jsp")) {
			backUrl = backUrl.split("mark=")[1];
			fromUserProfile = true;
		}
	}
	/**
	 * 用来处理用户注销的action
	 * @return
	 */
	public String signOut() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements())
			session.removeAttribute(sessionNames.nextElement());
		return SIGNOUT;
	}
}
