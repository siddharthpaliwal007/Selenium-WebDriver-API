import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserActions {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// open webpage
		driver.get("https://www.google.ca/"); // Opens a web page
		Thread.sleep(1000);
		// store window handle
		String originalWindow = driver.getWindowHandle();

		driver.navigate().to("https://automationstepbystep.com/"); // Navigate to a web page after opening
		// get url
		System.out.println(driver.getCurrentUrl()); // Get current URL
		// get title
		System.out.println(driver.getTitle()); // Get Title
		// back forward refresh
		driver.navigate().back(); // Go back
		Thread.sleep(1000);
		driver.navigate().forward(); // Go forward
		Thread.sleep(1000);
		driver.navigate().refresh(); // Refresh page

		// open and switch to new window or tab
		driver.switchTo().newWindow(WindowType.WINDOW); // Opens new window and switch to the window.
		driver.get("https://automationstepbystep.com/");
		driver.switchTo().newWindow(WindowType.TAB); // Opens new tab and switch to the tab.
		Thread.sleep(2000);
		driver.switchTo().window(originalWindow); // Switch to the new window which is defined above line 29

		// frames
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.switchTo().frame("frm1"); // Finding iframe tag using id or name
		Thread.sleep(1000);
		driver.findElement(By.linkText("Dropdown")).click(); // Finding element inside the frame
		driver.switchTo().defaultContent(); // return to top level window

		// size
		int width = driver.manage().window().getSize().width; // Get width and height
		int height = driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);

		Dimension size = driver.manage().window().getSize(); // Store Dimensions to query later use
		System.out.println(size.getWidth());
		System.out.println(size.getHeight());
		driver.manage().window().setSize(new Dimension(800, 600)); // Set window size

		// position
		System.out.println(driver.manage().window().getPosition().getX()); // Access x and y dimensions individually
		System.out.println(driver.manage().window().getPosition().getY());
		Point position = driver.manage().window().getPosition(); // Store dimensions to query later
		System.out.println(position.getX());
		System.out.println(position.getY());
		driver.manage().window().setPosition(new Point(500, 100));
		driver.manage().window().setPosition(new Point(0, 0)); // Move the window to the top left of the primary monitor
		Thread.sleep(3000);

		// maximise(), minimize(), fullscreen()
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Take screenshot
		FileUtils.copyFile(scrFile, new File("./image1.png"));

		WebElement element = driver.findElement(By.cssSelector(".lnXdpd")); // Take element screenshot
		File scrFile2 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("./image2.png"));

		JavascriptExecutor js = (JavascriptExecutor) driver; // Creating the JavaScript Executor interface object by
																// Type Casting
		WebElement button = driver.findElement(By.name("btnI")); // Return value from script
		js.executeScript("arguments[0].click();", button); // JavaScript to click element
		js.executeScript("console.log('Hello World')"); // execute JS directly. Console can be seen on web browser

		Thread.sleep(3000);

		driver.quit(); // driver.close() only closes current window or tab but driver.quit() closes all the sessions.
	}

}
