package MavenProjectMarch2022.MavenProjectMarch2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo {
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else {
			
			System.out.println("Wrong browser name = " + browser);
		}
		
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		
		System.out.println("The title name is : " + title);
		
	}

}
