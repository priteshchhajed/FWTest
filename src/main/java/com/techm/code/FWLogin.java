package com.techm.code;

import com.techm.application.BaseWebDriver;

public class FWLogin {

	private BaseWebDriver baseWebDriver;
	
	public FWLogin(BaseWebDriver baseWebDriver)
	{
		this.baseWebDriver=baseWebDriver;
	}
	
	public void login()
	{
		
		baseWebDriver.open();
		
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
}
