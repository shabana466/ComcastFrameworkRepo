package codingstardards;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.com.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 */

public class SearchContactTest extends BaseClass{
	/**
	 * 
	 */
	@Test
	public void searchcontactTest() {
		/*step1 login to app*/
	WebDriver driver = null;
	LoginPage ip=new LoginPage(driver);
	ip.LoginToApp(null, null, null);
		
	}
	

}
