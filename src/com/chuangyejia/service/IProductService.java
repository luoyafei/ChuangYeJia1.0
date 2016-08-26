package com.chuangyejia.service;

import java.util.List;

import com.chuangyejia.bean.Product;

public interface IProductService {

	public boolean saveProduct(Product p);
	public boolean deleteProduct(Product p);
	public boolean updateProduct(Product p);
	public Product getProductInId(String productId);
	public List<Product> getProductsInStartupsId(String startupsId);
	/**
	 * 将某个人所创建过的所有产品取出，
	 * 即，将所有他的leader的公司所创建的产品都取出！
	 * @param userId
	 * @return
	 */
	public List<Product> getProductsInUserId(String userId);
	public List<Product> getProductsListToShow(Integer start, Integer length, String sort);
	public int getAllProductsCount();
	
}
