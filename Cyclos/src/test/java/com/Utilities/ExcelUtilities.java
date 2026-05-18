package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities { // Referred

	public static String getCellData(String path, String sheetName, int rowNum, int colNum) throws IOException {

		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		XSSFRow row = sheet.getRow(rowNum);
		
		 String data = "";

		 if(row != null) {

			 XSSFCell cell = row.getCell(colNum);

		        if(cell != null) {

		            data = cell.toString();
		        }
		 }

		workbook.close();

		fis.close();

		return data;
	}

}
