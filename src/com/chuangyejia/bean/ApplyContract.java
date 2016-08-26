package com.chuangyejia.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 此为申请合同的实体类
 * @author Diamond
 */
@Entity
@Table(name="applyContract")
public class ApplyContract {

	private String applyId;
	private String applyOrganiserId;//发起者Id
	private String applyTitle;//申请标题
	private String applyContent;//申请内容
	private String applyStartupsId;//申请的公司Id
	private Timestamp createDate;//创建日期
	private Timestamp lastModifyDate;//最后一次的修改日期
	private String applyStatus = "正在审核";//申请状态(正在审核，已接受，已拒绝)
	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getApplyOrganiserId() {
		return applyOrganiserId;
	}
	public void setApplyOrganiserId(String applyOrganiserId) {
		this.applyOrganiserId = applyOrganiserId;
	}
	public String getApplyTitle() {
		return applyTitle;
	}
	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}
	public String getApplyContent() {
		return applyContent;
	}
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}
	public String getApplyStartupsId() {
		return applyStartupsId;
	}
	public void setApplyStartupsId(String applyStartupsId) {
		this.applyStartupsId = applyStartupsId;
	}
	
	/**
	 * 构建一个可以直接获取String类型的日期
	 * @return String
	 */
	@Transient
	public String getCreateDateStringTime() {
		if(createDate == null)
			createDate = new Timestamp(System.currentTimeMillis());
		return createDate.toString();
	}
	
	public Timestamp getCreateDate() {
		getCreateDateStringTime();
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Timestamp lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	
	
	
}
