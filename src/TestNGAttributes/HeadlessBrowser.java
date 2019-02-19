package TestNGAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessBrowser {
	
	WebDriver driver = null;
	@Test
	public void HeadLessBrowserTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver(options);
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}
}
