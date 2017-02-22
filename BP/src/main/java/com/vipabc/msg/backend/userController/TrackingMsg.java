package com.vipabc.msg.backend.userController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class TrackingMsg {
	public static void track(HttpFixture hf, String userid,
			String version_code,
			String ScreenHeight,
			String Action,
			String localizedModel,
			String GEOLocation,
			String app_version,
			String client_os,
			String owner,
			String app_bundleId,
			String carrierName,
			String client_language,
			String uuid,
			String latitude,
			String client,
			String systemName,
			String version_name,
			String radioAccessTechnology,
			String ScreenWidth,
			String token,
			String mac,
			String longitude,
			String where,
			String enterBackground,
			String model,
			String locaStr,
			String systemVersion,
			String opentime,
			String idfa) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/users/action/tracking?&token="+token;
		String reqBody="{\"userid\":\""+userid	+"\",\"version_code\":\""+version_code	+"\",\"ScreenHeight\":\""+ScreenHeight	+"\",\"Action\":\""+Action	+"\",\"localizedModel\":\""+localizedModel	+"\",\"GEOLocation\":\""+GEOLocation	+"\",\"app_version\":\""+app_version	+"\",\"client_os\":\""+client_os	+"\",\"owner\":\""+owner	+"\",\"app_bundleId\":\""+app_bundleId	+"\",\"carrierName\":\""+carrierName	+"\",\"client_language\":\""+client_language	+"\",\"uuid\":\""+uuid	+"\",\"latitude\":\""+latitude	+"\",\"client\":\""+client	+"\",\"systemName\":\""+systemName	+"\",\"version_name\":\""+version_name	+"\",\"radioAccessTechnology\":\""+radioAccessTechnology	+"\",\"ScreenWidth\":\""+ScreenWidth	+"\",\"token\":\""+token	+"\",\"mac\":\""+mac	+"\",\"longitude\":\""+longitude	+"\",\"where\":\""+where	+"\",\"enterBackground\":\""+enterBackground	+"\",\"model\":\""+model	+"\",\"locaStr\":\""+locaStr	+"\",\"systemVersion\":\""+systemVersion	+"\",\"opentime\":\""+opentime	+"\",\"idfa\":\""+idfa+"\"}";
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		hf.addRequestBody(reqBody);
		System.out.println(request);
		hf.Post();
	}
}
