package com.vipabc.msg.backend.blackWordController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetNickNameWordsMsg {
	public static void getNickName(HttpFixture hf) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/words/get?";
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
