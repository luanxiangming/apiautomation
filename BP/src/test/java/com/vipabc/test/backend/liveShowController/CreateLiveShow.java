package com.vipabc.test.backend.liveShowController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.liveShowController.CreateLiveShowMsg;
import com.vipabc.msg.backend.liveShowController.GetOnliveShowRoomIDMsg;
import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class CreateLiveShow extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "创建直播间")
	public void createLiveShow(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		String roomId=CreateLiveShowMsg.createLiveshow(hf, token,  dataDriven.get("cover"),  dataDriven.get("title"),  dataDriven.get("location"),  dataDriven.get("OPENRECORDINGKEY"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		GetOnliveShowRoomIDMsg.getRoomId(hf, token,  dataDriven.get("userId"));
		Assert.assertTrue(hf.findStringinResponse(roomId));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "createLiveShow");
	}
}
