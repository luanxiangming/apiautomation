package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.GetUserAvatarsMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class GetUserAvatars extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "查看用户头像")
	public void getAvatars(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		GetUserAvatarsMsg.getUserAvatars(hf, dataDriven.get("Uid"), token);
		Assert.assertEquals(hf.getStatus(), 200);
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "getAvatars");
	}
}
