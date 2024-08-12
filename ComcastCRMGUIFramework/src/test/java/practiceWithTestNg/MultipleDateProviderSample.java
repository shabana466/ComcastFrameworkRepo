package practiceWithTestNg;

import org.testng.annotations.Test;

public class MultipleDateProviderSample {
	@Test(dataProviderClass =CreateContact_DP_Test.class,dataProvider = "getData")
	public void createContactTest(String firstName,String lastName) {
		System.out.println(("FirstName:" + firstName + "LastName:" +lastName));
	}

}
