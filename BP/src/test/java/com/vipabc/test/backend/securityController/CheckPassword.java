package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.securityController.CheckPasswordMsg;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class CheckPassword {
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "")
	public void checkPassword(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("phone"), dataDriven.get("pw"));
		CheckPasswordMsg.checkPassword(hf, token, dataDriven.get("password"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "checkPassword");
	}
}
