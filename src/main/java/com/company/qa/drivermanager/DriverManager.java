package com.company.qa.drivermanager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	static WebDriver driver;
	@Parameters({"browser", "url"})
	@BeforeTest
	public void setUp(String browserName, String url){
	
	
	
	System.out.println("Browser name is : " + browserName);

	if (browserName.equalsIgnoreCase("Chrome")) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(url);

	} else if (browserName.equalsIgnoreCase("firefox")) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		driver.get(url);

	} else if (browserName.equalsIgnoreCase("Edge")) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get(url);

	} else if (browserName.equalsIgnoreCase("safari")) {

		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();

		driver.get(url);

	} else {

		System.out.println("Wrong Browser selected");
	}

	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
	
	
	
	
	public static String getScreenShot() {

		File src = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);

		String path = System.getProperty("user.dir") + "/ScreenShot/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
		
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	

}
