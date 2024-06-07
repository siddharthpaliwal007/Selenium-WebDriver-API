import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proxydemo {

	public static void main(String[] args) throws InterruptedException {

		// Proxy server acts as an intermediary for requests between a client and a server.
		// Used for capture network traffic, Mock back-ends call, Access a website under corporate restrictions.

		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		// proxy.setHttpProxy("localhost:8080");
		proxy.setSslProxy("localhost:8080");

		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.ca/"); 
		Thread.sleep(3000);
		driver.quit();

	}
}
