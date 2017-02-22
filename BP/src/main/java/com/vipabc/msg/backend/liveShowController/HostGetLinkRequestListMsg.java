package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class HostGetLinkRequestListMsg {
	public static void getLinkRequest(HttpFixture hf, String token,String roomId) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/host/link_request_list?token=" + token+"&roomId="+roomId;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
