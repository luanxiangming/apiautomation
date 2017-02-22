package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class PhoneBindingMsg {
	public static void binding(HttpFixture hf, String token, String mobilephone,String nationCode,String verCode) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/bind?token="+token+"&mobilePhone=" + mobilephone+"&nationCode="+nationCode+"&verificationCode="+verCode;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
