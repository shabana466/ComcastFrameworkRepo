package practicea_Assert_homeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePage_Report1 {
	@Test
	public void homePageTest(Method mtd) {
		
		Reporter.log(mtd.getName() +" Test Start ");

		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
	    Reporter.log("step-4",true);
	    Reporter.log(mtd.getName() +" Test End ");
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName() +" Test Start ");
		
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);


		Reporter.log("step-3",true);
		
		Reporter.log(mtd.getName() +" Test End ");

	}

}
