package com.chuangyejia.jsonbean;

/**
 * 这里返回的都是对应实体的错误信息
 * @author Diamond
 *
 */
public class UserModifyAjaxReturnBean {

	/**
	 * 用来表示是否成功
	 */
	private boolean success = false;
	private String password = "";
	private String newPassword = "";
	private String nickname = "";
	private String address = "";
	private String profile = "";
	private String category = "";
	private String ability = "";
	private String field = "";
	private String video = "";
	
	/**
	 * 往数据库中插入失败的标识
	 */
	private String update = "";
	
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	
	
	
}
