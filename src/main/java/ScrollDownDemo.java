import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDownDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement languageBtn = driver.findElement(By.xpath("//*[@id='icp-touch-link-language']"));
		
		

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");		
		languageBtn.click();
		
		
		driver.quit();
		
		
		
		
		//a[@id='icp-touch-link-language']/span[@class='icp-color-base']
	}

}
