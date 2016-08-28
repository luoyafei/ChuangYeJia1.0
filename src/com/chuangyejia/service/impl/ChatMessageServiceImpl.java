package com.chuangyejia.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.ChatMessage;
import com.chuangyejia.bean.User;
import com.chuangyejia.dao.IChatMessageDao;
import com.chuangyejia.service.IChatMessageService;

@Component(value="cms")
public class ChatMessageServiceImpl implements IChatMessageService {

	private IChatMessageDao cmd;
	public IChatMessageDao getCmd() {
		return cmd;
	}
	@Resource(name="cmd")
	public void setCmd(IChatMessageDao cmd) {
		this.cmd = cmd;
	}
	
	@Override
	public boolean saveChatMessage(ChatMessage cm) {
		// TODO Auto-generated method stub
		return cmd.saveChatMessage(cm);
	}

	@Override
	public boolean saveChatMessage(ChatMessage[] cms) {
		// TODO Auto-generated method stub
		return cmd.saveChatMessage(cms);
	}

	@Override
	public boolean deleteChatMessage(ChatMessage cm) {
		// TODO Auto-generated method stub
		return cmd.deleteChatMessage(cm);
	}

	@Override
	public boolean emptyChatMessagesByUserIdToSomeOne(String fromUserId, String toUserId) {
		// TODO Auto-generated method stub
		return cmd.emptyChatMessagesByUserIdToSomeOne(fromUserId, toUserId);
	}

	@Override
	public boolean emptyChatMessagesByUserIdToSomeOne(String fromUserId, String toUserId, Timestamp beforeDate) {
		// TODO Auto-generated method stub
		return cmd.emptyChatMessagesByUserIdToSomeOne(fromUserId, toUserId, beforeDate);
	}

	@Override
	public boolean emptyChatMessagesByUserId(String fromUserId) {
		// TODO Auto-generated method stub
		return cmd.emptyChatMessagesByUserId(fromUserId);
	}

	@Override
	public List<ChatMessage> getChatMessageInId(String chatMessageId) {
		// TODO Auto-generated method stub
		return cmd.getChatMessageInId(chatMessageId);
	}

	@Override
	public List<ChatMessage> getHistoryChatMessagesByTwoUserId(String fromUserId, String toUserId, int maxLength) {
		// TODO Auto-generated method stub
		return cmd.getHistoryChatMessagesByTwoUserId(fromUserId, toUserId, maxLength);
	}

	@Override
	public List<ChatMessage> getHistoryChatMessagesByTwoUserId(String fromUserId, String toUserId, Timestamp beforeDate, int maxLength) {
		// TODO Auto-generated method stub
		return cmd.getHistoryChatMessagesByTwoUserId(fromUserId, toUserId,  beforeDate, maxLength);
	}

	@Override
	public List<ChatMessage> getNotReadChatMessages(String fromUserId, String toUserId, int needRead) {
		// TODO Auto-generated method stub
		return cmd.getNotReadChatMessages(fromUserId, toUserId, needRead);
	}

	@Override
	public Long getNotReadChatMessagesCount(String fromUserId, String toUserId, int needRead) {
		// TODO Auto-generated method stub
		return cmd.getNotReadChatMessagesCount(fromUserId, toUserId, needRead);
	}

	@Override
	public List<User> getAllNotReadChatMessages(String userId, int needRead) {
		// TODO Auto-generated method stub
		return cmd.getAllNotReadChatMessages(userId, needRead);
	}
	@Override
	public Long getAllNotReadChatMessageCounts(String userId, int needRead) {
		// TODO Auto-generated method stub
		return cmd.getAllNotReadChatMessageCounts(userId, needRead);
	}

}
