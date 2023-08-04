package Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * this clss consists of all the generic methods of java
 * @author Suman R
 *
 */
public class JavaUtilities {
	
	/**
	 * this method will generate random for every exicution
	 * @return Random value
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
	    int ran = r.nextInt(1000);
	    return ran;		
	}	
	/**
	 * this method will return the system date
	 * @return
	 */
	public String getSystemDate() 
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * this method will return the system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":","-");
	    String dateInformat = currentDate+"_"+month+"_"+year+"_"+time;
	    return dateInformat;
	}
}
