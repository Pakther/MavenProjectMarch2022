package com.qa.actionclassdemo;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyFaceBookLogo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	
	@Test(priority = 1)
	public void logoDisplayTest() {
		
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Facebook']")).isDisplayed());
		
		
		
	}
	
	@Test(priority = 1)
	public void messageDisplayTest() {
		
		
		String expected = "Facebook - log in or sign up";

		String actual = driver.getTitle();

		
			
		assertEquals(actual, expected, "Wrong message displayed");
		
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
