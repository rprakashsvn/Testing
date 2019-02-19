package FailedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	public int minRetryCount = 0;
	public int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (minRetryCount < maxRetryCount) {
			minRetryCount++;
			return true;
		} else {
			return false;
		}
	}
}
