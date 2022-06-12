package com.qa.ddtesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookDDT {
	
	WebDriver driver;
	

	@BeforeTest
	public void FBLoginPage() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		
	}
	@Test(dataProvider = "FacebookData")
	public void FBLoginUser(String username, String password) throws InterruptedException {
		
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);

	driver.findElement(By.xpath("//button[@id='u_0_d_0F']")).click();
	
	
	Thread.sleep(5000);
	System.out.println(driver.getTitle());
	
	
	
	driver.quit();
		
	}
	
	
	
	
	@DataProvider(name = "FacebookData")
	public Object[][] passData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0]="Primaakther11@yahoo.com";
		data[0][1]="password123";
		
		data[1][0]="jannatul.ferdous.ssj@gmail.com";
		data[1][1]="msultan123";
		
		data[0][2]="pakther2211@gmail.com";
		data[2][1]="userjk123";
		return data;
		


		
	}

}
