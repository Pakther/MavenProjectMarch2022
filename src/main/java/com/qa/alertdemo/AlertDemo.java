package com.qa.alertdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		
		
		
		@Test
		public void getPopUpMessage() {
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String popUpMessage	= alert.getText();
		
		System.out.println(popUpMessage);
		
	//	alert.accept();
		
	//	alert.dismiss();
		
		
		}
		
		@Test
		public void verifyPopUpMessage() {
		
		String expectMessage = "Hello , share this practice page and share your knowledge";
		String actualMessage = driver.findElement(By.id("alertbtn")).getAttribute(expectMessage);		
		Assert.assertEquals(actualMessage, expectMessage, "The message is displayed correctly");

		
		}
		
		@AfterMethod
		public void tearDown(){
			
			driver.quit();
			
		}
		

}
