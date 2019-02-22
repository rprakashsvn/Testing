package Basics;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxProfile {

	WebDriver driver;

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "");
		FirefoxProfile Profile = new FirefoxProfile();
		Profile.setPreference("browser.startup.homepage", "htttp://www.google.com");
		Profile.setAcceptUntrustedCertificates(true);
		Profile.setAssumeUntrustedCertificateIssuer(false);
		WebDriver driver = new FirefoxDriver((Capabilities) Profile);
	}
}
