package MavenProjectMarch2022.MavenProjectMarch2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenDemo {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/primaakther/Documents/workspace2022/SeleniumWebDriverDemo/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		
		
	}

}
