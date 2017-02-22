package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class FollowedOnliveListMsg {
	public static void followedOnlive(HttpFixture hf, String token,String pageNo,String pageSize) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/followed/list?token=" + token+"&pageNo="+pageNo+"&pageSize="+pageSize;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
