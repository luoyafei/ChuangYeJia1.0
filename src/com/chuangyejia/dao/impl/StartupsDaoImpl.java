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

import com.chuangyejia.bean.Startups;
import com.chuangyejia.dao.IStartupsDao;
import com.chuangyejia.tools.StartupsTempShow;

@Component(value="sd")
public class StartupsDaoImpl implements IStartupsDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean saveStartups(Startups startups) {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		try {
			hibernateTemplate.save(startups);
		} catch(DataAccessException e) {
			flag = false;
			e.printStackTrace();
System.out.println("dao层中，在StartupsDaoImpl类，创建公司时，进行数据库存储Startups对象时，出现异常！");
		}
		return flag;
		
	}

	@Override
	public boolean updateStartups(Startups startups) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.update(startups);
		} catch(DataAccessException e) {
			flag = false;
			e.printStackTrace();
System.out.println("dao层中，在StartupsDaoImpl类，更新公司时，进行数据库更新Startups对象时，出现异常！");
		}
		return flag;
		
	}

	@Override
	public boolean deleteStartups(Startups startups) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int getAllStartupsCount() {
		// TODO Auto-generated method stub
		Long count = new Long(0);
		
		try {
			count = (Long)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					String ejbql = "select count(*) from Startups s";
					return (Long)session.createQuery(ejbql).uniqueResult();
				}
			});
			
		} catch(DataAccessException e) {
			count = 0L;
System.out.println("在dao层，StartupsDaoImpl中，获取数据库中所有公司的数量");
			e.printStackTrace();
		}
		return count.intValue();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<StartupsTempShow> getStartupTempShows(final Integer start, final Integer length, final String sort) {
		// TODO Auto-generated method stub
		List<StartupsTempShow> stsList = null;
		try {
			stsList = (List<StartupsTempShow>)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					List<StartupsTempShow> listTemp = new ArrayList<StartupsTempShow>();
					Query query = session.createQuery("from Startups s order by :sort desc").setString("sort", "s."+sort).setMaxResults(length).setFirstResult(start*length);
					List<Startups> startupsList = (List<Startups>)query.list();
					for(int i = 0; i < startupsList.size(); i++)
						listTemp.add(startupsList.get(i).toStartupsTempShow());
					return listTemp;
				}
			});
		} catch(DataAccessException e) {
			stsList = null;
			System.out.println("dao层中，在StartupsDdaoImpl类，通过start，length，cort来获取Startups对象集合时出错！");
			e.printStackTrace();
		}
		return stsList;
	}

	@Override
	public Startups getStartupsInId(String startupsId) {
		// TODO Auto-generated method stub

		Startups startups = null;
		try {
			startups = (Startups)hibernateTemplate.get(Startups.class, startupsId);
			
		} catch(DataAccessException e) {
			startups = null;
System.out.println("dao层中，在StartupsDdaoImpl类，通过startupsId来获取Startups对象出错！");
			e.printStackTrace();
		}
		return startups;
	}


	
	
	@Override
	public StartupsTempShow getStartupsTempShowInId(String startupsId) {
		// TODO Auto-generated method stub
		StartupsTempShow sts = null;
		
		try {
			Startups s = (Startups)hibernateTemplate.get(Startups.class, startupsId);
			if(s != null)
				sts =  s.toStartupsTempShow();
			else
				sts = null;
		} catch(DataAccessException e) {
			sts = null;
System.out.println("dao层中，在StartupsDdaoImpl类，通过startupsId来获取StartupsTempShow对象出错！");
			e.printStackTrace();
		}
		
		return sts;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Startups> getStartupsInLeaderId(final String leaderId) {
		// TODO Auto-generated method stub
		
		return (ArrayList<Startups>)hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String ejbql = "from Startups s where s.startupsLeader.userId = :leaderId";
				return (ArrayList<Startups>)session.createQuery(ejbql).setString("leaderId", leaderId).list();
			}
		});
	}

	@Override
	public boolean isNameRepeat(String startupsName) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Startups> getStartupsInCopartnerId(final String copartnerId) {
		// TODO Auto-generated method stub
		
		return (ArrayList<Startups>)hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				String ejbql = "select s from Startups s left join s.copartner u where u.userId = :copartnerId";
				return (ArrayList<Startups>)session.createQuery(ejbql).setString("copartnerId", copartnerId).list();
			}
		});
	}
}
