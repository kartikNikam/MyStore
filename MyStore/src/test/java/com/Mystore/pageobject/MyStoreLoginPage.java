package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreLoginPage {

	WebDriver ldriver;
	
	public MyStoreLoginPage(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}
	
	// indentify webelements
	@FindBy(id="login2")WebElement Loginclick;
	@FindBy(id="loginusername")WebElement Loginname;
	@FindBy(id="loginpassword")WebElement Loginpassword;
	@FindBy(xpath="//button[text()='Log in']")WebElement Loginbutton;
	@FindBy(xpath="(//*[@id='itemc'])[2]")WebElement SearchLaptop;
	
	public void LoginbuttonClick() {
		Loginclick.click();
	}
	
	public void Loginusername(String Name) {
		Loginname.sendKeys(Name);
	}
	public void LoginPassword(String Password) {
		Loginpassword.sendKeys(Password);
	}
	
	public void ButtonClick() {
		Loginbutton.click();
	}
	
	public void SearchItem() {
		SearchLaptop.click();
	}
	
	
}
