package com.chuangyejia.dao;

import java.util.List;

import com.chuangyejia.bean.Product;

public interface IProductDao {

	public boolean saveProduct(Product p);
	public boolean deleteProduct(Product p);
	public boolean updateProduct(Product p);
	public Product getProductInId(String productId);
	public List<Product> getProductsInStartupsId(String startupsId);
	public List<Product> getProductsListToShow(Integer start, Integer length, String sort);
	public int getAllProductsCount();
}
