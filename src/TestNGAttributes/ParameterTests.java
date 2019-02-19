package TestNGAttributes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTests {
	WebDriver driver = null;

	@Parameters({ "BrowserName" })
	@BeforeMethod
	public void LaunchBrowsers(String BrowserName) throws IOException {
		if (BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome Browser Launched Successfully");
		}

		if (BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Studies\\Selenium\\Drivers\\Geckodriver_V0.23.0.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firefox Browser Launched Successfully");
		}

		if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Studies\\Selenium\\Drivers\\IEDriverServer_V3.14.0.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE Browser Launched Successfully");
		}
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Test
	public void GoogleTest() {
		driver.findElement(By.name("q")).sendKeys("Testing");
		WebElement GoogleSearch = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
		GoogleSearch.click();
		System.out.println("Tested Successfully");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
