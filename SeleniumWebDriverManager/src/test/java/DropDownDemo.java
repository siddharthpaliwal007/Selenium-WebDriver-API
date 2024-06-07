import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://trytestingthis.netlify.app/");
		WebElement selectElement = driver.findElement(By.id("owc"));
		Select selectObject = new Select(selectElement);		// Select an option for m the drop down list. 
		
		Thread.sleep(1000);
		selectObject.selectByIndex(1);
		Thread.sleep(1000);
		selectObject.selectByValue("option 2");
		Thread.sleep(1000);
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(1000);
		selectObject.deselectByVisibleText("Option 3");			// Deselect an option from the drop down 
		driver.close();
		
		List<WebElement> allAvailableOptions = selectObject.getOptions();    // Store drop down options in a list
		// List<WebElement> allOptions = driver.findElements(By.id("option"));
		
		for(WebElement option : allAvailableOptions) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("option 2"))
			option.click();
		}	
		
		driver.quit();
	}
}