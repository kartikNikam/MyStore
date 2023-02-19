package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFinalItem {
	WebDriver ldriver;

	public SearchFinalItem(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}
	
	
	@FindBy(xpath="//a[contains(text(),'MacBook air')]")WebElement Searchitem;
	
	public void getsearchitem()
	{
		Searchitem.click();
	}
	
	
}
