package TestNGAttributes;

import org.testng.annotations.Test;

public class PriorityTests {
	@Test(priority=4)
	public void test1() {
		System.out.println("Test 1 (4)");
	}
	
	@Test(priority=3)
	public void test2() {
		System.out.println("Test 2 (3)");
	}
	
	@Test(priority=2)
	public void test3() {
		System.out.println("Test 3 (2)");
	}
	
	@Test(priority=1)
	public void test4() {
		System.out.println("Test 4 (1) ");
	}
	
	@Test
	public void test6() {
		System.out.println("Test 6 (0) ");
	}
	
	@Test(priority=0)
	public void test5() {
		System.out.println("Test 5 (No Priority) ");
	}
	
	@Test(priority=-1)
	public void test7() {
		System.out.println("Test 7 (-1) ");
	}
	
	@Test(priority=-10)
	public void test8() {
		System.out.println("Test 8 (-10) ");
	}
	
}
