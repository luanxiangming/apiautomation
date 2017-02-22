package com.vipabc.msg.backend.userAttentController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetFansListMsg {
	public static void getFans(HttpFixture hf, String token,String userId,String pageSize, String pageNum) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/fans/list?token=" + token+"&userId="+userId+"&pageSize="+pageSize+"&pageNum="+pageNum;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
