package Basics;

import org.apache.log4j.Logger;

public class Log4jTests2 {

	static Logger log = Logger.getLogger(Log4jTests2.class);
	public static String name;

	public static void Sample(String value) {
		if (value == null) {
			log.fatal("The value is null");
		} else {
			log.info("Your Name Is : " + value);
		}
	}

	public static void main(String[] args) {

		Log4jTests2.Sample(name);
	}
}
