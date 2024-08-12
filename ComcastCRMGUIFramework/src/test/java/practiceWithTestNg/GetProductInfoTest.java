package practiceWithTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comfast.crm.generic.fileutility.ExcelUtility;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	 public void GetProductInfo1Test(String BrandName,String productName) {
		 WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.amazon.in/");
			//search Product
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
			String x="(//span[text()='"+productName+"'])[1]/../../../../descendant::span[@class=\"a-price-whole\"]";
			String price=driver.findElement(By.xpath(x)).getText();
			System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		Object[][] objArr=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=eLib.getDataFromExcel("product",i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("product",i+1, 1);
		}
		return objArr;
				
			
	}
	
	

}
