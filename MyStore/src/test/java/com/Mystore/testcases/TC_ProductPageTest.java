package com.Mystore.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
import java.io.IOException;

import com.Mystore.pageobject.AfterPurchasemsg;
import com.Mystore.pageobject.CartPageorder;
import com.Mystore.pageobject.MyStoreLoginPage;
import com.Mystore.pageobject.PlaceOrderPage;
import com.Mystore.pageobject.SearchFinalItem;
import com.Mystore.pageobject.SearchResultPage;
import com.Mystore.pageobject.registereduser;
import com.Mystore.utilities.ReadExcelFile;


//import freemarker.log.Logger;


public class TC_ProductPageTest extends BaseClass {

	@Test(enabled=true,priority=0)
	public void VerifySearchProduct() throws InterruptedException, IOException
	{
		String searchKey = "MacBook air";

		Logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		driver.get(url);
		MyStoreLoginPage pg1 = new MyStoreLoginPage(driver);
//		Thread.sleep(3000);
		pg1.LoginbuttonClick();
		Thread.sleep(3000);
		pg1.Loginusername("kkn25");

		Logger.info("Login username entered");
		Thread.sleep(3000);
		pg1.LoginPassword("abcd");

		Logger.info("Login password entered");

		Thread.sleep(3000);
		pg1.ButtonClick();

		Logger.info("login button clicked");
        Thread.sleep(4000);
		pg1.SearchItem();
		Logger.info("Search Item is clicked");


		Logger.info("***************TestCase Search Product ends*****************"); 


		// Get Name of Searched Product
		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();
		Logger.info("Product name fetched");

		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			
			Assert.assertTrue(true);
			resultPg.ClickLogout();
			Logger.info("Search Product testcase - Passed"); 


		}
		else
		{
			Logger.info("Search Product testcase - Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		Logger.info("***************TestCase Search Product ends*****************"); 

	}




	@Test(enabled = true,priority=1)
	public void VerifyBuyProduct() throws IOException, InterruptedException
	{

		Logger.info("\n***************TestCase Buy Product started*****************"); 

		//String searchKey = "MacBook air";

		//Logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		driver.get(url);
		Thread.sleep(5000);
		MyStoreLoginPage pg1 = new MyStoreLoginPage(driver);
		pg1.LoginbuttonClick();
		Thread.sleep(3000);
		pg1.Loginusername("kkn25");
		Logger.info("Login username entered");
		Thread.sleep(3000);
		pg1.LoginPassword("abcd");
		
		Logger.info("Login password entered");
		Thread.sleep(3000);
		pg1.ButtonClick();
		Thread.sleep(2000);
		pg1.SearchItem();
		Thread.sleep(5000);
		Logger.info("Search Item is clicked");
		
		SearchFinalItem macbook = new SearchFinalItem(driver);
		{
			macbook.getsearchitem();
			Logger.info("Final  search item clicked");
			Thread.sleep(5000);
		}
		
		SearchResultPage resultPg = new SearchResultPage(driver);  // Item added to cart
		resultPg.ClickAddtoCart();
		Logger.info("Click on cart");
		Thread.sleep(3000);

		Actions act = new Actions(driver);

		driver.switchTo().alert().accept();
		Logger.info("alert");
		Thread.sleep(3000);

		resultPg.ClickonCart();
	
		
		CartPageorder pg2 = new CartPageorder(driver);
		pg2.ClickonCartButton();
		Logger.info("clicked order placed  button");


		 PlaceOrderPage pg3 = new  PlaceOrderPage(driver);
		 
		 pg3.AddName("Kartik Nikam");
		 Thread.sleep(1000);
		 pg3.Addcountry("India");
		 Thread.sleep(1000);
		 pg3.Addcity("sangli");
		 Thread.sleep(1000);
		 pg3.Addcard("1234567890");
		 Thread.sleep(1000);
		 pg3.Addmonth("23 March");
		 Thread.sleep(1000);
		 pg3.Addyear("2022");
		 pg3.ClickonPurchase();
         Thread.sleep(1000);
         Logger.info("Registration info inserted");
         
         AfterPurchasemsg pg4 = new AfterPurchasemsg(driver);
         String sucessMsg = pg4.getOrderSucessMessage();

 		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

 		if(sucessMsg.equals("Thank you for your purchase!"))
 		{
 			Logger.info("VerifyBuyProduct - Passed"); 
 			Assert.assertTrue(true);
 		    pg4.OKbuttonClick();

 		}
 		else
 		{
 			Logger.info("VerifyBuyProduct - Failed");
 			captureScreenShot(driver,"VerifyBuyProduct");
 			Assert.assertTrue(false);

 		} 
         Thread.sleep(4000);
         registereduser pg5 = new registereduser(driver);
         pg5.ClickLogout();
         Logger.info("final logout");
         
	}
	
}
