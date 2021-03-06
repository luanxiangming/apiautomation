package com.vipabc.test.backend.courseDetailController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.courseDetailController.GetTimingLessonMsg;
import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class GetTimingLesson extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "")
	public void getTimingLesson(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		hf.nextRequest();
		GetTimingLessonMsg.getTimingLesson(hf, token, dataDriven.get("client_language"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "getTimingLesson");
	}
}
