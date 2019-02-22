package Basics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	@Test
	public void Test1() {
		System.out.println("Test1");
	}

	@Test
	public void Test2() {
		System.out.println("Test2");
		Assert.assertEquals(13, 13);
		System.out.println("Failed");
	}

	@Test
	public void Test3() {
		System.out.println("Test3");
		SoftAssert asserts = new SoftAssert();
		asserts.assertTrue(false);
		asserts.assertAll();
	}

	@Test
	public void Test4() {
		System.out.println("Test4");
		Assert.assertEquals(13, 13);
		System.out.println("Passed");
	}
}
