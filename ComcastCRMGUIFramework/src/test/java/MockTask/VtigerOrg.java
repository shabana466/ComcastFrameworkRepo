package MockTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.com.baseTest.BaseClass;
@Listeners(com.comfast.crm.listenerutinity.ListImpClass.class)
public class VtigerOrg extends BaseClass {
	@Test
	public void vtigerOrg() throws Throwable{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).submit();
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  FileInputStream fis=new FileInputStream("./testdata/Book1.xlsx");
		  Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet("Sheet1");
			        
			        String orgname=s.getRow(1).getCell(0).toString();
			        driver.findElement(By.name("accountname")).sendKeys(orgname);
//			      if(orgname==null)
//			      {
//			    	 
//			      
//			        	File Screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			        	File dest=new File("./screenshot/page.png");
//			        	FileHandler.copy(Screenshot, dest);
//			        	System.out.println("screenshot taken");
//			      }
//			      else
//			      {
//			    	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
//			    	  }
			        
	wb.close();
	}

		  
	}



