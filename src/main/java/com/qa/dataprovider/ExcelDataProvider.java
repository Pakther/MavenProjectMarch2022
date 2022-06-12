package com.qa.dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	public Object[][] getData(String excelPath, String sheetName){
		
	
		ReadExcel excel = new ReadExcel(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object [][] data = new Object[rowCount-1][colCount];
		
		for(int i = 1; i <rowCount; i ++) {
			
			for (int j = 0; j<colCount; j ++) {
				
				Object testData = excel.getCellValue(i, j);
				data[i-1][j] = testData;

				System.out.println(data[i-1][j] + " | ");
				
				
			}
			
			System.out.println();
			
			
		}
		
		return data;	
		
		
	}
	
	
	@DataProvider (name="TestData")
	public Object[][] getTestData(){
		
		String excelPath = "./src/main/java/com/qa/dataprovider/Test_Data.xlsx";
		String sheetName = "Sheet1";
		
		Object data[][] = getData(excelPath, sheetName);
		
		return data;
		
	}
	
	
	@DataProvider(name ="LoginTestData")
	public Object[][] getLoginData(){
		
		String excelPath = "./src/main/java/com/qa/dataprovider/Test_Data.xlsx";
		String sheetName = "LoginTestData";
		
		Object data[][]= getData(excelPath, sheetName);
		
		return data;
		
		
	}
	
	@Test(dataProvider = "LoginTestData")
	public void loginTest(String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username.toString());
		driver.findElement(By.id("txtPassword")).sendKeys(password.toString());
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		driver.close();
		driver.quit();
		
	}
	
	
	@Test(dataProvider = "TestData")
	public void testOne(Object firstName, Object lastName, Object age ) {
		
		System.out.println("I am inside test one");
		System.out.println(firstName + " | " + lastName + " | " + age );
		
		
		
	}
	
	public void testTwo() {
		
		System.out.println("I am inside test two ");
		
	}
	

}
