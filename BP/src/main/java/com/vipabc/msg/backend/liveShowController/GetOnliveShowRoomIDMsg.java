package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetOnliveShowRoomIDMsg {
	public static String getRoomId(HttpFixture hf, String token,String userId) {
		Pro pro = new Pro();
		String roomid="";
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/get_live_roomid?token=" + token+"&userId="+userId;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
		roomid=hf.saveParamLeftstrRightstr("room_id\":\"", "\"}");
		return roomid;
	}
}
