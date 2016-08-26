package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Product;
import com.chuangyejia.dao.IProductDao;

@Component(value="pd")
public class ProductDaoImpl implements IProductDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			
			hibernateTemplate.save(p);
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("存储Product对象出错！");
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			
			hibernateTemplate.delete(p);
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("删除Product对象出错！");
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			
			hibernateTemplate.update(p);
			
		} catch(DataAccessException e) {
			flag = false;
System.out.println("更新Product对象出错！");
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Product getProductInId(String productId) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			
			product = (Product)hibernateTemplate.get(Product.class, productId);
			
		} catch(DataAccessException e) {
System.out.println("通过productId,获取Product对象出错！");
			e.printStackTrace();
		}
		
		return product;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> getProductsInStartupsId(final String startupsId) {
		// TODO Auto-generated method stub
		List<Product> products = null;
		try {
			
			products = (ArrayList<Product>)hibernateTemplate.executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from Product p where p.productStartups.startupsId = :startupsId";
					Query query = session.createQuery(ejbql).setString("startupsId", startupsId);
					return (ArrayList<Product>)query.list();
				}
				
			});
			
		} catch(DataAccessException e) {
			products = null;
System.out.println("通过productId,获取Product对象出错！");
			e.printStackTrace();
		}
		
		return products;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> getProductsListToShow(final Integer start, final Integer length, final String sort) {
		// TODO Auto-generated method stub
		List<Product> ps = null;
		try {
			
			ps = (ArrayList<Product>)hibernateTemplate.executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Query query = session.createQuery("from Product p order by :sort desc").setString("sort", "p."+sort).setMaxResults(length).setFirstResult(start*length);
					return (ArrayList<Product>)query.list();
				}
				
			});
			
		} catch(DataAccessException e) {
			ps = null;
System.out.println("dao层中，在ProductDaoImpl类，通过start，length，cort来获取Product对象集合时出错！");
			e.printStackTrace();
		}

		return ps;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int getAllProductsCount() {
		// TODO Auto-generated method stub
		Long count = new Long(0);
		try {
			
			count = (Long)hibernateTemplate.execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String ejbql = "select count(*) from Product s";
					return (Long)session.createQuery(ejbql).uniqueResult();
				}
				
			});
			
			
			
		} catch(HibernateException e) {
			count = new Long(0);
System.out.println("在dao层，ProductDaoImpl中，获取数据库中所有产品的数量");
			e.printStackTrace();
		}
		return count.intValue();
	}
	
	

}
