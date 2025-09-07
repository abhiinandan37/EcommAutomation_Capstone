package utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String testData(int rowNum, int colNum) {
		
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelSheet;
		XSSFCell ExcelCell;
		
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\LoginData.xlsx"; 
		String sheetName = "Sheet1";
		String cellData = null;
		
		
			
			
			try {
				FileInputStream ExcelFile;
				ExcelFile = new FileInputStream(path);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelSheet = ExcelWBook.getSheet(sheetName);
				ExcelCell = ExcelSheet.getRow(rowNum).getCell(colNum);
				cellData = ExcelCell.getStringCellValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return cellData;
			
			
	}

}
