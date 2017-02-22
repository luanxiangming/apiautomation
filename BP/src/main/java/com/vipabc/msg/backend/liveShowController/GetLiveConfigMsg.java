package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetLiveConfigMsg {
	public static void getLiveConfig(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/config?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
