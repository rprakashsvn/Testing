package TestNGAttributes;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(TestNGAttributes.ListernersTest.class)
public class ListernersTest extends Listerners{

	@Test
	public void Test1() {
		System.out.println("Tested 1 and Its Passed");
	}
	
	@Test
	public void Test2() {
		System.out.println("Tested 2 and Its Passed");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Test3() {
		System.out.println("Tested 3 and Its Passed");
	}
}
