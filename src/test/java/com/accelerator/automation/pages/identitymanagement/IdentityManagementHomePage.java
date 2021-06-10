package com.accelerator.automation.pages.identitymanagement;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class IdentityManagementHomePage extends BasePage{

	ResourceBundle homePageElements=ResourceBundle.getBundle("com.beachbody.automation.elementlib.OIM.HomePage");
	Logger logger = LogManager.getLogger(IdentityManagementHomePage.class);
	By buttonManage=By.xpath(homePageElements.getString("button_manage"));
	By linkUsers=By.xpath(homePageElements.getString("link_users"));
	By textMyInformation=By.xpath(homePageElements.getString("text_myinformation"));
	By linkAccountName=By.xpath(homePageElements.getString("link_accountName"));
	By buttonSignOut=By.xpath(homePageElements.getString("button_signOut"));
	
	public IdentityManagementHomePage(World world){
	     super(world,world.driver);
	}
	/*
	*clicking on manage button
	*/
	public boolean clickManage() throws Exception {
		  try {
			  	logger.info("Clicking on manage button");
	            return click(buttonManage);
	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	}
 
	/*
	 * clicking on users
	 */	
	public boolean clickUsers() throws Exception {
		try {
			logger.info("Clicking on users link");
            return click(linkUsers);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}	
	
	/*
	 * verifying user information
	 */
	public boolean verifyMyInformation(String txt) throws Exception {
		try {
			logger.info("Verifying user information");
			return getTextFromElement(textMyInformation).equalsIgnoreCase(txt);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * Clicking on Signout
	 */
	public boolean signOut() throws Exception {
		try {
			logger.info("Logging out from application");
			click(linkAccountName);
			click(buttonSignOut);
			return true;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
