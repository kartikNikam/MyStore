package com.Mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	WebDriver ldriver;

	public PlaceOrderPage(WebDriver rdriver) // constructor remote driver
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this); // searchcontex ,pageobject-this
		
		
	}
	@FindBy(xpath="//input[@id='name']")WebElement name;
	@FindBy(xpath="//input[@id='country']")WebElement Country;
	@FindBy(xpath="//input[@id='city']")WebElement city;
	@FindBy(xpath="//input[@id='card']")WebElement Creditcard;
	@FindBy(xpath="//input[@id='month']")WebElement month;
	@FindBy(xpath="//input[@id='year']")WebElement year;
	@FindBy(xpath="//button[contains(text(),'Purchase')]")WebElement purchasebutton;
	

	
	public void AddName(String Name) {
		name.sendKeys(Name);
	}
	public void Addcountry(String country) {
		Country.sendKeys(country);
	}
	public void Addcity(String City) {
		city.sendKeys(City);
	}
	public void Addcard(String Card) {
		Creditcard.sendKeys(Card);
	}
	public void Addmonth(String Month) {
		month.sendKeys(Month);
	}
	public void Addyear(String Year) {
		year.sendKeys(Year);
	}
	public void ClickonPurchase() {
		purchasebutton.click();
	}
	
	
	
	
	
	
	
}
