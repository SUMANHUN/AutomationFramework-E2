package Vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addToCart(String Name , int Price , String Modle)
	{
		
	  System.out.println("Phone Name Is "+Name+" Price Is "+Price+" Modle is "+Modle+"");
	
	}
	
	@DataProvider
	public Object[][] getData()
	{    
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Iphone";
		data[0][1] = 30000;
		data[0][2] = "S14";
				
		data[1][0] = "Samsung";
		data[1][1] = 20000;
		data[1][2] = "A80";
		
		data[2][0] = "Oppo";
		data[2][1] = 10000;
		data[2][2] = "F15";
		
		return data;
	
	}

}
