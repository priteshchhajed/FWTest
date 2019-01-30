package com.techm.application;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebDriver {
	
	protected WebDriver driver = null;
	
	protected Properties FWAppProperties;
	
	protected Properties FWLocProperties;
	
	
	
	
	public WebDriver initializeDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Internet Explorer"))
		{
			driver = new InternetExplorerDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public void initialize()
	{
		initializeAppReadFile();
		initializeLocReadFile();
		
		//String browserName = getAppProperty("browser.name");
		
		String browserName = FWAppProperties.getProperty("browser.name");
		
		initializeDriver(browserName);
		
	}
	
	public void javaScript()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//input[@class='btn-call-to-action']"));
		js.executeScript("window.scrollTo(" + element.getLocation().x + "," +(element.getLocation().y- 100) + ");");
		element.click();
	}
	
	public void javaScriptSummary()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//a[@class='btn-call-to-action']"));
		js.executeScript("window.scrollTo(" + element.getLocation().x + "," +(element.getLocation().y- 100) + ");");
		element.click();
	}
	
	/*public void screenShot() throws IOException
	{
		//Code to capture the screen shot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Code to copy the screen shot in the desired location
		//FileUtils.copyFile(srcFile, new File("C:\\Users\\PC00467497\\Desktop\\SeleniumScreenshots\\google.jpg"));
	}*/

	public String getAppProperty(String propertyName) {
		// TODO Auto-generated method stub
		
		String element =null;
		try
		{
			element= FWAppProperties.getProperty(propertyName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Element is not found due to an error" +e);
		}
		
		return element;
	}

	private void initializeLocReadFile() {
		// TODO Auto-generated method stub
		
		//FWAppProperties = FileUtils.applicationFileRead();
		FWAppProperties = FileUtilsClass.applicationFileRead();
	}

	private void initializeAppReadFile() {
		// TODO Auto-generated method stub
		
		FWLocProperties = FileUtilsClass.locatorFileRead();
	}

	public void open(String appURL)
	{
		String element = getAppProperty(appURL);
		try
		{
			driver.get(element);
			driver.getPageSource();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Browser could not open due to an error" +e);
		}
	}
	
	public void openNewTab(String appURL)
	{
		String element = getAppProperty(appURL);
		try
		{		
			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
			
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_T);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_T);
			
			driver.get(element);
			driver.getPageSource();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Browser could not open another application due to an error" +e);
		}
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void clear(String locator)
	{
		try
		{
			WebElement element = getElement(locator);
			element.clear();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement getElement(String locator) {
		
		WebElement element = null;
		String keyValue[] = null;
		
		try
		{
			keyValue=FWLocProperties.getProperty(locator).split(Pattern.quote("|"));
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Element is not properly defined" +e);
		}
		
		element = getLocatorElement(keyValue);
		
		return element;
	}

	public WebElement getLocatorElement(String[] keyValue) {
		// TODO Auto-generated method stub
		WebElement element = null;
		if(keyValue[0].equalsIgnoreCase("id"))
		{
			element = driver.findElement(By.id(keyValue[1]));
		}
		else if(keyValue[0].equalsIgnoreCase("Xpath"))
		{
			element = driver.findElement(By.xpath(keyValue[1]));
		}
		else if(keyValue[0].equalsIgnoreCase("name"))
		{
			element = driver.findElement(By.name(keyValue[1]));
		}
		else if(keyValue[0].equalsIgnoreCase("linkText"))
		{
			element = driver.findElement(By.linkText(keyValue[1]));
		}
		else if(keyValue[0].equalsIgnoreCase("partialLinkText"))
		{
			element = driver.findElement(By.partialLinkText(keyValue[1]));
		}
		else if(keyValue[0].equalsIgnoreCase("class"))
		{
			element = driver.findElement(By.className(keyValue[1]));
		}
		else
		{
			System.out.println("Please enter valid locator");
		}
	
		return element;
		
	}

	public void click(String locator)
	{
		try
		{
			WebElement element = getElement(locator);
			element.click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickLocator(String locator)
	{
		try
		{
			String[] keyValue = locator.split(Pattern.quote("|"));
			WebElement element = getLocatorElement(keyValue);
			element.click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void type(String locator, String text)
	{
		try
		{
			WebElement element = getElement(locator);
			element.sendKeys(text);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean validateTextBox(String locator)
	{
		try
		{
			WebElement element = getElement(locator);
			String textValue = element.getText();
			if(textValue.isEmpty())
			{
				return false;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("The field is still empty with reason" + e);
		}
		return true;
	}
	
	public void typeAndEnter(String locator, String orderNo)
	{
		try
		{
			WebElement element = getElement(locator);
			element.sendKeys(orderNo);
			element.sendKeys(Keys.ENTER);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void submit(String locator)
	{
		try
		{
			WebElement element = getElement(locator);
			element.submit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectText(String locator, String text)
	{
		WebElement element = null;		
		element = getElement(locator);
		
		Select selectText = new Select(element);
		selectText.selectByVisibleText(text);
	}
	
	public void selectIndex(String locator, Integer number)
	{
		WebElement element = null;		
		element = getElement(locator);
		
		Select selectText = new Select(element);
		selectText.selectByIndex(number);
	}
	
	public void pageRefresh()
	{
		driver.navigate().refresh();
	}
	
	public void waitExplicit(String locator)
	{
		String element=valueofLocator(locator);
		String elementLocator= locatorValue(locator);
		WebDriverWait wait = new WebDriverWait(driver,30);
		if(elementLocator.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
		}
		else if(elementLocator.equalsIgnoreCase("XPath"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		}
		else if(elementLocator.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.name(element)));
		}
		else if(elementLocator.equalsIgnoreCase("linkText"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
		}
		else if(elementLocator.equalsIgnoreCase("partialLinkText"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(element)));
		}
	}
	
	 public void dateSelect()
	    {
	        WebElement element = driver.findElement(By.xpath("//span[@class='yui-skin-sam']//parent::span//input"));
	        Actions builder = new Actions(driver);
	        Action seriesOfActions = builder
	                .moveToElement(element)
	                .click()
	                .build();
	        seriesOfActions.perform();
	    }
	
	public void waitElement(String locator)
	{
		String element=valueofLocator(locator);
		String elementLocator= locatorValue(locator);
		WebDriverWait wait = new WebDriverWait(driver,40);
		if(elementLocator.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
		}
		else if(elementLocator.equalsIgnoreCase("XPath"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		}
		else if(elementLocator.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.name(element)));
		}
		else if(elementLocator.equalsIgnoreCase("linkText"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
		}
		else if(elementLocator.equalsIgnoreCase("partialLinkText"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(element)));
		}
	}

	private String locatorValue(String locator) {
		// TODO Auto-generated method stub
		String keyValue[]=null;
		
		keyValue = FWLocProperties.getProperty(locator).split(Pattern.quote("|"));
		
		return keyValue[0];
	}

	private String valueofLocator(String locator) {
		// TODO Auto-generated method stub
		String keyValue[]=null;
		try
		{
			keyValue = FWLocProperties.getProperty(locator).split(Pattern.quote("|"));
			
		}catch(Exception e)
		{
			System.out.println("Get Property failed due to e"+e);
		}
		
		return keyValue[1];
	}
	
	public String getLocatorProperty(String propertyName) throws IOException
	{
		String element = null;
		try
		{
			element = FWLocProperties.getProperty(propertyName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("This method fails due to an error" +e);
		}
		
		return element;
	}
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void javaScriptMethod() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//input[@class='btn-call-to-action']"));
		js.executeScript("window.scrollTo(" + element.getLocation().x + "," +(element.getLocation().y- 100) + ");");
	}
	
}
