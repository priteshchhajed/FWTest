package com.techm.application;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;


//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebDriver {
	
	
	protected WebDriver driver;

	protected Properties blcAppProperties;
	
	protected Properties blcLocatorProperties;
  
	public void initializeDriver(String browserName) {
		
		//String browserName="firefox";
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
	}	
	
	public void initialize() throws IOException
	{
		initializeAppRead();
		initializeLocatorRead();
		String browserName=getAppProperty("browser.name");
		initializeDriver(browserName);
	}
	
  //@BeforeTest
  //@Parameters({"browserName","appURL"})
  public void open() {
	 
	  String appURL = getAppProperty("application.url");
	  try {
		
		driver.get(appURL);
		driver.getPageSource();
		driver.manage().window().maximize();
		
		//System.out.println("Browser opened successfully");
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Browser could not open due to error: " + e);
		}
	}
  
  
 
  public void initializeAppRead(){
	  blcAppProperties = FileUtils.applicationFileRead();
  }
   

  public void initializeLocatorRead() throws IOException{
	  blcLocatorProperties = FileUtils.locatorFileRead();
  }
  
  public WebElement getElement(String locator) throws IOException {
		WebElement element = null;
		String[] keyValue = null;
		try{
			keyValue = blcLocatorProperties.getProperty(locator).split(Pattern.quote("|"));
		}catch(Exception e)
		{
			System.out.println("Get Property failed due to an error"+e);
		}
		if(keyValue[0].equalsIgnoreCase("id")) {
			element =driver.findElement(By.id(keyValue[1]));
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
			element=driver.findElement(By.className(keyValue[1]));
		}
		else if (keyValue[0].equalsIgnoreCase("XPath"))
		{
			element=driver.findElement(By.xpath(keyValue[1]));
		}
		else if (keyValue[0].equalsIgnoreCase("cssSelector"))
		{
			element = driver.findElement(By.cssSelector(keyValue[1]));
		}
		else
		{
			System.out.println("Please enter a valid locator");
			
		}
			return element;
	}
	
  
    
	public void type(String locator, String text) {
		try {
		WebElement element = getElement(locator);
		element.sendKeys(text);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
    
    
    public void click(String locator)
	{
		try {
			WebElement element = getElement(locator);
			element.click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public void clickonText(String text)
    {
    	WebElement element = driver.findElement(By.linkText(text));
    	element.click();
    }
	public void submit(String locator)
	{
		try {
			WebElement element = getElement(locator);
			element.submit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getAppProperty(String propertyName)
	{
		//String element = BLCAppProperties.getProperty(propertyName);
		String element=null;
		try
		{
			element = blcAppProperties.getProperty(propertyName);			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("This method fails due to an error" + e);
		}
		
		
		return element;
		
	}
	
	
	public String getLocatorProperty(String propertyName) throws IOException
	{
		String element = null;
		try
		{
			element = blcLocatorProperties.getProperty(propertyName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("This method fails due to an error" +e);
		}
		
		return element;
	}
	
	public void selectText(String locator, String text){
		WebElement element = null;		
		try {
			element = getElement(locator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	public void selectIndex(String locator){
		WebElement element = null;		
		try {
			element = getElement(locator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select = new Select(element);
		select.selectByIndex(1);
		
	}
	
	public void webRefresh()
	{
		driver.navigate().refresh();
	}
	
	/*public void waitImplicit()
	{
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}*/
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
	
	public String locatorValue(String locator)
	{
		String[] keyValue = blcLocatorProperties.getProperty(locator).split(Pattern.quote("|"));
		
		return keyValue[0];
	}
	
	public String valueofLocator(String locator)
	{	
		//locator=BLCLocatorProperties.getProperty("login.username");
		
		String[] keyValue = blcLocatorProperties.getProperty(locator).split(Pattern.quote("|"));
		
		
		return keyValue[1];
	}
	
}
