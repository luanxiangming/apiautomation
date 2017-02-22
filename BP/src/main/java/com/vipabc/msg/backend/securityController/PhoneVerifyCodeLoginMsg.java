package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class PhoneVerifyCodeLoginMsg {
	public static void VerifyCodeLogin(HttpFixture hf, String mobilephone,String nationCode, String verificationCode) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/verifycode_login?mobilePhone=" + mobilephone+"&nationCode="+nationCode+"&verificationCode="+verificationCode;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
