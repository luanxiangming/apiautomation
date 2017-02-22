package com.vipabc.test.backend.securityController;

import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.securityController.PhonePasswordResetThenLoginMsg;
import com.vipabc.msg.backend.securityController.SendVerificationCodeMsg;
import com.vipabc.utils.Env;
import com.vipabc.utils.Pro;

import shelper.datadrive.ExcelProvider;
import shelper.db.Pg;
import shelper.iffixture.HttpFixture;

public class PhonePasswordResetThenLogin extends Env{
	HttpFixture hf = new HttpFixture();
	Pro pro=new Pro();
	@Test(priority = 1, dataProvider = "data", description = "找回密碼")
	public void resetLogin(Map<String, String> dataDriven) {
		SendVerificationCodeMsg.sendVerCode(hf, dataDriven.get("phone"), dataDriven.get("nationcode"));
		if(dataDriven.get("verCode").equals(""))
		{
			String verifycode=queryCode(dataDriven.get("phone"));
		PhonePasswordResetThenLoginMsg.resetLogin(hf, dataDriven.get("phone"), dataDriven.get("nationcode"), verifycode, dataDriven.get("newPassword"));
		}
		else
			PhonePasswordResetThenLoginMsg.resetLogin(hf, dataDriven.get("phone"), dataDriven.get("nationcode"), dataDriven.get("verCode"), dataDriven.get("newPassword"));
		Assert.assertEquals(hf.getStatus(), 200);
		Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
		Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		if(dataDriven.get("case").equals("noraml login"))
		{
			Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
			Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
		}
			
	}
	@DataProvider
	public Iterator<Object[]> data() {
		System.out.println(this.getClass().toString());
		return new ExcelProvider(this, "resetLogin");
	}
	public String queryCode(String phone)
	{
    	Pg pg=new Pg(pro.getEnvPropties("pg.url","url"), pro.getEnvPropties("pg.username","url"), pro.getEnvPropties("pg.password","url"));
    	String code=pg.query("select verification_code from mobilephone_verifycation where mobile_phone='"+phone+"' order by update_time desc limit 1");
    	return code;
	}
	
}
