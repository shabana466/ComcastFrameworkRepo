package practiceWithTestNg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comfast.crm.generic.fileutility.FileUtility;

public class SampleTestForScreenShot {
	@Test
     public void amazonTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement element = driver.findElement(By.xpath("//div[text()=\"Metro, Mochi ...\"]"));
	File des = element.getScreenshotAs(OutputType.FILE);
	File src=new File("./Sreenshot/ele.png");
	FileUtils.copyFile(src, des);
	//org.openqa.selenium.io.FileHandler.copy(des, src);
	driver.quit();
	
		
    	 
     }
}
