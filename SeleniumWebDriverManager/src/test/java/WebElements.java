import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// find element
		driver.get("https://www.google.ca/");
		WebElement searchBox = driver.findElement(By.name("q")); // Locate element using its unique properties
		searchBox.sendKeys("Selenium");
		driver.quit();

		// find elements
		driver.get("https://trytestingthis.netlify.app/");
		driver.findElement(By.cssSelector("#fname")).sendKeys("Selenium");

		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]")); // Locate Multiple Elements
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

		// Can also use ID, CSS selectors, XPath in order

		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		WebElement passwordBox = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton));
		passwordBox.sendKeys("ABCD");

		// findElement method accepts a new method with(By) which returns Relative Locator. Example: above, below, toLeftOf, toRightOf, near
		
		// Get active element
		driver.get("https://www.google.ca/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String title = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(title);
		
		// Get tag name,text, CSS, etc. 
		WebElement searchBox2 = driver.findElement(By.name("q"));
		String tagname = searchBox2.getTagName();
		String text = searchBox2.getTagName();
		String cssvalue = searchBox2.getCssValue("font");
		
		System.out.println(tagname); 
		System.out.println(text); 
		System.out.println(cssvalue); 
		
		Thread.sleep(4000);
		driver.quit();
	}
}

