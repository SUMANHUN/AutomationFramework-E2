package Vtiger.practice;

import Vtiger.GenericUtilities.ExcellFileUitility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
		 JavaUtilities jutil = new JavaUtilities();
		 
		 int value = jutil.getRandomNumber();
		 System.out.println(value);
		 
		 System.out.println(jutil.getSystemDate());
		 
		 System.out.println(jutil.getSystemDateInFormat());
		        
		 PropertyFileUtility putil = new PropertyFileUtility();
		 String value1 = putil.getDataFromPropertyFile("password");
		 System.out.println(value1);
		 
		 ExcellFileUitility eUtil = new ExcellFileUitility();
		 String data = eUtil.getDataFromExcel("Organizations", 1, 2);
		 System.out.println(data);
		 
		 
		 eUtil.writeDataFromExcel("sample", 3, 4, "batman");
		 System.out.println("data added");	
	}
}
