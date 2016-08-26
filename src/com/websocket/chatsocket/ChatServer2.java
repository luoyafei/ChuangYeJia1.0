package com.websocket.chatsocket;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.chuangyejia.bean.ChatMessage;
import com.chuangyejia.bean.User;
import com.chuangyejia.websockettoolkit.GetHttpSessionConfigurator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@ServerEndpoint(value = "/chat2/server",configurator=GetHttpSessionConfigurator.class)
public class ChatServer2  {
	
	private User fromUser;
	private User toUser;
	private String toUserId;
	private ApplicationContext ac;
	private HibernateTemplate hibernateTemplate;
	private int i = 0;
	private Gson gson = new Gson();
	private JsonObject jo = new JsonObject();
	private Session session;
	
	private static final Map<String,Object> connections = new HashMap<String,Object>();  
	@SuppressWarnings({"unchecked", "rawtypes" })
	@OnMessage // 接受客户端消息
	public void onMessage(String msg) throws Exception {
		
		session.setMaxIdleTimeout(-1);//设置永不断线
		
		if(i == 0) {
			toUserId = msg;
			final User toUserTemp = new User();
			boolean rightToUser = (boolean)hibernateTemplate.execute(new HibernateCallback() { 
				@Override
				public Object doInHibernate(org.hibernate.Session session) throws HibernateException, SQLException {
					Object[] s = (Object[]) session.createQuery("select u.userId,u.userNickName,u.userPhoto from User u where u.userId = :userId").setParameter("userId", toUserId).list().get(0);
					if(s != null) {
						toUserTemp.setUserId(s[0].toString());
						toUserTemp.setUserNickName(s[1].toString());
						toUserTemp.setUserPhoto(s[2].toString());
						return true;
					} else
						return false;
				}
			});
			toUser = toUserTemp;
			toUser.setUserPassword(null);


			if(fromUser != null && toUser != null && rightToUser) {
				jo.add("toUser", gson.toJsonTree(toUser));
				
				session.getBasicRemote().sendText(jo.toString()); // 发送信息到客户端
			}
			
		} else {
			//jo.add("toUser", gson.toJsonTree(toUser));
			/**
			 * 若对方在线，进行推送！
			 */
			Session toUserSession = null;
			for(int i = 0; i < connections.size(); i++) {
				
				if(connections.containsKey(toUserId)) {
					toUserSession = (Session)connections.get(toUserId);
					JsonObject j = new JsonObject();
					j.addProperty("pushToUser", msg);
					toUserSession.getBasicRemote().sendText(j.toString());
				}
			}
		}
		i++;
	}

	@OnOpen // 成功连接时执行此代码
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println(connections.size());
		this.session = session;
		
		HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		fromUser = (User)httpSession.getAttribute("user");

		/**
		 * 将连接成功的用户存入connections内
		 */
		connections.put(fromUser.getUserId(), session);
		
		
		ac = new ClassPathXmlApplicationContext("beans.xml");
		hibernateTemplate = ac.getBean("hibernateTemplate", HibernateTemplate.class);
		
System.out.println("------------webSocket is Open------------");
	}

	@OnClose // 连接关闭时执行
	public void onClose() {
		System.out.println("------------webSocket is onClose------------");
	}

	
}