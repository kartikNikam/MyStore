package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterPurchasemsg {
	WebDriver ldriver;

	public AfterPurchasemsg(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}
	
	@FindBy(xpath="//button[text()='OK']")WebElement Okmsg;
	//@FindBy(xpath="//button[text()='OK']")WebElement Okmsg1;
	
	@FindBy(xpath="//*[text()='Thank you for your purchase!']")WebElement Successmsg;
	
	public void OKbuttonClick() {
		
		Okmsg.click();
	}
	
	public String getOrderSucessMessage()
{
		return(Successmsg.getText());
}
}
