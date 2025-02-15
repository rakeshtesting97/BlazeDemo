package com.blazedemo.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.testbase;

public class destinationpage extends testbase{
	
	
	@FindBy(xpath = "//a[text()='Travel The World']")
	WebElement travelTheWorld;
	
	
	public destinationpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public welcomepage clickonTravelTheWorld() throws IOException
	{
		travelTheWorld.click();
		return new welcomepage();
	}
	

}
