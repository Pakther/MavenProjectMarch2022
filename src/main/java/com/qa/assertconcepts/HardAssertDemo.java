package com.qa.assertconcepts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertDemo {
	
	WebDriver driver;
	
	
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
	public void logoDisplayed() {
		
		Assert.assertTrue(driver.findElement(By.id("divLogin")).isDisplayed());
		
		
		
	}
	
	@Test(priority = 1)
	public void orangeHRMTitleTest() {
		
		
		
	
	//	String expected = "google";
		String expected2 = "OrangeHRM";
		String actual = driver.getTitle();
		
		
		//assertEquals(actual, expected,"Wrong Title");
		assertEquals(actual, expected2, "Correct Title");
		
		
		System.out.println("Page title is " + actual);
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}

}
