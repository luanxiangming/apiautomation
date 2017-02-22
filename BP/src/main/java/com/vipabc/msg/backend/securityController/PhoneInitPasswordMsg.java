package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class PhoneInitPasswordMsg {
	public static void init(HttpFixture hf, String token,	String pw)
	{
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/init_pwd?&token="+token+"&password="+pw;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
