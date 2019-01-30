package com.techm.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.techm.application.BaseWebDriver;
import com.techm.code.FWLogin;

public class Sample {

	WebDriver driver;
	
	
	
	
	
	/*@BeforeTest
	public void initialize()
	{
		baseWebDriver = new BaseWebDriver();
		
		try
		{
			baseWebDriver.initialize();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Initialize method fails due to an error" +e);
		}
	}*/
		
	@Test
	public void sampleScript() throws AWTException, InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver", "C://Users//PC00467497//Downloads//chromedriver_win32//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
		
		driver.get("https://testportal.broadnet.no/wicket/page?8");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("pritesh.chhajed@broadnet.no");
		driver.findElement(By.id("password1")).sendKeys("Broadnet12345");
		driver.findElement(By.xpath("//input[@class='btn-call-to-action']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Admin")).click();
		
		driver.findElement(By.name("searchField")).sendKeys("300171");
		driver.findElement(By.name("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='gear-icon']")).click();
		
		driver.findElement(By.xpath("//i[@class='change-icon']")).click();
		

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Orders/Subscriptions')]")).click();
		
		//ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		//System.out.println("size of the windows open" + windowHandles.size());
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_T);
		rt.keyRelease(KeyEvent.VK_T);
		
		//System.out.println("size of the windows open after Ctrl \t" + windowHandles.size());
		
		driver.get("http://10.15.9.36/telefakt/index.cfm");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.name("Username")).sendKeys("prichh");
		driver.findElement(By.name("Password")).sendKeys("Rockbottom130");
		
		driver.findElement(By.name("Submit")).submit();
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		action.keyUp(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
		//driver.findElement(By.xpath("//span[contains(text(),'Active sub.')]")).click();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().refresh();
		
		driver.findElement(By.name("connid")).sendKeys("28923074");
		//driver.findElement(By.name("submitButton")).click();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@class='gear-icon-col']//div")).click();
		driver.findElement(By.xpath("//td[@class='gear-icon-col']//div//li[6]")).click();
		
		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		action.keyUp(Keys.CONTROL).sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		
		
	}
	
}

