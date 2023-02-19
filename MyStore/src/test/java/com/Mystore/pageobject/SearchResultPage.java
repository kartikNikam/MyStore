package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
	}

	@FindBy(xpath="//*[text()='MacBook air']")WebElement searchResultProduct ;
	@FindBy(xpath="//*[contains(text(),'Add to cart')]")WebElement AddtoCart ;

	@FindBy(linkText="Log out")WebElement Logout1;
	
	@FindBy(xpath="//a[@id='cartur']")WebElement Cart;


	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}

	public void ClickAddtoCart()
	{
		
		AddtoCart.click();
		
	}
	public void ClickLogout() {

		Logout1.click();
	}
	
	public void ClickonCart() {
		
		Cart.click();
	}



}
