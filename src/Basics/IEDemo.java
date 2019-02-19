package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IEDemo {
	WebDriver driver;

	public String URL = "http://iBoxChennai:ibche@members.mscgva.ch/manuals/container_shipping/glossary_t.html";
	public String NewURL = "http://@members.mscgva.ch/manuals/container_shipping/glossary_t.html";

	@SuppressWarnings("deprecation")
	@Test(enabled = true)
	public void IETest() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver", "D:\\Studies\\Selenium\\Drivers\\IEDriverServer_V3.14.0.exe");
		driver = new InternetExplorerDriver(cap);
		driver.get(NewURL);
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void ChromeTest() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver(cap);
		driver.get(NewURL);
		driver.manage().window().maximize();
	}
}
