package com.vipabc.msg.backend.userAttentController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetUserBlackListMsg {
	public static void getBlackList(HttpFixture hf, String token,String pageSize, String pageNum) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/blacklist/list?token=" + token+"&pageSize="+pageSize+"&pageNum="+pageNum;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
