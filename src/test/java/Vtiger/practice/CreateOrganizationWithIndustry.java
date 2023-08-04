package Vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry {
	public static void main(String[] args) {
		
		//step 1: open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step 2: Load the URL
		driver.get("http://localhost:8888");	
		
		//Step 3: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();	
		
	    //Step 4: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();	
		
		//Step 5: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();	
		
		//Step 6: create Organization
		driver.findElement(By.name("accountname")).sendKeys("L&T");	
		
		//Step 7: Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue("Chemicals");
		
		//Step 8: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		
		//Step 9: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if(OrgHeader.contains("L&T"))
				{
					System.out.println("PASS");
					System.out.println(OrgHeader);
				}
				else
				{
					System.out.println("Fail");
				}			
		//Step 10: Logout of Application				
	    WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));				Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();				
		driver.findElement(By.linkText("Sign Out")).click();
				
		System.out.println("Logout successfull");
				
	}
}
