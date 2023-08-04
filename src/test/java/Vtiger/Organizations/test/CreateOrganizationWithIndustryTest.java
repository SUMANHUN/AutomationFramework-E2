package Vtiger.Organizations.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcellFileUitility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass{

	    @Test
	    public void  createOrganizationWithIndustryTest() throws Throwable {
	    	
		
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eUtil.getDataFromExcel("Organizations",4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organizations", 4, 3);
		
		//Step 5: Click on Organizations Link
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrgLink();
				
		//Step 6: click on Create Organization look up image
	    OrganizationPage op = new OrganizationPage(driver);
	    op.clickOnCreateOrgLookUpImg();
	  
		//Step 6: create Organization
	    CreateNewOrganizationPage Cno = new CreateNewOrganizationPage(driver);
	    Cno.createOrganization(ORGNAME, INDUSTRY);
				
		//Step 8: Validate
	    OrganizationInfoPage Oip = new OrganizationInfoPage(driver);
	    String OrgHeader = Oip.getHeaderText();
	    Assert.assertTrue(OrgHeader.contains(ORGNAME));
	    System.out.println(OrgHeader);
     	
	}
}
