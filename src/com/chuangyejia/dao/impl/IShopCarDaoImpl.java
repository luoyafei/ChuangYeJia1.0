package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.ShopCar;
import com.chuangyejia.bean.UserId_ProductId;
import com.chuangyejia.dao.IShopCarDao;

@Component("iscd")
public class IShopCarDaoImpl implements IShopCarDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean saveUserIdProductId(String userId, String productId) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			UserId_ProductId up = new UserId_ProductId(userId, productId);
			hibernateTemplate.save(up);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("将产品存入购物车数据库出错！");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteProductInShopCar(final String userId, String[] productIds) {
		// TODO Auto-generated method stub
		boolean flag = true;
		for(final String productId : productIds) {
			flag = hibernateTemplate.execute(new HibernateCallback<Boolean>() {
				@Override
				public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
					int result = session.createQuery("delete from UserId_ProductId up where up.userId = :userId and up.productId = :productId").setString("userId", userId).setString("productId", productId).executeUpdate();
					if(result > 0)
						return true;
					else
						return false;
				}
			});
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Product> getProductsInUserId(final String userId) {
		// TODO Auto-generated method stub
		return (Vector<Product>) hibernateTemplate.executeFind(new HibernateCallback<Vector<Product>>() {
			@Override
			public Vector<Product> doInHibernate(Session session) throws HibernateException, SQLException {
				Vector<Product> ps = new Vector<>();

				List<String> productIds = session.createQuery("select productId from UserId_ProductId up where up.userId = :userId").setString("userId", userId).list();
				for(String productId : productIds) {

					hibernateTemplate.get(Product.class, productId);
					ps.add(hibernateTemplate.get(Product.class, productId));
				}
				return ps;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getProductIdsInUserId(final String userId) {
		// TODO Auto-generated method stub
		return (Vector<String>) hibernateTemplate.executeFind(new HibernateCallback<Vector<String>>() {
			@Override
			public Vector<String> doInHibernate(Session session) throws HibernateException, SQLException {
				Vector<String> strs = new Vector<>();
				List<String> listStrs = session.createQuery("select productId from UserId_ProductId up where up.userId = :userId").setString("userId", userId).list();
				for(String s : listStrs)
					strs.add(s);
				return strs;
			}
		});
	}
	@Override
	public boolean saveShopCar(ShopCar sc) {
		// TODO Auto-generated method stub
		return false;
	}

}
