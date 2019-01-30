package com.techm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;

public class Sample3 {
	
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/");
		
		List<WebElement> list = driver.findElements(By.tagName("li"));
		
		System.out.println(list.size());
		try{
		for(int i=1; i<=list.size();i = i+1)
		{
			System.out.println(list.get(i).getText());
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
