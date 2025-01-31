package com.blazedemo.utility;

import com.blazedemo.base.testbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class testutil extends testbase{
	
	public testutil()
	{
		super();
	}
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void takeScreenshot() throws IOException
	{
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile, new File(currentdir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	
	

}
