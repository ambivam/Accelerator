	package com.accelerator.automation.libraries;

	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	
	public class WebDriverUtilities {
		
		
		public boolean click(WebDriver driver,By ele) 
		{
			WebElement element= waitforElementPresent(driver,ele);
			try
			{
				element.click();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public void pause() throws InterruptedException 
		{
			Thread.sleep(4000);			
			
		}
		
		public boolean enter_text(WebDriver driver,By ele,String val) 
		{
			WebElement element = waitforElementPresent(driver,ele);
			try
			{
				element.clear();			
				element.sendKeys(val);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
						
		public boolean mouseOver(WebDriver driver,By ele)
		{
			try
			{
				Actions action = new Actions(driver);
				WebDriverWait wait = new WebDriverWait(driver,10);
				action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(ele))).build().perform();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public WebElement findElement(WebDriver driver,By ele)
		{
			try
			{
				WebElement web = driver.findElement(ele);
				return web;
			}
			catch(Exception e)
			{
				return null;
			}
		}
		
		public WebElement waitforElementPresent(WebDriver driver,By ele) 
		{
			int seconds = 60;
			WebElement element = null;
			int timecount=0;
			while(timecount<seconds)
			{
				element = findElement(driver,ele);
				if(element!=null)
				{				
					return element;
				}
				try {
				Thread.sleep(1000);
				} catch(Exception e){
					
				}
				timecount=timecount+1;
			}
			return element;
		}
		
		public String getElementText(WebDriver driver,By ele) 
		{
			WebElement element = waitforElementPresent(driver,ele);
			
			if(element!=null)
			{
				return element.getText();
			}
			else
			{
				return null;
			}
		}
		
			
		public byte[] captureScreenshot(WebDriver driver)
		{
			try {  
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);  
	            return screenshot;
	        } catch (WebDriverException wde) {  
	            System.err.println(wde.getMessage()); 
	            return null;
	        } catch (ClassCastException cce) {  
	            cce.printStackTrace(); 
	            return null;
	        } 
		}
		
		public void screenShot(WebDriver driver) throws IOException, InterruptedException {
            File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
            File dest = new File("target\\reports\\htmlreport\\" + filename);
            FileUtils.copyFile(scr, dest);
        }
		
		public String randomEmail() {
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(10000);  
			return "username"+ randomInt +"@yopmail.com"; 
		}
		
		public boolean verifyElementDisplayed(WebDriver driver,By strXpath) {	
			try {
	    	WebElement result = null;
	    	result = waitforElementPresent(driver, strXpath);
	    	Assert.assertTrue(result.isDisplayed(),"element not displayed");
	    	return true;
			}catch (Exception e) {
				return false;
			}					
		}
		
		public boolean verifyElementEnabled(WebDriver driver,By strXpath) {	
			try {
	    	WebElement result = null;
	    	result = waitforElementPresent(driver, strXpath);
	    	Assert.assertTrue(result.isEnabled(),"element not displayed");
	    	return true;
			}catch (Exception e) {
				return false;
			}					
		}
	
	public boolean selectListValue(WebDriver driver, By ele, String val) {		
		try {
			Select s = new Select(waitforElementPresent(driver,ele));
			s.selectByValue(val);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public boolean selectByValue(WebDriver driver, By xpath, String option) {
		try {
			Select s = new Select(waitforElementPresent(driver,xpath));
			s.selectByValue(option);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}
	public boolean clickUsingJavaScript(WebDriver driver,By ele) {
		try {
			Thread.sleep(3000);
			WebElement web = driver.findElement(ele);
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", web);
			return true;
		}
		catch(Exception e) {
			return false;
			
		}	
	}

	
}