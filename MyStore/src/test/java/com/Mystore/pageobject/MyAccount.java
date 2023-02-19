package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	//1. create object of webdriver
	
		WebDriver ldriver;
		
		public MyAccount(WebDriver rdriver) // constructor remote driver
		{
			ldriver = rdriver;
			
			PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
		}
		
		// indentify webelements
	
	@FindBy(id="sign-username")WebElement username;
	@FindBy(id="sign-password")WebElement password;
	@FindBy(xpath="//button[text()='Sign up']")WebElement button;
	
	public void Name(String Name) {
		username.sendKeys(Name);
	}
		
	public void Password(String pass) {
		password.sendKeys(pass);
	}
	
	public void ButtonClick()  {
		button.click();
	//	ldriver.switchTo().alert().accept();
	
	}

}
