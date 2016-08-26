package com.chuangyejia.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ApplyContract;
import com.chuangyejia.dao.IApplyContractDao;
import com.chuangyejia.service.IApplyContractService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.UserTempShow;

@Component(value="acs")
public class ApplyContractServiceImpl implements IApplyContractService {

	private IApplyContractDao acd;
	private IUserService us;
	
	public IApplyContractDao getAcd() {
		return acd;
	}
	@Resource(name="acd")
	public void setAcd(IApplyContractDao acd) {
		this.acd = acd;
	}
	public IUserService getUs() {
		return us;
	}
	@Resource(name="us")
	public void setUs(IUserService us) {
		this.us = us;
	}
	
	
	@Override
	public boolean saveApplyContract(ApplyContract ac) {
		// TODO Auto-generated method stub
		return acd.saveApplyContract(ac);
	}

	@Override
	public boolean updateApplyContract(ApplyContract ac) {
		// TODO Auto-generated method stub
		return acd.updateApplyContract(ac);
	}

	@Override
	public boolean deleteApplyContract(ApplyContract ac) {
		// TODO Auto-generated method stub
		return acd.deleteApplyContract(ac);
	}

	@Override
	public ApplyContract getApplyContractInApplyId(String applyId) {
		// TODO Auto-generated method stub
		return acd.getApplyContractInApplyId(applyId);
	}

	@Override
	public List<ApplyContract> getApplyContractInUserId(String userId) {
		// TODO Auto-generated method stub
		return acd.getApplyContractInUserId(userId);
	}

	@Override
	public List<ApplyContract> getApplyContractInUserId(String userId, String status) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ApplyContract> getApplyContractInStartupsId(String startupsId, String status) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ApplyContract> getApplyContractInStartupsId(String startupsId) {
		// TODO Auto-generated method stub
		return acd.getApplyContractInStartupsId(startupsId);
	}

	@Override
	public List<ApplyContract> getApplyContractInStatus(String status) {
		// TODO Auto-generated method stub
		return acd.getApplyContractInStatus(status);
	}

	@Override
	public List<ApplyContract> getApplyContractInCreateDate(Timestamp createDate) {
		// TODO Auto-generated method stub
		return acd.getApplyContractInCreateDate(createDate);
	}


	@Override
	public boolean canApplyContract(String userId, String startupsId, String stataus) {
		// TODO Auto-generated method stub
		
		
		return acd.canApplyContract(userId, startupsId, stataus);
	}


	@Override
	public List<ApplyContract> getApplyContractInLeaderId(String leaderId) {
		// TODO Auto-generated method stub
		List<ApplyContract> allLeaderStartupsReceivedApply = new ArrayList<ApplyContract>();
		
		UserTempShow uts = us.getUserTempShowInId(leaderId);
		/**
		 * 先将该用户创建的所有公司取出，再将每个公司中所有的申请取出，
		 * 最后全部加入一个总的List中
		 */
		Iterator<StartupsTempShow> itSts = uts.getAllLeaderStartups().iterator();
		while(itSts.hasNext()) {
			allLeaderStartupsReceivedApply.addAll(acd.getApplyContractInStartupsId(itSts.next().getStartupsId()));
		}
		return allLeaderStartupsReceivedApply;
	}
}
