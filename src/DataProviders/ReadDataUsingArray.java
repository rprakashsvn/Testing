package DataProviders;

import org.testng.annotations.DataProvider;

public class ReadDataUsingArray
{
	@DataProvider(name = "LoginDetails")
	public static Object[][] passDataUsingArray() {
		Object[][] inputData = new Object[2][2];

		inputData[0][0] = "rprakashsvn@gmail.com";
		inputData[0][1] = "prakash@1992";
		inputData[1][0] = "rprakashrajaram@gmail.com";
		inputData[1][1] = "prakash@1992";

		return inputData;
	}
}
