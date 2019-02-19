package Utility;

import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class SetPropertyFiles 
{
	String filePath = "D:\\Studies\\Selenium\\New.properties";
	
	@Test
	public void SetPropertyValues() throws Exception {
		
		System.out.println(System.getProperty("user.dir"));
		FileOutputStream outputFile = new FileOutputStream(filePath);
		Properties setProp = new Properties();
		setProp.setProperty("result", "Pass");
		setProp.store(outputFile, "Stored Successfully");
		setProp.setProperty("result", "Fail");
		setProp.store(outputFile, "Stored Successfully");
		System.out.println("File writted successfully");
	}
}
