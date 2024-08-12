package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comfast.crm.generic.fileutility.WebDriverUtility;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savaBtn;
	@FindBy(xpath="//input[@name=\\\"account_name\\\"]/following-sibling::img")
	private WebElement orgbutn;
	@FindBy(name="support_start_date")
	private WebElement startDataTxt;
	@FindBy (name="support_end_date")
	private WebElement endDataTxt;
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actStartDate;
	@FindBy(id="mouseArea_Support End Date")
	private WebElement actEndDate;
	
	
	public WebElement getActStartDate() {
		return actStartDate;
	}
	
	public WebElement getActEndDate() {
		return actEndDate;
	}
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getSavaBtn() {
		return savaBtn;
	}
	
	
	public WebElement getStartDataTxt() {
		return startDataTxt;
	}
	public WebElement getEndDataTxt() {
		return endDataTxt;
	}
	
	public WebElement getOrgbutn() {
		return orgbutn;
	}
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		savaBtn.click();
	}
	
	
	
	
	

}
