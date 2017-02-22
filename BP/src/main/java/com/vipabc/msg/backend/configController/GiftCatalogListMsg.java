package com.vipabc.msg.backend.configController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GiftCatalogListMsg {
	public static void giftList(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/config/gift/list?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
