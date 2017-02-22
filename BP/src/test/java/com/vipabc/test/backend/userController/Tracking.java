package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.TrackingMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class Tracking extends Env{
	HttpFixture hf = new HttpFixture();

	@Test(priority = 1, dataProvider = "data", description = "只检查了接口是否通")
	public void track(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		TrackingMsg.track(hf, dataDriven.get("userid"), 	dataDriven.get("version_code"), 	
				dataDriven.get("ScreenHeight"), 	
				dataDriven.get("Action"), 	
				dataDriven.get("localizedModel"), 	
				dataDriven.get("GEOLocation"), 	
				dataDriven.get("app_version"), 	
				dataDriven.get("client_os"), 	
				dataDriven.get("owner"), 	
				dataDriven.get("app_bundleId"), 	
				dataDriven.get("carrierName"), 	
				dataDriven.get("client_language"), 	
				dataDriven.get("uuid"), 	
				dataDriven.get("latitude"), 	
				dataDriven.get("client"), 	
				dataDriven.get("systemName"), 	
				dataDriven.get("version_name"), 	
				dataDriven.get("radioAccessTechnology"), 		
				dataDriven.get("ScreenWidth"), 	
				token, 	
				dataDriven.get("mac"), 	
				dataDriven.get("longitude"), 	
				dataDriven.get("where"), 	
				dataDriven.get("enterBackground"), 	
				dataDriven.get("model"), 	
				dataDriven.get("locaStr"), 	
				dataDriven.get("systemVersion"), 	
				dataDriven.get("opentime"), 	
				dataDriven.get("idfa"));
		AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "track");
	}
}
