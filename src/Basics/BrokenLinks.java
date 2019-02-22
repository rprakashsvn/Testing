package Basics;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	/*
	 * Let’s see some of the HTTP status codes. 200 – Valid Link 404 – Link not
	 * found 400 – Bad request 401 – Unauthorized 500 – Internal Error
	 */

	public static WebDriver driver = null;
	public final static int response200 = 200;
	public final static int response201 = 201;
	public final static int response400 = 400;
	public final static int response404 = 404;
	public final static int response500 = 500;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");

		// get all the links by using tag name as <a>
		// Total Links in Site
		List<WebElement> elementLinks = driver.findElements(By.tagName("a"));
		int totalLinks = elementLinks.size();
		System.out.println("Total Links : " + totalLinks);

		for (WebElement element : elementLinks) {

			String URL = element.getAttribute("href");
			System.out.println(URL);
			URL urlLink = new URL(URL);

			HttpURLConnection httpURLConnect = (HttpURLConnection) urlLink.openConnection();
			httpURLConnect.setConnectTimeout(2000);
			httpURLConnect.connect();

			int respCode = httpURLConnect.getResponseCode();
			System.out.println(URL + " : " + respCode + " : " + httpURLConnect.getResponseMessage());
		}
		driver.quit();
	}

}
