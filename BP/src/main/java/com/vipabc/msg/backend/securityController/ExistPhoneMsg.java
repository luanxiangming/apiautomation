package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class ExistPhoneMsg {
	public static void existPhone(HttpFixture hf, String mobilephone,String nationCode) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/exist?mobilePhone=" + mobilephone+"&nationCode="+nationCode;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
