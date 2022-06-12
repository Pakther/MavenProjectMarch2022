package com.qa.assertconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo {
	
	WebDriver driver;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test(priority = 1)
	public void orangeHRMTitleTest() {
		
		
		
		softAssert = new SoftAssert();
		
	
	
		String expected2 = "OrangeHRM";
		String actual = driver.getTitle();
		
		softAssert.assertEquals(actual, expected2);
		
		
		
		//System.out.println("Page title is " + actual);
		
		
	}
	
	@Test(priority = 2)
	public void loginPanelText() {
		
		
		String expectedLoginText = "LOGIN Panel";
		String actualLoginText	= driver.findElement(By.id("logInPanelHeading")).getText();
		
		//Soft Assert will allow the program to continue on to the next test case weather or not it passes or fails
	
	
		softAssert.assertEquals(actualLoginText, expectedLoginText, "Incorrect text");
		
		
		
		
	
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}

}
