package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ChatMessage;
import com.chuangyejia.bean.User;
import com.chuangyejia.dao.IChatMessageDao;

@Component(value="cmd")
public class ChatMessageDaoImpl implements IChatMessageDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public boolean saveChatMessage(ChatMessage cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveChatMessage(ChatMessage[] cms) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteChatMessage(ChatMessage cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean emptyChatMessagesByUserIdToSomeOne(final String fromUserId, final String toUserId) {
		// TODO Auto-generated method stub
		
		
		try {
			return (Boolean)hibernateTemplate.execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					
					String ejbql = "delete from ChatMessage cm where cm.fromUserId = :fromUserId and cm.toUserId = :toUserid";
					session.createQuery(ejbql).setParameter("fromUserId", fromUserId).setParameter("toUserId", toUserId).executeUpdate();
					return true;
				}
			});
		} catch(DataAccessException e) {
System.out.println("删除双方聊天消息出错！");
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean emptyChatMessagesByUserIdToSomeOne(String fromUserId, String toUserId, Timestamp beforeDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean emptyChatMessagesByUserId(String fromUserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChatMessage> getChatMessageInId(String chatMessageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChatMessage> getHistoryChatMessagesByTwoUserId(String fromUserId, String toUserId, int maxLength) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChatMessage> getHistoryChatMessagesByTwoUserId(String fromUserId, String toUserId, Timestamp beforeDate, int maxLength) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ChatMessage> getNotReadChatMessages(final String fromUserId, final String toUserId, final int needRead) {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<ChatMessage>)hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					
					String ejbql = "from ChatMessage cm where cm.formUserId = :fromUserId and cm.toUserId = :toUserId and cm.needRead = :needRead";
					return (ArrayList<ChatMessage>)session.createQuery(ejbql).setParameter("fromUserId", fromUserId).setParameter("toUserId", toUserId).setParameter("needRead", needRead).list();
				}
				
			});
		} catch(DataAccessException e) {
			System.out.println("获取历史消息的个数出现错误！");
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long getNotReadChatMessagesCount(final String fromUserId, final String toUserId, final int needRead) {
		
		try {
			Long l =  (Long)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String ejbql = "select count(*) from ChatMessage cm where cm.formUserId = :fromUserId and cm.toUserId = :toUserId and cm.needRead = :needRead";
					return (Long)session.createQuery(ejbql).setParameter("fromUserId", fromUserId).setParameter("toUserId", toUserId).setParameter("needRead", needRead).uniqueResult();
				}
				
			});
			return l;
		} catch(DataAccessException e) {
			System.out.println("获取历史消息的个数出现错误！");
			e.printStackTrace();
			return 0L;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User> getAllNotReadChatMessages(final String userId, final int needRead) {
		// TODO Auto-generated method stub
		final String ebjqlForCM = "select cm.fromUserId from ChatMessage cm where cm.toUserId = :userId and cm.needRead = :needRead";
		final String ejbqlForUser = "select u.userId, u.userNickName, u.userPhoto from User u where u.userId = :fromUserId";
		List<User> users = null;
		
		users = (ArrayList<User>)hibernateTemplate.executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				/**
				 * 先获取所有的发送消息的用户Id
				 */
				ArrayList<String> fromUserIds = (ArrayList<String>)session.createQuery(ebjqlForCM).setParameter("userId", userId).setParameter("needRead", needRead).list();
				if(fromUserIds != null && fromUserIds.size() > 0) {
					List<User> usersTemp = new ArrayList<User>();
					
					/**
					 * 根据获取到的用户Id获取与其对应的用户信息。
					 */
					for(int i = 0; i < fromUserIds.size(); i++) {
						final String fromUserId = fromUserIds.get(i);
						
						usersTemp.add((User)hibernateTemplate.execute(new HibernateCallback() {

							@Override
							public Object doInHibernate(Session session) throws HibernateException, SQLException {
								
								Object[] userTemplObj = (Object[])session.createQuery(ejbqlForUser).setParameter("fromUserId", fromUserId).list().get(0);
								if(userTemplObj != null) {
									User userobj = new User();
									userobj.setUserId(userTemplObj[0].toString());
									userobj.setUserNickName(userTemplObj[1].toString());
									userobj.setUserPhoto(userTemplObj[2].toString());
									return userobj;
								} else {
									return null;
								}
							}
							
						}));
					}
					return usersTemp;
				} else
					return null;
			}
			
		});
		
		return users;
	}

}
