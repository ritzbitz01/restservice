package com.rbp.simplespring.restservice.controller.database.h2.entity;

import org.junit.Assert;
import org.junit.Test;

import com.rbp.simplespring.restservice.database.h2.entity.MessageEntity;

public class MessageEntityTest {

	@Test
	public void messageEntityTest() throws Exception {
		String messageSender = "TestSender";
		String messageData = "TestData";
		MessageEntity data = new MessageEntity(messageSender, messageData);
		Long id = data.getId();
		Assert.assertEquals(messageSender, data.getMessageOwner());
		Assert.assertEquals(messageData, data.getMessageData());

		String updatedData = "UpdatedData";
		String updatedSender = "UpdatedSender";
		data.setMessageData(updatedData);
		data.setMessageOwner(updatedSender);
		Long updatedId = (long) Math.random();
		data.setId(updatedId);
		Assert.assertEquals(updatedSender, data.getMessageOwner());
		Assert.assertEquals(updatedData, data.getMessageData());
		Assert.assertEquals(updatedId, data.getId());

	}

	@Test
	public void toStringTest() throws Exception {
		String messageSender = "TestSender";
		String messageData = "TestData";
		MessageEntity data = new MessageEntity(messageSender, messageData);

		Assert.assertNotNull(data.toString());
	}
}
