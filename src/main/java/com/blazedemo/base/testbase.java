package com.blazedemo.base;

import java.io.File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.blazedemo.utility.testutil;


public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public testbase() {
	try
	{
		prop=new Properties();
		String currentdir=System.getProperty("user.dir");
		
		FileInputStream file=new FileInputStream(currentdir+"\\src\\main\\java\\com\\blazedemo\\config\\config.properties");
		
		prop.load(file);
	}
	catch(Exception e)
	{
	   e.printStackTrace();	
	}
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(browsername.equals("FF"))
		{
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(testutil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testutil.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));
		
	}

}
