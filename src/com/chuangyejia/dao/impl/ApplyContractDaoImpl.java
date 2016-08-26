package com.chuangyejia.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
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

import com.chuangyejia.bean.ApplyContract;
import com.chuangyejia.dao.IApplyContractDao;

@Component(value="acd")
public class ApplyContractDaoImpl implements IApplyContractDao {

	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveApplyContract(ApplyContract ac) {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		try {
			hibernateTemplate.save(ac);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("dao层中，ApplyContractDaoImpl中，将申请合同插入数据库出错！");	
			e.printStackTrace();
		}
		
		return flag;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ApplyContract> getApplyContractInStartupsId(final String startupsId) {
		// TODO Auto-generated method stub
		List<ApplyContract> acs = null;
		try {
			acs = (ArrayList<ApplyContract>)hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					return (ArrayList<ApplyContract>)session.createQuery("from ApplyContract ac where ac.applyStartupsId = :applyStartupsId").setString("applyStartupsId", startupsId).list();
				}
			});
		} catch (DataAccessException e) {
			acs = null;
System.out.println("在ApplyContractDaoImpl.java中，获取某公司下的所有申请出错！");
			e.printStackTrace();
		}
		return acs;
	}

	@Override
	public boolean updateApplyContract(ApplyContract ac) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			hibernateTemplate.update(ac);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("更新申请合同时，出现错误！");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteApplyContract(ApplyContract ac) {
		
		boolean flag = true;
		try {
			ApplyContract applyC = (ApplyContract)hibernateTemplate.load(ApplyContract.class, ac.getApplyId());
			hibernateTemplate.delete(applyC);
		} catch(DataAccessException e) {
			flag = false;
System.out.println("删除申请时出错！");
			e.printStackTrace();
		}
		
		return flag;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ApplyContract getApplyContractInApplyId(final String applyId) {
		
		ApplyContract ac = null;
		try {
			
			ac = (ApplyContract)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String ejbql = "from ApplyContract ac where ac.applyId = :applyId";
					Query query = session.createQuery(ejbql).setString("applyId", applyId);
					return (ApplyContract)query.uniqueResult();
				}
			});
		} catch(DataAccessException e) {
			ac = null;
System.out.println("通过applyId，获取申请时出错！");
			e.printStackTrace();
		}
		
		return ac;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ApplyContract> getApplyContractInUserId(final String userId) {

		List<ApplyContract> acs = null;
		try {
			acs = (ArrayList<ApplyContract>)hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from ApplyContract ac where ac.applyOrganiserId = :applyOrganiserId";
					
					Query query = session.createQuery(ejbql).setString("applyOrganiserId", userId);
					return (ArrayList<ApplyContract>)query.list();
				}
			});

		} catch(DataAccessException e) {
			acs = null;
System.out.println("通过用户Id，获取申请集合时出错！");
			e.printStackTrace();
		}
		return acs;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ApplyContract> getApplyContractInUserId(final String userId, final String status) {
		
		List<ApplyContract> acs = null;
		
		try {
			
			acs = (ArrayList<ApplyContract>)hibernateTemplate.executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from ApplyContract ac where ac.applyOrganiserId = :applyOrganiserId and ac.applyStatus = :applyStatus";
					Query query = session.createQuery(ejbql).setString("applyOrganiserId", userId).setString("applyStatus", status);
					return (ArrayList<ApplyContract>)query.list();
				}
			});
			
		} catch(DataAccessException e) {
			acs = null;
System.out.println("通过用户Id，根据状态获取申请集合时出错！");
			e.printStackTrace();
		}
		
		return acs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ApplyContract> getApplyContractInStartupsId(final String startupsId, final String status) {
		// TODO Auto-generated method stub
		List<ApplyContract> acs = null;
		
		try {
			acs = (ArrayList<ApplyContract>)hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from ApplyContract ac where ac.applyStartupsId = :applyStartupsId and ac.applyStatus = :applyStatus";
					
					Query query = session.createQuery(ejbql).setString("applyStartupsId", startupsId).setString("applyStatus", status);
					return (ArrayList<ApplyContract>)query.list();
				}
				
			});
			
		} catch(HibernateException e) {
			acs = null;
System.out.println("通过公司Id，根据状态获取申请集合时出错！");
			e.printStackTrace();
		}
		return acs;
	}

	@Override
	public List<ApplyContract> getApplyContractInStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApplyContract> getApplyContractInCreateDate(Timestamp createDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean canApplyContract(final String userId, final String startupsId, final String status) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			int count = 1;
			count = (Integer)hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from ApplyContract ac where ac.applyStartupsId = :applyStartupsId and ac.applyStatus = :applyStatus and ac.applyOrganiserId = :applyOrganiserId";
					
					Query query = session.createQuery(ejbql).setString("applyStartupsId", startupsId).setString("applyStatus", status).setString("applyOrganiserId", userId);

					return query.list().size();
				}
			});
			
			if(count == 0)
				flag = true;
			else
				flag = false;
		} catch(HibernateException e) {
			flag = false;
System.out.println("通过公司Id,用户Id，申请状态stage来找申请时出错！");
			e.printStackTrace();
		}
		return flag;
	}
}
