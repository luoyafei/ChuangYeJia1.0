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

import com.chuangyejia.bean.InviteContract;
import com.chuangyejia.dao.IInviteContractDao;

@Component(value = "icd")
public class InviteContractDaoImpl implements IInviteContractDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {

			hibernateTemplate.save(ic);

		} catch (DataAccessException e) {
			flag = false;
			System.out.println("存储邀请合同出错！");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {

			hibernateTemplate.delete(ic);

		} catch (DataAccessException e) {
			flag = false;
			System.out.println("删除邀请合同出错！");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {

			hibernateTemplate.update(ic);

		} catch (DataAccessException e) {
			flag = false;
			System.out.println("更新邀请合同出错！");
			e.printStackTrace();
		}
		return flag;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public InviteContract getInviteContractInInviteId(final String inviteId) {
		// TODO Auto-generated method stub
		InviteContract ic = null;
		try {

			ic = (InviteContract) hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from InviteContract ic where ic.inviteId = :inviteId";

					Query query = session.createQuery(ejbql).setString("inviteId", inviteId);
					return (InviteContract) query.uniqueResult();
				}
			});

		} catch (DataAccessException e) {
			ic = null;
			System.out.println("通过inviteId，获取邀请时出错！");
			e.printStackTrace();
		}

		return ic;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<InviteContract> getInviteContractsInStartupsId(final String startupsId) {
		// TODO Auto-generated method stub
		List<InviteContract> ics = null;

		try {

			ics = (ArrayList<InviteContract>) hibernateTemplate.executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from InviteContract ic where ic.inviteOrganiserStartupsId = :startupsId";
					Query query = session.createQuery(ejbql).setString("startupsId", startupsId);
					return (ArrayList<InviteContract>) query.list();
				}

			});

		} catch (DataAccessException e) {
			ics = null;
			System.out.println("在InviteContractDaoImpl.java中，获取某公司下的所有邀请出错！");
			e.printStackTrace();
		}

		return ics;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<InviteContract> getInviteContractsInInviteUserId(final String inviteUserId) {
		// TODO Auto-generated method stub
		List<InviteContract> ics = null;

		try {

			ics = (ArrayList<InviteContract>) hibernateTemplate.executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from InviteContract ic where ic.inviteUserId = :inviteUserId";

					Query query = session.createQuery(ejbql).setString("inviteUserId", inviteUserId);
					return (ArrayList<InviteContract>) query.list();

				}

			});

		} catch (DataAccessException e) {
			ics = null;
			System.out.println("在InviteContractDaoImpl.java中，获取某用户的所有被邀请的合同出错！");
			e.printStackTrace();
		}

		return ics;
	}

	@Override
	public List<InviteContract> getInviteContractsInStartupsId(String startupsId, String inviteStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InviteContract> getInviteContractsInInviteUserId(String inviteUserId, String inviteStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean canInviteContract(final String startupsId, final String inviteUserId, final String inviteStatus) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			int count = 1;
			count = (Integer) hibernateTemplate.execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String ejbql = "from InviteContract ic where ic.inviteOrganiserStartupsId = :startupsId and ic.inviteStatus = :inviteStatus and ic.inviteUserId = :inviteUserId";

					Query query = session.createQuery(ejbql).setString("startupsId", startupsId)
							.setString("inviteStatus", inviteStatus).setString("inviteUserId", inviteUserId);

					return query.list().size();

				}

			});

			if (count == 0)
				flag = true;
			else
				flag = false;
		} catch (DataAccessException e) {
			flag = false;
			System.out.println("通过公司Id,用户Id，邀请状态stage来找邀请时出错！");
			e.printStackTrace();
		}
		return flag;
	}

}
