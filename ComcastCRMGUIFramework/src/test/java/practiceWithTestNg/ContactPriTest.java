package practiceWithTestNg;

import org.testng.annotations.Test;

public class ContactPriTest {
	@Test//(priority = 1)
 public void createContactTest() {
		System.out.println("execute createcontact");
	}
	@Test//(priority = 2)
	public void modifyCreateTest() {
		//System.out.println("create contact IcIcI");
		System.out.println("execute query insert contact in DB=====.ICICI");
		System.out.println("execute  modify createcontact=======hdfc");
	}
	@Test//(priority = 3)
	public void deleteCreateTes() {
		//System.out.println("create contact UPI");
		System.out.println("execute query insert contact in DB=====UPI");
		System.out.println("execute  delete createcontact UPI");
	}
}
