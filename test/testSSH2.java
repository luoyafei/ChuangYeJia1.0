import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.ShopCar;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;

@ContextConfiguration("classpath:beans.xml")
public class testSSH2 extends AbstractJUnit4SpringContextTests {
	
	@Resource(name="us")
	private IUserService ius;
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate ht;
	
	@Test
	public void testOrder() {
		/**
		 * 402881fc5684957d0156849ef02b0001 | 好东西修改               |
| 402881fc5684957d015684a4255e0002 | 好东西一起分享啊         |
| 402881fc56892db30156893256d40001
		 */
		ShopCar car = new ShopCar();
		User userId = ht.get(User.class, "402881fc56415b8001564162f8330001");
		car.setUserId(userId);
//		car.setProducts(ps);
		ht.save(car);
//		System.out.println(car.getShopCarId());
	}
	
	@Test
	public void testSSH() {
		User user = new User();
		user.setUserNickName("测试胜多负少地方就是的");
		user.setUserPassword("cksejrksejkf");
		ht.save(user);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void main(String[] args) {
		
		final HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean("hibernateTemplate", HibernateTemplate.class);
		
		final String ebjqlForCM = "select cm.fromUserId from ChatMessage cm where cm.toUserId = :userId and cm.needRead = :needRead";
		final String ejbqlForUser = "select u.userId, u.userNickName, u.userPhoto from User u where u.userId = :fromUserId";
		List<User> users = null;
		
		final String userId = "402881fc56415b8001564162f8330001 ";
		final int needRead = 1;
		
		
		Long l = (Long)hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String ejbql = "select count(*) from ChatMessage cm where cm.fromUserId = :fromUserId and cm.toUserId = :toUserId and cm.needRead = :needRead";
				return (Long)session.createQuery(ejbql).setParameter("fromUserId", "402881fc56c5cdba0156c5cf9d1e0002 ").setParameter("toUserId", "402881fc56415b8001564162f8330001 ").setParameter("needRead", 0).uniqueResult();
			}
			
		});
		System.out.println(l.longValue());
		
		
		users = (ArrayList<User>)hibernateTemplate.executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				/**
				 * 先获取所有的发送消息的用户Id
				 */
				ArrayList<String> fromUserIds = (ArrayList<String>)session.createQuery(ebjqlForCM).setParameter("userId", userId).setParameter("needRead", needRead).list();
				if(fromUserIds != null && fromUserIds.size() > 0) {
					List<User> usersTemp = new ArrayList<User>();
					
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
				} else {
					return null;
				}
			}
			
		});
		
		System.out.println(users.size());
		System.out.println(users.get(0).toString());
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCount() {
		Long l = (Long)ht.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				String ejbql = "select count(*) from ChatMessage cm where cm.formUserId = :fromUserId and cm.toUserId = :toUserId and cm.needRead = :needRead";
				return (Long)session.createQuery(ejbql).setParameter("fromUserId", "402881fc56c5cdba0156c5cf9d1e0002 ").setParameter("toUserId", "402881fc56415b8001564162f8330001 ").setParameter("needRead", 0).uniqueResult();
			}
			
		});
		System.out.println(l.longValue());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDelete() {
		
		ht.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				
				session.delete("delete from User u where u.userId = '402881fc567011c701567011cb0c0002'");
				return null;
				
			}
			
		});
		
		
	}
}
