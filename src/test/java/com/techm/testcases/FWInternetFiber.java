package com.techm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.FWInternetService;
import com.techm.code.FWLogin;

public class FWInternetFiber {
	
	BaseWebDriver baseWebDriver;
	
	@BeforeTest
	public void initalize()
	{
		baseWebDriver = new BaseWebDriver();
		
		try
		{
			baseWebDriver.initialize();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Initialize method fails due to an error" +e);
		}
	}
	
	@Test
	public void internetFiber()
	{
		FWLogin fwlogin = new FWLogin(baseWebDriver);
		fwlogin.login();
		fwlogin.changeUser();
		
		FWInternetService fwInternet = new FWInternetService(baseWebDriver);
		fwInternet.internetFiberCreate();
	}
}
