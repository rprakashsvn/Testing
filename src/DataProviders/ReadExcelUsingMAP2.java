package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelUsingMAP2 {

	private String filePath = "D:\\Studies\\Selenium\\TestData\\UserDetails.xlsx";

	@Test(dataProvider = "getData")
	public void integrationTest(Map<Object, Object> map) {
		System.out.print(map.get("FirstName") + " ");
		System.out.print(map.get("FathersName") + " ");
		System.out.println();
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();

		// Row Count
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("Total No Of Rows : " + lastRowNum);

		// Column Count
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("Total No Of Cols : " + lastCellNum);

		Object[][] obj = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {

			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {

				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
			}

			obj[i][0] = datamap;
		}
		return obj;
	}

}