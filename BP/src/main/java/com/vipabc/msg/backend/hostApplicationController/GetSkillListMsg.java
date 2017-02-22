package com.vipabc.msg.backend.hostApplicationController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetSkillListMsg {
	public static void getSkillList(HttpFixture hf, String token,String requiresVerify) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/host/skills?token=" + token+"&requiresVerify="+requiresVerify;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
