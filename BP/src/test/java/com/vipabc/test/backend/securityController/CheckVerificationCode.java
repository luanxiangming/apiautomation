package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.securityController.CheckVerificationCodeMsg;
import com.vipabc.msg.backend.securityController.SendVerificationCodeMsg;
import com.vipabc.utils.Pro;
import com.vipabc.utils.PublicMethod;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class CheckVerificationCode {
	HttpFixture hf = new HttpFixture();
	Pro pro = new Pro();

	@Test(priority = 1, dataProvider = "data", description = "")
	public void checkVercode(Map<String, String> dataDriven) {
		if (!dataDriven.get("verificationCode").equals(""))
		{
			SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("mobilephone"), dataDriven.get("nationCode"));
			CheckVerificationCodeMsg.checkVerificationCode(hf, dataDriven.get("nationCode"), dataDriven.get("mobilephone"), dataDriven.get("verificationCode"));
		}
		else {
			String verCode = PublicMethod.queryCode(pro, dataDriven.get("mobilephone"));
			CheckVerificationCodeMsg.checkVerificationCode(hf, dataDriven.get("nationCode"), dataDriven.get("mobilephone"), verCode);
		}
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "checkVercode");
	}
}
