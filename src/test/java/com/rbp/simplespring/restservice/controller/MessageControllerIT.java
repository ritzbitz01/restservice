package com.rbp.simplespring.restservice.controller;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.rbp.simplespring.restservice.model.MessageData;

import io.restassured.response.Response;

public class MessageControllerIT {

	public static String serviceUrl;
	public static final String BOGUS_ID = "BOGUS_ID";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceUrl = System.getProperty("serviceUrl");
	}

	@Test
	public void createMessageIntegrationTest() throws Exception {
		String msgSender = "TestUser";
		String msgData = "TestData";
		MessageData data = new MessageData(msgSender, msgData);
		Gson gson = new Gson();
		String dataJson = gson.toJson(data);
		Response r = given().contentType("application/json").body(dataJson).when().post(serviceUrl + "/message");
		Long messageId = r.getBody().as(Long.class);
		System.out.println(messageId);

		MessageData getResponse = get(serviceUrl + "/message/" + messageId).as(MessageData.class);
		Assert.assertEquals(msgSender, getResponse.getMessageSender());
		Assert.assertEquals(msgData, getResponse.getData());

	}

	@Test
	public void retrieveBogusMessage() throws Exception {
		expect().statusCode(400).when().get(serviceUrl + "/message/" + BOGUS_ID);
	}

	@Test
	public void messageNotFoundTest() throws Exception {
		expect().statusCode(404).when().get(serviceUrl + "/message/" + 9999999);
	}
}
