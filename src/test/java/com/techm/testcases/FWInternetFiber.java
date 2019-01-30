package com.techm.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.FWInternetService;
import com.techm.code.FWLogin;
import com.techm.code.WTFValidation;

public class FWInternetFiber {
	
	BaseWebDriver baseWebDriver;
	String orderno=null;
	
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
	public void internetFiber() throws InterruptedException 
	{
		FWLogin fwlogin = new FWLogin(baseWebDriver);
		fwlogin.login();
		fwlogin.changeUser();
		
		FWInternetService fwInternet = new FWInternetService(baseWebDriver);
		String orderno=fwInternet.internetFiberCreate();
		//String orderno = "5513336";
		fwlogin.WTFlogin();
		
		WTFValidation WTFvalidate = new WTFValidation(baseWebDriver);
		WTFvalidate.WTFValidate(orderno);		
	}
	
}
