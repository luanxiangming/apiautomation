package com.vipabc.msg.backend.giftController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CountGiftByHostsMsg {
	public static void countGift(HttpFixture hf, String hostsStr, String giftNamesStr,String purpose) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/gift/countGift?hostsStr=" + hostsStr+"&giftNamesStr=" +giftNamesStr+"&purpose=" +purpose;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
	}
}
