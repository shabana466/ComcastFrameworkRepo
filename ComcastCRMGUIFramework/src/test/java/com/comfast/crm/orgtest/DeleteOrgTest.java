package com.comfast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.com.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comfast.crm.generic.fileutility.ExcelUtility;
import com.comfast.crm.generic.fileutility.FileUtility;
import com.comfast.crm.generic.fileutility.JavaUtility;
import com.comfast.crm.generic.fileutility.WebDriverUtility;

public class DeleteOrgTest extends BaseClass{
	@Test
	public void dDeleteOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
							 
								//read data testcript fromexcel file
								String orgName=elib.getDataFromExcel("Org",10,2)+jlib.getRandomNumber();
								//System.out.println(orgName);
								
						
						//navigate to organization module 
						HomePage hp=new HomePage(driver);
						hp.getOrgLink().click();
					    //click on "create org"Button
						OrganizationsPage cnp=new OrganizationsPage(driver);
						cnp.getCreateNewOrgBtn().click();
						//enter all details and create new organization
					CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
					cnop.createOrg(orgName);
					Thread.sleep(2000);
					
						//verify Header msg Expected Result
					OrganizationInfoPage oip=new OrganizationInfoPage(driver);
					String actOrgName = oip.getHeaderMsg().getText();
					
						 	
						 if(actOrgName.contains(orgName)) {
							 System.out.println(orgName+"is verified ===pass");
						 }
						 else
						 {
							 System.out.println(orgName+"is not verified ===fail");
						 }
						//go back to organization module 
							// hp=new HomePage(driver);
							hp.getOrgLink().click();
							//search for Organisation in ORG PAGE
							
							cnp.getSerchEdt().sendKeys(orgName);
							wlib.handleDropDown("Organization Name",cnp.getSerchDD());
							cnp.getSearchBtn().click();
							//in dynamic webTABLE SELECT AND DELET
							driver.findElement(By.xpath("(//a[text()='"+orgName+"'])[2]/../../td[8]/a[text()='del']")).click();
						 
						 wlib.switchtoAlertAndCancel(driver);
						 
					

		}
	}

