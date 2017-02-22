package com.vipabc.msg.backend.hostApplicationController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class UpdateApplicationSkillsMsg {
	public static void updateApplicationSkills(HttpFixture hf, String token,String applicationId) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/host/application/"+applicationId+"/skill?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addRequestBody("HostApplication");
		System.out.println(request);
		hf.Post();
	}
}
