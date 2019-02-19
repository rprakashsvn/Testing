package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Reports.GenerateExtentReport;

public class Helper extends GenerateExtentReport {

	public static WebDriver driver = null;
	static Properties propFile = new Properties();

	public static void loadObject() 
	{
		// Load Properties Files
		try 
		{
			FileInputStream configFile = new FileInputStream("D:\\Studies\\Selenium\\AppConfigs.properties");
			FileInputStream LocatorsFile = new FileInputStream("D:\\Studies\\Selenium\\Locators.properties");
			propFile.load(configFile);
			propFile.load(LocatorsFile);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	};

	public static void LaunchBrowser(String BrowserName) 
	{
		WebDriver driver = null;
		System.out.println(propFile.getProperty("Chrome"));
		System.out.println(propFile.getProperty("username.id"));
		// Initialize Browsers
		if (BrowserName.equals(propFile.getProperty("Chrome"))) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome Browser Launched Successfully");
		}

		else if (BrowserName.equals(propFile.getProperty("Firefox"))) 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Studies\\Selenium\\Drivers\\Geckodriver_V0.23.0.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firefox Browser Launched Successfully");
		}

		else if (BrowserName.equals(propFile.getProperty("IE"))) 
		{
			System.setProperty("webdriver.ie.driver", "D:\\Studies\\Selenium\\Drivers\\IEDriverServer_V3.14.0.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println("IE Browser Launched Successfully");
		}
		else
		{
			System.out.println("Browser Name Is Not Matched.! Kindly Check AppCofig Properties File");
		}

		driver.get(propFile.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void CaptureScreenShot(WebDriver driver, String screenShotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Src, new File("D:\\Studies\\Selenium\\Screenshots\\" + screenShotName + ".png"));
	}
	
	public static String captureScreenShotReport(String screenShotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String dest = "D:\\Studies\\Selenium\\Screenshots\\" + screenShotName + ".png";
		File destFile = new File(dest);
		FileUtils.copyFile(srcFile, destFile);
		return dest;
	}

	public static void HighLightElement(WebDriver driver, WebElement ele) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
	}
}
