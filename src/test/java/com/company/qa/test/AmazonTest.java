package com.company.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.company.constant.Constant;


import com.company.qa.drivermanager.DriverManager;

public class AmazonTest extends DriverManager {
	
	

	
	WebDriver driver;

	
	@Test
	public void amazonTitle() {
		
	String actualTitle = driver.getTitle();
		
	String expectedTitle = "Amazon.com. Spend less. Smile more.";
	
	
	

	System.out.println("Page title is " + actualTitle);
	System.out.println(Constant.PAGE_TITLE_IS + actualTitle);
	
	
	Assert.assertEquals(actualTitle, expectedTitle, "Incorrect title");
	
	System.out.println("The title of this page is:  " + actualTitle);
	
	}

	
	

}
