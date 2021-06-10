package com.accelerator.automation.pages.shareacart;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartLoginPage extends BasePage {
	
	ResourceBundle shareACartLoginPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.shareACartLoginPageElements.SAC.LoginPage");
	Logger logger = LogManager.getLogger(ShareACartLoginPage.class);

	By inputEmail = By.xpath(shareACartLoginPageElements.getString("input_Email"));
	By inputPassword = By.xpath(shareACartLoginPageElements.getString("input_Password"));
	By buttonSignIn = By.xpath(shareACartLoginPageElements.getString("button_SignIn"));

	public ShareACartLoginPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Entering Email in text field
	 */

	public boolean enterUsername(String username) throws Exception {
		try {
			logger.info("Entering Username");
			return enterText(inputEmail, username);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Entering Password in text field
	 */

	public boolean enterPassword(String password) throws Exception {
		try {
			logger.info("Entering Password");
			return enterText(inputPassword, password);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Clicking on SignIn
	 */
	public boolean clickSignIn() throws Exception {
		try {
			logger.info("Clicking on SignIn");
			return click(buttonSignIn);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

}
