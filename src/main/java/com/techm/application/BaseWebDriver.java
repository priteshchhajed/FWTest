package com.techm.application;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.condition.Presence;

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
		
		FWAppProperties = FileUtils.applicationFileRead();
	}

	private void initializeAppReadFile() {
		// TODO Auto-generated method stub
		
		FWLocProperties = FileUtils.locatorFileRead();
	}

	public void open()
	{
		String element = getAppProperty("fw.url");
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
	
	private WebElement getElement(String locator) {
		
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

	private WebElement getLocatorElement(String[] keyValue) {
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
	
	
}
