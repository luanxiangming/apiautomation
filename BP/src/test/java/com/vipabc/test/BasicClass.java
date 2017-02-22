package com.vipabc.test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import shelper.environment.Environment;

public class BasicClass {
	public static String qa_test_home;
	@Parameters("testEnv")
	@Test(priority=1)
	public static void env(String testEnv)
	{		
		if(System.getProperty("qa_test_home")==null){
			System.setProperty("qa_test_home", ".");
		}
		qa_test_home=System.getProperty("qa_test_home");
		String separator = File.separator;
		Assert.assertTrue(testEnv.equalsIgnoreCase("dev")||testEnv.equalsIgnoreCase("stage"),"测试环境配置错误："+testEnv);
		//设置测试环境
		Environment.changeConfig("./src/test/resources/ta/TA.properties", "Selenium.TestEnv", testEnv+".properties");
		Environment.set("Selenium.TestEnv", testEnv+".properties");
		Environment.set(qa_test_home + separator + "src" + separator + "test" + separator
				+ "resources" + separator + "ta" + separator
				+ Environment.get("Selenium.TestEnv"));
		Environment.setProperites(new File(
				System.getProperty("Selenium.EnvironmentRoot")));
		String logcontent = "Set test Environment to "
				+ Environment.get("Selenium.TestEnv");
		Logger.getLogger(Environment.class.getName()).log(Level.INFO,
				logcontent);
	}

	
}
