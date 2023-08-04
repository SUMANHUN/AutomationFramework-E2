package Vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Vtiger.GenericUtilities.ExcellFileUitility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgwithIndustryUsingDDT_U {
	
	public static void main(String[] args) throws Throwable  {
		
		//create object of rewuired utilities
		JavaUtilities jUtil = new JavaUtilities();
		ExcellFileUitility eUtil = new ExcellFileUitility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver=null;
		
		//Step 1: Read all the necessary data
		
		/* Read data from property File - Common Data */
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eUtil.getDataFromExcel("Organizations",4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organizations", 4, 3);
	
		//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launched");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launched");
		}
		else
		{
			System.out.println("invalid Browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//Step 3: Load the URL
		driver.get(URL);
		
		//Step 4: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: create Organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 6: Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industryDropDown, INDUSTRY);
		
		//Step 7: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 9: Logout of Application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminImg);
		driver.findElement(By.linkText("Sign Out")).click();	
		System.out.println("Logout successfull");		

	}

}
