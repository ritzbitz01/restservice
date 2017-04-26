package com.rbp.simplespring.restservice.model;

public class MessageData {

	public String messageSender;
	public String data;

	public MessageData() {

	}

	public MessageData(String messageSender, String data) {
		this.messageSender = messageSender;
		this.data = data;

	}

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
