package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of generic method releted to Excell file
 * @author suman
 *
 */
public class ExcellFileUitility {
	
private static final WorkbookFactory WorkBookFactory = null;

/**
 * this method will read dat from excell sheet based of sheet name,row name
 * and cell no given by caller
 * @param sheetName
 * @param rowNo
 * @param celNo
 * @param data
 * @return 
 * @throws Throwable 
 */

	public String getDataFromExcel(String sheetName, int RowNo, int celNo) throws Throwable
	{
	
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetName).getRow(RowNo).getCell(celNo).getStringCellValue();
		 wb.close();
		 return value;
	}
	
/**
 * this method return data in excell sheet
 * @param sheetName
 * @param rowNo
 * @param celNo
 * @param data
 * @throws Throwable 
 */
	public void writeDataFromExcel(String sheetName, int RowNo, int celNo,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.ExcelFilePath);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.createSheet(sheetName);
	    Row rw = sh.createRow(RowNo);
	   Cell cl = rw.createCell(celNo);
	   cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.ExcelFilePath);
		wb.write(fos);
		wb.close();				
	}
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstants.ExcelFilePath);
	    Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
	    int lastcel = sh.getRow(0).getLastCellNum();
		
	    Object[][] data = new Object[lastRow][lastcel];
	    
	   
	    for(int i=0; i<lastRow; i++)
	    {
	    	for(int j=0; j<lastcel; j++)
	    	{
	    		data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
	    	}
	    }
	    
	    return data;
	
	}
	

}
