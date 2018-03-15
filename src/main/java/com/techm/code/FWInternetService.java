package com.techm.code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techm.application.BaseWebDriver;

public class FWInternetService {
	
	private BaseWebDriver baseWebDriver;
	
	public FWInternetService(BaseWebDriver baseWebDriver)
	{
		this.setBaseWebDriver(baseWebDriver);
	}
	
	public void internetFiberCreate()
	{
		
		selectProduct();
		selectAddress();
		selectServiceInformation();
		selectAddServices();
		selectSummary();
		selectOrderScreen();
		
	}
	
	public void selectOrderScreen() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.endUsrName");
		String endUserName = baseWebDriver.getAppProperty("fw.endUsrName");
		baseWebDriver.type("fw.endUsrName", endUserName);
		
		String orgNo = baseWebDriver.getAppProperty("fw.endUsrOrgno");
		baseWebDriver.type("fw.endUsrOrgno", orgNo);
		
		String floorNo = baseWebDriver.getAppProperty("fw.endUsrFloor");
		baseWebDriver.selectText("fw.endUsrFloor", floorNo);
		
		String roomDesc = baseWebDriver.getAppProperty("fw.endUsrRoomDesc");
		baseWebDriver.type("fw.endUsrRoomDesc", roomDesc);
		
		String localContactName = baseWebDriver.getAppProperty("fw.endUsrLocalContactName");
		baseWebDriver.type("fw.endUsrLocalContactName", localContactName);
		
		String localContactPhone = baseWebDriver.getAppProperty("fw.endUsrLocalContactPhn");
		baseWebDriver.type("fw.endUsrLocalContactPhn", localContactPhone);
		
		//Date selected from Date Picker
		baseWebDriver.click("fw.orderScrDatePicker");
		
		baseWebDriver.waitExplicit("fw.orderScrDateInputBox");
		baseWebDriver.click("fw.orderScrDateInputBox");
		
		String dateOfMonth = baseWebDriver.getAppProperty("fw.dateOfMonth");
		baseWebDriver.selectText("fw.orderScrDateofMonth", dateOfMonth);
		
		String dateOfYear = baseWebDriver.getAppProperty("fw.dateOfYear");
		baseWebDriver.type("fw.orderScrDateofYear", dateOfYear);
		
		baseWebDriver.click("fw.orderScrDateOkayBtn");
		
		String dateOfDay = baseWebDriver.getAppProperty("fw.dateOfDay");
		String locator = "XPath|//tbody[@class='m3 calbody']//a[contains(text(),'"+ dateOfDay +"')]";
		
		baseWebDriver.clickLocator(locator);
		
		baseWebDriver.waitExplicit("fw.endUsrAsEndUsrBtn");
		baseWebDriver.click("fw.endUsrAsEndUsrBtn");
		
				
		String invoiceGroup = baseWebDriver.getAppProperty("fw.chcInvoicegrp");
		baseWebDriver.selectText("fw.chcInvoicegrp", invoiceGroup);
		
		
		
		String custReciept = baseWebDriver.getAppProperty("fw.custOrdererRecpt");
		baseWebDriver.selectText("fw.custOrdererRecpt", custReciept);
		
		
		baseWebDriver.waitElement("fw.recvrEqpUsrName");
		String recEquipment = baseWebDriver.getAppProperty("fw.recvrEqpUsrName");
		baseWebDriver.type("fw.recvrEqpUsrName", recEquipment);
		
		baseWebDriver.waitExplicit("fw.orderScrOrdBtn");
		
		baseWebDriver.click("fw.orderScrOrdBtn");
	}

	public void selectSummary()
	{
		baseWebDriver.waitExplicit("fw.summaryNextButton");
		baseWebDriver.click("fw.summaryNextButton");
	}
	
	public void selectAddServices() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.addserviceNextButton");
		baseWebDriver.click("fw.addserviceNextButton");
	}

	public void selectServiceInformation() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseWebDriver.waitExplicit("fw.serviceInformationTab");
		String productDuration = baseWebDriver.getAppProperty("fw.productDuration");
		String productType = baseWebDriver.getAppProperty("fw.productType");
		
		int iproductDuration = Integer.parseInt(productDuration);
		
		switch (iproductDuration)
		{
			case 12 :
				String locator12Month = "XPath|//td[contains(text(),"+productType+")]//following::td[1]";
				baseWebDriver.clickLocator(locator12Month);
				break;
			case 24 :
				String locator24Month = "XPath|//td[contains(text(),"+productType+")]//following::td[2]";
				baseWebDriver.click(locator24Month);
				break;
			case 36 :
				String locator36Month = "XPath|//td[contains(text(),"+productType+")]//following::td[3]";
				baseWebDriver.click(locator36Month);
				break;
			case 48 :
				String locator48Month = "XPath|//td[contains(text(),"+productType+")]//following::td[4]";
				baseWebDriver.click(locator48Month);
				break;	
		}
	}

	public void selectAddress() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.address");
		
		String custAddress = baseWebDriver.getAppProperty("fw.address");
		baseWebDriver.type("fw.address", custAddress);
		
		baseWebDriver.waitExplicit("fw.addressSelect");
		baseWebDriver.click("fw.addressSelect");
		
		baseWebDriver.waitExplicit("fw.addressContinueButton");
		
		baseWebDriver.click("fw.addressContinueButton");
	}

	public void selectProduct() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.custOrderEntry");
		baseWebDriver.click("fw.custOrderEntry");
		
		baseWebDriver.waitExplicit("fw.internetProductChoose");
		baseWebDriver.click("fw.internetProductChoose");
		
		baseWebDriver.waitExplicit("fw.internetFiberProduct");
		baseWebDriver.click("fw.internetFiberProduct");
	}

	public void internetFiberChangeSpeed()
	{
		
	}
	
	public void internetFiberChangeLocation()
	{
		
	}

	public BaseWebDriver getBaseWebDriver() {
		return baseWebDriver;
	}

	public void setBaseWebDriver(BaseWebDriver baseWebDriver) {
		this.baseWebDriver = baseWebDriver;
	}

	
}
