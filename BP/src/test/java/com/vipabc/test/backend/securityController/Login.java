package com.vipabc.test.backend.securityController;


import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vipabc.msg.backend.login.AppLogin;
import com.vipabc.utils.Env;
import com.vipabc.utils.Pro;

import shelper.datadrive.ExcelProvider;
import shelper.db.Pg;
import shelper.iffixture.HttpFixture;

/**
 * Created by emily_jwang on 11/21/2016.
 */
public class Login extends Env{

    HttpFixture hf=new HttpFixture();
    @Test(priority = 1,dataProvider = "data",description="手机号码登录")
    public void phone_login(Map<String,String> dataDriven)
    {
        AppLogin.login(hf,dataDriven.get("User"),dataDriven.get("Password"));
        Assert.assertEquals(hf.getStatus(), 200);
        Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
        if(dataDriven.get("Case").equals("Normal Login"))
        {
            Assert.assertEquals(hf.saveParamLeftstrRightstr("nickName\":\"", "\","), dataDriven.get("NickName"));
            Assert.assertEquals(hf.saveParamLeftstrRightstr("gender\":\"", "\","), dataDriven.get("Gender"));
            Assert.assertEquals(hf.saveParamLeftstrRightstr("intro\":\"", "\","), dataDriven.get("intro"));
            Assert.assertEquals(hf.saveParamLeftstrRightstr("fileName\":\"", "\""), dataDriven.get("fileName"));
            Assert.assertEquals(hf.saveParamLeftstrRightstr("area\":\"", "\","), dataDriven.get("area"));
        }
    }
    @Test(priority = 2,dataProvider = "thirdData",description="第三方登录，包含第一次登录，及已存在用户登录")
    public void thirdparty_login(Map<String,String> dataDriven)
    {
		for(int i=0;i<2;i++)
		{
    	AppLogin.thirdparty_login(hf,dataDriven.get("User"),dataDriven.get("Gender"),dataDriven.get("NickName"),dataDriven.get("IconUrl"),dataDriven.get("Platform"));
        Assert.assertEquals(hf.getStatus(), 200);
        Assert.assertEquals(hf.saveParamLeftstrRightstr("success\":", ",\""), dataDriven.get("success"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("message\":\"", "\",\""), dataDriven.get("message"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("error_code\":", ",\""), dataDriven.get("error_code"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("nickName\":\"", "\","), dataDriven.get("NickName"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("gender\":\"", "\","), dataDriven.get("Gender"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("thirdpartyPlatform\":\"", "\","), dataDriven.get("Platform"));
        Assert.assertEquals(hf.saveParamLeftstrRightstr("signupType\":\"", "\","), "THIRDPARTY");
		}
    }

    //需要确认，数据删除是不是有效
    @Test(priority = 0, dataProvider = "thirdData",description="清除第三方登录信息")
    public void initData(Map<String,String> dataDriven)
    {
		Pro pro=new Pro();
    	Pg pg=new Pg(pro.getEnvPropties("pg.url","url"), pro.getEnvPropties("pg.username","url"), pro.getEnvPropties("pg.password","url"));
//    	pg.query("select * from \"user\" where thirdparty_account='"+dataDriven.get("User")+"'");    	
//    	pg.delete("delete from \"user\" where thirdparty_account='"+dataDriven.get("User")+"'");
    }

   @DataProvider
    public Iterator<Object[]> data()
    {
        System.out.println(this.getClass().toString());
        return new ExcelProvider(this,"phone_login");
    }
    
    @DataProvider
    public Iterator<Object[]> thirdData()
    {
        System.out.println(this.getClass().toString());
        return new ExcelProvider(this,"thirdparty_login");
    }
}
