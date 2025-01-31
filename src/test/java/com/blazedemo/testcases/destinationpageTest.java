package com.blazedemo.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.testbase;
import com.blazedemo.pages.destinationpage;
import com.blazedemo.pages.welcomepage;

public class destinationpageTest extends testbase{
	
	welcomepage welpage;
	destinationpage despage;
	
	public destinationpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		welpage=new welcomepage(); 
		despage=welpage.clickonDestinationLink();
	}
	
	@Test
	public void validateURL() throws IOException
	{
		
		String currenturl=driver.getCurrentUrl();
		
		if(currenturl.contains("vacation"))
		{
			System.out.println("In URL Vacation string is present");
		}else
		{
			System.out.println("In URL Vacation string is not present");
		}
		
		welpage=despage.clickonTravelTheWorld();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
