package com.rbp.simplespring.restservice.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rbp.simplespring.restservice.database.h2.H2MessageRepository;
import com.rbp.simplespring.restservice.database.h2.entity.MessageEntity;
import com.rbp.simplespring.restservice.model.MessageData;

@Repository(value = "h2")
public class H2MessageDatabase implements MessageDatabase {

	@Autowired
	H2MessageRepository messageRepo;

	@Override
	public Long saveMessageData(MessageData data) {
		MessageEntity entity = new MessageEntity(data.getMessageSender(), data.getData());
		messageRepo.save(entity);
		return entity.getId();
	}

	@Override
	public MessageData getMessageData(Long id) {
		MessageEntity entity = messageRepo.findOne(id);
		MessageData data = new MessageData(entity.getMessageOwner(), entity.getMessageData());
		return data;
	}

	@Override
	public void deleteMessageData(Long id) {
		messageRepo.delete(id);

	}

	@Override
	public MessageData updateMessageData(MessageData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
