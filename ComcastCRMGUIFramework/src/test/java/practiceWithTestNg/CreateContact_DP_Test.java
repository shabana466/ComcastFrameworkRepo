package practiceWithTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName) {
		System.out.println(("FirstName:" + firstName + "LastName:" +lastName));
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Shabana";
		objArr[0][1]="Eng";
		objArr[1][0]="Sana";
		objArr[1][1]="Hr";
		objArr[2][0]="Sahera";
		objArr[2][1]="Teacher";
		return objArr;
				
	
	}

}
