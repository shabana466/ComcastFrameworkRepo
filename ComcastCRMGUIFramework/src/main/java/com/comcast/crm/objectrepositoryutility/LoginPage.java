package com.comcast.crm.objectrepositoryutility;
/**
 * @author shaik shabana 
* contains LoginPage element & business libraries
 */
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comfast.crm.generic.fileutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	//Rule1 create a separate java class
	WebDriver driver;
	public LoginPage(WebDriver driver) {
	       this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Rule2 object creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//Rule=3 object initialization
	
	//rule4;object  Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to applictaion based username,password,url
	 * @param url
	 * @param username
	 * @param password
	 */
	//rule5 provide action
	public void LoginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	

}
