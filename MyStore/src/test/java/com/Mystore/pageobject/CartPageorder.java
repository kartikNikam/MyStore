package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageorder {
	WebDriver ldriver;

	public CartPageorder(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}
	
	@FindBy(xpath="//button[@class='btn btn-success']")WebElement CartButton;
	
	public void ClickonCartButton() {
		
		CartButton.click();
	}

	
}
