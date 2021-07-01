package com.fl.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fl.qa.base.TestBase;

public class ExcelUtility extends TestBase{

	
	public static Map<String, String> getMap() throws IOException {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			FileInputStream fileInput = new FileInputStream("C:\\Users\\George Mathew\\Desktop\\excel\\TestData1.xlsx");
			
			Workbook workbook = new XSSFWorkbook(fileInput);
			Sheet sheet = workbook.getSheet("Sheet1");
			
			
			for(int i=0;i<3;i++) {
				data.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(1).getCell(i).toString());
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return data;
	}
	
	
	
}
