package com.chuangyejia.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.Startups;
import com.chuangyejia.bean.User;
import com.chuangyejia.dao.IOrderDao;
import com.chuangyejia.service.IOrderService;

@Component(value="iosi")
public class IOrderServiceImpl implements IOrderService {

	private IOrderDao iod;
	public IOrderDao getIod() {
		return iod;
	}
	@Resource(name="iodi")
	public void setIod(IOrderDao iod) {
		this.iod = iod;
	}

	@Override
	public boolean saveOrders(Order[] orders) {
		// TODO Auto-generated method stub
		return iod.saveOrders(orders);
	}

	@Override
	public boolean updateOrders(Order[] orders) {
		// TODO Auto-generated method stub
		return iod.updateOrders(orders);
	}

	@Override
	public boolean deleteOrders(Order[] orders) {
		// TODO Auto-generated method stub
		return iod.deleteOrders(orders);
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return hideField(new Order[]{iod.getOrder(orderId)})[0];
	}

	@Override
	public Order[] getOrders(String[] orderIds) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrders(orderIds));
	}

	@Override
	public Order[] getOrdersByUserId(String userId, String orderStatus) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByUserId(userId, orderStatus));
	}

	@Override
	public Order[] getOrdersByUserIsSigned(String userId, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByUserIsSigned(userId, isSigned));
	}

	@Override
	public Order[] getOrdersByStartupsId(String startupsId, String orderStatus) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsId(startupsId, orderStatus));
	}

	@Override
	public Order[] getOrdersByStartupsIdIsSigned(String startupsId, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsIdIsSigned(startupsId, isSigned));
	}
	

	@Override
	public Order[] getOrdersByUserId(String userId, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByUserId(userId, orderStatus, isSigned));
	}
	@Override
	public Order[] getOrdersByStartupsId(String startupsId, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsId(startupsId, orderStatus, isSigned));
	}
	@Override
	public Order[] getOrdersByStartupsIdsIsSigned(String[] startupsIds, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsIdsIsSigned(startupsIds, isSigned));
	}
	@Override
	public Order[] getOrdersByStartupsIdsOrderStatus(String[] startupsIds, String orderStatus) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsIdsOrderStatus(startupsIds, orderStatus));
	}
	@Override
	public Order[] getOrdersByStartupsIds(String[] startupsIds, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersByStartupsIds(startupsIds, orderStatus, isSigned));
	}
	@Override
	public Order[] getOrdersBySellerIdOrderStatus(String sellerId, String orderStatus) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersBySellerIdOrderStatus(sellerId, orderStatus));
	}
	@Override
	public Order[] getOrdersBySellerIdIsSigned(String sellerId, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersBySellerIdIsSigned(sellerId, isSigned));
	}
	@Override
	public Order[] getOrdersBySellerId(String sellerId, String orderStatus, String isSigned) {
		// TODO Auto-generated method stub
		return hideField(iod.getOrdersBySellerId(sellerId, orderStatus, isSigned));
	}
	
	/**
	 * 隐藏订单中产品和公司的某些敏感字段
	 * @param orders
	 * @return
	 */
	private Order[] hideField(Order[] orders) {
		
		Order[] newOrder = new Order[orders.length];
		int i = 0;
		for(Order o : orders) {
			
			newOrder[i] = new Order();
			newOrder[i].setOrderId(o.getOrderId());
			newOrder[i].setAddr(o.getAddr());
			newOrder[i].setIsSigned(o.getIsSigned());
			newOrder[i].setOrderDate(o.getOrderDate());
			newOrder[i].setProductCount(o.getProductCount());
			newOrder[i].setStatus(o.getStatus());
			newOrder[i].setUnitPrice(o.getUnitPrice());
			
			Product pn = new Product();
			pn.setProductId(o.getProductId().getProductId());
			pn.setProductName(o.getProductId().getProductName());
			pn.setProductPrice(o.getProductId().getProductPrice());
			newOrder[i].setProductId(pn);
			Startups sn = new Startups();
			sn.setStartupsId(o.getStartupsId().getStartupsId());
			sn.setStartupsName(o.getStartupsId().getStartupsName());
			User un = new User();
			un.setUserId(o.getUserid().getUserId());
			un.setUserNickName(o.getUserid().getUserNickName());
			
			newOrder[i].setProductId(pn);
			newOrder[i].setUserid(un);
			newOrder[i].setStartupsId(sn);
			
			i++;
		}
		return newOrder;
	}
}
