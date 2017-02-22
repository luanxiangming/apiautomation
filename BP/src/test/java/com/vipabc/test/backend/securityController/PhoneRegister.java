package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.securityController.PhoneRegisterMsg;
import com.vipabc.msg.backend.securityController.SendVerificationCodeMsg;
import com.vipabc.msg.backend.userController.RemoveUserMsg;
import com.vipabc.utils.DateUtils;
import com.vipabc.utils.Pro;
import com.vipabc.utils.PublicMethod;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class PhoneRegister {
	HttpFixture hf = new HttpFixture();
	Pro pro = new Pro();
	@Test(priority = 1, dataProvider = "data", description = "")
	public void regist(Map<String, String> dataDriven) {
		SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("mobilephone"), dataDriven.get("nationCode"));
		if (!dataDriven.get("verificationCode").equals(""))
			PhoneRegisterMsg.regist(hf, dataDriven.get("nationCode"), dataDriven.get("mobilephone"), dataDriven.get("verificationCode"));
		else {
			String verifycode = PublicMethod.queryCode(pro, dataDriven.get("mobilephone"));
			PhoneRegisterMsg.regist(hf, dataDriven.get("nationCode"), dataDriven.get("mobilephone"), verifycode);
			Assert.assertTrue(!hf.saveParamLeftstrRightstr("id\":", ",\"").equals(""));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("isAudiences\":", ",\""), dataDriven.get("isAudiences"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("trialHost\":", ",\""), dataDriven.get("trialHost"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("role\":", ",\""), dataDriven.get("role"));

			RemoveUserMsg.removeUser(hf, dataDriven.get("mobilephone"), DateUtils.getDateToString_simple()+"Mosai");
		}
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "regist");
	}
}
