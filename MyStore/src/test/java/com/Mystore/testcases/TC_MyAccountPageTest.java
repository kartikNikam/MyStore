package com.Mystore.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
//import org.apache.logging.log4j.core.util.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.Mystore.pageobject.MyAccount;
import com.Mystore.pageobject.MyStoreLoginPage;
import com.Mystore.pageobject.indexpage;
import com.Mystore.pageobject.registereduser;




public class TC_MyAccountPageTest extends BaseClass {

	@Test(priority=0,enabled=false)
	public void VerifyRegistrationAndLogin() throws InterruptedException  {

		// Open url
//		driver.get(url);
//		Logger.info("url opend");

		indexpage pg = new indexpage(driver);
		pg.Signupclick();
		Logger.info("clicked on signup");

		MyAccount page  = new MyAccount(driver);
		page.Name("kkn16");
		Logger.info("enter username");

		Thread.sleep(5000);
		page.Password("1234");
		//page.ButtonClick();

		Thread.sleep(5000);
		page.ButtonClick();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
        Logger.info("sign up successful");

//
//		MyStoreLoginPage pg1 = new MyStoreLoginPage(driver);
//
//		Thread.sleep(5000);
//		pg1.LoginbuttonClick();
//		Thread.sleep(3000);
//		pg1.Loginusername("kkn15");
//
//		Logger.info("Login username entered");
//
//		pg1.LoginPassword("1234");
//
//		Logger.info("Login password entered");
//
//		Thread.sleep(3000);
//		pg1.ButtonClick();
//
//		Logger.info("login button clicked");
//
//
//
//		registereduser pg2 = new registereduser(driver);
//		Thread.sleep(6000);
//
//		String user	=pg2.getUserName();
//		Assert.assertEquals("Welcome kkn15", user);

	}
	
	@Test(priority=1)
	
	public void VerifyLogin() throws InterruptedException, IOException {
		
		driver.get(url);
		MyStoreLoginPage pg1 = new MyStoreLoginPage(driver);
		Thread.sleep(5000);
		pg1.LoginbuttonClick();
		Thread.sleep(3000);
		pg1.Loginusername("kkn16");

		Logger.info("Login username entered");

		pg1.LoginPassword("1234");

		Logger.info("Login password entered");

		Thread.sleep(3000);
		pg1.ButtonClick();

		Logger.info("login button clicked");
		
		registereduser pg2 = new registereduser(driver);
		Thread.sleep(6000);

		String user	=pg2.getUserName();
		//Assert.assertEquals("Welcome kkn16", user);
		
		Logger.info("validation using assert");
		if(user.equals("Welcome kkn16"))
		{
			Logger.info("User Verified");
			
			Assert.assertTrue(true);
		}
		else
		{   Logger.info("User Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		
		

		
	}
	






}
