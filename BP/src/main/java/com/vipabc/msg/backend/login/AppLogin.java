package com.vipabc.msg.backend.login;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class AppLogin {
	public static String login(HttpFixture hf,String name,String pw)
	{
		Pro pro=new Pro();
		String request=pro.getEnvPropties("url.server","url")+"/vliveshow-api-app/v1/users/phone/password_login?mobilePhone="+name+"&nationCode=86&password="+pw;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
		return hf.saveParamLeftstrRightstr("token\":\"", "\"}"); 
	}
	public static String thirdparty_login(HttpFixture hf,String account,String gender, String nick_name, String icon,String platform)
	{
		Pro pro=new Pro();
		String request=pro.getEnvPropties("url.server","url")+"/vliveshow-api-app/v1/users/thirdparty/login?gender="+gender+"&nickName="+nick_name+"&thirdpartyAccount="+account+"&thirdpartyIconUrl="+icon+"&thirdpartyPlatform="+platform;
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.Post();
		return hf.saveParamLeftstrRightstr("token\":\"", "\"}"); 
	}
}
