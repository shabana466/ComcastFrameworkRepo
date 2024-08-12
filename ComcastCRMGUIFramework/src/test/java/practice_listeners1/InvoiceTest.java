package practice_listeners1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.com.baseTest.BaseClass;
//@Listeners(com.comfast.crm.listenerutinity.ListImpClass.class)
public class InvoiceTest extends BaseClass {
	@Test 
	public void createInvoiceTest() {
		System.out.println("excute create InvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	@Test 
	public void createInvoiceWithContactTest() {
		System.out.println("excute createInvoiceWithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}

}
