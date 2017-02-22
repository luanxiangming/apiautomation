package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class ShowListMsg {
	public static void showList(HttpFixture hf, String token,String keyword, String pageNo,String pageSize) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/list?token=" + token+"&keyword="+keyword+"&pageNo="+pageNo+"&pageSize="+pageSize;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
