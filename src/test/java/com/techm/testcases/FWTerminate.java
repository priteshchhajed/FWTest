package com.techm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.FWInternetService;
import com.techm.code.FWLogin;
import com.techm.code.WTFValidation;

public class FWTerminate {
	
	BaseWebDriver baseWebDriver;
	
	@BeforeTest
	public void initialize()
	{
		baseWebDriver = new BaseWebDriver();
		try
		{
			baseWebDriver.initialize();
		}
		catch(Exception e)
		{
			System.out.println("Initialize method fails due to an error" +e);
		}
	}
	
	@Test
	public void terminate() throws InterruptedException
	{
		FWLogin fwlogin = new FWLogin(baseWebDriver);
		fwlogin.login();
		fwlogin.changeUser();
		
		FWInternetService fwInternetFW = new FWInternetService(baseWebDriver);
		String orderNo = fwInternetFW.terminateOrder();
		
		fwlogin.WTFlogin();
		
		WTFValidation WTFValidate = new WTFValidation(baseWebDriver);
		WTFValidate.WTFValidate(orderNo);
	}
	
	

}
