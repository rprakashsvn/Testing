package Basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitBrowsers {
	static WebDriver driver;

	// static String BrowserName = "Chrome";

	public static void main(String[] args) throws Exception {
		InitBrowsers.LaunchBrowsers("Chrome");
		InitBrowsers.LaunchBrowsers("Firefox");
		InitBrowsers.LaunchBrowsers("IE");
	}

	public static void LaunchBrowsers(String BrowserName) throws IOException {
		if (BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			WebElement GoogleSearch = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
			InitBrowsers.HighLightElement(GoogleSearch);
			InitBrowsers.CaptureScreenShot("Google Search Highlighted");
			System.out.println("Chrome Browser Launched Successfully");
			driver.quit();
		}

		if (BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Studies\\Selenium\\Drivers\\Geckodriver_V0.23.0.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			WebElement GoogleSearch = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
			InitBrowsers.HighLightElement(GoogleSearch);
			InitBrowsers.CaptureScreenShot("Google Search Highlighted");
			InitBrowsers.CaptureScreenShot("Firefox");
			System.out.println("Firefox Browser Launched Successfully");
			driver.quit();
		}

		if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Studies\\Selenium\\Drivers\\IEDriverServer_V3.14.0.exe");
			driver = new InternetExplorerDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			WebElement GoogleSearch = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
			InitBrowsers.HighLightElement(GoogleSearch);
			InitBrowsers.CaptureScreenShot("Google Search Highlighted");
			InitBrowsers.CaptureScreenShot("IE");
			System.out.println("IE Browser Launched Successfully");
			driver.quit();
		}
	}

	public static void CaptureScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Src, new File("D:\\Studies\\Selenium\\Screenshots\\" + fileName + ".png"));
	}

	public static void HighLightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
	}

	public static void ExplicitWaits(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static void FluentWaits(WebElement ele) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(10, TimeUnit.SECONDS);
	}
}