package com.qa.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.etsy.com/");
		
		driver.manage().window().maximize();
		
		By searchEtsy = By.id("global-enhancements-search-query");
		WebElement searchPanel = driver.findElement(By.id("global-enhancements-search-query"));

		
		
		
		searchEtsy(searchEtsy, 2).sendKeys("Blue");
		
		
		
		
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.contextClick(searchPanel).perform();
		
		
		Thread.sleep(2000);
		action.clickAndHold(searchPanel).perform();
		action.moveToElement(searchPanel);
		
		
		
	
		driver.quit();
		
	}
	
	public static WebElement searchEtsy(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	
	
}
