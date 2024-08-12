package practiceWithTestNg;

import org.testng.annotations.Test;

public class InvocationTest {

	
		@Test(invocationCount = 10)
		public void createOrderTest() {
			System.out.println("Execute createOrderTest====.123");
			String str=null;
			System.out.println(str.equals("123"));
		}
		@Test(enabled = false)
		public void billingOnOrderTest() {
			System.out.println("Execute createOrderTest====.123");
		}

	

}
