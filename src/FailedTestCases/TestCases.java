package FailedTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = Tranformer.class)
public class TestCases {
	@Test
	public void test1() {
		System.out.println("Test 1 (4)");
	}

	@Test
	public void test2() {
		System.out.println("Test 2 (3)");
	}

	@Test //(retryAnalyzer = FailedTestCases.RetryAnalyzer.class)
	public void test3() {
		Assert.assertTrue(false);
		System.out.println("Test 3 (2)");
	}

	@Test
	public void test4() {
		System.out.println("Test 4 (1) ");
	}

	@Test
	public void test6() {
		System.out.println("Test 6 (0) ");
	}
}
