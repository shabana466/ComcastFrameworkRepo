package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;
	@FindBy(name="search_text")
	private WebElement serchEdt;
	@FindBy(id="bas_searchfield")
	private WebElement serchDD;
	@FindBy(name="submit")
	private WebElement SearchBtn;
	

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	

	public WebElement getSerchEdt() {
		return serchEdt;
	}

	public WebElement getSerchDD() {
		return serchDD;
	}



	public WebElement getSearchBtn() {
		return SearchBtn;
	}



	
	
	

	
	
		
	}


