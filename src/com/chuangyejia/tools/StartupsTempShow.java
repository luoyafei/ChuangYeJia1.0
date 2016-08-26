package com.chuangyejia.tools;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 提供一个Startups的展现信息的类
 * 传入request给用户show_startups.jsp展示（非leader修改信息），
 * 而不是将真正的Startups对象之间传入前台展示，
 * 为了安全起见！
 * @author Diamond
 */
public class StartupsTempShow {

	private String startupsId = null;
	private String startupsName = null;//公司名称
	private Timestamp startupsCreateDate = null;//创建时间
	private String startupsBrief = null;//公司简介
	private String startupsDetail = null;//公司详细内容
	private String startupsServiceType = null;//服务类型
	private String startupsAddress = null;//公司归属地
	private String startupsCopartnerRequire = null;	//合伙人需求   (资金，技术，运营)
	private String startupsOperationStage = null;//运营阶段
	private String startupsCover = null;//公司封面
	private String startupsVideo = null;//公司视频
	private String startupsPhoto1 = null;//公司照片1
	private String startupsPhoto2 = null;//公司照片2
	private String startupsPhoto3 = null;//公司照片3
	
	private UserTempShow startupsLeader = null;//公司leader对象
	private Set<UserTempShow> copartner = new HashSet<UserTempShow>();//公司成员
	
	public String getStartupsId() {
		return startupsId;
	}
	public void setStartupsId(String startupsId) {
		this.startupsId = startupsId;
	}
	public String getStartupsName() {
		return startupsName;
	}
	public void setStartupsName(String startupsName) {
		this.startupsName = startupsName;
	}
	public Timestamp getStartupsCreateDate() {
		return startupsCreateDate;
	}
	public void setStartupsCreateDate(Timestamp startupsCreateDate) {
		this.startupsCreateDate = startupsCreateDate;
	}
	public String getStartupsBrief() {
		return startupsBrief;
	}
	public void setStartupsBrief(String startupsBrief) {
		this.startupsBrief = startupsBrief;
	}
	public String getStartupsDetail() {
		return startupsDetail;
	}
	public void setStartupsDetail(String startupsDetail) {
		this.startupsDetail = startupsDetail;
	}
	public String getStartupsServiceType() {
		return startupsServiceType;
	}
	public void setStartupsServiceType(String startupsServiceType) {
		this.startupsServiceType = startupsServiceType;
	}
	public String getStartupsAddress() {
		return startupsAddress;
	}
	public void setStartupsAddress(String startupsAddress) {
		this.startupsAddress = startupsAddress;
	}
	public String getStartupsCopartnerRequire() {
		return startupsCopartnerRequire;
	}
	public void setStartupsCopartnerRequire(String startupsCopartnerRequire) {
		this.startupsCopartnerRequire = startupsCopartnerRequire;
	}
	public String getStartupsOperationStage() {
		return startupsOperationStage;
	}
	public void setStartupsOperationStage(String startupsOperationStage) {
		this.startupsOperationStage = startupsOperationStage;
	}
	public String getStartupsCover() {
		return startupsCover;
	}
	public void setStartupsCover(String startupsCover) {
		this.startupsCover = startupsCover;
	}
	public String getStartupsVideo() {
		return startupsVideo;
	}
	public void setStartupsVideo(String startupsVideo) {
		this.startupsVideo = startupsVideo;
	}
	public String getStartupsPhoto1() {
		return startupsPhoto1;
	}
	public void setStartupsPhoto1(String startupsPhoto1) {
		this.startupsPhoto1 = startupsPhoto1;
	}
	public String getStartupsPhoto2() {
		return startupsPhoto2;
	}
	public void setStartupsPhoto2(String startupsPhoto2) {
		this.startupsPhoto2 = startupsPhoto2;
	}
	public String getStartupsPhoto3() {
		return startupsPhoto3;
	}
	public void setStartupsPhoto3(String startupsPhoto3) {
		this.startupsPhoto3 = startupsPhoto3;
	}
	public UserTempShow getStartupsLeader() {
		return startupsLeader;
	}
	public void setStartupsLeader(UserTempShow startupsLeader) {
		this.startupsLeader = startupsLeader;
	}
	public Set<UserTempShow> getCopartner() {
		return copartner;
	}
	public void setCopartner(Set<UserTempShow> copartner) {
		this.copartner = copartner;
	}
}
