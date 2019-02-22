package Basics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConcepts {

	static WebDriver driver = null;

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) {

		// Implict Wait Syntax
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Explcit Wait Syntax
		WebElement element = null, source = null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeSelected(element));

		// FulentWatis Syntax
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		// Context Click
		Actions action = new Actions(driver);
		action.contextClick(element).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		action.click();

		// Move to element
		action.moveToElement(element).build().perform();

		// Drag and drop
		action.dragAndDrop(source, element).build().perform();

		// click and hold and release
		action.clickAndHold(source).release(element).build().perform();

		// click and hold
		action.clickAndHold();

		// double Click
		action.doubleClick(element).build().perform();

		// move offset
		action.moveByOffset(100, 200).build().perform();

		// Switch To Frame
		driver.switchTo().frame(element);

		// Switch To Parent Frame
		driver.switchTo().parentFrame();

		// Switch To default content
		driver.switchTo().defaultContent();

		// Single window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

		// Single window handle
		Set<String> windowsList = driver.getWindowHandles();
		System.out.println(windowsList);

		// JavaScript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		// Scroll By
		js.executeScript("window.ScrollBy(0,100)");

		// refresh
		js.executeScript("history.go(0)");

		// navigate url
		js.executeScript("window.location ='http://www.google.com'");
		

		driver.close();
		driver.quit();
	}

}
