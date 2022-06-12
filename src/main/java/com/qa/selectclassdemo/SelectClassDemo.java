package com.qa.selectclassdemo;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassDemo {
	
		static WebDriver driver;
		
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		
		
		//Implicit wait example would declare wait time for the whole program
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		By urlInsert = By.id("Form_submitForm_subdomain");
		By fullName = By.id("Form_submitForm_Name");
		By contactNum = By.id("Form_submitForm_Contact");
		By emailInsert = By.id("Form_submitForm_Email");
		By countries = By.id("Form_submitForm_Country");
		
		
		free30DayTrail(urlInsert, 3).sendKeys("pakther.com");
		free30DayTrail(fullName, 3).sendKeys("Prima Akther");
		free30DayTrail(emailInsert, 3).sendKeys("Pakther2211@gmail.com");
		free30DayTrail(contactNum, 3).sendKeys("939-234-0987");
		free30DayTrail(countries, 3).click();
		
		
		
		
		//SELECT CLASS EXAMPLE
		
		Thread.sleep(3000);

		Select drpCountry = new Select (driver.findElement(By.id("Form_submitForm_Country")));
		drpCountry.selectByVisibleText("Turkey");
		drpCountry.selectByVisibleText("Bangladesh");
		
		
		//Get all options
		List<WebElement> dd = (List<WebElement>) drpCountry.getOptions();
		
		// Get the length
		
		System.out.println(dd.size());
		
		//Loop to print one by one
		for (int i = 0; i < dd.size(); i ++) {
			System.out.println(dd.get(i).getText());
		}
				
				
				
		
	}
	
	
	public static WebElement free30DayTrail(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		
	}

}
