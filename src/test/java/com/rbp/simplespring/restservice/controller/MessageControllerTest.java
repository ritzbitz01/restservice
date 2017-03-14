package com.rbp.simplespring.restservice.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.rbp.simplespring.restservice.model.MessageData;
import com.rbp.simplespring.restservice.service.MessageService;
import com.rbp.simplespring.restservice.utils.RestServiceTestUtils;

public class MessageControllerTest {

	@InjectMocks
	@Autowired
	MessageController controller;

	@Mock
	MessageService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveMessageDataTest() throws Exception {
		Long id = (long) Math.random();
		MessageData data = RestServiceTestUtils.generateMessageData(1).get(0);
		Mockito.when(service.saveMessageData(data)).thenReturn(id);
		controller.saveMessageData(data);
	}

}
