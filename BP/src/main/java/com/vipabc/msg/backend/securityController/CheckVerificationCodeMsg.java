package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CheckVerificationCodeMsg {
	public static void checkVerificationCode(HttpFixture hf,String nationCode, String mobilephone,String verificationCode) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/check_verification_code?nationCode="+nationCode+"&mobilePhone=" + mobilephone+"&verificationCode="+verificationCode;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
