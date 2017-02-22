package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.msg.backend.securityController.PhoneBindingMsg;
import com.vipabc.msg.backend.securityController.SendVerificationCodeMsg;
import com.vipabc.msg.backend.userController.RemoveUserMsg;
import com.vipabc.msg.backend.userController.ShowBaseInfoMsg;
import com.vipabc.utils.DateUtils;
import com.vipabc.utils.Env;
import com.vipabc.utils.Pro;
import com.vipabc.utils.PublicMethod;

import shelper.datadrive.ExcelProvider;
import shelper.iffixture.HttpFixture;

public class PhoneBinding extends Env {
	HttpFixture hf = new HttpFixture();
	Pro pro = new Pro();

	// @Test(priority = 1, dataProvider = "data", description = "")
	public void bind_phone(Map<String, String> dataDriven) {
		String token = AppLogin.login(hf, dataDriven.get("phone"), dataDriven.get("password"));
		SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("bindPhone"), dataDriven.get("nationcode"));
		if (dataDriven.get("verCode").equals("")) {
			String verCode = PublicMethod.queryCode(pro, dataDriven.get("bindPhone"));
			PhoneBindingMsg.binding(hf, token, dataDriven.get("bindPhone"), dataDriven.get("nationcode"), verCode);
		} else {
			PhoneBindingMsg.binding(hf, token, dataDriven.get("bindPhone"), dataDriven.get("nationcode"),
					dataDriven.get("verCode"));
		}
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":", ",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		if (dataDriven.get("success").equals("true")) {
			ShowBaseInfoMsg.showBaseInfo(hf, token);
			Assert.assertEquals(hf.saveParamLeftstrRightstr("decodeMobilePhone\":\"", "\""),
					dataDriven.get("bindPhone"));
		}
	}

	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "bind_phone");
	}

	@Test(priority = 1, dataProvider = "third_data", description = "")
	public void bind_thirdParty(Map<String, String> dataDriven) {
		String token = AppLogin.thirdparty_login(hf, dataDriven.get("User"), dataDriven.get("Gender"),
				dataDriven.get("NickName"), dataDriven.get("IconUrl"), dataDriven.get("Platform"));
		SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("bindPhone"), dataDriven.get("nationcode"));
		if (dataDriven.get("verCode").equals("")) {
			if (dataDriven.get("User").equals("")) {
				RemoveUserMsg.removeUser(hf, dataDriven.get("bindPhone"), DateUtils.getDateToString_simple() + "Mosai");
			} else {
				String verCode = PublicMethod.queryCode(pro, dataDriven.get("bindPhone"));
				PhoneBindingMsg.binding(hf, token, dataDriven.get("bindPhone"), dataDriven.get("nationcode"), verCode);
			}
			if (dataDriven.get("success").equals("true") && !dataDriven.get("User").equals("")) {
				ShowBaseInfoMsg.showBaseInfo(hf, token);
				Assert.assertEquals(hf.saveParamLeftstrRightstr("decodeMobilePhone\":\"", "\""),
						dataDriven.get("bindPhone"));
			}
		} else
			PhoneBindingMsg.binding(hf, token, dataDriven.get("bindPhone"), dataDriven.get("nationcode"),
					dataDriven.get("verCode"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":", ",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
	}

	@DataProvider
	public Iterator<Object[]> third_data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "bind_thirdParty");
	}
}
