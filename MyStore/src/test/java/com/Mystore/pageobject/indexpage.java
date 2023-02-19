package com.Mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexpage {
	//1. create object of webdriver
	
	WebDriver ldriver;
	
	public indexpage(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}
	
	// indentify webelements
	
        // By signin = By.id("nav-link-accountList");
	
	@FindBy(id="signin2")WebElement signup;

           
	// identify action on webelement
	
	
	
	public void Signupclick() {
		signup.click();
		
	}
           
}
 