
package Vtiger.Organizations.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcellFileUitility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrgWithIndustry extends BaseClass{
	
   ExcellFileUitility eUtil = new ExcellFileUitility();
   JavaUtilities jUtil = new JavaUtilities();
   PropertyFileUtility pUtil = new PropertyFileUtility();
   WebDriverUtility wUtil = new WebDriverUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRY) throws Throwable
	{
		
	   
	   /* Read Data from Excel sheet - Test data */
	   String ORGNAME = ORG + jUtil.getRandomNumber();

	  // Step 5: Click on Organizations Link
	  HomePage hp = new HomePage(driver);
      hp.clickOnOrgLink();

      // Step 6: click on Create Organization look up image
      OrganizationPage op = new OrganizationPage(driver);
      op.clickOnCreateOrgLookUpImg();

      // Step 6: create Organization
      CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
      cnop.createOrganization(ORGNAME, INDUSTRY);

      // Step 8: Validate
      OrganizationInfoPage oip = new OrganizationInfoPage(driver);
      String OrgHeader = oip.getHeaderText();
      Assert.assertTrue(OrgHeader.contains(ORGNAME));
      System.out.println(OrgHeader);
  }
	  
	 @DataProvider
	 public Object[][] getdata() throws Throwable, IOException
	 {
		 return eUtil.readMultipleData("MultipleOrg");
	 }

}
