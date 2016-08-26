package com.chuangyejia.dto;

import com.chuangyejia.jsonbean.UserModifyAjaxReturnBean;
import com.chuangyejia.tools.UserUtil;

public class UserInfoDTO {

	private boolean isModifyPassword;
	private String nickname;
	private String address;
	private String profile;
	private String password;
	private String newPassword;
	
	private String category = "";//合伙人类型（资金，技术，推广，运营，其他）
	private String ability = "";//创业能力
	private String field = "";//领域 (移动互联网，电子商务，文化艺术，教育体育，汽车，旅游户外，房产，营销广告，硬件，工具软件，企业服务，搜索安全，医疗健康，媒体资讯，生活消费，其他)
	private String video = "";//介绍视频
	
	public boolean isModifyPassword() {
		return isModifyPassword;
	}
	public void setModifyPassword(boolean isModifyPassword) {
		this.isModifyPassword = isModifyPassword;
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
	/**
	 * 进行简单的数据校验
	 * @return boolean
	 */
	public UserModifyAjaxReturnBean checkData() {
		// TODO Auto-generated method stub
		UserModifyAjaxReturnBean error = new UserModifyAjaxReturnBean();
		if(isModifyPassword) {
			if(password.trim().hashCode() == 0 || password.trim().length() < 6) {
				error.setPassword("用户原始密码输入错误！");
				error.setSuccess(false);
			} else if(newPassword.trim().hashCode() == 0 || newPassword.trim().length() < 6) {
				error.setNewPassword("用户新密码输入错误！");
				error.setSuccess(false);
			} else
				error.setSuccess(true);
		} else {
			if(nickname.trim().hashCode() == 0 || nickname.trim().length() < 2 || nickname.trim().length() > 16) {
				error.setNickname("用户昵称长度必须在2-16个字之间！");
				error.setSuccess(false);
			} else if(address.trim().hashCode() == 0 || address.trim().length() > 16) {
				error.setAddress("所属高校不能为空，且不能超过16个字！");
				error.setSuccess(false);
			} else if(profile.trim().hashCode() == 0) {
				error.setProfile("用户经历不能为空！");
				error.setSuccess(false);
			} else if(profile.trim().length() > 255) {
				error.setProfile("用户经历字数不能超过255个！！");
				error.setSuccess(false);
			} else if(category == null) {
				error.setCategory("能力方向不能为空！！");
				error.setSuccess(false);
			} else if(ability.trim().hashCode() == 0) {
				error.setAbility("创业能力不能为空！！");
				error.setSuccess(false);
			} else if(field == null) {
				error.setField("创业能力不能为空！！");
				error.setSuccess(false);
			} else {
				error.setSuccess(true);
			}
			
			/**
			 * 用来确认传输过来的值未被人恶意修改过！
			 */
			try {
				@SuppressWarnings("unused")
				String copCate = UserUtil.copartnerCategory[Integer.parseInt(category)];
			} catch(NumberFormatException e) {
				error.setCategory("能力方向出现异常！");
				error.setSuccess(false);
			} catch(ArrayIndexOutOfBoundsException e) {
				error.setCategory("能力方向出现异常！");
				error.setSuccess(false);
			}
			try {
				 @SuppressWarnings("unused")
				String userField = UserUtil.userField[Integer.parseInt(field)];
			} catch(NumberFormatException e) {
				error.setField("关注领域异常！");
				error.setSuccess(false);
			} catch(ArrayIndexOutOfBoundsException e) {
				error.setField("关注领域异常！");
				error.setSuccess(false);
			}
		}
		return error;
	}
}
