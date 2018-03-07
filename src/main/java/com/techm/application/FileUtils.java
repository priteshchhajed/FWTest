package com.techm.application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	public static String getPreoprty(String key) {
		return null;
	}
	
	
	public static Properties locatorFileRead() throws IOException
	{
		File file = new File("C:/Users/PC00467497/workspace/TestBLCMaven/src/test/resources/Locators.properties");
		
		FileInputStream fileInput = null;
		
		Properties blcLocatorProperties = new Properties();
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found with an error"+e);
		}
		
		try
		{
			blcLocatorProperties.load(fileInput);
			//System.out.println("Locator File is Loaded successfully");
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("File is not uploaded due to an error"+e);
		}
		
		
		return blcLocatorProperties;
		
	}
	
	
	public static Properties applicationFileRead()
	{
		File file = new File("C:/Users/PC00467497/workspace/TestBLCMaven/src/test/resources/application.properties");
		
		FileInputStream fileInput = null;
		
		Properties blcAppProperties =  new Properties();
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found with an error"+e);
		}
		
		try {
			blcAppProperties.load(fileInput);
			//System.out.println("Application File is Loaded successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not uploaded due to an error"+e);
		}
		
	
		return blcAppProperties;
		
	}
	
	public static void main(String[] args) {
		System.out.println(applicationFileRead().getProperty("application.url"));
	}
	
}
