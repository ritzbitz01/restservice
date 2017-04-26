package com.rbp.simplespring.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbp.simplespring.restservice.model.MessageData;
import com.rbp.simplespring.restservice.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;

	public MessageController() {

	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public Long saveMessageData(@RequestBody MessageData data) {

		return messageService.saveMessageData(data);
	}

	@RequestMapping(value = "/message/{messageId}", method = RequestMethod.GET)
	public MessageData getMessageData(@PathVariable Long messageId) {
		return messageService.getMessageData(messageId);
	}

}
