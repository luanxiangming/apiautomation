package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.ShowBaseInfoMsg;
import com.vipabc.msg.backend.userController.UpdateBaseInfoMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class UpdateBaseInfo extends Env{
	HttpFixture hf = new HttpFixture();

	@Test(priority = 1, dataProvider = "data", description = "更新个人信息")
	public void updateInfo(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		UpdateBaseInfoMsg.updateInfo(hf, token, dataDriven.get("gender"), dataDriven.get("nickName"), dataDriven.get("intro"), dataDriven.get("area"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ","), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\","), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ","), dataDriven.get("error_code"));
		hf.nextRequest();
		ShowBaseInfoMsg.showBaseInfo(hf, token);
		if(!dataDriven.get("nickName").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("nickName\":\"", "\","), dataDriven.get("nickName"));
		else
			Assert.assertEquals(hf.saveParamLeftstrRightstr("nickName\":\"", "\","), dataDriven.get("nickName_check"));
		if(!dataDriven.get("gender").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("gender\":\"", "\","), dataDriven.get("gender"));
		else
			Assert.assertEquals(hf.saveParamLeftstrRightstr("gender\":\"", "\","), dataDriven.get("gender_check"));
		if(!dataDriven.get("intro").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("intro\":\"", "\","), dataDriven.get("intro"));
		else
			Assert.assertEquals(hf.saveParamLeftstrRightstr("intro\":\"", "\","), dataDriven.get("intro_check"));
		if(!dataDriven.get("area").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("area\":\"", "\","), dataDriven.get("area"));
		else
			Assert.assertEquals(hf.saveParamLeftstrRightstr("area\":\"", "\","), dataDriven.get("area_check"));

	}


	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "updateInfo");
	}

}
