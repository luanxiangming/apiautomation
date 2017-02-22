package com.vipabc.msg.backend.courseDetailController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetLivingInfoMsg {
	public static void getLivingInfo(HttpFixture hf, String token,String courseId) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/course/lesson/LivingInfo?token=" + token+"&courseId="+courseId;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
