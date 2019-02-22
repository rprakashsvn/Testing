package Basics;

public class TestClass {

	public static String name = "Prakash";

	public static void getName(String firstName) {
		if (firstName.equals("Prakash")) {
			System.out.println("First Name : " + firstName);
		} else {
			System.out.println("System Exist Becz Its Not Matched");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		TestClass.getName(name);
	}
}
