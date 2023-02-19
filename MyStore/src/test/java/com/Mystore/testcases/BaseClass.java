package com.Mystore.testcases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;  // import manually
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.Mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig read = new ReadConfig();
	
	String url  = read.getBaseUrl();
	
	String browser = read.Browser();
	
	public static WebDriver driver;
	
	// create logger class variable
	
	public static Logger Logger;
	
	
@BeforeClass	
	public void setup() {
		
	switch(browser.toLowerCase())
	{
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;

	case "msedge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;

	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	default:
		driver = null;
		break;

	}
		
		//Add waits()
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	// for logging log4j2 property file
	
	Logger = LogManager.getLogger("MyStoreV1");
	driver.get(url);
	Logger.info("url opend");
	
	}

@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
public void captureScreenShot(WebDriver driver,String testName) throws IOException
{
	//step1: convert webdriver object to TakesScreenshot interface
	TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
	//step2: call getScreenshotAs method to create image file
	
	File src = screenshot.getScreenshotAs(OutputType.FILE);
	
	File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + testName + ".png");

	//step3: copy image file to destination
	FileUtils.copyFile(src, dest);
}


}
