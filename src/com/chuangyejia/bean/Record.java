package com.chuangyejia.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="record_invite")
public class Record {
	
	
	@Override
	public String toString() {
		return "Record [ip=" + ip + ", fromUrl=" + fromUrl + "]";
	}
	private int id;
	private String ip;
	private String fromUrl;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFromUrl() {
		return fromUrl;
	}
	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}
	
}
