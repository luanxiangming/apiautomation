package com.vipabc.msg.backend.giftController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class SendGiftMsg {
	public static void senfGift(HttpFixture hf, String token,String client_language,String giftId,String num,String roomId,String timestamp) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/gift/sendgift?token=" + token+"&client_language="+client_language;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addParamValue("giftId",giftId );
		hf.addParamValue("num", num);
		hf.addParamValue("roomId",roomId );
		hf.addParamValue("timestamp", timestamp);
		System.out.println(request);
		hf.Post();
	}
}
