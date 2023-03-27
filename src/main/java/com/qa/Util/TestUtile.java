package com.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.qa.base.TestBase;

public class TestUtile extends TestBase {

public static long PAGE_LOAD_TIME=30;
public static long LOAD_TIME=20;
public static String TestData_Sheet_path="C:\\Users\\LENOVO\\eclipse-workspace\\CrmTesting\\src\\main\\java\\com\\qa\\Testdata\\Testdata.xlsx";
static Workbook book;
static org.apache.poi.ss.usermodel.Sheet sheet;


public void switchToFrame() {
	driver.switchTo().frame("mainpanel");
	}

public static Object[][] getTestData(String sheetname){
	FileInputStream file=null;
	try {
		file=new FileInputStream(TestData_Sheet_path);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book=WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet=book.getSheet(sheetname);
	Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			System.out.println(data[i][k]);
		}
	
		}
	return data;	
}

public static void takeScreenShotAtEndOfTest() throws IOException {
	 File scrfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 String CurrentDir = System.getProperty("user.dir");
	 FileUtils.copyFile(scrfile,new File(CurrentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
	 
}
		
}