package Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDateIntoExcellSheet {
public static void main(String[] args) throws Throwable, IOException {
		
	    // step 1: load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
		// step 2: creare a workbook for the file loaded
		 Workbook wb = WorkbookFactory.create(fis);
		 
		// step 3: create the sheet
		Sheet sh = wb.createSheet("Trial");
		
		// step 4: create row
		Row rw = sh.createRow(4);
		
		// step 5: create cell
		 Cell ce = rw.createCell(3);
		 
		 //step 6: set the value into the cell
		 ce.setCellValue("Spider Man");
		 
		 //step 7: open the file in java write format
		 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 
		 //step 8: call the write method
		 wb.write(fos);
		 
		 //step 9: close the work book
		 wb.close();
		 System.out.println("workbook closed");		
   }
}
