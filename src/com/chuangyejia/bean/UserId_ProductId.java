package com.chuangyejia.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户Id与产品Id对应表
 * 用于存储购物车的数据
 * @author Diamond
 */
@Entity
@Table(name="userId_productId")
public class UserId_ProductId {

	@Override
	public String toString() {
		return "UserId_ProductId [upId=" + upId + ", userId=" + userId + ", productId=" + productId + "]";
	}
	private int upId;
	private String userId = null;
	private String productId = null;
	
	public UserId_ProductId() {}
	
	public UserId_ProductId(String userId, String productId) {
		this.userId = userId;
		this.productId = productId;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUpId() {
		return upId;
	}
	public void setUpId(int upId) {
		this.upId = upId;
	}
	

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

}
