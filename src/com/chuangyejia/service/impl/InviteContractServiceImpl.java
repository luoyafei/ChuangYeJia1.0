package com.chuangyejia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.InviteContract;
import com.chuangyejia.dao.IInviteContractDao;
import com.chuangyejia.service.IInviteContractService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;

@Component(value="ics")
public class InviteContractServiceImpl implements IInviteContractService {

	private IInviteContractDao icd;
	private IUserService us;
	public IInviteContractDao getIcd() {
		return icd;
	}
	@Resource(name="icd")
	public void setIcd(IInviteContractDao icd) {
		this.icd = icd;
	}
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	@Override
	public boolean saveInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		return icd.saveInviteContract(ic);
	}

	@Override
	public boolean deleteInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		return icd.deleteInviteContract(ic);
	}

	@Override
	public boolean updateInviteContract(InviteContract ic) {
		// TODO Auto-generated method stub
		return icd.updateInviteContract(ic);
	}

	@Override
	public InviteContract getInviteContractInInviteId(String inviteId) {
		// TODO Auto-generated method stub
		return icd.getInviteContractInInviteId(inviteId);
	}

	@Override
	public List<InviteContract> getInviteContractsInStartupsId(String startupsId) {
		// TODO Auto-generated method stub
		return icd.getInviteContractsInStartupsId(startupsId);
	}

	@Override
	public List<InviteContract> getInviteContractsInInviteUserId(String inviteUserId) {
		// TODO Auto-generated method stub
		return icd.getInviteContractsInInviteUserId(inviteUserId);
	}

	@Override
	public List<InviteContract> getInviteContractsInStartupsId(String startupsId, String inviteStatus) {
		// TODO Auto-generated method stub
		return icd.getInviteContractsInStartupsId(startupsId, inviteStatus);
	}

	@Override
	public List<InviteContract> getInviteContractsInInviteUserId(String inviteUserId, String inviteStatus) {
		// TODO Auto-generated method stub
		return icd.getInviteContractsInInviteUserId(inviteUserId, inviteStatus);
	}

	@Override
	public boolean canInviteContract(String startupsId, String inviteUserId, String inviteStatus) {
		// TODO Auto-generated method stub
		return icd.canInviteContract(startupsId, inviteUserId, inviteStatus);
	}

	@Override
	public List<InviteContract> getInviteContractInLeaderId(String leaderId) {
		// TODO Auto-generated method stub
		List<InviteContract> allLeaderStartupsSendInvite = new ArrayList<InviteContract>();
		
		UserTempShow uts = us.getUserTempShowInId(leaderId);
		/**
		 * 先将该用户创建的所有公司取出，再将每个公司中所有的邀请取出，
		 * 最后全部加入一个总的List中
		 */
		Iterator<StartupsTempShow> itSts = uts.getAllLeaderStartups().iterator();
		while(itSts.hasNext()) {
			allLeaderStartupsSendInvite.addAll(icd.getInviteContractsInStartupsId(itSts.next().getStartupsId()));
		}
		return allLeaderStartupsSendInvite;
	}



}
