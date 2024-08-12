package practiceWithTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDP_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber) {
		System.out.println(("FirstName:" + firstName + "LastName:" +  lastName +",phoneNumber:"+  phoneNumber));
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Shabana";
		objArr[0][1]="Eng";
		objArr[0][2]=843198032;
		
		objArr[1][0]="Sana";
		objArr[1][1]="Hr";
		objArr[1][2]=89765432;
		objArr[2][0]="Sahera";
		objArr[2][1]="Teacher";
		objArr[2][2]=23456789;
		return objArr;
				
	
	}

}
