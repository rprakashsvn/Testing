package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ListAscendingOrder {

	public static WebDriver driver = null;
	public static String URL = "http://seleniumpractise.blogspot.com/";
	public static String stqaToolsURL = "http://demo.stqatools.com/Multiselect.php";

	public static void main(String[] args) throws Exception {
		LaunchBrowser();
		// CheckList();
		// CheckListAscending();
		multiSelectList();
		// CloseBrowser();
	}

	public static void multiSelectList() throws Exception {
		
		WebElement multiSelect = driver.findElement(By.className("date_s"));
		Select selectYear = new Select(multiSelect);
		
		Boolean isMultiSelectYear = selectYear.isMultiple();
		System.out.println(isMultiSelectYear);
		
		selectYear.selectByValue("1986");
		selectYear.selectByValue("1983");
		selectYear.selectByVisibleText("1985");

		Thread.sleep(5000);
		System.out.println("List value is selected");

		selectYear.deselectByValue("1986");
		selectYear.deselectByValue("1983");
		selectYear.deselectByVisibleText("1985");

		WebElement multiSelectNames = driver.findElement(By.className("name_s"));
		Select selectName = new Select(multiSelectNames);
		
		Boolean isMultiSelectName = selectName.isMultiple();
		System.out.println(isMultiSelectName);
		
		selectName.selectByValue("Martina");
		selectName.selectByValue("Jonny Wayne");
		selectName.selectByVisibleText("Gustaf");
		selectName.selectByVisibleText("Jonas");

		Thread.sleep(3000);
		System.out.println("List value is selected");

		selectName.deselectByValue("Martina");
		selectName.deselectByValue("Jonny Wayne");
		selectName.deselectByVisibleText("Gustaf");
		selectName.deselectByVisibleText("Jonas");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void CheckListAscending() {
		// Arraylist collections
		// Capture the elements and stroe in list
		// create one temp list and store all the values now
		// now check whether its asceding order or not

		WebElement listValue = driver.findElement(By.id("tools1"));
		Select select = new Select(listValue);
		java.util.List<WebElement> Value = select.getOptions();

		List actualList = new ArrayList<>();

		for (WebElement webElement : Value) {
			String toolNames = webElement.getText().trim();
			System.out.println(toolNames);
			actualList.add(toolNames);
		}

		System.out.println("Actual List : " + actualList);

		// Now create one temp list and store again all the values in that list
		List tempList = new ArrayList<>();
		tempList.addAll(actualList);

		// Asceding Order
		Collections.sort(tempList);
		System.out.println("Asceding Order : " + tempList);

		// Desceding Order
		Collections.reverse(tempList);
		System.out.println("Desceding Order : " + tempList);

		Assert.assertFalse(actualList.equals(tempList));
		System.out.println("List is not an ascending order... Test Failed");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void CheckList() {
		// Arraylist collections
		// Capture the elements and stroe in list
		// create one temp list and store all the values now
		// now check whether its asceding order or not

		WebElement listValue = driver.findElement(By.id("tools"));
		Select select = new Select(listValue);
		java.util.List<WebElement> Value = select.getOptions();

		List actualList = new ArrayList<>();

		for (WebElement webElement : Value) {
			String toolNames = webElement.getText().trim();
			System.out.println(toolNames);
			actualList.add(toolNames);
		}
		System.out.println("Actual List : " + actualList);

		// Now create one temp list and store again all the values in that list
		List tempList = new ArrayList<>();
		tempList.addAll(actualList);

		// Asceding Order
		Collections.sort(tempList);

		Assert.assertTrue(actualList.equals(tempList));
		System.out.println("List is Ascending Order.. Test Passed");

	}

	public static void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver();
		driver.get(stqaToolsURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void CloseBrowser() {
		driver.quit();
	}

}
