package com.vipabc.msg.backend.hostApplicationController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CreateApplicationMsg {
	public static void createApplication(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/host/application?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addRequestBody("HostApplication");
		System.out.println(request);
		hf.Post();
	}
}
