package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {

    @DataProvider(name = "addNew", parallel = true)

    public Object[][] validData() throws IOException {

        return getExcelData(
                "src/test/resources/testData/ExcelData.xlsx",
                "AddFeature_sriram_k");
    }


    @DataProvider(name = "validVoucher", parallel = true)

    public Object[][] validVoucher() throws IOException {

        return getExcelData(
                "src/test/resources/testData/ExcelData.xlsx",
                "valid_vovucher");
    }


    private Object[][] getExcelData(String file, String sheet) {

        String[][] data = null;

        try {

            FileInputStream files =
                    new FileInputStream(file);

            XSSFWorkbook work =
                    new XSSFWorkbook(files);

            XSSFSheet sheets =
                    work.getSheet(sheet);

            XSSFRow row =
                    sheets.getRow(0);

            int noOfRows =
                    sheets.getPhysicalNumberOfRows();

            int noOfCols =
                    row.getLastCellNum();

            data =
                    new String[noOfRows - 1][noOfCols];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < noOfRows; i++) {

                row = sheets.getRow(i);

                for (int j = 0; j < noOfCols; j++) {

                    Cell cell = row.getCell(j);

                    data[i - 1][j] =
                            formatter.formatCellValue(cell);
                }
            }

            work.close();

            files.close();

        } catch (Exception e) {

            System.out.println(
                    "The exception is : "
                            + e.getMessage());
        }

        return data;
    }
}