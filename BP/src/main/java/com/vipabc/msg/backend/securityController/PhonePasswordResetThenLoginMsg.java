package com.vipabc.msg.backend.securityController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class PhonePasswordResetThenLoginMsg {
	public static void resetLogin(HttpFixture hf, String mobilephone,String nationCode, String verificationCode,String newPw) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/phone/verifycode_login?mobilePhone=" + mobilephone+"&nationCode="+nationCode+"&verificationCode="+verificationCode+"&newPwd="+newPw;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
