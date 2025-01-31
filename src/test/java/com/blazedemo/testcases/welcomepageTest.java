package com.blazedemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.testbase;
import com.blazedemo.pages.welcomepage;

public class welcomepageTest extends testbase{
	
	welcomepage welpage;
	
	public welcomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		welpage=new welcomepage(); 
	}
	
	@Test
	public void welcomepagetitletest()
	{
		String title=welpage.ValidateTitle();
		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!","Title is missing");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
