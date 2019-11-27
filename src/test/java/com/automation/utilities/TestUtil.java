package com.automation.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.automation.base.DriverImplementation;

public class TestUtil extends DriverImplementation {

	@DataProvider(name="dp")
	public static Object[][] getData(Method m){
		
		String sheetName= m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object [rows-1][cols];
		
		for (int rownum =2 ; rownum <=rows ;rownum++){
			for (int colnum =0 ;colnum <cols ;colnum++){
				data[rownum-2][colnum] = excel.getCellData(sheetName, colnum, rownum);
			}
		}
		return data;
		
	}
	
}
