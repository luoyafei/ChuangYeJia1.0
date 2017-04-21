package com.chuangyejia.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="microRecord")
public class MicroRecord {

	private String id;
	private String startupsId;
	private String dataAddress;
	private Timestamp createDate;
	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartupsId() {
		return startupsId;
	}
	public void setStartupsId(String startupsId) {
		this.startupsId = startupsId;
	}
	public String getDataAddress() {
		return dataAddress;
	}
	public void setDataAddress(String dataAddress) {
		this.dataAddress = dataAddress;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
