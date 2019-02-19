package TestNGAttributes;

import org.testng.annotations.Test;

@Test(groups = { "AllGroupTests" })
public class GroupTests {

	@Test(groups = { "Smoke" })
	public void Test1() {
		System.out.println("Smoke Test1");
	}

	@Test(groups = { "Smoke" })
	public void Test2() {
		System.out.println("Smoke Test2");
	}

	@Test(groups = { "Sanity" })
	public void Test3() {
		System.out.println("Sanity Test3");
	}

	@Test(groups = { "Sanity" })
	public void Test4() {
		System.out.println("Sanity Test4");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void Test5() {
		System.out.println("Smoke Sanity Test5");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void Test6() {
		System.out.println("Smoke Sanity Test6");
	}

	@Test(groups = { "Regression" })
	public void Test7() {
		System.out.println("Regression Test7");
	}
}
