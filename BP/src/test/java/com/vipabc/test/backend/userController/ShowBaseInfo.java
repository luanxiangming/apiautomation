package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.ShowBaseInfoMsg;
import com.vipabc.utils.Env;

import net.sf.json.JSONObject;
import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class ShowBaseInfo extends Env {
	HttpFixture hf = new HttpFixture();

	@Test(priority = 1, dataProvider = "data", description = "获取用户信息")
	public void phone_info(Map<String, String> dataDriven) {
		try{
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		ShowBaseInfoMsg.showBaseInfo(hf, token);
		JSONObject hfJson=JSONObject.fromObject(hf.getResponseBody());
		JSONObject profileJson=JSONObject.fromObject(JSONObject.fromObject(hfJson.getString("results")).getString("profile"));
		Assert.assertEquals(hf.getStatus(), 200);
		if(!dataDriven.get("id").equals(""))
		{
		Assert.assertEquals(hfJson.getString("success"), dataDriven.get("success"));
		Assert.assertEquals(hfJson.getString("message"), dataDriven.get("message"));
		Assert.assertEquals(hfJson.getString("error_code"), dataDriven.get("error_code"));
		Assert.assertEquals(profileJson.getString("id"), dataDriven.get("id"));
		Assert.assertEquals(profileJson.getString("username"), dataDriven.get("username"));
		Assert.assertEquals(profileJson.getString("nickName"), dataDriven.get("nickName"));
		Assert.assertEquals(profileJson.getString("gender"), dataDriven.get("gender"));
		Assert.assertEquals(profileJson.getString("intro"), dataDriven.get("intro"));
		Assert.assertEquals(profileJson.getString("mobilePhone"), dataDriven.get("mobilePhone"));
		Assert.assertEquals(profileJson.getString("nationCode"), dataDriven.get("nationCode"));
		Assert.assertEquals(profileJson.getString("signupType"), dataDriven.get("signupType"));
		Assert.assertEquals(profileJson.getString("area"), dataDriven.get("area"));
		Assert.assertEquals(profileJson.getString("role"), dataDriven.get("role"));
		Assert.assertEquals(profileJson.getString("isBlocked"), dataDriven.get("isBlocked"));
		Assert.assertEquals(profileJson.getString("isHost"), dataDriven.get("isHost"));
		Assert.assertEquals(profileJson.getString("isSuperUser"), dataDriven.get("isSuperUser"));
		Assert.assertEquals(profileJson.getString("isSpecialGuest"), dataDriven.get("isSpecialGuest"));
		Assert.assertEquals(profileJson.getString("isGuest"), dataDriven.get("isGuest"));
		Assert.assertEquals(profileJson.getString("isAudiences"), dataDriven.get("isAudiences"));
		Assert.assertEquals(profileJson.getString("trialHost"), dataDriven.get("trialHost"));
		Assert.assertEquals(profileJson.getString("administrator"), dataDriven.get("administrator"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 1, dataProvider = "thirdData", description = "获取用户信息")
	public void thirdparty_info(Map<String, String> dataDriven) {
		String token = AppLogin.thirdparty_login(hf, dataDriven.get("User"), dataDriven.get("Gender"),
				dataDriven.get("NickName"), dataDriven.get("IconUrl"), dataDriven.get("Platform"));
		ShowBaseInfoMsg.showBaseInfo(hf, token);
		JSONObject hfJson=JSONObject.fromObject(hf.getResponseBody());
		JSONObject profileJson=JSONObject.fromObject(JSONObject.fromObject(hfJson.getString("results")).getString("profile"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hfJson.getString("success"), dataDriven.get("success"));
		Assert.assertEquals(hfJson.getString("message"), dataDriven.get("message"));
		Assert.assertEquals(hfJson.getString("error_code"), dataDriven.get("error_code"));
		Assert.assertEquals(profileJson.getString("id"), dataDriven.get("id"));
		Assert.assertEquals(profileJson.getString("username"), dataDriven.get("username"));
		Assert.assertEquals(profileJson.getString("nickName"), dataDriven.get("nickName"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("avatars\":\"", "\","), dataDriven.get("avatars"));
		Assert.assertEquals(profileJson.getString("gender"), dataDriven.get("gender"));
		Assert.assertEquals(profileJson.getString("intro"), dataDriven.get("intro"));
		Assert.assertEquals(profileJson.getString("mobilePhone"), dataDriven.get("mobilePhone"));
		Assert.assertEquals(profileJson.getString("nationCode"), dataDriven.get("nationCode"));
		Assert.assertEquals(profileJson.getString("signupType"), dataDriven.get("signupType"));
		Assert.assertEquals(profileJson.getString("area"), dataDriven.get("area"));
		Assert.assertEquals(profileJson.getString("role"), dataDriven.get("role"));
		Assert.assertEquals(profileJson.getString("isBlocked"), dataDriven.get("isBlocked"));
		Assert.assertEquals(profileJson.getString("isHost"), dataDriven.get("isHost"));
		Assert.assertEquals(profileJson.getString("isSuperUser"), dataDriven.get("isSuperUser"));
		Assert.assertEquals(profileJson.getString("isSpecialGuest"), dataDriven.get("isSpecialGuest"));
		Assert.assertEquals(profileJson.getString("isGuest"), dataDriven.get("isGuest"));
		Assert.assertEquals(profileJson.getString("isAudiences"), dataDriven.get("isAudiences"));
		Assert.assertEquals(profileJson.getString("trialHost"), dataDriven.get("trialHost"));
		Assert.assertEquals(profileJson.getString("administrator"), dataDriven.get("administrator"));
	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "phone_info");
	}

	@DataProvider
	public Iterator<Object[]> thirdData() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "thirdparty_info");
	}
}
