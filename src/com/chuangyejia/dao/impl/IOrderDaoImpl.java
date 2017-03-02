package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.dao.IOrderDao;

@Component(value="iodi")
public class IOrderDaoImpl implements IOrderDao {

	private HibernateTemplate hibernateTemplate;	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private boolean saveOrder(Order order) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.save(order);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("存储订单出现异常！");
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public boolean saveOrders(Order[] orders) {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		try {
			
			for(Order o : orders) {
				if(!saveOrder(o)) {
					flag = false;
					break;
				}
			}
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("存储订单出现异常！");
			e.printStackTrace();
		}
		
		return flag;
	}

	private boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.update(order);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("更新订单出现异常！");
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public boolean updateOrders(Order[] orders) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			for(Order o : orders) {
				if(!updateOrder(o)) {
					flag = false;
					break;
				}
			}
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("更新订单出现异常！");
			e.printStackTrace();
		}
		return flag;
	}

	
	private boolean deleteOrder(Order o) {
		boolean flag = true;
		try {
			hibernateTemplate.delete(o);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("删除订单出现异常！");
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean deleteOrders(Order[] orders) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			for(Order o : orders) {
				if(!deleteOrder(o)) {
					flag = false;
					break;
				}
			}
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("删除订单出现异常！");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		Order order = null;
		try {
			order = (Order) hibernateTemplate.get(Order.class, orderId);
		} catch(DataAccessException e) {
System.out.println("通过orderId获取订单，出现异常");
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Order[] getOrders(String[] orderIds) {
		// TODO Auto-generated method stub
		Order[] orders = new Order[orderIds.length];
		int i = 0;
		for(String orderId : orderIds) {
			Order o = getOrder(orderId);
			if(o == null) {
				orders = null;
System.out.println("获取订单出错！");
				break;
			}
			orders[i++] = o;
		}
		return orders;
	}

	@Override
	public Order[] getOrdersByUserId(final String userId, final String orderStatus) {
		// TODO Auto-generated method stub
		Order[] orders = null;
		try {
			List<Order> listOrders = hibernateTemplate.execute(new HibernateCallback<List<Order>>() {
				@SuppressWarnings("unchecked")
				@Override
				public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return session.createQuery("from Order o where o.userid = :userId and o.status = :orderStatus").setString("userId", userId).setString("orderStatus", orderStatus).list();
				}
			});
			orders = listOrders.toArray(new Order[listOrders.size()]);
		} catch(DataAccessException e) {
System.out.println("通过买家id和订单状态，获取订单");
			e.printStackTrace();
		}
		
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order[] getOrdersByUserIsSigned(final String userId, final String isSigned) {
		// TODO Auto-generated method stub
		Order[] orders = null;
		try {
			List<Order> listOrders = hibernateTemplate.executeFind(new HibernateCallback<List<Order>>() {
				@Override
				public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return session.createQuery("from Order o where o.userid = :userId and o.isSigned = :isSigned").setString("userId", userId).setString("isSigned", isSigned).list();
				}
			});
			orders = listOrders.toArray(new Order[listOrders.size()]); 
		} catch(DataAccessException e) {
System.out.println("通过买家id和签收状态，获取订单");
			e.printStackTrace();
		}
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order[] getOrdersByStartupsId(final String startupsId, final String orderStatus) {
		// TODO Auto-generated method stub
		Order[] orders = null;
		try {
			List<Order> listOrders = hibernateTemplate.executeFind(new HibernateCallback<List<Order>>() {

				@Override
				public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return session.createQuery("from Order o where o.startupsId.startupsId = :startupsId and o.status = :orderStatus").setString("startupsId", startupsId).setString("orderStatus", orderStatus).list();
				}
				
			});
			orders = listOrders.toArray(new Order[listOrders.size()]);
		} catch(DataAccessException e) {
System.out.println("通过公司id和订单状态，获取订单");
			e.printStackTrace();
		}
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order[] getOrdersByStartupsIdIsSigned(final String startupsId, final String isSigned) {
		// TODO Auto-generated method stub
		Order[] orders = null;
		try {
			List<Order> listOrders = hibernateTemplate.executeFind(new HibernateCallback<List<Order>>() {

				@Override
				public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return session.createQuery("from Order o where o.startupsId.startupsId = :startupsId and o.isSigned = :isSigned").setString("startupsId", startupsId).setString("isSigned", isSigned).list();
				}
			});
			orders = listOrders.toArray(new Order[listOrders.size()]);
			
		} catch(DataAccessException e) {
System.out.println("通过公司Id与是否签收，获取订单");
			e.printStackTrace();
		}
		return orders;
	}

	
	@Override
	public Order[] getOrdersByUserId(String userId, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order[] getOrdersByStartupsId(String startupsId, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order[] getOrdersByStartupsIdsIsSigned(String[] startupsIds, String isSigned) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order[] getOrdersByStartupsIdsOrderStatus(String[] startupsIds, String orderStatus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Order[] getOrdersByStartupsIds(final String[] startupsIds, final String orderStatus, final String isSigned) {
		// TODO Auto-generated method stub
		Order[] orders = null;
		try {
			List<Order> listOrders = hibernateTemplate.executeFind(new HibernateCallback<List<Order>>() {

				@Override
				public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					List<Order> allOrders = new ArrayList<Order>();
					for(String startupsId : startupsIds) {
						allOrders.addAll(session.createQuery("from Order o where o.startupsId.startupsId = :startupsId and o.isSigned = :isSigned and o.status = :orderStatus").setString("startupsId", startupsId).setString("isSigned", isSigned)
								.setString("orderStatus", orderStatus).list());
					}
					return allOrders;
				}
			});
			orders = listOrders.toArray(new Order[listOrders.size()]);
			
		} catch(DataAccessException e) {
System.out.println("通过公司Id与是否签收，获取订单");
			e.printStackTrace();
		}
		return orders;
	}
	@Override
	public Order[] getOrdersBySellerIdOrderStatus(String sellerId, String orderStatus) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order[] getOrdersBySellerIdIsSigned(String sellerId, String isSigned) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Order[] getOrdersBySellerId(final String sellerId, final String orderStatus, final String isSigned) {
		// TODO Auto-generated method stub
		
		Order[] orders = null;
		try {
			List<String> listStartupsIds = hibernateTemplate.executeFind(new HibernateCallback<List<String>>() {
				@Override
				public List<String> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return session.createQuery("select startupsId from Startups s where s.startupsLeader.userId = :leaderId").setString("leaderId", sellerId).list();
				}
			});
			orders =  getOrdersByStartupsIds(listStartupsIds.toArray(new String[listStartupsIds.size()]), orderStatus, isSigned);
			
		} catch(DataAccessException e) {
System.out.println("通过公司Id与是否签收，获取订单");
			e.printStackTrace();
		}
		return orders;
	}
}
