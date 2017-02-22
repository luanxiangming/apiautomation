package com.vipabc.msg.backend.courseDetailController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class GetHostCourseMsg {
	public static void getHostCourse(HttpFixture hf, String token, String client_language) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/course/mine?token=" + token+"&client_language="+client_language;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Get();
	}
}
