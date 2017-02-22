package com.vipabc.test.backend.userController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.userController.GetUserExtensionMsg;
import com.vipabc.msg.backend.userController.SaveUserExtensionMsg;
import com.vipabc.utils.Env;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class SaveUserExtension extends Env{
	HttpFixture hf = new HttpFixture();
	@Test(priority = 1, dataProvider = "data", description = "")
	public void saveExtension(Map<String, String> dataDriven) throws InterruptedException {
		String token = AppLogin.login(hf, dataDriven.get("User"), dataDriven.get("Password"));
		SaveUserExtensionMsg.saveUserExtension(hf, token, dataDriven.get("EnableNotFollowInvite"), dataDriven.get("EnableLiveNotice"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		hf.nextRequest();
		Thread.sleep(1000);
		GetUserExtensionMsg.getUserExtenstion(hf, token);
		Assert.assertEquals(hf.getStatus(), 200);
		if(dataDriven.get("Case").equals("no token"))
		{
			Assert.assertEquals(hf.getStatus(), 200);
			Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ","), dataDriven.get("success"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		}
		else
		{
		if(!dataDriven.get("EnableLiveNotice").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("enableLiveNotice\":", ",\""), dataDriven.get("EnableLiveNotice"));
		if(!dataDriven.get("EnableNotFollowInvite").equals(""))
		Assert.assertEquals(hf.saveParamLeftstrRightstr("enableNotFollowInvite\":", ",\""), dataDriven.get("EnableNotFollowInvite"));
		}

	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "saveExtension");
	}

}
