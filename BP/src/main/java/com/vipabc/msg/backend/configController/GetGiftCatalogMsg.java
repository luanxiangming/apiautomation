package com.vipabc.msg.backend.configController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetGiftCatalogMsg {
	public static void giftCatalog(HttpFixture hf, String token,String id) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/config/gift?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addParamValue("id", id);
		System.out.println(request);
		hf.Get();
	}
}
