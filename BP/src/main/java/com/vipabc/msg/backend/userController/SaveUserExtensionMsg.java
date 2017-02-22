package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class SaveUserExtensionMsg {
	public static void saveUserExtension(HttpFixture hf, String token, String followFlag, String noticeFlag) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/extension/save?token="
				+ token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		if (followFlag.equals("") || noticeFlag.equals("")) {
			if (!followFlag.equals(""))
				hf.addRequestBody("{\"enableNotFollowInvite\":\"" + followFlag + "\"}");
			else if (!noticeFlag.equals(""))
				hf.addRequestBody("{\"enableLiveNotice\":\"" + noticeFlag + "\"}");
		} else
		{
			hf.addRequestBody("{\"enableNotFollowInvite\":\"" + followFlag + "\",\"enableLiveNotice\":\"" + noticeFlag + "\"}");
		}
		System.out.println(request);
		hf.Post();
	}
}
