package com.rbp.simplespring.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> saveMessageData(@RequestBody MessageData data) {

		Long messageId = messageService.saveMessageData(data);
		return new ResponseEntity<>(messageId, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/message/{messageId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getMessageData(@PathVariable Long messageId) {
		MessageData data = messageService.getMessageData(messageId);
		if (data == null) {
			return new ResponseEntity<>("Message with messageId " + messageId + " does not exist.",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(data, HttpStatus.CREATED);
	}

}
