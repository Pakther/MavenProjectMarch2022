package MavenProjectMarch2022.MavenProjectMarch2022;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTotalImages {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
	
		System.out.println("The total number of images : " +images.size());
	
	
		for(int i = 0; i < images.size(); i ++) {
			
			
			String source = images.get(i).getAttribute("src");
			String altText = images.get(i).getAttribute("alt");
			
			System.out.println(source);
			System.out.println(altText);

			
		}
		
		
		
		
		driver.quit();
	
	
	
	}
	


}
