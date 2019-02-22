package Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class HardAssertExample {

	@Test
	public void Test1() {
		System.out.println("Test1 Started ");
	}

	@Test
	public void Test2() {
		System.out.println("Test2 Started");
		Assert.assertTrue(false);
		System.out.println("Failed");
	}

	@Test
	public void Test3() {
		System.out.println("Test3 Started");
		Verify.verify(false);
	}

	@Test
	public void Test4() {
		System.out.println("Test4 Started");
		Assert.assertTrue(true);
		System.out.println("Passed");
	}

	@Test
	public void Test5() {
		System.out.println("Test5 Started");
	}
}
