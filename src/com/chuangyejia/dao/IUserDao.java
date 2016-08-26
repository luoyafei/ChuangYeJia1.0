package com.chuangyejia.dao;

import java.util.List;

import com.chuangyejia.bean.User;

/**
 * 定义数据访问对象dao的接口
 * @author Diamond
 * 
 */
public interface IUserDao {

	/**
	 * 存储User对象
	 * @param user
	 * @return boolean
	 */
	public boolean saveUser(User user);
	/**
	 * 根据userId 删除User对象
	 * @param userId
	 * @return boolean
	 */
	public boolean deleteUser(String userId);
	/**
	 * 更新User对象
	 * @param user
	 * @return boolean
	 */
	public boolean updateUser(User user);
	/**
	 * 获取用户的所有数量,根据合伙人的类型
	 * @param copartnerCategory //如果为"null"这里是字符串null，则为获取所有用户的数量
	 * @return int
	 */
	public int getAllUsersCount(String copartnerCategory);
	/**
	 * 在指定位置，获取指定数量的用户
	 * @param start
	 * @param length
	 * @return List<User>
	 */
	public List<User> getUsers(Integer start, Integer length);
	/**
	 * 在指定位置，获取指定数量,根据合伙人类型区分 ，根据sort排序的用户集合
	 * @param start
	 * @param length
	 * @param copartnerCategory
	 * @return List<User>
	 */
	public List<User> getUsers(Integer start, Integer length, String copartnerCategory, String sort);
	/**
	 * 通过userId 获取User对象
	 * @param userId
	 * @return User
	 */
	public User getUserInId(String userId);
	
	/**
	 * 通过userEmail(邮箱) 获取User对象
	 * @param userEmail
	 * @return User
	 */
	public User getUserInEmail(String userEmail);
	/**
	 * 通过idCard(身份证) 获取User对象
	 * @param idCard
	 * @return User
	 */
	public User getUserInIdCard(String idCard);
	/**
	 * 通过weChat(微信) 获取User对象
	 * @param weChat
	 * @return User
	 */
	public User getUserInWeChat(String weChat);
	/**
	 * 通过tel(电话) 获取User对象
	 * @param tel
	 * @return User
	 */
	public User getUserInTel(String tel);
	/**
	 * 判断email是否中数据库中存在,若存在返回true，反之返回false
	 * @param email
	 * @return boolean
	 */
	public boolean checkEmail(String email);
	/**
	 * 在登录时检测email和password是否正确
	 * @param user.getUserEmail user.getUserPassword
	 * @return User
	 */
	public User checkEmailAndPassword(User user);
}
