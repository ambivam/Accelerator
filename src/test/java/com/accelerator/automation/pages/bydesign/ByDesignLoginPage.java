package com.accelerator.automation.pages.bydesign;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import com.accelerator.automation.utilities.ConfigFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

/**
 * By Design Login Page Functionality...
 */
public class ByDesignLoginPage extends BasePage {

	ResourceBundle loginPageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.BYDESIGN.LoginPage");
	Logger logger = LogManager.getLogger(ByDesignLoginPage.class);

	By textBoxUsername = By.xpath(loginPageElements.getString("textbox_Username"));
	By textBoxPassword = By.xpath(loginPageElements.getString("textbox_Password"));
	By buttonSignIn = By.xpath(loginPageElements.getString("button_SignIn"));

	public ByDesignLoginPage(World world, WebDriver driver) {
		super(world, driver);
	}

	/*
	 * Navigates to By Design Login Page, URL will be retrieved from config
	 * properties
	 */
	public boolean navigateToByDesignLoginPage() throws Exception {
		try {
			logger.info("Navigating to Coach Office Login page");
			return navigateToWebPage(ConfigFileReader.getConfigFileReader().getBYDUrl());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean navigateToByDesignCustomerSearchPage() throws Exception {
		try {
			logger.info("Navigating to Coach Office Customer Search Page");
			return navigateToWebPage(ConfigFileReader.getConfigFileReader().getBYDSearchUrl());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Username
	 */

	public boolean enterUserName(String userName) throws Exception {
		try {
			logger.info("Entering username");
			return enterText(textBoxUsername, userName);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Password
	 */

	public boolean enterPassword(String password) throws Exception {
		try {
			logger.info("Entering password");
			return enterText(textBoxPassword, password);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on signin button
	 */

	public boolean clickOnSignInButton() throws Exception {
		try {
			logger.info("Clicking on signin button");
			return click(buttonSignIn);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Login Page
	 */

	public boolean login(String username, String password) {
		boolean result = false;
		try {
			logger.info("Login to application");
			enterUserName(username);
			enterPassword(password);
			clickOnSignInButton();
			result = true;
		} catch (Exception e1) {
			throw new RuntimeException("signin button not clicked" + e1);
		}
		return result;
	}

}
