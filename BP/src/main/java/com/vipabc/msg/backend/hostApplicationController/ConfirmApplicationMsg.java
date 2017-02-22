package com.vipabc.msg.backend.hostApplicationController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class ConfirmApplicationMsg {
	public static void confirmApplication(HttpFixture hf, String applicationId, String token,String purpose) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/host/application/"+applicationId+"/confirm?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
