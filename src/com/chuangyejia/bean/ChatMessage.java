package com.chuangyejia.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="chatMessage")
public class ChatMessage {

	private String chatMessageId;
	private String chatMessage;
	private String fromUserId;
	private String toUserId;
	private String toChatRoomId = "0";//默认的聊天室是没有的,0
	private Timestamp messageSendTime;
	private int needRead = 0;//默认是未读，等读取后转换为1，为已读状态
	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getChatMessageId() {
		return chatMessageId;
	}
	public void setChatMessageId(String chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	
	/**
	 * 构建一个可以直接获取String类型的日期
	 * @return String
	 */
	@Transient
	public String messageSendTimeStringTime() {
		if(messageSendTime == null)
			messageSendTime = new Timestamp(System.currentTimeMillis());
		return messageSendTime.toString();
	}
	public Timestamp getMessageSendTime() {
		messageSendTimeStringTime();
		return messageSendTime;
	}
	public void setMessageSendTime(Timestamp messageSendTime) {
		this.messageSendTime = messageSendTime;
	}
	public int getNeedRead() {
		return needRead;
	}
	public void setNeedRead(int needRead) {
		this.needRead = needRead;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getToChatRoomId() {
		return toChatRoomId;
	}
	public void setToChatRoomId(String toChatRoomId) {
		if(toChatRoomId == null)
			this.toChatRoomId = "0";
	}
}
