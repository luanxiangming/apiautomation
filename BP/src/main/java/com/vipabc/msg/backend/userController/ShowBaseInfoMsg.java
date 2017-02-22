package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class ShowBaseInfoMsg {
	public static void showBaseInfo(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/profile/base?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
