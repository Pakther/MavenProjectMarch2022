package com.company.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.qa.drivermanager.DriverManager;

public class EbayTest extends DriverManager {
	
	
WebDriver driver;
	
	

	
	@Test
	public void ebayTitle() {
		
	String actualTitle = driver.getTitle();
		
	String expectedTitle = "ebay.com";

	
	System.out.println("Page title is " + actualTitle);
	
	Assert.assertEquals(actualTitle, expectedTitle, "Incorrect title");
	
	System.out.println("The title of this page is:  " + actualTitle);
	
	}

	
	

}
