package com.qa.actionclassdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class moveToElementDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//navigate to Url
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		// Store variable into a web element
		WebElement motors = driver.findElement(By.className("hl-cat-nav__js-tab"));
		WebElement boats = driver.findElement(By.xpath("//a[contains(text(),'Boats')]"));
		
		//initialize the actions class
		Actions action = new Actions(driver);
		
		//actions method
		action.moveToElement(motors).perform();


		boats.click();
		
		driver.quit();
		
		
		
		
		
		
		
	}

}
