package com.vipabc.msg.backend.userAttentController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetUserBaseInfoMsg {
	public static void getUserInfo(HttpFixture hf, String token,String userId) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/get_base_info?token=" + token+"&userId="+userId;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
