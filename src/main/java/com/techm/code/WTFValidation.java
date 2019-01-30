package com.techm.code;

import org.openqa.selenium.WebElement;

import com.techm.application.BaseWebDriver;

public class WTFValidation {
	
	private BaseWebDriver baseWebDriver;
	
	public WTFValidation(BaseWebDriver baseWebDriver)
	{
		this.baseWebDriver = baseWebDriver;
	}
	
	public void WTFValidate(String orderNo)
	{
		System.out.println(orderNo);
		baseWebDriver.waitExplicit("fw.WTFOrderId");
		baseWebDriver.typeAndEnter("fw.WTFOrderId", orderNo);
		
		baseWebDriver.waitExplicit("fw.WTFLineStatus");
		
		WebElement lineStatus;
		lineStatus = baseWebDriver.getElement("fw.WTFLineStatus");
		System.out.println(lineStatus);
		String valueOf = lineStatus.getAttribute("value");
		System.out.println("Value is" +valueOf);
		char status = lineStatus.getText().charAt(3);
		System.out.println("Status is" +status);
	}
	
	public void WTFValidateCktNo(String circuitNo)
	{
		
	}

}
