package Basics;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackTests {

	public static final String USERNAME = "prakash397";
	public static final String AUTOMATE_KEY = "1L48XRQ5UCRaiQ37XsXF";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		//Test File
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "62.0");
		caps.setCapability("project", "Selenium Project");
		caps.setCapability("build", "Build 1.0");
		caps.setCapability("name", "Google Test");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.timezone", "UTC");
		caps.setCapability("browserstack.selenium_version", "3.5.2");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("BrowserStack");
		element.submit();

		System.out.println(driver.getTitle());
		driver.quit();

	}
}
