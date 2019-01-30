package com.techm.code;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techm.application.BaseWebDriver;

import junit.framework.Assert;

public class FWInternetService {
	
	private BaseWebDriver baseWebDriver;
	
	public FWInternetService(BaseWebDriver baseWebDriver)
	{
		this.setBaseWebDriver(baseWebDriver);
	}
	
	public String internetFiberCreate() throws InterruptedException
	{
		
		selectProduct();
		selectAddress();
		selectServiceInformation();
		selectAddServices();
		selectSummary();
		selectOrderScreen();
		String orderNo = fetchOrderNo();
		return orderNo;
		//verifyInWTF(orderNo);
	}
	

	/*private void verifyInWTF(String orderNo) {
		// TODO Auto-generated method stub
		baseWebDriver.open("fw.WTFURL");
		
		baseWebDriver.waitExplicit("fw.WTFLoginButton");
		baseWebDriver.click("fw.WTFLoginButton");
		
		baseWebDriver.waitExplicit("fw.WTFUserName");
		
		String userName = baseWebDriver.getAppProperty("fw.WTFUserName");
		baseWebDriver.type("fw.WTFUserName", userName);
		
		String password = baseWebDriver.getAppProperty("fw.password");
		baseWebDriver.type("fw.WTFPassword", password);
		
		baseWebDriver.submit("fw.WTFLoginEnter");
		
		baseWebDriver.waitExplicit("fw.WTFOrderId");
		baseWebDriver.typeAndEnter("fw.WTFOrderId");
		
		baseWebDriver.waitExplicit("fw.WTFLineStatus");
		
		WebElement lineStatus;
		lineStatus = baseWebDriver.getElement("fw.WTFLineStatus");
		char status = lineStatus.getText().charAt(0);
		System.out.println(status);
	}*/

	private String fetchOrderNo() {
		// TODO Auto-generated method stub
		WebElement element;
		element = baseWebDriver.getElement("fw.orderonreceipt");
		String str=element.getText().trim();
		System.out.println(str);
		String newStr = null;
		Integer indexof = str.indexOf("Receipt – Order no. ");
		System.out.println(indexof);
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(str);
		while(m.find())
		{
			newStr=m.group();
		}
		System.out.println(newStr);
		return newStr;
	}

	public void selectOrderScreen() throws InterruptedException  {
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
		orderDate();
		
		
		
		baseWebDriver.waitExplicit("fw.endUsrAsEndUsrBtn");
		baseWebDriver.click("fw.endUsrAsEndUsrBtn");
		
				
		String invoiceGroup = baseWebDriver.getAppProperty("fw.chcInvoicegrp");
		baseWebDriver.selectText("fw.chcInvoicegrp", invoiceGroup);
		
		
		
		String custReciept = baseWebDriver.getAppProperty("fw.custOrdererRecpt");
		baseWebDriver.selectText("fw.custOrdererRecpt", custReciept);
		
		
		baseWebDriver.waitElement("fw.recvrEqpUsrName");
		String recEquipment = baseWebDriver.getAppProperty("fw.recvrEqpUsrName");
		baseWebDriver.type("fw.recvrEqpUsrName", recEquipment);
		Robot rb;
		try {
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Boolean check = baseWebDriver.validateTextBox("fw.recvrEqpUsrName");
		System.out.println(check);
		if(check == false)
		{
			baseWebDriver.clear("fw.recvrEqpUsrName");
			baseWebDriver.type("fw.recvrEqpUsrName", recEquipment);
		}
		
		baseWebDriver.waitExplicit("fw.orderScrOrdBtn");
		
		baseWebDriver.click("fw.orderScrOrdBtn");
	}

	private void orderDate() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		//baseWebDriver.waitExplicit("fw.orderScrDatePicker");
		//baseWebDriver.click("fw.orderScrDatePicker");
		
		baseWebDriver.dateSelect();
		
		baseWebDriver.waitExplicit("fw.orderScrDateInputBox");
		baseWebDriver.click("fw.orderScrDateInputBox");
		
		String dateOfMonth = baseWebDriver.getAppProperty("fw.dateOfMonth");
		baseWebDriver.selectText("fw.orderScrDateofMonth", dateOfMonth);
		
		String dateOfYear = baseWebDriver.getAppProperty("fw.dateOfYear");
		baseWebDriver.type("fw.orderScrDateofYear", dateOfYear);
		
		baseWebDriver.click("fw.orderScrDateOkayBtn");
		
		Thread.sleep(3000);
		
		String dateOfDay = baseWebDriver.getAppProperty("fw.dateOfDay");
		String locator = "XPath|//span[@class='yui-skin-sam']//a[contains(text(),'"+ dateOfDay +"')]";
	
		baseWebDriver.implicitWait();
		//baseWebDriver.waitExplicit(locator);
		baseWebDriver.clickLocator(locator);
		
	}

	public void selectSummary()
	{
		//baseWebDriver.waitExplicit("fw.summaryNextButton");
		//baseWebDriver.click("fw.summaryNextButton");
		baseWebDriver.javaScriptSummary();
	}
	
	public void selectAddServices() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.addserviceNextButton");
		baseWebDriver.javaScript();
		//baseWebDriver.javaScriptMethod();
		//baseWebDriver.click("fw.addserviceNextButton");
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
		
		selectProductDuration(iproductDuration,productType);
		
	}
	
	public void selectProductDuration(Integer iproductDuration, String productType)
	{
		switch (iproductDuration)
		{
			case 12 :
				String locator12Month = "XPath|//td[contains(text(),"+productType+")]//following::td[1]";
				baseWebDriver.clickLocator(locator12Month);
				break;
			case 24 :
				String locator24Month = "XPath|//td[contains(text(),"+productType+")]//following::td[2]";
				baseWebDriver.clickLocator(locator24Month);
				break;
			case 36 :
				String locator36Month = "XPath|//td[contains(text(),"+productType+")]//following::td[3]";
				baseWebDriver.clickLocator(locator36Month);
				break;
			case 48 :
				String locator48Month = "XPath|//td[contains(text(),"+productType+")]//following::td[4]";
				baseWebDriver.clickLocator(locator48Month);
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

	public String internetFiberChangeSpeed() throws InterruptedException
	{
		baseWebDriver.waitExplicit("fw.ordrSubscrptTab");
		baseWebDriver.click("fw.ordrSubscrptTab");
		
		baseWebDriver.waitExplicit("fw.searchInput");
		String searchSubscrptn = baseWebDriver.getAppProperty("fw.subscrptnID");
		baseWebDriver.type("fw.searchInput", searchSubscrptn);
		
		baseWebDriver.click("fw.searchButton");
		
		Thread.sleep(3000);
		baseWebDriver.waitExplicit("fw.subWagonWheel");
		baseWebDriver.click("fw.subWagonWheel");
		
		baseWebDriver.waitExplicit("fw.subChangeSpeedMenu");
		baseWebDriver.click("fw.subChangeSpeedMenu");
		
		baseWebDriver.waitExplicit("fw.subAddressSelctLink");
		baseWebDriver.click("fw.subAddressSelctLink");
			
		baseWebDriver.waitExplicit("fw.selectServiceTab");
		
		Thread.sleep(5000);
		String productDuration = baseWebDriver.getAppProperty("fw.subscrnNewProdDuration");
		String productType = baseWebDriver.getAppProperty("fw.subscrnNewProdType");
		
		Thread.sleep(5000);
		
		int iproductDuration = Integer.parseInt(productDuration);
		
		selectProductDuration(iproductDuration,productType);
		
		selectAddServices();
		selectSummary();
		orderDateNew();
		baseWebDriver.waitExplicit("fw.endUsrAsEndUsrBtn");
		baseWebDriver.click("fw.endUsrAsEndUsrBtn");
		
		String custReciept = baseWebDriver.getAppProperty("fw.custOrdererRecpt");
		baseWebDriver.selectText("fw.custOrdererRecpt", custReciept);
		
		baseWebDriver.waitExplicit("fw.orderScrOrdBtn");
		
		baseWebDriver.click("fw.orderScrOrdBtn");
		
		String orderNo = fetchOrderNo();
		return orderNo;
	}
	
	private void orderDateNew() {
		// TODO Auto-generated method stub
		
		/*Date newDate = new Date();
		String strnewDate = "30-07-2018";
		System.out.println("New Date is :" +newDate);
		System.out.println("String New Date is :" +strnewDate);
		SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date ndate = date_format.parse(strnewDate);
			strnewDate = date_format.format(ndate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("String New Date is :" +strnewDate);
		String date = date_format.format(newDate);
		System.out.println("Date is :" +date);
		
		baseWebDriver.waitExplicit("fw.orderScrDatePickerDirect");
		baseWebDriver.type("fw.orderScrDatePickerDirect", strnewDate);
		*/
		baseWebDriver.waitExplicit("fw.orderScrDatePicker");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseWebDriver.click("fw.orderScrDatePicker");
		
		
		WebElement datep = baseWebDriver.getElement("fw.orderScrDatePicker");
		
		List<WebElement> columns = datep.findElements(By.tagName("td"));
		
		for (WebElement cell:columns)
		{
			if(cell.getText().equals("30"))
			{
				cell.findElement(By.linkText("30")).click();
				break;
			}
		}
		
	}

	public void internetFiberChangeLocation()
	{
		
	}
	
	public String terminateOrder() throws InterruptedException
	{
		//String circuitNo = null;
		clickonOrderSubscription();
		searchSubScrption();
		terminate();
		String orderNo = fetchOrderNo();
		return orderNo;
	}

	private void terminate() throws InterruptedException {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.subWagonWheel");
		baseWebDriver.pageRefresh();
		baseWebDriver.waitExplicit("fw.subWagonWheel");
		baseWebDriver.click("fw.subWagonWheel");
		
		baseWebDriver.click("fw.terminationMenu");
		
		baseWebDriver.waitExplicit("fw.terminationPreferredDate");
		baseWebDriver.click("fw.terminationPreferredDate");
		orderDate();
		
		String cancelReason = baseWebDriver.getAppProperty("fw.terminateCancelReason");
		baseWebDriver.selectText("fw.terminationCancelReason", cancelReason);
		
		String subReason = baseWebDriver.getAppProperty("fw.terminateSubReason");
		baseWebDriver.selectText("fw.terminationSubReason", subReason);
		
		baseWebDriver.waitExplicit("fw.terminationInvoiceDate");
		baseWebDriver.click("fw.terminationInvoiceDate");
		orderDate();
		
		
		String BTagNo = baseWebDriver.getAppProperty("fw.terminationBTag");
		baseWebDriver.type("fw.terminationBTag", BTagNo);
		
		String custOrderReceipt = baseWebDriver.getAppProperty("fw.terminationCustOrderReceipt");
		baseWebDriver.selectText("fw.terminationCustOrderReceipt", custOrderReceipt);
		
		//baseWebDriver.click("fw.terminationSubmitButton");
		
		
	}
	
	public String internetFiberADDON() throws InterruptedException
	{
		baseWebDriver.waitExplicit("fw.ordrSubscrptTab");
		baseWebDriver.click("fw.ordrSubscrptTab");
		
		baseWebDriver.waitExplicit("fw.searchInput");
		String searchSubscrptn = baseWebDriver.getAppProperty("fw.ADDONsubscrptnID");
		baseWebDriver.type("fw.searchInput", searchSubscrptn);
		
		baseWebDriver.click("fw.searchButton");
		
		Thread.sleep(3000);
		baseWebDriver.waitExplicit("fw.subWagonWheel");
		baseWebDriver.click("fw.subWagonWheel");
		
		baseWebDriver.waitExplicit("fw.subADDONMenu");
		baseWebDriver.click("fw.subADDONMenu");
		
		baseWebDriver.waitExplicit("fw.subContinueButtonADDON");
		baseWebDriver.click("fw.subContinueButtonADDON");
		
		
		
		return null;
	}

	private void searchSubScrption() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.searchInput");
		
		String circuitID= baseWebDriver.getAppProperty("fw.subscrptnID");
		baseWebDriver.type("fw.searchInput", circuitID);
		
		baseWebDriver.click("fw.searchButton");
	}

	private void clickonOrderSubscription() {
		// TODO Auto-generated method stub
		baseWebDriver.waitExplicit("fw.orderSubscriptionMenu");
		baseWebDriver.click("fw.orderSubscriptionMenu");
		
		baseWebDriver.waitExplicit("fw.activeSubscriptionList");
		baseWebDriver.click("fw.activeSubscriptionList");
	}

	public BaseWebDriver getBaseWebDriver() {
		return baseWebDriver;
	}

	public void setBaseWebDriver(BaseWebDriver baseWebDriver) {
		this.baseWebDriver = baseWebDriver;
	}

	
}
