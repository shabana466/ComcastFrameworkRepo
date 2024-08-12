package practicea_Assert_homeTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;





public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() +" Test Start ");
		String expectPage="Home";
		WebDriver driver=new  ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert
		Assert.assertEquals(actTitle,expectPage);
		driver.close();
		System.out.println(mtd.getName() +" Test End ");
		}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() +" Test Start ");
	
		WebDriver driver=new  ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		//Hard Assertion
		Assert.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName() +" Test End ");
		}

	}


