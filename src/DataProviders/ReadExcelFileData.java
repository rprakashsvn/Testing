package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelFileData {

	public static String FilePath = "D:\\Studies\\Selenium\\TestData\\UserDetails.xlsx";
	public static String[][] XLData = null;

	@Test(dataProvider = "getData")
	public void LoginDetails(String Number, String Name, String FatherName) throws Exception {
		System.out.println(Number + " " + Name + " " + FatherName);
	}

	@SuppressWarnings("resource")
	@DataProvider
	public static String[][] readExcel() throws Exception 
	{
		File loadFile = new File(FilePath);
		FileInputStream readFile = new FileInputStream(loadFile);
		String fileName = loadFile.getName();
		System.out.println("Loaded File Name Is : " + fileName);
		try 
		{
			XSSFWorkbook workBook = new XSSFWorkbook(readFile);
			XSSFSheet sheet = workBook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);

			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println(columnCount);

			XLData = new String[rowCount][columnCount];
			int startRowIndex = 1;
			int startColIndex = 0;
			for (int i = startRowIndex; i < rowCount + 1; i++) 
			{
				XSSFRow row = sheet.getRow(i);
				for (int j = startColIndex; j < columnCount; j++) 
				{
					if (row == null) 
					{
						XLData[i][j] = "";
					} 
					else 
					{
						XSSFCell cell = row.getCell(j);
						if (cell == null) 
						{
							XLData[i][j] = "";
						} 
						else 
						{
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