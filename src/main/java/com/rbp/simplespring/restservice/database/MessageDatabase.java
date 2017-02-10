package com.rbp.simplespring.restservice.database;

import com.rbp.simplespring.restservice.model.MessageData;

public interface MessageDatabase {

	public MessageData saveMessageData(MessageData data);

	public MessageData getMessageData(String id);

	public void deleteMessageData(String id);

	public MessageData updateMessageData(MessageData data);

}
