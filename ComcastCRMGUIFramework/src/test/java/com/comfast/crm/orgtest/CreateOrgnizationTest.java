package com.comfast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(com.comfast.crm.listenerutinity.ListImpClass.class)
public class CreateOrgnizationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrgnizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// read data testcript fromexcel file
		String orgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// click on "create org"Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// enter all details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		Thread.sleep(2000);

		// verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status,true);
		System.out.println("CreateOrganization Test passed");

		
		
	}

	@Test(groups = "regressionTest")
	public void createOrgaanisationWithIndustriesTest() throws EncryptedDocumentException, IOException {

		// read data testcript fromexcel file
		String orgName = elib.getDataFromExcel("Org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("Org", 4, 3);
		String type = elib.getDataFromExcel("Org", 4, 4);

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// click on "create org"Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// Enter all the details and create new organisation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type, wlib);

		// verify THE INDUSTIES AND TYPE INFO
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustry = oip.getActIndustries().getText();
		boolean status=actIndustry.contains(industry);
		Assert.assertEquals(status,true);
		System.out.println("industry is verified===== passed");
		
		// verify Header TYPE info Expectedresult
		String actType1 = oip.getActType().getText();
		boolean status1=actType1.contains(type);
		Assert.assertEquals(status1,true);
		System.out.println("type is verified===== passed");
		System.out.println("createOrgaanisationWithIndustriesTest =======passed");
		
		

	}
	
	@Test(groups = "regressionTest")
	public void createOrgaanisationWithPhoneTest() throws EncryptedDocumentException, IOException {
		// read data testcript fromexcel file
		String orgName = elib.getDataFromExcel("Org", 7, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("Org", 7, 3);
		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// click on "create org"Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// Enter all the details and create new organisation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNumber);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status,true);
		System.out.println("CreateOrganization is created");
		
		// verify Header phoneNumber info Expectedresult
		String actphoneNumber = oip.getHeadermsgphone().getText();
		boolean status1=actphoneNumber.contains(phoneNumber);
		Assert.assertEquals(status1,true);
		System.out.println("phoneNumber is verified===== passed");
		System.out.println("createOrgaanisationWithPhoneTest======passed");

		

	}

}
