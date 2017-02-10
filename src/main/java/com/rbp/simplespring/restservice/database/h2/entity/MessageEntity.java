package com.rbp.simplespring.restservice.database.h2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String messageOwner;
	private String messageData;

	protected MessageEntity() {

	}

	public MessageEntity(String messgeOwner, String messageData) {
		this.messageData = messageData;
		this.messageOwner = messgeOwner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageOwner() {
		return messageOwner;
	}

	public void setMessageOwner(String messageOwner) {
		this.messageOwner = messageOwner;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

	@Override
	public String toString() {
		return String.format("Message[id=%d, owner='%s', data='%s']", id, messageOwner, messageData);
	}

}
