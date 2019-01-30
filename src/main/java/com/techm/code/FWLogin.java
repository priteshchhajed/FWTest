package com.techm.code;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import com.techm.application.BaseWebDriver;

public class FWLogin {

	private BaseWebDriver baseWebDriver;
	
	public FWLogin(BaseWebDriver baseWebDriver)
	{
		this.baseWebDriver=baseWebDriver;
	}
	
	public void login() 
	{
		
		//String appURL = baseWebDriver.getAppProperty("fw.url");
		baseWebDriver.open("fw.url");
		
		baseWebDriver.waitExplicit("fw.userName");
		
		String userName = baseWebDriver.getAppProperty("fw.userName");
		baseWebDriver.type("fw.userName", userName);
		
		String password = baseWebDriver.getAppProperty("fw.password");
		baseWebDriver.type("fw.password", password);
		
		baseWebDriver.submit("fw.submit");
		
		
	}
	
	public void changeUser() 
	{
		baseWebDriver.waitExplicit("fw.adminMenu");
		
		baseWebDriver.click("fw.adminMenu");
		
		baseWebDriver.waitExplicit("fw.searchCustomer");
		
		String customerID = baseWebDriver.getAppProperty("fw.customerID");
		baseWebDriver.type("fw.searchCustomer", customerID);
		
		baseWebDriver.click("fw.searchButton");
		
		baseWebDriver.waitExplicit("fw.custWagonWheel");
		
		baseWebDriver.click("fw.custWagonWheel");
		
		baseWebDriver.click("fw.changeCustomer");
		
	}
	
	public void WTFlogin()
	{
		//String appWTFURL = baseWebDriver.getAppProperty("fw.WTFURL");
		baseWebDriver.openNewTab("fw.WTFURL");
		
		baseWebDriver.waitExplicit("fw.WTFLoginButton");
		baseWebDriver.click("fw.WTFLoginButton");
		
		baseWebDriver.waitExplicit("fw.WTFUserName");
		
		String userName = baseWebDriver.getAppProperty("fw.WTFUserName");
		baseWebDriver.type("fw.WTFUserName", userName);
		
		String password = baseWebDriver.getAppProperty("fw.WTFPassword");
		baseWebDriver.type("fw.WTFPassword", password);
		
		baseWebDriver.submit("fw.WTFLoginEnter");
		
		
	}
}
