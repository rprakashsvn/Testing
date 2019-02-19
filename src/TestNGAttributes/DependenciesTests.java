package TestNGAttributes;

import org.testng.annotations.Test;

public class DependenciesTests {

	@Test(dependsOnMethods = { "Test2", "Test3" })
	public void Test1() {
		System.out.println("Test1");
	}

	@Test
	public void Test2() {
		System.out.println("Test2");
	}

	@Test
	public void Test3() {
		System.out.println("Test3");
	}

	@Test
	public void Test4() {
		System.out.println("Test4");
	}

	@Test
	public void Test5() {
		System.out.println("Test5");
	}
}
