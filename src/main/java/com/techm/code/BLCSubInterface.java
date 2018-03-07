package com.techm.code;

import com.techm.application.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class BLCSubInterface{
	
	WebDriver driver = null;
	private BaseWebDriver baseWebDriver;
	
	public BLCSubInterface(BaseWebDriver baseWebDriver)
	{
		this.baseWebDriver = baseWebDriver;
	}
 
	public void creatSubInterface() throws IOException 
	{
	  
	  //String elementSubInterface = baseWebDriver.getLocatorProperty("subInterace.link");
	  baseWebDriver.waitExplicit("subInterace.link");
	  
	  baseWebDriver.click("subInterace.link");
	  
	  //String subInterfaceNew = baseWebDriver.getLocatorProperty("subInterface.New");
	  baseWebDriver.waitExplicit("subInterface.New");
	  
	  baseWebDriver.click("subInterface.New");
	  
	  try {
		Thread.sleep(20000);
	  	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  	  }
	  
	  baseWebDriver.waitExplicit("subInterfaceNew.PERouter");
	  
	  String appPERouter = baseWebDriver.getAppProperty("subInterfaceNew.PERouter");
	  //baseWebDriver.selectText("subInterfaceNew.PERouter", appPERouter);
	  
	  baseWebDriver.type("subInterfaceNew.PERouter", appPERouter);
	  
	  
	  baseWebDriver.waitExplicit("subInterface.customer");
	  
	  //Filling up all the data on New SubInterface screen
	  
	  String appCustomerName=baseWebDriver.getAppProperty("subInterface.customer");
	  baseWebDriver.type("subInterface.customer",appCustomerName);
	  
	  String appTelefaktID = baseWebDriver.getAppProperty("subInterfaceNew.telefaktID");
	  baseWebDriver.type("subInterfaceNew.telefaktID", appTelefaktID);
	  
	  baseWebDriver.waitExplicit("subInterfaceNew.PERouter");
	  
	  String appSubInterfaceName = baseWebDriver.getAppProperty("subInterfaceNew.subInterfaceName");
	  baseWebDriver.type("subInterfaceNew.subInterfaceName", appSubInterfaceName);
	  
	  String appTech = baseWebDriver.getAppProperty("subInterfaceNew.technology");
	  baseWebDriver.selectText("subInterfaceNew.technology", appTech);
	  	  
	  String appASCircuitID = baseWebDriver.getAppProperty("subInterfaceNew.AScircuitID");
	  baseWebDriver.type("subInterfaceNew.AScircuitID", appASCircuitID);
	  
	  String appServiceID= baseWebDriver.getAppProperty("subInterfaceNew.serviceID");
	  baseWebDriver.type("subInterfaceNew.serviceID", appServiceID);
	  
	  String appVPNGroup = baseWebDriver.getAppProperty("subInterfaceNew.vpnGroup");
	  baseWebDriver.selectText("subInterfaceNew.vpnGroup", appVPNGroup);
	  
	  
	  
	  //String appVPN = baseWebDriver.getAppProperty("subInterfaceNew.vpn");
	    
	  //baseWebDriver.selectText("subInterfaceNew.vpn", appVPN);
	  
	  String appLocation = baseWebDriver.getAppProperty("subInterfaceNew.location");
	  baseWebDriver.type("subInterfaceNew.location", appLocation);
	  
	  baseWebDriver.waitExplicit("subInterfaceNew.inputSpeed");
	  
	  String appInputSpeed = baseWebDriver.getAppProperty("subInterfaceNew.inputSpeed");
	  baseWebDriver.selectText("subInterfaceNew.inputSpeed", appInputSpeed);
	  
	  baseWebDriver.waitExplicit("subInterfaceNew.outputSpeed");
	  
	  String appOutputSpeed = baseWebDriver.getAppProperty("subInterfaceNew.outputSpeed");
	  baseWebDriver.selectText("subInterfaceNew.outputSpeed", appOutputSpeed);
	  
	  baseWebDriver.waitExplicit("subInterfaceNew.interfaceRouter");
	  
	  //String appInterfaceRouter = baseWebDriver.getAppProperty("subInterfaceNew.interfaceRouter");
	  baseWebDriver.selectIndex("subInterfaceNew.interfaceRouter");
	  
	  //Need to refresh the application and also need to put Explicit wait for few items to be enabled
	  
	  
	  
	  String appSVLAN = baseWebDriver.getAppProperty("subInterfaceNew.SVLAN");
	  baseWebDriver.type("subInterfaceNew.SVLAN", appSVLAN);
	  
	  String appcpeVendor = baseWebDriver.getAppProperty("subInterfaceNew.cpeVendor");
	  baseWebDriver.selectText("subInterfaceNew.cpeVendor", appcpeVendor);
	  
	  String appcpHostName = baseWebDriver.getAppProperty("subInterfaceNew.cpeHostName");
	  baseWebDriver.type("subInterfaceNew.cpeHostName", appcpHostName);
	  
	  baseWebDriver.submit("subInterfaceNew.create");
	  
  }
 
  public void updateSubInterface() {
	  
	  
  }

  
  public void deleteSubInterface() {
	  
	  baseWebDriver.waitExplicit("subInterace.link");
	  
	  baseWebDriver.click("subInterace.link");
	  
	  baseWebDriver.waitExplicit("subInterface.searchName");
	  
	  String searchSubInterfaceName = baseWebDriver.getAppProperty("subInterfaceDelete.name");
	  baseWebDriver.type("subInterface.searchName", searchSubInterfaceName);
	  
	  //baseWebDriver.waitExplicit(locator);
	  
	  baseWebDriver.click("subInterface.searchButton");
	  
	  baseWebDriver.waitExplicit("subInterface.searchButton");
	  
	 @SuppressWarnings("unused")
	 Boolean searchInput =searchSubInterfaceName.isEmpty();
	  
	  if(searchInput=false)
	  {
		  baseWebDriver.clickonText(searchSubInterfaceName);
	  }
	  else
	  {
		  System.out.println("The search SubInterface does not exist");
		  System.exit(0);
		  //return;
		  
		  
	  }
	  
	  baseWebDriver.waitExplicit("subInterfaceDelete.deleteButton");
	  
	  baseWebDriver.click("subInterfaceDelete.deleteButton");
	  
	  baseWebDriver.waitExplicit("subInterfaceDelete.delButton");
	  
	  baseWebDriver.click("subInterfaceDelete.delButton");
	  
	  baseWebDriver.waitExplicit("subInterfaceDelete.deleteOKButton");
	  
	  baseWebDriver.click("subInterfaceDelete.deleteOKButton");
	  
	  
  }

}
