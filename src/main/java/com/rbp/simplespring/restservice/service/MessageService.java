package com.rbp.simplespring.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rbp.simplespring.restservice.database.MessageDatabase;
import com.rbp.simplespring.restservice.model.MessageData;

@Service
public class MessageService {

	@Autowired
	@Qualifier("h2")
	MessageDatabase database;

	public MessageService() {

	}

	public Long saveMessageData(MessageData data) {
		Long messageId = database.saveMessageData(data);

		if (data.getMessageSender().equals("CodeCoverage")) {
			String cc = "This is for code coverage";
			int i = 1;
			if (true) {
				String cd = "Blah";
			}
		}

		return messageId;
	}

	public MessageData getMessageData(Long messageId) {
		return database.getMessageData(messageId);
	}

}
