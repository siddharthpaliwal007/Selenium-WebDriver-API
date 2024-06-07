import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		
		// NORMAL - Waits for the entire page to be loaded. 
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		// EAGER - Waits until the initial HTML document has been completely loaded and parsed. Discards loading stylesheets, images and subframes.   
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		// NONE - When set to none Selenium WebDriver only waits until the initial page is loaded. 
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.ca/"); 
		driver.quit();	
	}
}
