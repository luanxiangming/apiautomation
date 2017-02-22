package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.configController.GetLiveAdSpaceListMsg;
import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.LogoutMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class Logout extends Env{
	HttpFixture hf = new HttpFixture();

	@Test(priority = 1, dataProvider = "data", description = "手机号码用户登出")
	public void phone_logout(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		if (token.equals("") || token.equals(null)) {
			LogoutMsg.logout(hf, dataDriven.get("Token"));
		} else {
			LogoutMsg.logout(hf, token);
		}
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		GetLiveAdSpaceListMsg.giftCatalog(hf, token); //调接口查看token是否真的失效
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""),"false");
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), "Without this token or has expired");
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), "20001");
	}

	@Test(priority = 1, dataProvider = "thirdData", description = "第三方登出")
	public void thirdparty_logout(Map<String, String> dataDriven) {
		String token = AppLogin.thirdparty_login(hf, dataDriven.get("User"), dataDriven.get("Gender"),
				dataDriven.get("NickName"), dataDriven.get("IconUrl"), dataDriven.get("Platform"));
		LogoutMsg.logout(hf, token);
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		GetLiveAdSpaceListMsg.giftCatalog(hf, token); //调接口查看token是否真的失效
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""),"false");
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), "Without this token or has expired");
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), "20001");
	}

	
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "phone_logout");
	}

	@DataProvider
	public Iterator<Object[]> thirdData() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "thirdparty_logout");
	}
}
