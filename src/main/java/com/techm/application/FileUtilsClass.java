package com.techm.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtilsClass {
	
	public static Properties applicationFileRead()
	{
		
		File file = new File("C:/Users/PC00467497/Broadnet/workspace/TestFiberWeb/src/main/resources/application.properties");
		
		FileInputStream fileInput = null;
		
		Properties FWAppProperties = new Properties();
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not found" +e);
		}
		
		try {
			FWAppProperties.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not loaded properly" +e);
		}
		
		
		return FWAppProperties;
	}
	
	public static Properties locatorFileRead()
	{
		File file = new File("C:/Users/PC00467497/Broadnet/workspace/TestFiberWeb/src/main/resources/locator.properties");
		
		FileInputStream fileInput = null;
		
		Properties FWLocatorProperties = new Properties();
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not found" +e);
		}
		
		try {
			FWLocatorProperties.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not loaded properly" +e);
		}
		
		return FWLocatorProperties;
	}
	
}
