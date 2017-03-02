package com.chuangyejia.dao;

import com.chuangyejia.bean.Order;

public interface IOrderDao {

	boolean saveOrders(Order[] orders);
	boolean updateOrders(Order[] orders);
	boolean deleteOrders(Order[] orders);
	Order getOrder(String orderId);
	Order[] getOrders(String[] orderIds);
	/**
	 * 根据买家，订单状态，获取订单
	 * @param userId
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @return
	 */
	Order[] getOrdersByUserId(String userId, String orderStatus);
	
	/**
	 * 根据买家，订单状态，是否签收， 获取订单
	 * @param userId
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByUserId(String userId, String orderStatus, String isSigned);
	
	/**
	 * 根据买家，是否签收，获取订单
	 * 买家用户，查看自己签收与否的所有订单
	 * @param userId
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByUserIsSigned(String userId, String isSigned);
	
	/**
	 * 根据卖家公司Id， 订单状态，获取订单
	 * @param startupsId
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @return
	 */
	Order[] getOrdersByStartupsId(String startupsId, String orderStatus);
	
	/**
	 * 根据卖家公司Id， 订单状态，买家是否签收， 获取订单
	 * @param startupsId
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByStartupsId(String startupsId, String orderStatus, String isSigned);
	
	/**
	 * 公司查询所有签收或未签收的订单
	 * @param startupsId
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByStartupsIdIsSigned(String startupsId, String isSigned);

	/**
	 * 通过批量公司Id，是否签收，获取所有订单
	 * @param startupsIds
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByStartupsIdsIsSigned(String[] startupsIds, String isSigned);
	/**
	 * 通过批量公司Id， 订单状态，获取所有订单
	 * @param startupsIds
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @return
	 */
	Order[] getOrdersByStartupsIdsOrderStatus(String[] startupsIds, String orderStatus);
	/**
	 * 通过批量公司Id， 订单状态，是否签收，获取所有订单
	 * @param startupsIds
	 * @param orderStatus (0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废)
	 * @param isSigned (0:未签收，1:已签收，2：已上传凭证)
	 * @return
	 */
	Order[] getOrdersByStartupsIds(String[] startupsIds, String orderStatus, String isSigned);
	
	/**
	 * 通过卖家Id，订单状态，获取所有订单
	 * @param sellerId
	 * @param orderStatus
	 * @return
	 */
	Order[] getOrdersBySellerIdOrderStatus(String sellerId, String orderStatus);
	/**
	 * 通过卖家Id，是否签收，获取所有订单
	 * @param sellerId
	 * @param orderStatus
	 * @return
	 */
	Order[] getOrdersBySellerIdIsSigned(String sellerId, String isSigned);
	/**
	 * 通过卖家Id，订单状态，是否签收，获取所有订单
	 * @param sellerId
	 * @param orderStatus
	 * @param isSigned
	 * @return
	 */
	Order[] getOrdersBySellerId(String sellerId, String orderStatus, String isSigned);
	
}
