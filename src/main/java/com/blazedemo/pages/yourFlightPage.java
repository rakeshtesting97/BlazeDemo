package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.testbase;

public class yourFlightPage extends testbase{
	
	@FindBy(xpath = "//p[text()='Total Cost: ']//em")
	WebElement totalCost;
	
	@FindBy(xpath= "//input[@class='btn btn-primary']")
	WebElement purchaseFlightButton;
	
	
	public yourFlightPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTotalCost()
	{
		return totalCost;
	}
	
	public thankyouPage clickonPurchaseFlightButton()
	{
		purchaseFlightButton.click();
		return new thankyouPage();
	}

}
