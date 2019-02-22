package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class AuthenticationLoginTests {

	WebDriver driver = null;

	@Test(enabled = true)
	public void FirefoxLogin() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Studies\\Selenium\\Drivers\\Geckodriver_V0.23.0.exe");
		driver = new FirefoxDriver();
		driver.get("http://members.mscgva.ch/manuals/container_shipping/glossary_t.html");
		Runtime.getRuntime().exec("C:\\Users\\RJP\\Desktop\\Firefox_Authenitications_Login.exe");
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void IELogin() throws Exception {
		System.setProperty("webdriver.ie.driver", "D:\\Studies\\Selenium\\Drivers\\IEDriverServer_V3.14.0.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://members.mscgva.ch/manuals/container_shipping/glossary_t.html");
		Runtime.getRuntime().exec("C:\\Users\\RJP\\Desktop\\IE_Authenitications_Login.exe");
		driver.manage().window().maximize();
	}
}
