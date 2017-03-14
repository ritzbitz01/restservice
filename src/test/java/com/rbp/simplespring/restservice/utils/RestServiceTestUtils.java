package com.rbp.simplespring.restservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.rbp.simplespring.restservice.model.MessageData;

public class RestServiceTestUtils {

	public static List<MessageData> generateMessageData(int numDatas) {
		int i = 0;
		List<MessageData> dataList = new ArrayList<>();
		while (i < numDatas) {
			MessageData d = new MessageData("TestSender" + i, "TestSenderData");
			dataList.add(d);
			i++;
		}
		return dataList;
	}
}
