package com.vipabc.msg.backend.agoraKeyController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class RecordCreateMsg {
	public static void createLiveshow(HttpFixture hf, String token,String roomId) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/key/record/create?token=" + token+"&roomId="+roomId;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
