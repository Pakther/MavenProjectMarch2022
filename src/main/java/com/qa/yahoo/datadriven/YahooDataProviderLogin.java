package com.qa.yahoo.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooDataProviderLogin  {
	
	WebDriver driver;
	
	
	public Object[][] getData(String excelPath, String sheetName){
		
	
		YahooReadExcel excel = new YahooReadExcel(excelPath, sheetName);
		
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
	
	
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData(){
		
		String excelPath = "./src/main/java/com/qa/yahoo/datadriven/YahooLogin.xlsx";
		String sheetName = "loginData";
		
		Object data[][]= getData(excelPath, sheetName);
		
		return data;
			

}
	
	
	public void yahooLoginTest(String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.yahoo.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	
	}
	
	
	
	
}