package com.vipabc.msg.backend.login;

import com.vipabc.utils.Pro;

import shelper.iffixture.HttpFixture;

public class BackOfficeLogin {
	public static String login(HttpFixture hf)
	{
		Pro pro=new Pro();
		String request=pro.getEnvPropties("bkoffice.url","url")+"/api/v1/accounts/login";
		hf.addHeaderValue("Content-Type", "application/json");
		hf.setUrl(request);
		System.out.println(request);
		hf.addRequestBody("{\"userName\":\""+pro.getEnvPropties("bkoffice.user","url")+"\",\"password\":\""+pro.getEnvPropties("bkoffice.pw","url")+"\"}");
		hf.Post();
		return hf.saveParamLeftstrRightstr("apiToken\":\"", "\","); 
	}

}
