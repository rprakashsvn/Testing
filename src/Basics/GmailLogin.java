package Basics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Reports.GenerateExtentReport;

public class GmailLogin extends GenerateExtentReport
{
	public WebDriver driver = null;
	Properties propFile = new Properties();

	@BeforeMethod
	public void InitBrowser() throws Exception 
	{
		// Load Properties Files
		FileInputStream configFile = new FileInputStream("D:\\Studies\\Selenium\\AppConfigs.properties");
		FileInputStream LocatorsFile = new FileInputStream("D:\\Studies\\Selenium\\Locators.properties");
		propFile.load(configFile);
		propFile.load(LocatorsFile);
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propFile.getProperty("URL"));
		System.out.println("Chrome Browser Launched Successfully");
	}
	
	@DataProvider(name = "LoginDetails")
	public Object[][] passDataUsingArray() 
	{
		Object[][] inputData = new Object[1][2];
		inputData[0][0] = "rprakashsvn@gmail.com";
		inputData[0][1] = "prakash@1992";
		/*inputData[1][0] = "rprakashrajaram@gmail.com";
		inputData[1][1] = "prakash@1992";*/

		return inputData;
	}

	@Test(dataProvider = "LoginDetails", enabled = true)
	public void gmailLogin(String username, String password) throws Exception 
	{
		Actions action = new Actions(driver);
		driver.findElement(By.id("identifierId")).sendKeys(username);
		WebElement moveNext1 = driver.findElement(By.xpath("(//div[@class='ZFr60d CeoRYc'])[1]"));
		action.moveToElement(moveNext1).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		WebElement moveNext2 = driver.findElement(By.xpath("(//div[@class='ZFr60d CeoRYc'])[1]"));
		action.moveToElement(moveNext2).click().build().perform();
		System.out.println("Gmail Logged In Successfully");
	}

	@Test(dataProvider = "LoginDetails", enabled = true)
	public void Login(String username, String password) throws Exception 
	{
		Actions action = new Actions(driver);
		driver.findElement(By.id(propFile.getProperty("username.id"))).sendKeys(username);
		WebElement moveNext1 = driver.findElement(By.xpath(propFile.getProperty("nextButton.xpath")));
		action.moveToElement(moveNext1).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(propFile.getProperty("password.xpath"))).sendKeys(password);
		WebElement moveNext2 = driver.findElement(By.xpath(propFile.getProperty("nextButton.xpath")));
		action.moveToElement(moveNext2).click().build().perform();
		System.out.println("Gmail Logged In Successfully");
	}
}
