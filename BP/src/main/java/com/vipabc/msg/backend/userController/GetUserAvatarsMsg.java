package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetUserAvatarsMsg {
	public static void getUserAvatars(HttpFixture hf, String uid, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/" + uid + "/avatars?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
