package com.techm.testcases;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FWInternetFiberGrid {
	
	WebDriver driver;
//	URL url = new URL("http://10.10.244.19:5566/wd/hub");
	String baseURL="https://www.guru99.com/";
	
	
	@BeforeTest
	public void initialize()
	{
		try
		{
			/*System.setProperty("webdriver.chrome.driver", "C://Users//PC00467497//Downloads//chromedriver_win32//chromedriver.exe");
			//DesiredCapabilities capability = DesiredCapabilities.firefox();
			//DesiredCapabilities capability = DesiredCapabilities.chrome();
			//capability.setBrowserName("Firefox");
			capability.setPlatform(Platform.WIN10);
			//capability.setCapability("binary", "C://Program Files//Mozilla  Firefox//firefox.exe");
			
			//System.setProperty("webdriver.firefox.bin", "C://Program Files//Mozilla Firefox//firefox.exe");
			//System.setProperty("webdriver.gecko.driver", "C://Selenium Server/geckodriver.exe");
			
			*/
			DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
	        capabilities.setCapability("networkConnectionEnabled", true);
	        capabilities.setCapability("browserConnectionEnabled", true); 
			driver = new RemoteWebDriver(new URL("http://10.10.244.75:5566/wd/hub"), capabilities);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Initialize method fails due to an error" +e);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGoogle()
	{
		driver.get("https://www.guru99.com");
		System.out.println("Successfully working");
		Assert.assertEquals("Meet Guru99 - Free Training Tutorials", driver.getTitle());
	}

}
