package practicea_Assert_homeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSample2 {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() +" Test Start ");
		SoftAssert  assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
	//	Assert.assertEquals("Home","Home-pAGE");
		assertObj.assertEquals("Home","Home-pAGE");
		
		System.out.println("step-3");
		Assert.assertEquals("Home-CRM","Home-CRM");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() +" Test End ");
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() +" Test Start ");
		SoftAssert  assertObj1=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj1.assertTrue(true);
		
	//	Assert.assertTrue(true);
		System.out.println("step-3");
		assertObj1.assertAll();
		System.out.println(mtd.getName() +" Test End ");

	}
}
