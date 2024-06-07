import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SelTest1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1= new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		driver.close();
		driver.quit();
		
		driver1.get("https://www.google.com/");
		driver1.close();
		driver1.quit();
	}
}
