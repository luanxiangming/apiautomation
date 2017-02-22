package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class CollectionMsg {
	public static void collection(HttpFixture hf, String version_code,	String ScreenHeight,	String localizedModel,	String GEOLocation,	String app_version,	String client_os,	String owner,	String app_bundleId,	String carrierName,	String client_language,	String uuid,	String client,	String systemName,	String version_name,	String radioAccessTechnology,	String ScreenWidth,	String mac,	String token,	String model,	String systemVersion,	String idfa) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/device_info/collection?&token="+token;
		String reqBody="{\"version_code\":\""+version_code	+"\",\"ScreenHeight\":\""+ScreenHeight	+"\",\"localizedModel\":\""+localizedModel	+"\",\"GEOLocation\":\""+GEOLocation	+"\",\"app_version\":\""+app_version	+"\",\"client_os\":\""+client_os	+"\",\"owner\":\""+owner	+"\",\"app_bundleId\":\""+app_bundleId	+"\",\"carrierName\":\""+carrierName	+"\",\"client_language\":\""+client_language	+"\",\"uuid\":\""+uuid	+"\",\"client\":\""+client	+"\",\"systemName\":\""+systemName	+"\",\"version_name\":\""+version_name	+"\",\"radioAccessTechnology\":\""+radioAccessTechnology	+"\",\"ScreenWidth\":\""+ScreenWidth	+"\",\"mac\":\""+mac	+"\",\"token\":\""+token	+"\",\"model\":\""+model	+"\",\"systemVersion\":\""+systemVersion	+"\",\"idfa\":\""+idfa+"\"}";
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addRequestBody(reqBody);
		System.out.println(request);
		hf.Post();
	}
}
