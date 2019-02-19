package TestNGAttributes;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listerners implements ITestListener 
{
	@Test
	public void ListernersDemo() {
		
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" ***Test Started : " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" ***Test Success : " +result.getName());
		System.out.println(result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE);		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" ***Test Failed : " +result.getName());
		System.out.println(result.getStatus() == ITestResult.FAILURE);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" ***Test Skipped : " +result.getName());
		System.out.println(result.getStatus() == ITestResult.SKIP);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" ***Test Completed : " +context.getName());
	}
}
