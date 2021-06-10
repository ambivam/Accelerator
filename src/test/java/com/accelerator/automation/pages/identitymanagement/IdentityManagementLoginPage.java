package com.accelerator.automation.pages.identitymanagement;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class IdentityManagementLoginPage extends BasePage{

	ResourceBundle loginPageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.OIM.LoginPage");
	Logger logger = LogManager.getLogger(IdentityManagementLoginPage.class);
	By inputUserName=By.xpath(loginPageElements.getString("textbox_username"));
	By inputPassword=By.xpath(loginPageElements.getString("textbox_password"));
	By buttonSignin=By.xpath(loginPageElements.getString("button_signin"));
	By textIdentityService=By.xpath(loginPageElements.getString("text_identityselfservice"));
	public IdentityManagementLoginPage(World world) {
		super(world,world.driver);
	}
	/*
	*entering login details
	*/
	public boolean login(String username, String password) throws Exception {
		try {
			enterUserName(username);
			enterPassword(password);
			return clickOnSignInButton();
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}
	/*
	 * entering username
	 */
	public boolean enterUserName(String LoginUsername) throws Exception {
		try {
			logger.info("Entering username");
			return enterText(inputUserName,LoginUsername);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * entering password
	 */
	public boolean enterPassword(String LoginPassword) throws Exception {
		try {
			logger.info("Entering password");
			return enterText(inputPassword, LoginPassword);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * clicking on signIn button
	 */
	public boolean clickOnSignInButton() throws Exception {
		try {
		logger.info("Clicking on signin button");
		return click(buttonSignin);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * validating IdentityServiceConsole
	 */	
	public boolean verifyIdentifyServiceConsole(String txt) throws Exception {
		try {
			logger.info("verifying IdentityService Console");
			return getTextFromElement(textIdentityService).equalsIgnoreCase(txt);
		} catch(Exception e) {
		throw new Exception(e.getMessage());
		}
	}
}	
