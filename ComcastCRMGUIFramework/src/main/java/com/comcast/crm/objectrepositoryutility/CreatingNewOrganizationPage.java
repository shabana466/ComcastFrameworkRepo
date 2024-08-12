package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comfast.crm.generic.fileutility.JavaUtility;
import com.comfast.crm.generic.fileutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savaBtn;
	@FindBy(name="industry")
	private WebElement industryDB;
	@FindBy(name="accounttype")
	private WebElement typeDB;
	@FindBy(id="phone")
	private WebElement phoneTxt;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSavaBtn() {
		return savaBtn;
	}
	public WebElement getIndustryDB() {
		return industryDB;
	}
	public WebElement getTypeDB() {
		return typeDB;
	}
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}
	public JavaUtility getJlib() {
		return jlib;
	}
	JavaUtility jlib= new JavaUtility();
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		savaBtn.click();
	}
	//public void createOrg(String orgName,String industry) {
		//orgNameEdt.sendKeys(orgName);
		//Select sel=new Select(industryDB);
		//sel.selectByVisibleText(industry);
		//savaBtn.click();
		
	//}
	public void createOrg(String orgName,String Energy,String Press,WebDriverUtility wlib) {
		orgNameEdt.sendKeys(orgName);
		wlib.handleDropDown(Energy, industryDB);
		wlib.handleDropDown(Press, typeDB);
		savaBtn.click();
		
	}
	public void createOrg(String orgName,String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phoneTxt.sendKeys(phoneNumber);
		savaBtn.click();
		
		
	}
	
	 

}
