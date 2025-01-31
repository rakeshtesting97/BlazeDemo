package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.testbase;

public class thankyouPage extends testbase{
	
	
	@FindBy(xpath = "//td[text()='Id']//following-sibling::td")
	WebElement id;

	public thankyouPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getid()
	{
		String bookingid=id.getText();
		return bookingid;
	}

}
