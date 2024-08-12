package com.comcast.com.baseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comfast.crm.generic.fileutility.DataBaseUtility;
import com.comfast.crm.generic.fileutility.ExcelUtility;
import com.comfast.crm.generic.fileutility.FileUtility;
import com.comfast.crm.generic.fileutility.JavaUtility;
import com.comfast.crm.generic.fileutility.WebDriverUtility;
import com.comfast.crm.generic.webdriverutility.UtilityClassObject;

public class BaseClass {
	public DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility  elib=new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;//lisner purpose
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("======Connect Db ,Report Config============");
		dbLib.getDbconnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//parallel
	//public void configBC(String browser) throws Throwable {
	public void configBC() throws Throwable {
		System.out.println("=======Lunch the Browser============");
		//String BROWSER=browser;
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("=======login==========");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("=======logout=========");
		HomePage hp=new HomePage(driver);
		hp.logout(wlib);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("======close the browser======");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("=========closeDB, Report backup===========");
		dbLib.closeDbconnection();
		
	}
}
