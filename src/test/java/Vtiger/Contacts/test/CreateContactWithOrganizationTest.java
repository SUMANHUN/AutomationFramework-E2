package Vtiger.Contacts.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.ContactInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

@Listeners(Vtiger.GenericUtilities.ListenerImplimentationClass.class)

public class CreateContactWithOrganizationTest extends BaseClass {
	

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws Throwable {
		
		/*Create Organization 
		
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eUtil.getDataFromExcel("Contacts", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);

		// Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 6: click on Create Organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		// Step 6: create Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME);

		
		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		/* Create Contact using Organization */

		// step 9: click on contacts link
		hp.clickOnContactsLink();

		// Step 10: Navigate to create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// step 10: Create a contact with mandatory information
	    CreateNewContactPage cncp = new CreateNewContactPage(driver);
	    cncp.CreateContact(driver, LASTNAME, ORGNAME);
	    
		// Step 15: Validate for Organization
	    ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
		
		System.out.println("hai");
	}
}


