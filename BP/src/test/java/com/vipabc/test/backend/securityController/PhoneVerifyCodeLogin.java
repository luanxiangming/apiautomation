package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.securityController.PhoneVerifyCodeLoginMsg;
import com.vipabc.msg.backend.securityController.SendVerificationCodeMsg;
import com.vipabc.utils.Env;
import com.vipabc.utils.Pro;
import com.vipabc.utils.PublicMethod;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class PhoneVerifyCodeLogin extends Env {
	HttpFixture hf = new HttpFixture();
	Pro pro = new Pro();

	@Test(priority = 1, dataProvider = "data", description = "驗證碼登錄")
	public void verificationLogin(Map<String, String> dataDriven) {
		SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("phone"), dataDriven.get("nationcode"));
		if (!dataDriven.get("verCode").equals(""))
			PhoneVerifyCodeLoginMsg.VerifyCodeLogin(hf, dataDriven.get("phone"), dataDriven.get("nationcode"),
					dataDriven.get("verCode"));
		else {
			String verifycode = PublicMethod.queryCode(pro, dataDriven.get("phone"));
			PhoneVerifyCodeLoginMsg.VerifyCodeLogin(hf, dataDriven.get("phone"), dataDriven.get("nationcode"), verifycode);
		}
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		if (dataDriven.get("case").equals("normal login")) {
			Assert.assertEquals(hf.saveParamLeftstrRightstr("id\":", ",\""), dataDriven.get("id"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("nickName\":\"", "\",\""), dataDriven.get("nickName"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("gender\":\"", "\",\""), dataDriven.get("gender"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("intro\":\"", "\",\""), dataDriven.get("intro"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("area\":", ",\""), dataDriven.get("area"));
		}
	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "verificationLogin");
	}

}
