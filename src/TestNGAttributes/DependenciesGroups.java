package TestNGAttributes;

import org.testng.annotations.Test;

public class DependenciesGroups {

	@Test(dependsOnGroups = { "Sanitys" })
	public void Test1() {
		System.out.println("Test1");
	}

	@Test(groups = { "Sanitys" })
	public void Test2() {
		System.out.println("Test2");
	}

	@Test
	public void Test3() {
		System.out.println("Test3");
	}

	@Test(groups = { "Sanitys" })
	public void Test4() {
		System.out.println("Test4");
	}

	@Test
	public void Test5() {
		System.out.println("Test5");
	}
}
