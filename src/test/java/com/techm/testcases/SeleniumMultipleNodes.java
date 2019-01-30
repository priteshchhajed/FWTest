package com.techm.testcases;

import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumMultipleNodes {

	
	String huburl="http://10.10.244.4:4444/wd/hub";
	
	@Test
	public void testFirefoxWithNode1()
	{
		System.out.println("Start testing firefox on Node1");
		this.testUtil(huburl,"http://www.seleniumhq.org/","Firefox");
		System.out.println("Stop testing firefox on Node1");
	}
	
	@Test
	public void testChromeWithNode2()
	{
		this.testUtil(huburl, "https://www.guru99.com/","Firefox");
	}

	private void testUtil(String huburl, String testUrl, String browserName) {
		// TODO Auto-generated method stub
		
		RemoteWebDriver rdriver = null;
		
		DesiredCapabilities capability = null;
		
		try
		{
			if("Firefox".equalsIgnoreCase(browserName))
			{
				System.out.println("Create Firefox browser Desired Capabilities object");
				capability  = DesiredCapabilities.firefox();
			}
			else if("Chrome".equalsIgnoreCase(browserName))
			{
				System.out.println("Create Chrome browser Desired Capabilities object");
				capability = DesiredCapabilities.chrome();
			}
			else
			{
				System.out.println("Create Internet Explorer Desired Capabilities by default");
				capability = DesiredCapabilities.internetExplorer();
			}
			
			System.out.println("Create remote webdriver object to connect to grid Hub server:" + huburl);
			
			rdriver = new RemoteWebDriver(new URL(huburl), capability);
			
			System.out.println("Maximize the window");
			
			rdriver.manage().window().maximize();
						
			System.out.println("Browser web page" + testUrl);
			
			rdriver.get(testUrl);
			
			System.out.println("Wait for 10 seconds");
			Thread.sleep(10000);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rdriver!=null)
			{
				//rdriver.quit();
			}
		}
	}
}
