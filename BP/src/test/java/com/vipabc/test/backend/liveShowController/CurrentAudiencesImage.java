package com.vipabc.test.backend.liveShowController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.liveShowController.CurrentAudiencesImageMsg;
import com.vipabc.msg.backend.liveShowController.GetOnliveShowRoomIDMsg;
import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class CurrentAudiencesImage extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "直播间用户头像")
	public void audienceImage(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		String roomId= GetOnliveShowRoomIDMsg.getRoomId(hf, token, dataDriven.get("uid"));
		CurrentAudiencesImageMsg.currentImage(hf, token, roomId, dataDriven.get("size"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "audienceImage");
	}
}
