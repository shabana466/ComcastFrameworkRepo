package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	@FindBy(id="mouseArea_Industry")
	private WebElement actIndustries;
	@FindBy(id="mouseArea_Type")
	private WebElement actType;
	@FindBy(id="dtlview_Phone")
	private WebElement headermsgphone;
	
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	

	public WebElement getActIndustries() {
		return actIndustries;
	}

	public WebElement getActType() {
		return actType;
	}



	public WebElement getHeadermsgphone() {
		return headermsgphone;
	}
	
	
	
	
	

}
