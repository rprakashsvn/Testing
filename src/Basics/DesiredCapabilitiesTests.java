package Basics;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesTests {

	@SuppressWarnings({ "unused", "deprecation" })
	public void FireFoxCapabilities() {
		System.setProperty("webdriver.gecko.driver", "");
		FirefoxProfile Profile = new FirefoxProfile();
		Profile.setPreference("browser.startup.homepage", "htttp://www.google.com");
		Profile.setAcceptUntrustedCertificates(true);
		Profile.setAssumeUntrustedCertificateIssuer(false);
		WebDriver driver = new FirefoxDriver((Capabilities) Profile);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	public void ChromeCapabilites() {
		System.setProperty("webdriver.chrome.driver", "");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver driver = new ChromeDriver(cap);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	public void IECapabilites() {
		System.setProperty("webdriver.chrome.driver", "");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver driver = new InternetExplorerDriver(cap);
	}

	public static void main(String[] args) {

	}

}
