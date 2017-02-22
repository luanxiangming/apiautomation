package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.GetUserExtensionMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class GetUserExtension extends Env{
	HttpFixture hf = new HttpFixture();

	@Test(priority = 1, dataProvider = "data", description = "手机号码登录")
	public void phone_login(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		if(!dataDriven.get("Token").equals(""))
			GetUserExtensionMsg.getUserExtenstion(hf, dataDriven.get("Token"));
		else
		GetUserExtensionMsg.getUserExtenstion(hf, token);
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}

	@Test(priority = 2, dataProvider = "thirdData", description = "第三方登录")
	public void thirdparty_login(Map<String, String> dataDriven) {
		String token = AppLogin.thirdparty_login(hf, dataDriven.get("User"), dataDriven.get("Gender"),
				dataDriven.get("NickName"), dataDriven.get("IconUrl"), dataDriven.get("Platform"));
		GetUserExtensionMsg.getUserExtenstion(hf, token);
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "phone_login");
	}

	@DataProvider
	public Iterator<Object[]> thirdData() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "thirdparty_login");
	}
}
