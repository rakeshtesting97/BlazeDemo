package com.blazedemo.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.testbase;

public class welcomepage extends testbase{
	
	
	@FindBy(xpath = "//div[@class='container']//h1")
	WebElement title;
	
	
	@FindBy(xpath = "//a[text()='destination of the week! The Beach!']")
	WebElement destination;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement departureCity;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement destinationCity;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement findPlaneButton;
	
	
	public welcomepage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	

	public String ValidateTitle()
	{
		return title.getText();
	}
	
	public destinationpage clickonDestinationLink() throws IOException
	{
		destination.click();
		return new destinationpage();
	}
	
	public WebElement selectDeparture()
	{
		return departureCity;
	}
	
	public WebElement selectDestination()
	{
		return destinationCity;
	}
	
	public flightsListPage clickonFindPlaneButton()
	{
		findPlaneButton.click();
		return new flightsListPage();
	}


	
	
	

}
