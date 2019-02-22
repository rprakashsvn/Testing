package Basics;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTests {

	static Logger log = Logger.getLogger(Log4jTests.class);

	@Test
	public void Test1() {
		System.out.println("Test1 Started ");
		log.debug("This is debug Message");
	}

	@Test
	public void Test2() {
		System.out.println("Test2 Started");
		log.error("This is Error Message");
	}

	@Test
	public void Test3() {
		System.out.println("Test3 Started");
		log.fatal("This is Fatel Message");
	}

	@Test
	public void Test4() {
		System.out.println("Test4 Started");
		log.info("This is Info Message");
	}

	@Test
	public void Test5() {
		System.out.println("Test5 Started");
		log.trace("This is Trace Message");
	}

	@Test
	public void Test6() {
		System.out.println("Test5 Started");
		log.warn("This is Warn Message");
	}
}
