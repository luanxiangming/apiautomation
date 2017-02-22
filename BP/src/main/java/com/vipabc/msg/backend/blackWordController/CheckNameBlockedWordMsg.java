package com.vipabc.msg.backend.blackWordController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CheckNameBlockedWordMsg {
	public static void checkName(HttpFixture hf, String name) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/words/check?";
		hf.addHeaderValue("Content-Type", "application/json");
		hf.addParamValue("name", name);
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
