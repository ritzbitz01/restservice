package com.rbp.simplespring.restservice.database;

import com.rbp.simplespring.restservice.model.MessageData;

public interface MessageDatabase {

	public Long saveMessageData(MessageData data);

	public MessageData getMessageData(Long id);

	public void deleteMessageData(Long id);

	public MessageData updateMessageData(MessageData data);

}
