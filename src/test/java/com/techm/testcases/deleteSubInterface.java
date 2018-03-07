package com.techm.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.BLCLogin;
import com.techm.code.BLCSubInterface;

public class deleteSubInterface {
	
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
			System.out.println("Initialize method fails due to an error " +e);
		}
	}
	
	@Test
	public void BLCdeleteSubInterface()
	{
		BLCLogin login = new BLCLogin(baseWebDriver);
		login.Login();
		
		BLCSubInterface deleteSBI = new BLCSubInterface(baseWebDriver);
		try
		{
			deleteSBI.deleteSubInterface();
			System.out.println("SubInterface is deleted successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Deletion of SubInterface is failed due to an error" +e);
		}
		
		
	}

}
