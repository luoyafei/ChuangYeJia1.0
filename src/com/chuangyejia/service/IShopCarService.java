package com.chuangyejia.service;

import java.util.Vector;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.ShopCar;

public interface IShopCarService {

	boolean saveShopCar(ShopCar sc);
	boolean deleteProductInShopCar(String userId, String[] productIds);
	Vector<Product> getProductsInUserId(String userId);//获取所有产品
	Vector<String> getProductIdsInUserId(String userId);//获取所有产品Id
	boolean saveUserIdProductId(String userId, String productId);
}
