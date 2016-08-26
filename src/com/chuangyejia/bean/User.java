package com.chuangyejia.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;
import com.chuangyejia.tools.UserTempShowOnlyUser;

@Entity
@Table(name="user")
public class User {
	
	private final static String PHOTO_DEFAULT = "/ChuangYeJia/assets/img/defaultImg/head.png";

	private String userId = null;
	private String userNickName = null;//用户昵称
	private String userEmail = null;//用户邮箱
	private String userRealName = null;//用户真实姓名
	private String userPassword = "123456";
	private String userIntroduce = null;//个人经历
	private String userGender = null;
	private Timestamp userBirthday = null;
	private String userPhoto = "";//用户头像
	private String userRealPhoto = "";//用户照片
	private String userAddress = null;//所属高校
	private String userIp = null;
	private String userWeChat = null;
	private String userIdCard = null;
	private Timestamp userCreateDate = null;
	private String isVerify = "0";//是否认证
	private String userTel = null;//电话
	
	
	private String copartnerCategory = null;//合伙人类型（资金，技术，推广，运营，其他）
	private String startAbility = null;//创业能力 (资金信息，技术信息，推广信息，运营信息，创业能力)
	private String userField = null;//关注领域 (移动互联网，电子商务，文化艺术，教育体育，汽车，旅游户外，房产，营销广告，硬件，工具软件，企业服务，搜索安全，医疗健康，媒体资讯，生活消费，其他)
	private String introduceVideo = null;//介绍视频
	
	/**
	 * 获取该用户所创建的所有的创业公司
	 */
	private Set<Startups> allLeaderStartups = new HashSet<Startups>();
	

	/**
	 * 获取该用户参与的所有的创业公司
	 */
	private Set<Startups> allJoinStartups = new HashSet<Startups>();
	
	public User() {}
	
	
	public User(String userId, String userNickName, String userEmail, String userRealName, String userPassword,
			String userIntroduce, String userGender, Timestamp userBirthday, String userPhoto, String userRealPhoto,
			String userAddress, String userIp, String userWeChat, String userIdCard, Timestamp userCreateDate,
			String isVerify, String userTel, String copartnerCategory, String startAbility, String userField,
			String userDirection, String introduceVideo, Set<Startups> allLeaderStartups,
			Set<Startups> allJoinStartups) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userEmail = userEmail;
		this.userRealName = userRealName;
		this.userPassword = userPassword;
		this.userIntroduce = userIntroduce;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userPhoto = userPhoto;
		this.userRealPhoto = userRealPhoto;
		this.userAddress = userAddress;
		this.userIp = userIp;
		this.userWeChat = userWeChat;
		this.userIdCard = userIdCard;
		this.userCreateDate = userCreateDate;
		this.isVerify = isVerify;
		this.userTel = userTel;
		this.copartnerCategory = copartnerCategory;
		this.startAbility = startAbility;
		this.userField = userField;
		this.introduceVideo = introduceVideo;
		this.allLeaderStartups = allLeaderStartups;
		this.allJoinStartups = allJoinStartups;
	}

	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserIntroduce() {
		return userIntroduce;
	}
	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Timestamp getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Timestamp userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserPhoto() {
		if(userPhoto == null || userPhoto.trim().hashCode() == 0)
			userPhoto = PHOTO_DEFAULT;
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		if(userPhoto == null || userPhoto.trim().hashCode() == 0)
			userPhoto = PHOTO_DEFAULT;
		this.userPhoto = userPhoto;
	}
	public String getUserRealPhoto() {
		return userRealPhoto;
	}
	public void setUserRealPhoto(String userRealPhoto) {
		this.userRealPhoto = userRealPhoto;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserWeChat() {
		return userWeChat;
	}
	public void setUserWeChat(String userWeChat) {
		this.userWeChat = userWeChat;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	/**
	 * 构建一个可以直接获取String类型的日期
	 * @return String
	 */
	@Transient
	public String getUserCreateDateStringTime() {
		if(userCreateDate == null)
			userCreateDate = new Timestamp(System.currentTimeMillis());
		return userCreateDate.toString();
	}
	public Timestamp getUserCreateDate() {
		getUserCreateDateStringTime();//保证其在hibernate使用时，调用。
		return userCreateDate;
	}
	public void setUserCreateDate(Timestamp userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public String getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	public String getCopartnerCategory() {
		return copartnerCategory;
	}

	public void setCopartnerCategory(String copartnerCategory) {
		this.copartnerCategory = copartnerCategory;
	}

	public String getStartAbility() {
		return startAbility;
	}

	public void setStartAbility(String startAbility) {
		this.startAbility = startAbility;
	}

	public String getUserField() {
		return userField;
	}

	public void setUserField(String userField) {
		this.userField = userField;
	}


	public String getIntroduceVideo() {
		return introduceVideo;
	}

	public void setIntroduceVideo(String introduceVideo) {
		this.introduceVideo = introduceVideo;
	}

	
	
	/**
	 * 这里是一对多双向关联，获取到该用户是leader的所有创业公司
	 * 注意：这里与之对应的是 Startups类中的User(startupsLeader)对象
	 * @return
	 */
	@OneToMany(mappedBy="startupsLeader",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	public Set<Startups> getAllLeaderStartups() {
		return allLeaderStartups;
	}
	public void setAllLeaderStartups(Set<Startups> allLeaderStartups) {
		this.allLeaderStartups = allLeaderStartups;
	}

	/**
	 * 多对多双向关联，可以获得到该用户参与的所有的创业公司
	 * 注意：不包含他是leader的身份的创业公司，仅仅是以普通成员的身份参与其中的创业公司
	 * @return
	 */
	@ManyToMany(mappedBy="copartner",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	public Set<Startups> getAllJoinStartups() {
		return allJoinStartups;
	}
	public void setAllJoinStartups(Set<Startups> allJoinStartups) {
		this.allJoinStartups = allJoinStartups;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User信息:[userId:" + userId
				+ ", userNickName:" + userNickName
				+ ", userEmail:" + userEmail
				+ ", userRealName:" + userRealName
				+ ", userPassword:" + userPassword
				+ ", userIntroduce:" + userIntroduce
				+ ", userGender:" + userGender
				+ ", userBirthday:" + userBirthday
				+ ", userPhoto:" + userPhoto
				+ ", userRealPhoto:" + userRealPhoto
				+ ", userAddress:" + userAddress
				+ ", userIp:" + userIp
				+ ", userWeChat:" + userWeChat
				+ ", userIdCard:" + userIdCard
				+ ", userCreateDate:" + userCreateDate
				+ ", isVerify:" + isVerify
				+ ", userTel:" + userTel
				+ ", copartnerCategory" + copartnerCategory
				+ ", startAbility" + startAbility
				+ ", userField" + userField
				+ ", introduceVideo" + introduceVideo
				+ "]";
	}

	
	/**
	 * 提供了一个UserTempShow对象，将给被人展示的信息装入，不要将整个User对象拿出，具有安全信息！
	 * @return
	 */
	public UserTempShow toUserTempShow() {
		
		UserTempShow uts = new UserTempShow();
		
		uts.setUserId(userId);
		uts.setUserNickName(userNickName);
		uts.setUserEmail(userEmail);
		uts.setUserIntroduce(userIntroduce);
		uts.setUserGender(userGender);
		uts.setUserAddress(userAddress);
		uts.setUserPhoto(userPhoto);
		uts.setUserWeChat(userWeChat);
		uts.setUserTel(userTel);
		uts.setUserCreateDate(userCreateDate);
		uts.setIsVerify(isVerify);
		
		uts.setCopartnerCategory(copartnerCategory);
		uts.setStartAbility(startAbility);
		uts.setUserField(userField);
		uts.setIntroduceVideo(introduceVideo);
		
		
		Set<StartupsTempShow> allLeaderStartupsTemp = new HashSet<StartupsTempShow>();
		Set<StartupsTempShow> allJoinStartupsTemp = new HashSet<StartupsTempShow>();
		
		Iterator<Startups> iteratorAllLeader = allLeaderStartups.iterator();
		Iterator<Startups> iteratorJoin = allJoinStartups.iterator();
//System.out.println("User ++++++++++++++++++++++++++++++ " + allLeaderStartups.size());
		/**
		 * 由于继续选择toStartupsTempShow()转换，将会造成死循环，现在选用以下方法
		 * 从User角度获取到的StartupsTempShow对象，仅有id，name，brief 具有值
		 */
		
		while(iteratorAllLeader.hasNext()) {
			Startups s = iteratorAllLeader.next();
			StartupsTempShow sts = new StartupsTempShow();
			
			sts.setStartupsId(s.getStartupsId());
			sts.setStartupsName(s.getStartupsName());
			sts.setStartupsBrief(s.getStartupsBrief());
			
			allLeaderStartupsTemp.add(sts);
		}
		uts.setAllLeaderStartups(allLeaderStartupsTemp);
		
		while(iteratorJoin.hasNext()) {
			
			Startups s = iteratorJoin.next();
			StartupsTempShow sts = new StartupsTempShow();
			
			sts.setStartupsId(s.getStartupsId());
			sts.setStartupsName(s.getStartupsName());
			sts.setStartupsBrief(s.getStartupsBrief());
			
			allJoinStartupsTemp.add(sts);
		}
		uts.setAllJoinStartups(allJoinStartupsTemp);
//System.out.println("user ++++++++++++++" + uts.getAllLeaderStartups().size());
		return uts;
		
	}
	
	
	/**
	 * 提供了一个UserTempShowOnlyUser对象，将给被人展示的信息装入，不要将整个User对象拿出，具有安全信息！
	 * 此处只提供User字段的！不包含Startups的内容
	 * @return
	 */
	public UserTempShowOnlyUser toUserTempShowOnlyUser() {
		
		UserTempShowOnlyUser utsou = new UserTempShowOnlyUser();
		
		utsou.setUserId(userId);
		utsou.setUserNickName(userNickName);
		utsou.setUserEmail(userEmail);
		utsou.setUserIntroduce(userIntroduce);
		utsou.setUserGender(userGender);
		utsou.setUserAddress(userAddress);
		utsou.setUserPhoto(userPhoto);
		utsou.setUserWeChat(userWeChat);
		utsou.setUserTel(userTel);
		utsou.setUserCreateDate(userCreateDate);
		utsou.setIsVerify(isVerify);
		
		utsou.setCopartnerCategory(copartnerCategory);
		utsou.setStartAbility(startAbility);
		utsou.setUserField(userField);
		utsou.setIntroduceVideo(introduceVideo);
		
		
		return utsou;
		
	}
	
}
