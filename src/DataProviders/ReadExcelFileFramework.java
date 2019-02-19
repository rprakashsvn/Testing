package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelFileFramework {

	public WebDriver driver;
	public static String FilePath = "D:\\Studies\\Selenium\\TestData\\UserDetails.xlsx";
	public static String[][] XLData = null;

	@Test(dataProvider = "LoginData", enabled = false)
	public void loginData(String number, String name, String fathersName) {
		System.out.println(number + " " + name + " " + fathersName);
	}

	@Test(dataProvider = "Sheet1")
	public void Sheet1(String name, String pass) {
		System.setProperty("webdriver.chrome.driver", "D:\\Studies\\Selenium\\Drivers\\Chromedriver_V2.44.exe");
		driver = new ChromeDriver();
		System.out.println(name + " " + name);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("pass")).sendKeys(pass);
	}

	@DataProvider
	public String[][] LoginData() throws Exception {
		String[][] data = ReadExcelFileFramework.readExcel(FilePath, "LoginDetails");
		return data;
	}

	@DataProvider
	public String[][] Sheet1() throws Exception {
		String[][] data = ReadExcelFileFramework.readExcel(FilePath, "Sheet1");
		return data;
	}

	@SuppressWarnings("resource")
	public static String[][] readExcel(String excelFilePath, String SheetName) throws Exception {
		File loadFile = new File(excelFilePath);
		FileInputStream readFile = new FileInputStream(loadFile);
		String fileName = loadFile.getName();
		System.out.println("Loaded File Name Is : " + fileName);
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(readFile);
			XSSFSheet sheet = workBook.getSheet(SheetName);

			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);

			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println(columnCount);

			XLData = new String[rowCount][columnCount];
			int startRowIndex = 1;
			int startColIndex = 0;
			for (int i = startRowIndex; i < rowCount + 1; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = startColIndex; j < columnCount; j++) {
					if (row == null) {
						XLData[i][j] = "";
					} else {
						XSSFCell cell = row.getCell(j);
						if (cell == null) {
							XLData[i][j] = "";
						} else {
							DataFormatter formatData = new DataFormatter();
							String cellValue = formatData.formatCellValue(cell);
							XLData[i - 1][j] = cellValue;
							System.out.println(XLData[i - 1][j]);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		readFile.close();
		return XLData;
	}
}