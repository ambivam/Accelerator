package com.accelerator.automation.pages.coachoffice;

import com.accelerator.automation.utilities.ConfigFileReader;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ResourceBundle;

/**
 * Coach Office Login Page Actions, Validations etc...
 */
public class CoachOfficeLoginPage extends BasePage {

	ResourceBundle loginPageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.COO.LoginPage");
	Logger logger = LogManager.getLogger(CoachOfficeLoginPage.class);

	By inputEmail = By.xpath(loginPageElements.getString("input_Email"));
	By inputPassword = By.xpath(loginPageElements.getString("input_Password"));
	By buttonSignin = By.xpath(loginPageElements.getString("button_Sign"));
	private World world;

	public CoachOfficeLoginPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Navigates to Coach Home Page, URL will be retrieved from config properties
	 */
	public boolean navigateToCoachLoginPage() throws Exception {
		try {
			logger.info("Navigating to Coach Office Login page");
			return navigateToWebPage(ConfigFileReader.getConfigFileReader().getCOOUrl());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * In future if different type of users have to login to same application, use
	 * Enums, pass String(userType) to below method
	 */
	public boolean loginWith(String username, String password) throws Exception {
		try {
			logger.info("Trying to login to Coach Office..");
			enterText(inputEmail, ConfigFileReader.getConfigFileReader().getCOOUserName());
			enterText(inputPassword, ConfigFileReader.getConfigFileReader().getCOOPassword());
			click(buttonSignin);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean login(String username, String password) throws Exception {
		try {
			logger.info("Trying to login to Coach Office..");
			enterText(inputEmail, username);
			enterText(inputPassword, password);
			click(buttonSignin);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void validatePageTitle(String pageTitle) throws Exception{
		try {
		Assert.assertEquals(returnPageTitle(), pageTitle.trim(), "Not launched COO Application");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
}
