package com.comfast.crm.generic.fileutility;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void waitForElementTitle(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public  void waitForElementSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public  void waitForElementTitles(WebDriver driver,  String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partailTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if(actTitle.contains(partailTitle)) {
				break;
			}
		}
	}
	public void switchToTabOnUrl(WebDriver driver,String partailURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();
			if(actURL.contains(partailURL)) {
				break;
			}
		}
	}

	public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver,String nameid) {
		driver.switchTo().frame(nameid);
	}
	public void switchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	//handle dropdown menu
	public Select dropdown(WebElement element) {
		Select sel=new Select(element);
		return sel;
	}
	public void handleDropDown(WebElement element,String value) {
		dropdown(element).selectByValue(value);
	}
	public void handleDropDown(WebElement element,int index) {
		dropdown(element).selectByIndex(index);
	}
	public void handleDropDown(String text,WebElement element) {
		dropdown(element).selectByVisibleText(text);
	}
	public void handleDropDown(int index,WebElement element) {
		dropdown(element).deselectByIndex(index);
	}
	//handle mouse and keys action
	public  Actions action(WebDriver driver) {
		Actions act=new Actions(driver);
		return act;
	}
	public void mouseHover(WebDriver driver,WebElement element) {
		action(driver).moveToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement dest, WebElement src) {
		action(driver).dragAndDrop(src, dest).perform();
	}
	public void doubleClickElement(WebDriver driver,WebElement element) {
		action(driver).doubleClick(element).perform();
	
}
	public void rigthClickElement(WebDriver driver,WebElement element) {
		action(driver).contextClick(element).perform();
}
	public void clickOnHold(WebDriver driver,WebElement element) {
		action(driver).clickAndHold(element).perform();
}
	//handle to scrollbar with javascriptExecutor
		public void scrollToElement(WebElement element,WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].ScrollIntoView(true)",element);
		}
		public void clickableToElement(WebElement element,WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		}
		
		
		//TakeScreenShot
		public String getScreenShot(WebDriver driver) {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File desc=new File("./Screenshot/"+"_"+".png");
		  try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return desc.getAbsolutePath();
		      
		}
	}
	
	
	

