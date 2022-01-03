package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	// Get cell value in string format
	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {

			return "";
		}
	}

	// Get number of row in the Test Data sheet
	public int getNoOfRowInSheet() {
		int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
		return rowCount;
	}

	public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
		// creating a new cell in row and setting value to it
		ExcelWSheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		ExcelWBook.write(outputStream);
	}

}
