package Vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcellSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
	    // step 1: load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
		// step 2: creare a workbook for the file loaded
		 Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: navigate to the required sheet
	     Sheet sh = wb.getSheet("Organizations");
	     
	    // step 4: navigate to the required row
	     Row rw = sh.getRow(1);
	     
	     // step 5 : navigate to the required cell
	     Cell ce = rw.getCell(2);
	     
	     // step 6 :Captured the value inside the cell
	     String value = ce.getStringCellValue();
	     System.out.println(value);	     
	}
}
