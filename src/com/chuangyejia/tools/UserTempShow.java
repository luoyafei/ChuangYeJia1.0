package com.chuangyejia.tools;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 提供一个User的展现信息的类
 * 传入request给用户展示他人基础资料
 * （非修改个人信息），
 * 而不是将真正的User对象之间传入前台展示，
 * 为了安全起见！
 * @author Diamond
 */
public class UserTempShow {

	private String userId = null;
	private String userNickName = null;//用户昵称
	private String userEmail = null;//用户邮箱
	private String userIntroduce = null;
	private String userGender = null;
	private String userPhoto = "";//用户头像
	private String userAddress = null;
	private String userWeChat = null;
	private Timestamp userCreateDate = null;
	private String isVerify = "0";//是否认证
	private String userTel = null;//电话
	
	private String copartnerCategory = null;//合伙人类型（资金，技术，推广，运营，其他）
	private String startAbility = null;//创业能力
	private String userField = null;//领域 (移动互联网，电子商务，文化艺术，教育体育，汽车，旅游户外，房产，营销广告，硬件，工具软件，企业服务，搜索安全，医疗健康，媒体资讯，生活消费，其他)
	private String introduceVideo = null;//介绍视频
	
	/**
	 * 获取该用户所创建的所有的创业公司
	 */
	private Set<StartupsTempShow> allLeaderStartups = new HashSet<StartupsTempShow>();
	
	/**
	 * 获取该用户参与的所有的创业公司
	 */
	private Set<StartupsTempShow> allJoinStartups = new HashSet<StartupsTempShow>();
	
	public Set<StartupsTempShow> getAllLeaderStartups() {
		return allLeaderStartups;
	}
	public void setAllLeaderStartups(Set<StartupsTempShow> allLeaderStartups) {
		this.allLeaderStartups = allLeaderStartups;
	}
	public Set<StartupsTempShow> getAllJoinStartups() {
		return allJoinStartups;
	}
	public void setAllJoinStartups(Set<StartupsTempShow> allJoinStartups) {
		this.allJoinStartups = allJoinStartups;
	}
	
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserWeChat() {
		return userWeChat;
	}
	public void setUserWeChat(String userWeChat) {
		this.userWeChat = userWeChat;
	}
	public Timestamp getUserCreateDate() {
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
	
	
}
