package com.lenskart.utility;

import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {
	
	public Object[][] getExcelData(String fileName, String sheetName) {

		Object[][] data = null;
		Workbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			
			if(fileExtensionName.equals(".xlsx"))
				wb = new XSSFWorkbook(fis);
			else if(fileExtensionName.equals(".xls")){		       
				wb = new HSSFWorkbook(fis);
		    } 
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(0);
			int noOfRows = sh.getPhysicalNumberOfRows();
			System.out.println(noOfRows-1);
			int noOfCols = row.getLastCellNum();
			data = new Object[noOfRows - 1][noOfCols];
			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					DataFormatter df=new DataFormatter();
					data[i - 1][j] = df.formatCellValue(sh.getRow(i).getCell(j)); //1
					System.out.println(data[i - 1][j]);
														
				}
			}
		}

		catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		
		return data;
	}

		
	
}

