package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridConcepts {
	@Test

	public void mailTest() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		cap.setBrowserName("firefox");

		cap.setPlatform(Platform.WINDOWS);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.20.10.3:4444/wd/hub"), cap);

		driver.navigate().to("https://www.google.co.in");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Search me");

		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

		driver.close();

	}
}
