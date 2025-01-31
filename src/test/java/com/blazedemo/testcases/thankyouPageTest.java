package com.blazedemo.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.testbase;
import com.blazedemo.pages.destinationpage;
import com.blazedemo.pages.flightsListPage;
import com.blazedemo.pages.thankyouPage;
import com.blazedemo.pages.welcomepage;
import com.blazedemo.pages.yourFlightPage;

public class thankyouPageTest extends testbase{
	
	welcomepage welpage;
	destinationpage despage;
	flightsListPage flipage;
	yourFlightPage youpage;
	thankyouPage thapage;
	Select sel;
	
	public thankyouPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		welpage=new welcomepage(); 
		WebElement dep=welpage.selectDeparture();
		sel=new Select(dep);
		sel.selectByVisibleText("Mexico City");
		WebElement des=welpage.selectDestination();
		sel=new Select(des);
		sel.selectByVisibleText("London");
		flipage=welpage.clickonFindPlaneButton();
		
		 List<WebElement> priceElements = driver.findElements(By.xpath("//input[@class='btn btn-small']//following::td[5]"));
		 List<WebElement> buttonElements = driver.findElements(By.xpath("//input[@class='btn btn-small']"));

		 double lowestPrice = Double.MAX_VALUE;
		 WebElement buttonToClick = null;

		 for (int i = 0; i < priceElements.size(); i++) {
		     String priceText = priceElements.get(i).getText().replace("$", "").trim();
		     double price = Double.parseDouble(priceText);

		     if (price < lowestPrice) {
		         lowestPrice = price;
		         buttonToClick = buttonElements.get(i); 
		     }
		 }
		 if (buttonToClick != null) {
			  buttonToClick.click();
		 } 
		 
		 youpage=new yourFlightPage();
		thapage=youpage.clickonPurchaseFlightButton();
		
	}
	
	@Test
	public void printid()
	{
		String bookingid=thapage.getid();
		System.out.println(bookingid);
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
