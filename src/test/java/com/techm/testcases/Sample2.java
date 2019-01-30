package com.techm.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;


public class Sample2 {

	//public static void main(String[] args)
	@Test
	public void dateTest()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date1 = dateFormat.format(today);
		System.out.println(date1);
	}
}
