package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registereduser {

	WebDriver ldriver;

	public registereduser(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}

	// indentify webelements

	@FindBy(xpath="//a[@id='nameofuser']")WebElement userName;
	@FindBy(linkText="Log out")WebElement Logout;

	public String getUserName()
	{
		String text = userName.getText();
		return text;
	}
	
	public void ClickLogout() {
		
		Logout.click();
	}
}
