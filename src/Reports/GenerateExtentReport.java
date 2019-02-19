package Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport 
{
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent = new ExtentReports();
	public ExtentTest test;
	public WebDriver driver;

	@BeforeSuite
	public void StartReport() 
	{
		System.out.println("Started to Generate the Extent Report");
		extent.setSystemInfo("OS", "Windows-7");
		extent.setSystemInfo("HostName", "HOME");
		extent.setSystemInfo("Envrionment", "QA Test");
		extent.setSystemInfo("Username", "Prakash Rajaram");
	}

	@BeforeSuite
	public void SetReportStyle() 
	{
		htmlReport = new ExtentHtmlReporter("D:\\Studies\\Selenium\\Reports\\Extent Reports\\GoogleTest.html");
		extent.attachReporter(htmlReport);
		htmlReport.config().setDocumentTitle("Automation Testing Report");
		htmlReport.config().setReportName("Automation Script Status");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setChartVisibilityOnOpen(true);
	}
	
	@Test(enabled = true)
	public void ChromeTest() 
	{
		test=extent.createTest("Google Login Test");
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}
	
	@Test(enabled = true)
	public void ChromeSerach() 
	{
		test=extent.createTest("Google Search Test");
		driver.findElement(By.name("q")).sendKeys("Automation Testing");
		driver.findElement(By.name("btnK")).click();
	}

	@AfterMethod
    public void getResult(ITestResult result)
    {
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case Failed due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

	@AfterSuite
	public void endReport() 
	{
		extent.flush();
		System.out.println("Extent Generated Successfully");
	}
}
