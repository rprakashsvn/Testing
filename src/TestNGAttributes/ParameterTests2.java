package TestNGAttributes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTests2 {
	WebDriver driver = null;

	@Parameters({ "myName" })
	@Test
	public void LaunchBrowsers(@Optional("Jegadees") String myName) {
		System.out.println("My Name Is : " + myName);
	}
}
