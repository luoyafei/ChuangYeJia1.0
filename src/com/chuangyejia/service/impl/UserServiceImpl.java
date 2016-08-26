package com.chuangyejia.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.dao.IUserDao;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.UserTempShow;
import com.chuangyejia.tools.UserTempShowOnlyUser;

@Component(value="us")
public class UserServiceImpl implements IUserService {

	private IUserDao ud;
	
	public IUserDao getUd() {
		return ud;
	}
	@Resource(name="ud")
	public void setUd(IUserDao ud) {
		this.ud = ud;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return ud.saveUser(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		return ud.deleteUser(userId);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

	@Override
	public int getAllUsersCount(String copartnerCategory) {
		// TODO Auto-generated method stub
		return ud.getAllUsersCount(copartnerCategory);
	}

	@Override
	public List<User> getUsers(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return ud.getUsers(start, length);
	}
	
	@Override
	public List<User> getUsers(Integer start, Integer length, String copartnerCategory, String sort) {
		// TODO Auto-generated method stub
		
		List<User> users = ud.getUsers(start, length, copartnerCategory, sort);
		
		return users;
	}

	@Override
	public List<UserTempShow> getUserTempShows(Integer start, Integer length, String copartnerCategory, String sort) {
		// TODO Auto-generated method stub
		List<User> users = ud.getUsers(start, length, copartnerCategory, sort);
		List<UserTempShow> uts = new ArrayList<UserTempShow>();
		for(int i = 0; i < users.size(); i++) {
			uts.add(users.get(i).toUserTempShow());
		}
		return uts;
	}

	@Override
	public List<UserTempShowOnlyUser> getUserTempShowOnlyUser(Integer start, Integer length, String copartnerCategory, String sort) {
		// TODO Auto-generated method stub

		List<User> users = ud.getUsers(start, length, copartnerCategory, sort);
		List<UserTempShowOnlyUser> utsou = new ArrayList<UserTempShowOnlyUser>();
		for(int i = 0; i < users.size(); i++) {
			utsou.add(users.get(i).toUserTempShowOnlyUser());
		}
		return utsou;
	}

	
	
	@Override
	public User getUserInId(String userId) {
		// TODO Auto-generated method stub

		User user = ud.getUserInId(userId);
		return user;
	}
	
	

	@Override
	public UserTempShow getUserTempShowInId(String userId) {
		// TODO Auto-generated method stub
		User user = ud.getUserInId(userId);
		UserTempShow uts = user.toUserTempShow();
		return uts;
	}

	@Override
	public User getUserInEmail(String userEmail) {
		// TODO Auto-generated method stub
		return ud.getUserInEmail(userEmail);
	}

	@Override
	public User getUserInIdCard(String idCard) {
		// TODO Auto-generated method stub
		return ud.getUserInIdCard(idCard);
	}

	@Override
	public User getUserInWeChat(String weChat) {
		// TODO Auto-generated method stub
		return ud.getUserInWeChat(weChat);
	}

	@Override
	public User getUserInTel(String tel) {
		// TODO Auto-generated method stub
		return ud.getUserInTel(tel);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return ud.checkEmail(email);
	}

	@Override
	public User checkEmailAndPassword(User user) {
		// TODO Auto-generated method stub
		return ud.checkEmailAndPassword(user);
	}

}
