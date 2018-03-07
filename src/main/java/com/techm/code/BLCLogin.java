package com.techm.code;

import com.techm.application.*;

public class BLCLogin {

	private BaseWebDriver baseWebDriver;
	
	public BLCLogin(BaseWebDriver baseWebDriver) {
		this.baseWebDriver = baseWebDriver;
	}
	
	
	
  //@Test
  public void Login() {
	  
		
	  	//String appURL = getAppProperty("application.url");
	  	baseWebDriver.open();
	  	
	  	baseWebDriver.waitExplicit("login.username");
		
		//String locUserName=getLocatorProperty("login.username");
		String userName=baseWebDriver.getAppProperty("login.user");
		baseWebDriver.type("login.username",userName);
		
		String userPassword=baseWebDriver.getAppProperty("login.password");
		baseWebDriver.type("login.password",userPassword);
		
		//Submitting the Sign IN button
		baseWebDriver.submit("login.signIn");
		
	  
  }
}
