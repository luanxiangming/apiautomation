package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class UpdateBaseInfoMsg {
	public static void updateInfo(HttpFixture hf, String token,	String gender,	String nickName,	String intro,	String area) {
		Pro pro = new Pro();
		hf.addHeaderValue("Content-Type", "multipart/form-data; boundary=--");
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/profile/base?token="+token;
		hf.setUrl(request);
		if(gender!="")
		hf.addUrlParamValue("gender", gender);
		if(nickName!="")
		hf.addUrlParamValue("nickName", nickName);
		if(intro!="")
		hf.addUrlParamValue("intro", intro);
		if(area!="")
		hf.addUrlParamValue("area", area);
		System.out.println(request);
		hf.Post();
	}
}
