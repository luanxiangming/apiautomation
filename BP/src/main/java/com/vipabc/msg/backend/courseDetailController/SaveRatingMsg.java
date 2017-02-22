package com.vipabc.msg.backend.courseDetailController;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class SaveRatingMsg {
	public static void saveRating(HttpFixture hf, String token) {
		Pro pro = new Pro();
		String request = pro.getEnvPropties("url.server", "url") + "/vliveshow-api-app/v1/course/lesson/rating?token=" + token;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.addRequestBody("CourseRating");
		hf.Post();
	}
}
