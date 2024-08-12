package practice_listeners1;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;



public class RetryLisnerSampleTest {
  @Test(retryAnalyzer=com.comfast.crm.listenerutinity.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("excute create InvoiceTest");
		
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

}
}
