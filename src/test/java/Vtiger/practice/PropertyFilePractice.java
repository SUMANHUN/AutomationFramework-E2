package Vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		// step 1: load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		
		//step 2: create the object  properties class from java.utill
		Properties pobj = new Properties();
		
		//step 3 : load the file into properties class
		pobj.load(fis);
		
		//step 4: provide the key and get value
		String value = pobj.getProperty("url");
		System.out.println(value);
		
	}

}
