package com.vipabc.test.uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
	@Test
	public void login() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://172.16.4.141:8680/#/home/relation");
		driver.findElement(By.id("User")).sendKeys("dev");
		driver.findElement(By.id("password")).sendKeys("1");
		driver.findElement(By.name("button")).click();
		driver.findElement(By.id(".//*[@id='searchForm']/div[1]/div/input[1]")).sendKeys("7000282");
		driver.findElement(By.xpath(".//*[@id='searchForm']/div[12]/div/div/input[1]")).click();
	}
	@Test
	public void queryUser()
	{


		
	}
	@BeforeClass
	public void before()
	{
		
	}
	

}
