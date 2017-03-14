package com.rbp.simplespring.restservice.controller.database.h2;

import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.rbp.simplespring.restservice.database.H2MessageDatabase;
import com.rbp.simplespring.restservice.database.h2.H2MessageRepository;
import com.rbp.simplespring.restservice.database.h2.entity.MessageEntity;
import com.rbp.simplespring.restservice.model.MessageData;
import com.rbp.simplespring.restservice.utils.RestServiceTestUtils;

public class H2MessageDatabaseTest {
	@InjectMocks
	@Autowired
	H2MessageDatabase database;

	@Mock
	H2MessageRepository repo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveMessageDataTest() throws Exception {
		MessageData data = RestServiceTestUtils.generateMessageData(1).get(0);
		Mockito.when(repo.save(any(MessageEntity.class))).thenReturn(any(MessageEntity.class));
		database.saveMessageData(data);
	}

	@Test
	public void getMessageDataTest() throws Exception {
		Long id = (long) Math.random();
		MessageEntity data = new MessageEntity("TestSender", "TestData");
		data.setId(id);
		Mockito.when(repo.findOne(id)).thenReturn(data);
		database.getMessageData(id);
	}

	@Test
	public void deleteMessageDataTest() throws Exception {
		Mockito.doNothing().when(repo).delete(any(Long.class));
		database.deleteMessageData((long) Math.random());
	}

	@Test
	public void updateMessageDataTest() throws Exception {
		MessageData data = RestServiceTestUtils.generateMessageData(1).get(0);
		database.updateMessageData(data);
	}
}
