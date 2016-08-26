package com.chuangyejia.service;

import java.sql.Timestamp;
import java.util.List;

import com.chuangyejia.bean.ApplyContract;

public interface IApplyContractService {

	/**
	 * 存储ApplyContract对象
	 * @param ac
	 * @return
	 */
	public boolean saveApplyContract(ApplyContract ac);
	/**
	 * 更改ApplyContract对象
	 * @param ac
	 * @return
	 */
	public boolean updateApplyContract(ApplyContract ac);
	/**
	 * 删除ApplyContract对象
	 * @param ac
	 * @return
	 */
	public boolean deleteApplyContract(ApplyContract ac);
	/**
	 * 通过applyId获取ApplyContract对象
	 * @param applyId
	 * @return
	 */
	public ApplyContract getApplyContractInApplyId(String applyId);
	/**
	 * 获取某个用户下的所有申请
	 * @param userId
	 * @return
	 */
	public List<ApplyContract> getApplyContractInUserId(String userId);
	/**
	 * 获取某个公司被申请的所有申请
	 * @param startupsId
	 * @return
	 */
	public List<ApplyContract> getApplyContractInStartupsId(String startupsId);
	/**
	 * 根据申请状态，获取所有申请
	 * @param status
	 * @return
	 */
	public List<ApplyContract> getApplyContractInStatus(String status);
	/**
	 * 根据创建时间，获取所有申请
	 * @param createDate
	 * @return
	 */
	public List<ApplyContract> getApplyContractInCreateDate(Timestamp createDate);
	/**
	 * 将某个人的申请，按照状态获取到
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<ApplyContract> getApplyContractInUserId(String userId, String status);
	/**
	 * 将某个公司被申请的申请，按照状态获取
	 * @param startupsId
	 * @param status
	 * @return
	 */
	public List<ApplyContract> getApplyContractInStartupsId(String startupsId, String status);
	/**
	 * 用来检测是否用户已经发了一个申请，且尚未被拒绝，只是停留在0状态（即正在处理的状态！）
	 * @param userId
	 * @param startups
	 * @param string
	 * @return
	 */
	public boolean canApplyContract(String userId, String startupsId, String status);
	/**
	 * 根据用户的id，来获取他是leader的公司所收到的申请合同
	 * @param userId
	 * @return
	 */
	public List<ApplyContract> getApplyContractInLeaderId(String leaderId);
}
