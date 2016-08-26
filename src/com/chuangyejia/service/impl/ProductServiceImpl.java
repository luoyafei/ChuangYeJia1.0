package com.chuangyejia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.dao.IProductDao;
import com.chuangyejia.service.IProductService;

@Component(value="ps")
public class ProductServiceImpl implements IProductService {

	
	private IProductDao pd;
	
	public IProductDao getPd() {
		return pd;
	}
	@Resource(name="pd")
	public void setPd(IProductDao pd) {
		this.pd = pd;
	}

	@Override
	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.saveProduct(p);
	}

	@Override
	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.deleteProduct(p);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.updateProduct(p);
	}

	@Override
	public Product getProductInId(String productId) {
		// TODO Auto-generated method stub
		return pd.getProductInId(productId);
	}

	@Override
	public List<Product> getProductsInStartupsId(String startupsId) {
		// TODO Auto-generated method stub
		return pd.getProductsInStartupsId(startupsId);
	}

	@Override
	public List<Product> getProductsInUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsListToShow(Integer start, Integer length, String sort) {
		// TODO Auto-generated method stub
		return pd.getProductsListToShow(start, length, sort);
	}

	
	@Override
	public int getAllProductsCount() {
		// TODO Auto-generated method stub
		return pd.getAllProductsCount();
	}
}
