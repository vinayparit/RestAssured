package Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public String readDataFromExcelFile(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		return value;
	}

	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();

		return rowCount;
	}

	public void writeToExcelFile(String sheetName, int row, int cell, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		wb.write(fout);
		wb.close();

	}

	public HashMap<String, String> readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet(sheetName);
		int lastRowCount = sheet.getLastRowNum();
		int lastCellCount = sheet.getRow(0).getLastCellNum();

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i <= lastRowCount; i++) {

			for (int j = 1; j <= lastCellCount; j++) {
				String key = sheet.getRow(i).getCell(j - 1).getStringCellValue();
				String value = sheet.getRow(i).getCell(j++).getStringCellValue();

				map.put(key, value);
			}
		}
		return map;

	}

	public Object[][] readMultipleDataProvider(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RestAssuredData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet(sheetName);
		int lastRowCount = sheet.getLastRowNum() + 1;
		int lastCellCount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowCount][lastCellCount];

		for (int i = 0; i < lastRowCount; i++) {

			for (int j = 0; j < lastCellCount; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return obj;

	}

}
