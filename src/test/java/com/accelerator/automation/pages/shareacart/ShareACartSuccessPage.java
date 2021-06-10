package com.accelerator.automation.pages.shareacart;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;


public class ShareACartSuccessPage extends BasePage{
	
	ResourceBundle elementLib = ResourceBundle.getBundle("com.beachbody.automation.elementlib.SAC.SuccessPage");
	Logger logger = LogManager.getLogger(ShareACartSuccessPage.class);

	By textVerifySuccessPage=By.xpath(elementLib.getString("text_VerifySuccessPage"));
    By menuBars=By.xpath(elementLib.getString("menu_bars"));
    By linkViewStatus=By.xpath(elementLib.getString("link_ViewStatus"));
    
	public ShareACartSuccessPage(World world) {
		super(world,world.driver);
	}
	
	/*
	 * verifying Success page
	 */
	public boolean verifySuccessPage(String text) {
        boolean result = false;
	    try {
	          if (text.equalsIgnoreCase(getTextFromElement(textVerifySuccessPage))) {
	                result = true;
	            }
	        } catch (Exception e1) {
	            throw new RuntimeException("Successs Title not matched" + e1);
	        }
	        return result;
    }
	
	/*
	 * Clicking on Icon Bar on top left side
	 */
	public boolean clickMenuBar() throws Exception {
		//Thread.sleep(2000);
		try {
		return click(menuBars);
		} catch(Exception e1) {
			throw new Exception(e1.getMessage());
		}
		/*boolean result = driverUtils.verifyElementDisplayed(world.driver,By.xpath(elementLib.getString("menu_bars")));
		if(result==true) {
		return driverUtils.click(world.driver,  By.xpath(elementLib.getString("menu_bars")));
	}
		else
		{
			return false;
		}*/
	}
	
	/*
	 * Clicking on View Status
	 */
	public boolean clickViewStatus() throws Exception {
		//Thread.sleep(2000);
		try {
		return click(linkViewStatus);
		} catch(Exception e1) {
			throw new Exception(e1.getMessage());
		}
		/*boolean result=driverUtils.click(world.driver,  By.xpath(elementLib.getString("link_ViewStatus")));
		if(result==true)
		{
		return driverUtils.click(world.driver,  By.xpath(elementLib.getString("link_ViewStatus")));
		}
		else
		{
			return false;
		}*/
	}


}
