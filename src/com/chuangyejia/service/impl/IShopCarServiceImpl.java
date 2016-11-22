package com.chuangyejia.service.impl;

import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.ShopCar;
import com.chuangyejia.dao.IShopCarDao;
import com.chuangyejia.service.IShopCarService;

@Component("iscs")
public class IShopCarServiceImpl implements IShopCarService {

	private IShopCarDao iscd;
	public IShopCarDao getIscd() {
		return iscd;
	}
	@Resource(name="iscd")
	public void setIscd(IShopCarDao iscd) {
		this.iscd = iscd;
	}
	
	@Override
	public boolean saveShopCar(ShopCar sc) {
		// TODO Auto-generated method stub
		return iscd.saveShopCar(sc);
	}

	@Override
	public boolean deleteProductInShopCar(String userId, String[] productIds) {
		// TODO Auto-generated method stub
		return iscd.deleteProductInShopCar(userId, productIds);
	}

	@Override
	public Vector<Product> getProductsInUserId(String userId) {
		// TODO Auto-generated method stub
		return iscd.getProductsInUserId(userId);
	}

	@Override
	public Vector<String> getProductIdsInUserId(String userId) {
		// TODO Auto-generated method stub
		return iscd.getProductIdsInUserId(userId);
	}
	@Override
	public boolean saveUserIdProductId(String userId, String productId) {
		// TODO Auto-generated method stub
		return iscd.saveUserIdProductId(userId, productId);
	}

}
