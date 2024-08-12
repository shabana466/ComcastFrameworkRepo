package com.comfast.crm.contacttest;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.com.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comfast.crm.generic.fileutility.ExcelUtility;
import com.comfast.crm.generic.fileutility.FileUtility;
import com.comfast.crm.generic.fileutility.JavaUtility;
import com.comfast.crm.generic.fileutility.WebDriverUtility;
import com.comfast.crm.generic.webdriverutility.UtilityClassObject;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		// read data testcript fromexcel file
		UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
	    // navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();
		// click on "create contact"Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to  create contact page and click on contact link");
		ContactPage contP = new ContactPage(driver);
		contP.getCreateNewContactBtn().click();
		// enter all details
		UtilityClassObject.getTest().log(Status.INFO,"create new contact");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		
		cncp.createContact(lastName);
		UtilityClassObject.getTest().log(Status.INFO,"========created new contact========== ");
          //verify headerMsg 
		UtilityClassObject.getTest().log(Status.INFO,"=====validate contact in headermsg=======");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actHeader = cip.getHeaderMsg().getText();
		boolean status=actHeader.contains(lastName);
		Assert.assertEquals(status,true);
		System.out.println("CreateContactTest passed");

		// verify Header lastname Expected Result
		
	/*	String actLastName = cip.getHeaderMsg().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName,lastName);
		soft.assertAll();*/

		

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {

		// read data testcript fromexcel file
		String lastName = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		// Navigate to contact module
		HomePage hp1 = new HomePage(driver);
		hp1.getContactlnk().click();
		// click on "create contact"Button
		ContactPage contP = new ContactPage(driver);
		contP.getCreateNewContactBtn().click();
		// enter all details
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);

		String startDate = jlib.getSystemDateYYYYDDMM();
		String endData = jlib.getRequiredDateYYYYDDMM(30);
		cncp.getStartDataTxt().clear();
		cncp.getStartDataTxt().sendKeys(startDate);
		cncp.getEndDataTxt().clear();
		cncp.getEndDataTxt().sendKeys(endData);
		cncp.getSavaBtn().click();

		// Validate actual data and end date
		String actstartDate = cncp.getActStartDate().getText();
		boolean status=actstartDate.contains(startDate);
		Assert.assertEquals(status,true);
		System.out.println("createContactWithSupportDate,actstartDate passed");
		

		
		String actendDate = cncp.getActEndDate().getText();
		boolean status1=actstartDate.contains(endData);
		Assert.assertEquals(status1,false);
		System.out.println("createContactWithSupportDate,actstartDate passed");
	
		
		

	}
	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// read data testcript fromexcel file
		String orgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String LastName = elib.getDataFromExcel("contact", 7, 3);
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
		
	
		

		// Navigate to contact module
		HomePage hp1 = new HomePage(driver);
		hp1.getContactlnk().click();
		// click on "create contact"Button
		ContactPage contP = new ContactPage(driver);
		contP.getCreateNewContactBtn().click();
		// enter all details
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastNameEdt().sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		// switch to child window
		wlib.switchToTabOnUrl(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wlib.switchToTabOnUrl(driver, "Contacts&action");

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		// verify Header lastname and org name  Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.getHeaderMsg().getText();
		boolean status1=actLastName.contains(LastName);
		Assert.assertEquals(status1,true);
		System.out.println("LastName is verified ===pass");
        Assert.assertEquals(status,true);
		System.out.println("createContactWithOrgTest is passed");
		

	

	}

}
