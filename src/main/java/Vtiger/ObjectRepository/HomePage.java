package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}


	public WebElement getSignOutlnk() {
		return SignOutLnk;
	}
	
	//Busuness Library
	/**
	 * this method wii click on the Organization link
	 * 
	 */
	public void clickOnOrgLink()
	{
		OrganizationsLnk.click();
	}
	
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	/**this method will logout the application
	 * @throws Throwable 
	 * 
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, AdministratorImg);
		Thread.sleep(2000);
	    SignOutLnk.click();
		
	}

}
