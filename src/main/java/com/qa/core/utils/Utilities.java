package com.qa.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME_WAIT_TIME = 5;

	public static String getDateString() {
		Date d = new Date();
		return d.toString().replace(" ", "-").replace(":", "-");
	}

	public static String getEmailwithDate() {
		Date d = new Date();
		String date = "" + (d.getMonth() + 1) + d.getDate() + d.getYear() + d.getHours() + d.getMinutes()
				+ d.getSeconds();
		return "mdasifazhar" + date + "@gmail.com";
	}

	public static Object[][] getDataFromExcelSheet(String sheetName) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\auto\\testdata\\TestData.xlsx"));
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - 1;
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row != null) {
				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = Integer.toString((int) cell.getNumericCellValue());
						break;
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;
					}
				}
			}

		}
		return data;
	}

}
