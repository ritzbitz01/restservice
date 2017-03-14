package com.rbp.simplespring.restservice.controller.model;

import org.junit.Assert;
import org.junit.Test;

import com.rbp.simplespring.restservice.model.MessageData;

public class MessageDataTest {

	@Test
	public void messageDataTest() throws Exception {
		String messageSender = "TestSender";
		String messageData = "TestData";
		MessageData data = new MessageData(messageSender, messageData);
		Assert.assertEquals(messageSender, data.getMessageSender());
		Assert.assertEquals(messageData, data.getData());

		String updatedData = "UpdatedData";
		String updatedSender = "UpdatedSender";
		data.setData(updatedData);
		data.setMessageSender(updatedSender);
		Assert.assertEquals(updatedSender, data.getMessageSender());
		Assert.assertEquals(updatedData, data.getData());

	}
}
