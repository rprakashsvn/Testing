package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelUsingMAP {

	// Data Provider Using HashMap
	public String filePath = "D:\\Studies\\Selenium\\TestData\\UserDetails.xlsx";

	@Test(dataProvider = "getDataMap")
	public void integrationTest(Map<Object, Object> map) {
		System.out.print(map.get("FirstName") + " ");
		System.out.print(map.get("FathersName") + " ");
		System.out.println();
	}

	@DataProvider
	public Object[][] getDataMap() throws Exception {

		File loadFile = new File(filePath);
		FileInputStream readFile = new FileInputStream(loadFile);
		
		XSSFWorkbook workBook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workBook.getSheetAt(0);
		workBook.close();

		// Row Count
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total No Of Rows : " + rowCount);

		// Column Count
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Total No Of Cols : " + columnCount);
		
		Object[][] XLData = new Object[rowCount][columnCount-1];

		for (int i = 0; i < rowCount; i++) {

			Map<Object, Object> dataMap = new HashMap<>();

			for (int j = 0; j < columnCount; j++) {

				// Key - Value Pairs
				dataMap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
			}
			XLData[i][0] = dataMap;

		}
		return XLData;
	}
}
