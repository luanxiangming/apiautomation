package com.vipabc.test.backend.liveShowController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.liveShowController.GetOnliveShowRoomIDMsg;
import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class GetOnliveShowRoomID extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "获取正在直播用户所在的房间ID")
	public void getRoomid(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		GetOnliveShowRoomIDMsg.getRoomId(hf, token, dataDriven.get("uid"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "getRoomid");
	}
}
