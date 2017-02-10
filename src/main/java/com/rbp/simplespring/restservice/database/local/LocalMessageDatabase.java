package com.rbp.simplespring.restservice.database.local;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.rbp.simplespring.restservice.database.MessageDatabase;
import com.rbp.simplespring.restservice.model.MessageData;

@Repository(value = "local")
public class LocalMessageDatabase implements MessageDatabase {

	public Map<String, MessageData> localDbMap;

	public LocalMessageDatabase() {
		localDbMap = new HashMap<String, MessageData>();

	}

	@Override
	public MessageData saveMessageData(MessageData data) {
		String id = UUID.randomUUID().toString();
		localDbMap.put(id, data);
		return data;
	}

	@Override
	public MessageData getMessageData(String id) {
		MessageData data = localDbMap.get(id);
		return data;
	}

	@Override
	public void deleteMessageData(String id) {
		localDbMap.remove(id);

	}

	@Override
	public MessageData updateMessageData(MessageData data) {
		//localDbMap.put(key, value)
		return data;
	}

}
