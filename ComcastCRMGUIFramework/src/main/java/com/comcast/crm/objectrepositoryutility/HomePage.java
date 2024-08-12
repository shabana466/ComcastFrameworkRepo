package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comfast.crm.generic.fileutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy (linkText="Contacts")
	private WebElement contactlnk;
	
	@FindBy (linkText="Campaigns")
	private WebElement campaignlink;
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void navigateaTOCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignlink.click();
	}
	


	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public void logout(WebDriverUtility wlib) {
		wlib.mouseHover(driver, adminImg);
		
		signoutlink.click();
	}
	
	 

}
