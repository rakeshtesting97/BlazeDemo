package com.blazedemo.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.testbase;
import com.blazedemo.pages.destinationpage;
import com.blazedemo.pages.flightsListPage;
import com.blazedemo.pages.welcomepage;
import com.blazedemo.pages.yourFlightPage;

public class yourFlightPageTest extends testbase{
	welcomepage welpage;
	destinationpage despage;
	flightsListPage flipage;
	yourFlightPage youpage;
	Select sel;
	
	public yourFlightPageTest()
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
		         buttonToClick = buttonElements.get(i); // Store the button associated with the lowest price
		     }
		 }
		 if (buttonToClick != null) {
			  buttonToClick.click();
		     System.out.println("Clicked the button with the lowest price: " + lowestPrice);
		 } 
	}
	
	@Test
	public void totalCostformatTest()
	{
		youpage=new yourFlightPage();
		WebElement totalCostElement = youpage.getTotalCost();

		if (totalCostElement != null) {
		    String totalCostText = totalCostElement.getText().trim();
		    String pricePattern = "^(\\d{1,3})(\\.\\d{2})$";
		    
		    if (totalCostText.matches(pricePattern)) {
		        System.out.println("Valid Total Cost: " + totalCostText);
		    } else {
		        System.out.println("Total Cost is not in the correct format.");
		    }
		} else {
		    System.out.println("Total Cost field not found.");
		}
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
