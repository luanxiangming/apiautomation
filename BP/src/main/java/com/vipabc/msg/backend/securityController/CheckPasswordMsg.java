package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CheckPasswordMsg {
	public static void checkPassword(HttpFixture hf, String token,String password) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/check_password?token=" + token+"&password="+password;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
