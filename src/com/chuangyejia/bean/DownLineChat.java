package com.chuangyejia.bean;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 线下交谈实体类，
 * @author Diamond
 *
 */
@Entity
@Table(name="downLineChat")
public class DownLineChat {
	
	@Override
	public String toString() {
		return "DownLineChat [id=" + id + ", fromUserId=" + fromUserId + ", toUserId=" + toUserId + ", createDate="
				+ createDate + "]";
	}
	private String id = null;
	private User fromUserId = null;
	private User toUserId = null;
	private Timestamp createDate = null;
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="fromUserId")
	public User getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(User fromUserId) {
		this.fromUserId = fromUserId;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="toUserId")
	public User getToUserId() {
		return toUserId;
	}
	public void setToUserId(User toUserId) {
		this.toUserId = toUserId;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
