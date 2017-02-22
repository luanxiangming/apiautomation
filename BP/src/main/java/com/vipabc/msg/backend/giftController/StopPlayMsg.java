package com.vipabc.msg.backend.giftController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class StopPlayMsg {
	public static void stopPlay(HttpFixture hf, String token,String roomId, String timestamp) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/gift/stopPlay?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addParamValue("roomId", roomId);
		hf.addParamValue("timestamp", timestamp);
		System.out.println(request);
		hf.Post();
	}
}
