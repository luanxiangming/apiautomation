package com.vipabc.msg.backend.moneyController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class BalanceMsg {
	public static void getBalance(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/money/user/balance?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}

}
