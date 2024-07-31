import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Implicit Wait - Useful when there is some gap in loading time of the web page and web elements.
		// An implicit wait makes WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		driver.get("https://www.google.ca/");

		// Explicit wait - Useful when there you need to wait until some condition is met.
		// Makes WebDriver to wait until a certain condition is true.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("Selenium");

		// Fluent wait - Similar to Explicit wait , i.e. wait for a certain duration until a condition is met.
		// Differences - a.) Polling Frequency - can change as per need, b.) Ignore Exceptions - If element is not found use it as "NoSuchElement"
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

		Thread.sleep(2000);
		driver.quit();
	}

}
