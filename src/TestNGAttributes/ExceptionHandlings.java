package TestNGAttributes;

import org.testng.annotations.Test;

public class ExceptionHandlings {

	@Test
	public void Exceptions() {

		// Exception handling unexpexcted error during the excution
		// if any of the case is failed, it will contionue the remaining program

		try {
			System.out.println("Exception Handling Demo");
			int i = 10, result;
			result = i / 0; // Here Exception Occured
			System.out.println(result);
			//throw new ArithmeticException("unable to divide by zero");
		} catch (Exception e) {
			System.out.println("getLocalizedMessage Is : " + e.getLocalizedMessage());
			System.out.println("getMessage Is : " + e.getMessage());
			System.out.println("getCause Is : " + e.getCause());
			System.out.println("getClass : " + e.getClass());
			System.out.println("getStackTrace Is : " + e.getStackTrace());
			System.out.println("getSuppressed Is : " + e.getSuppressed());
		} finally {
			System.out.println("It will excuted always");
		}
	}
}
