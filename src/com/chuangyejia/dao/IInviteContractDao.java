package com.chuangyejia.dao;

import java.util.List;

import com.chuangyejia.bean.InviteContract;

public interface IInviteContractDao {

	public boolean saveInviteContract(InviteContract ic);
	
	public boolean deleteInviteContract(InviteContract ic);
	
	public boolean updateInviteContract(InviteContract ic);
	
	public InviteContract getInviteContractInInviteId(String inviteId);
	
	/**
	 * 通过公司Id获取该公司下所有的邀请
	 * @param startupsId
	 * @return
	 */
	public List<InviteContract> getInviteContractsInStartupsId(String startupsId);
	
	/**
	 * 通过被邀请的用户Id，获取所有的邀请
	 * @param inviteUserId
	 * @return
	 */
	public List<InviteContract> getInviteContractsInInviteUserId(String inviteUserId);
	
	/**
	 * 通过公司Id，根据邀请状态，获取该公司下所有的邀请
	 * @param startupsId
	 * @param inviteStatus
	 * @return
	 */
	public List<InviteContract> getInviteContractsInStartupsId(String startupsId, String inviteStatus);
	
	/**
	 * 通过被邀请的用户Id，根据要求状态，获取所有的邀请
	 * @param inviteUserId
	 * @param inviteStatus
	 * @return
	 */
	public List<InviteContract> getInviteContractsInInviteUserId(String inviteUserId, String inviteStatus);
	
	/**
	 * 当被邀请的用户已经有一个邀请合同，且该邀请合同处于 正在审核状态时，该用户不能作为该公司的邀请对象
	 * @param startupsId
	 * @param inviteUserId
	 * @param inviteStatus
	 * @return
	 */
	public boolean canInviteContract(String startupsId, String inviteUserId, String inviteStatus);
	
	
	
}
