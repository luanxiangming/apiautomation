package com.vipabc.msg.backend.liveShowController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CreateLiveShowMsg {
	public static String createLiveshow(HttpFixture hf, String token,String cover, String title,String location,String OPENRECORDINGKEY) {
		Pro pro = new Pro();
		String roomId="";
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/liveshow/create?token=" + token+"&cover="+cover+"&OPENRECORDINGKEY="+OPENRECORDINGKEY;
		hf.addHeaderValue("Content-Type", "multipart/form-data; boundary=--");
		hf.setUrl(request);
		hf.addUrlParamValue("title", title);
		hf.addUrlParamValue("geoLocaltion", location);
		hf.Post();
		roomId=hf.saveParamLeftstrRightstr("roomId\":\"", "\"");
		return roomId;
	}
}
