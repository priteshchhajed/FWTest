package com.techm.testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.BLCLogin;
import com.techm.code.BLCSubInterface;

import java.io.IOException;



public class CreateSubInterface {
	
	BaseWebDriver baseWebDriver;
	
	@BeforeTest
	public void initializeMethod()
	{
		baseWebDriver = new BaseWebDriver();
		try {
			baseWebDriver.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void BLCcreateSubInterface()
	{
		
		BLCLogin login = new BLCLogin(baseWebDriver);
		login.Login();
		
		BLCSubInterface createSI = new BLCSubInterface(baseWebDriver);
		try {
			createSI.creatSubInterface();
			System.out.println("Create SubInterface is successfully executed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Create SubInterface is failed due to an error"+e);
		}
	}

}
