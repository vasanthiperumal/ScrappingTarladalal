package com.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;

	FileInputStream Fis;
	FileOutputStream Fos;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row r;
	Cell c;

	 public ExcelReader(String path) { this.path = path; } 

	public int getrowcount(String Sheetname) throws IOException {
		Fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(Fis);
		sheet = workbook.getSheet(Sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		Fis.close();
		return rowcount;
	}

	public int getcellcount(String Sheetname, int rownum) throws IOException {
		Fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(Fis);
		sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		Fis.close();
		return cellcount;

	}

	public String setcelldata(String sheetname, int rownum, int cellnum, String data) throws IOException 
	{

		
		
		Fis= new FileInputStream(path);
		 workbook = new XSSFWorkbook(Fis);
		 //workbook = new XSSFWorkbook();
		 if(workbook.getSheetIndex(sheetname)==-1)
		  
		   workbook.createSheet(sheetname); 
		  
		  sheet=workbook.getSheet(sheetname);
		  //rownum=0;
		  
		  if(sheet.getRow(rownum)==null)
		  
		  sheet.createRow(rownum);
		  
		  sheet.getRow(rownum).createCell(cellnum).setCellValue(data);
		  
			
			/*
			 * r = sheet.getRow(rownum); c = r.createCell(cellnum); c.setCellValue(data);
			 */
			 
		  
		  Fos = new FileOutputStream(path);
		  workbook.write(Fos); 
		  workbook.close(); 
		 Fis.close();
		  Fos.close(); 
		  
		  return data;
		  
		  
		 
		/*
		 * //Fis= new FileInputStream(path); workbook = new XSSFWorkbook();
		 * sheet=workbook.createSheet(sheetname); sheet = workbook.getSheet(sheetname);
		 * if(sheet.getRow(rownum)==null) sheet.createRow(rownum); r =
		 * sheet.getRow(rownum); c = r.createCell(cellnum); c.setCellValue(data);
		 * FileOutputStream fo = new
		 * FileOutputStream(".\\datafiles\\HyperTension.xlsx"); workbook.write(fo);
		 * workbook.close(); //file.close(); fo.close(); return data;
		 */

	}
}