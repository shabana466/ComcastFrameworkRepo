package practiceWithTestNg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenShotFullPage {
	@Test
    public void amazonfullpageTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		TakesScreenshot ts=(TakesScreenshot)driver;
	File des = ts.getScreenshotAs(OutputType.FILE);

	File src=new File("./Sreenshot/fullpage.png");
	//FileUtils.copyFile(src, des);
	org.openqa.selenium.io.FileHandler.copy(des, src);
	driver.quit();
	
		
   	 
    }

}
