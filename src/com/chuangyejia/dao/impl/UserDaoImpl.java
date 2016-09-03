package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.dao.IUserDao;

@Component(value="ud")
public class UserDaoImpl implements IUserDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.save(user);
		} catch(DataAccessException e) {
			flag = false;
			e.printStackTrace();
System.out.println("存储用户出现异常！");
		}
		return flag;
	}

	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		
		return false;
	}

	
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.update(user);
		} catch(DataAccessException e) {
			flag = false;
			e.printStackTrace();
System.out.println("更新用户出现异常！");
		}
		return flag;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int getAllUsersCount(final String copartnerCategory) {
		// TODO Auto-generated method stub
		Long count = new Long(0);
		
		try {
			count = (Long)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					if(copartnerCategory.equals("null")) {
	    				String ejbql = "select count(*) from User u";
	    				return (Long)session.createQuery(ejbql).uniqueResult();
	    			} else {
	    				String ejbql = "select count(*) from User u where u.copartnerCategory = :copartnerCategory";
	    				return (Long)session.createQuery(ejbql).setString("copartnerCategory", copartnerCategory).uniqueResult();
	    			}
				}
				
			});
			
		} catch(DataAccessException e) {
			count = 0L;
			System.out.println("在dao层，UserDaoImpl中，根据copartnerCategory获取用户个数出错");
			e.printStackTrace();
		}
		
		return count.intValue();
	}

	@Override
	public List<User> getUsers(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User> getUsers(final Integer start, final Integer length, final String copartnerCategory, final String sort) {
		// TODO Auto-generated method stub
		
		List<User> users = null;
		
		try {
			users = (List<User>)hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					List<User> users;
					if(copartnerCategory.equals("null")) {
						String ejbql = "from User u order by :sort desc";
						Query query = session.createQuery(ejbql).setString("sort", sort).setFirstResult(start*length).setMaxResults(length);
						users = (ArrayList<User>)query.list();
					} else {
						String ejbql = "from User u where u.copartnerCategory = :copartnerCategory order by :sort desc";
						Query query = session.createQuery(ejbql).setString("copartnerCategory", copartnerCategory).setString("sort", sort).setFirstResult(start*length).setMaxResults(length);
						users = (ArrayList<User>)query.list();
					}
					return users;
				}
			});
			
		} catch(DataAccessException e) {
			users = null;
			System.out.println("在dao层，获取根据start, length, copartnweCategory获取用户集时出错！");
			e.printStackTrace();
		}
		return users;
		
	}

	@Override
	public User getUserInId(String userId) {
		// TODO Auto-generated method stub
		User user = (User)hibernateTemplate.get(User.class, userId);
		return user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User getUserInEmail(final String userEmail) {
		// TODO Auto-generated method stub
		User user = (User)hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return (User)session.createQuery("from User u where u.userEmail = :userEmail").setParameter("userEmail", userEmail).uniqueResult();
			}
		});
		return user;
	}

	@Override
	public User getUserInIdCard(String idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInWeChat(String weChat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkEmail(final String email) {
		// TODO Auto-generated method stub
		
		return (Boolean)hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("select userEmail from User u where u.userEmail = :email");
				q.setString("email", email);
				int count = q.list().size();
				if(count == 0)
					return false;//数据库中没有该email
				else
					return true;//有
			}
			
		});
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User checkEmailAndPassword(final User user) {
		
		return (User)hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query q = session.createQuery("from User u where u.userEmail = :email and u.userPassword = :password");
				q.setString("email", user.getUserEmail());
				q.setString("password", user.getUserPassword());
				int count = q.list().size();
				User result = null;
				if(count == 1) {
					result = (User)q.list().get(0);
				}
				return result;
			}
			
		});
		
	}

	
}
