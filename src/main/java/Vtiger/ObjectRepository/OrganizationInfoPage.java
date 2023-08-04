package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Declaration 
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//initialization 
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//declaration

	public WebElement getOrgHeaderText() 
	{
		return OrgHeaderText;
	}
	
	//business Library
	/**
	 * this method will get the information of page header
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
		
	}
}
