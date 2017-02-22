package com.vipabc.msg.backend.courseDetailController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class SubscriptionCourseMsg {
	public static void subscriptionCourse(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/course/subscription?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.addRequestBody("CourseSubscriptionDTO");
		hf.Post();
	}
}
