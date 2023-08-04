package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class consistes of generic methods releted to property file
 * @author suman
 *
 */
public class PropertyFileUtility {
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.PropertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;		
	}
}
