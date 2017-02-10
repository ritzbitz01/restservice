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

	public MessageData saveMessageData(MessageData data) {
		return data;
	}

}
