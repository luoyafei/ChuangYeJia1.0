package com.chuangyejia.dto;

import com.chuangyejia.bean.Startups;
import com.chuangyejia.tools.StartupsUtil;

public class StartupsCreateDTO {

	private String name;
	private String type;
	private String[] require;
	private String stage;
	private String address;
	private String brief;
	private String detail;
	private String video;
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getRequire() {
		return require;
	}
	public void setRequire(String[] require) {
		this.require = require;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * 用于粗略的检验接收到的数据是否为空
	 * @return
	 */
	public boolean checkData() {
		// TODO Auto-generated method stub
		
		return (notEmpty(name) && notEmpty(type) && notEmpty(stage) && notEmpty(address) && notEmpty(brief) && notEmpty(detail));
		
	}
	
	/**
	 * 用来检验字符串是否为空
	 * @param param
	 * @return
	 */
	private boolean notEmpty(String param) {
		if(param != null && param.trim().hashCode() != 0)
			return true;
		else
			return false;
	}
	public Startups toStartups() {
		// TODO Auto-generated method stub
		
		Startups startups = new Startups();
		String startupsRequire = "";
		if(require.length != 0) {
			try {
				for(int i = 0; i < require.length; i++) {
					startupsRequire += StartupsUtil.CopartnerRequire[Integer.parseInt(require[i])];
				}
			} catch(NumberFormatException e) {
				startupsRequire = "暂无";
			}
		} else {
			startupsRequire = "暂无";
		}
		
		String startupsServiceType = "";
		try {
			startupsServiceType = StartupsUtil.ServiceType[Integer.parseInt(type)];
		} catch(NumberFormatException e) {
			startupsServiceType = "其他";
		}
		
		String OperationStage = "";
		try {
			OperationStage = StartupsUtil.OperationStage[Integer.parseInt(stage)];
		} catch(NumberFormatException e) {
			OperationStage = "暂无";
		}
		
		startups.setStartupsName(name.trim());
		startups.setStartupsServiceType(startupsServiceType);
		startups.setStartupsCopartnerRequire(startupsRequire);
		startups.setStartupsOperationStage(OperationStage);
		startups.setStartupsAddress(address.trim());
		startups.setStartupsBrief(brief.trim());
		startups.setStartupsDetail(detail.trim());
		
		/**
		 * 将video的src过滤chul
		 */
		if(video != null && video.trim() != "") {
			String videoTemp = video.trim().split("src=")[1];
			String videoUrl = videoTemp.split("\"")[1];
			startups.setStartupsVideo(videoUrl);
		} else {
			startups.setStartupsVideo(null);
		}
		
		return startups;
	}
	
}
