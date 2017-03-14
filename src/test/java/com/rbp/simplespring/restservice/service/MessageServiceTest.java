package com.rbp.simplespring.restservice.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.rbp.simplespring.restservice.database.MessageDatabase;
import com.rbp.simplespring.restservice.model.MessageData;
import com.rbp.simplespring.restservice.utils.RestServiceTestUtils;

public class MessageServiceTest {

	@InjectMocks
	@Autowired
	MessageService service;

	@Mock
	MessageDatabase database;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveMessageDataTest() {
		Long id = (long) Math.random();
		MessageData data = RestServiceTestUtils.generateMessageData(1).get(0);
		Mockito.when(database.saveMessageData(data)).thenReturn(id);
		service.saveMessageData(data);

	}

	//	@Test
	//	public void failedTest() {
	//		long id = (long) Math.random();
	//		MessageData data = generateMessageData(1).get(0);
	//		Mockito.when(database.saveMessageData(data)).thenReturn(id);
	//		service.saveMessageData(data);
	//		Assert.assertEquals(1L, id);
	//	}

	@Test
	public void codeCoverageTest() {
		MessageData data = new MessageData("CodeCoverage", "data");
		service.saveMessageData(data);
	}

	@Test
	public void getMessageTest() {
		Long messageId = (long) Math.random();
		service.getMessageData(messageId);
	}

}
