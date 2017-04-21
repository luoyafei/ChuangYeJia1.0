package com.chuangyejia.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.dto.UserSignDTO;
import com.chuangyejia.service.IShopCarService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.IdentifyCode;
import com.chuangyejia.tools.UploadFileUtil;
import com.google.gson.JsonObject;
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
	
	private static final String RegisterJsonp = "registerJsonpCallback";
	
	private IUserService us;
	private IShopCarService iscs;
	public IShopCarService getIscs() {
		return iscs;
	}
	@Resource(name="iscs")
	public void setIscs(IShopCarService iscs) {
		this.iscs = iscs;
	}
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	private UserSignDTO ud;
	private String registerEmailCode;//过时：邮箱验证码
	private String registerTelCode;//电话验证码
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
		String telCode = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("telCode"));//将session中的电话验证码结果取出
		
		if(ud.getIdentifyCode().equals(code) && telCode.equals(registerTelCode)) {//如果判断相等，则继续执行
			ud.setIsLogin(false);
			if(ud.checkDataDispatchor()) {
				//判断数据库中是否存在该 Tel
				if(!us.checkTel(ud.getTel())) {
					User user = ud.toUser();
					/**
					 * 将ip存入user
					 */
					user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
					if(us.saveUser(user))  {//将User对象存入数据库中。
						HttpSession session = ServletActionContext.getRequest().getSession();
						session.setAttribute("user", user);//将插入成功的User对象放入Session中
						session.setAttribute("userTemp", null);
						session.setAttribute("code", null);
						session.setAttribute("telCode", null);
						session.setAttribute("shopCar", iscs.getProductsInUserId(user.getUserId()));
						
						if(fromShowStartups)
							return RDA_BACK_ITEM;
						else if(fromUserProfile)
							return RDA_BACK_MARK;
						else
							return BACK;
					} else
						this.addFieldError("error", "用户注册失败！请稍后重试");
				} else
					this.addFieldError("error", "该手机号码已被注册！请更换号码或者进行密码找回服务！谢谢合作");
			} else
				this.addFieldError("error", "请准确核实您的输入数据，确认格式的正确！");
		} else
			this.addFieldError("error", "验证码错误！");
		
		return REGISTER;
	}
	
	private String address;
	private String profile;
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	/**
	 * 图片存入数据库中的地址
	 */
	private static final String DB = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlVir");
	/**
	 * 图片实际存入硬盘的地址
	 */
	private static final String DISK = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDisk");
	/**
	 * 图片的默认地址
	 */
	private static final String DEFAULT = ServletActionContext.getServletContext().getInitParameter("uploadPictureUrlDef");
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getProfile() {
		return this.profile;
	}
	
	private String uploadPic() {
		/**
		 * 保证传输过来的是图片
		 */
		if(pictureContentType.split("/")[0].equals("image")) {
			/**
			 * 自定义上传的图像名
			 */
			pictureFileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
			
			/**
			 * 获取存入硬盘的具体地址
			 */
			String url = DISK + pictureFileName;
			/**
			 * 根据全路径，将文件创建出来。
			 */
			File file = new File(url);
			
			/**
			 * 标识，创建文件是否成功
			 * 使用上传文件工具类
			 */
			boolean create = UploadFileUtil.justDoIt(picture, file);

			/**
			 * 如果创建成功
			 */
			if(create) {
				return DB + pictureFileName;
			} else
				return null;
		} else
			return null;
	}
	/**
	 * 面向微课题的注册
	 */
	public String register_micro() {
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		String telCode = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("telCode"));//将session中的电话验证码结果取出
		
		if(ud.getIdentifyCode().equals(code) && telCode.equals(registerTelCode)) {//如果判断相等，则继续执行
			ud.setIsLogin(false);
			if(ud.checkDataDispatchor() && address != null && profile != null) {
				//判断数据库中是否存在该 Tel
				if(!us.checkTel(ud.getTel())) {
					
					if(uploadPic() != null) {
						User user = ud.toUser();
						user.setUserAddress(address);
						user.setUserIntroduce(profile);
						user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
						user.setUserPhoto(uploadPic());
						
						if(us.saveUser(user))  {//将User对象存入数据库中。
							HttpSession session = ServletActionContext.getRequest().getSession();
							session.setAttribute("user", user);//将插入成功的User对象放入Session中
							session.setAttribute("userTemp", null);
							session.setAttribute("code", null);
							session.setAttribute("telCode", null);
							session.setAttribute("shopCar", iscs.getProductsInUserId(user.getUserId()));
							
							if(fromShowStartups)
								return RDA_BACK_ITEM;
							else if(fromUserProfile)
								return RDA_BACK_MARK;
							else
								return BACK;
							
						} else
							this.addFieldError("error", "用户注册失败！请稍后重试");
						
					}
					
					
				} else
					this.addFieldError("error", "该手机号码已被注册！请更换号码或者进行密码找回服务！谢谢合作");
			} else
				this.addFieldError("error", "请准确核实您的输入数据，确认格式的正确！");
		} else
			this.addFieldError("error", "验证码错误！");
		
		return REGISTER;
	}
	
	/**
	 * 过时的方法，使用邮箱验证
	 * @return
	 */
	@SuppressWarnings("unused")
	private String register_email() {
		
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		String emailSessionCode = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("emailCode"));//将session中的邮箱验证码结果取出
		String sessionMail = null;
		String sessionCode = null;
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
					/**
					 * 将ip存入user
					 */
					user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
					if(us.saveUser(user))  {//将User对象存入数据库中。
						HttpSession session = ServletActionContext.getRequest().getSession(); 
						session.setAttribute("user", user);//将插入成功的User对象放入Session中
						session.setAttribute("userTemp", null);
						session.setAttribute("code", null);
						session.setAttribute("telCode", null);
						
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
		
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		if(ud.getIdentifyCode().equals(code)) {//如果判断相等，则继续执行
			ud.setIsLogin(true);
			if(ud.checkDataDispatchor()) {
				HttpSession session = ServletActionContext.getRequest().getSession();

				User user = (User)session.getAttribute("userTemp");
				if(user != null && user.getUserPassword().equals(ud.getPassword())) {
					
					session.setAttribute("user", user);//将User对象放入Session中
					session.setAttribute("userTemp", null);
					session.setAttribute("code", null);
					session.setAttribute("telCode", null);
					session.setAttribute("shopCar", iscs.getProductsInUserId(user.getUserId()));
					
					if(fromShowStartups)
						return RDA_BACK_ITEM;
					else if(fromUserProfile)
						return RDA_BACK_MARK;
					else
						return BACK;
				} else {
					this.addFieldError("error", "电话号码或登录密码错误！");
				}
			} else
				this.addFieldError("error", "电话号码格式错误！");
		} else
			this.addFieldError("error", "验证码错误！");
		
		return LOGIN;
	}
	
	/**
	 * 过时的方法，用于邮箱的登录
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private String execute_email() throws Exception {
		// TODO Auto-generated method stub
		
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
//		session.invalidate();
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements())
			session.removeAttribute(sessionNames.nextElement());
		return SIGNOUT;
	}
	public String getRegisterTelCode() {
		return registerTelCode;
	}
	public void setRegisterTelCode(String registerTelCode) {
		this.registerTelCode = registerTelCode;
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
	private String nickname;//昵称
	private String tel;//电话
	private String password;//密码
	private String identifyCode;//验证码
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	/**
	 * 手机端跨域注册函数
	 */
	public void registeForPhoto() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {}
		UserSignDTO ud = new UserSignDTO();
		ud.setNickname(nickname);
		ud.setTel(tel);
		ud.setPassword(password);
		ud.setIdentifyCode(identifyCode);
		ud.setValidatePassword(password);
		
		boolean flag = false;
		String reason = "";
		String code = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("code"));//先将session中的验证码结果取出
		String telCode = String.valueOf(ServletActionContext.getRequest().getSession().getAttribute("telCode"));//将session中的电话验证码结果取出
		if(ud.getIdentifyCode().equals(code) && telCode.equals(registerTelCode)) {//如果判断相等，则继续执行
			ud.setIsLogin(false);
			if(ud.checkDataDispatchor()) {
				//判断数据库中是否存在该 Tel
				if(!us.checkTel(ud.getTel())) {
					User user = ud.toUser();
					/**
					 * 将ip存入user
					 */
					user.setUserIp(ServletActionContext.getRequest().getRemoteAddr());
					if(us.saveUser(user))  {//将User对象存入数据库中。
						HttpSession session = ServletActionContext.getRequest().getSession();
						session.setAttribute("user", user);//将插入成功的User对象放入Session中
						session.setAttribute("userTemp", null);
						session.setAttribute("code", null);
						session.setAttribute("telCode", null);
						session.setAttribute("shopCar", iscs.getProductsInUserId(user.getUserId()));
						flag = true;
						
					} else
						reason = "用户注册失败！请稍后重试";
				} else
					reason = "该手机号码已被注册！请更换号码或者进行密码找回服务！谢谢合作";
			} else
				reason = "请准确核实您的输入数据，确认格式的正确！";
		} else
			reason = "验证码错误";
		JsonObject jo = new JsonObject();
		jo.addProperty("flag", flag);
		jo.addProperty("reason", reason);
		
		if(callback != null && callback.equals(RegisterJsonp)) {
			out.print(callback + "(" + jo.toString() + ")");
		} else
			out.print(jo.toString());
	}
}
