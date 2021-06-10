package com.accelerator.automation.pages.shareacart;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartNewEnrollmentPage extends BasePage {
	Boolean result;
	// public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle shareACartNewEnrollmentPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.shareACartNewEnrollmentPageElements.SAC.NewEnrollmentPage");
	Logger logger = LogManager.getLogger(ShareACartNewEnrollmentPage.class);
	
	By inputNewEmail=By.xpath(shareACartNewEnrollmentPageElements.getString("input_NewEmail"));
    By buttonCustomer=By.xpath(shareACartNewEnrollmentPageElements.getString("button_Customer"));
	By inputFirstName = By.xpath(shareACartNewEnrollmentPageElements.getString("input_firstName"));
	By inputLastName = By.xpath(shareACartNewEnrollmentPageElements.getString("input_lastName"));
	By selectCountry = By.xpath(shareACartNewEnrollmentPageElements.getString("select_Country"));
	By selectLanguage = By.xpath(shareACartNewEnrollmentPageElements.getString("select_Language"));
	By checkboxTermsConditions = By.xpath(shareACartNewEnrollmentPageElements.getString("checkbox_ChkTermsConditions"));
	By buttonContinue = By.xpath(shareACartNewEnrollmentPageElements.getString("button_Continue"));

	public ShareACartNewEnrollmentPage(World world) {
		super(world, world.driver);
	}

	public boolean clickCustomerButton() throws Exception {
		try {
			logger.info("Clicking Customer Button");
			return click(buttonCustomer);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	/*
	 * entering email address
	 */
	public boolean enterNewEmailAddress(String newEmail) throws Exception {
		try {
			logger.info("Entering New Email Address");
			return enterText(inputNewEmail, newEmail);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * entering first name
	 */

	public boolean enterFirstName(String firstName) throws Exception {
		try {
			logger.info("Entering First Name");
			// driverUtils.click(world.driver,
			// By.xpath(shareACartNewEnrollmentPageElements.getString("input_firstName")));
			// Thread.sleep(3000);
			return enterText(inputFirstName, firstName);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		/*
		 * Thread.sleep(6000); boolean result=
		 * driverUtils.verifyElementEnabled(world.driver,
		 * By.xpath(shareACartNewEnrollmentPageElements.getString("input_firstName")));
		 * driverUtils.click(world.driver,
		 * By.xpath(shareACartNewEnrollmentPageElements.getString("input_firstName")));
		 * if(result==true) { return driverUtils.enter_text(world.driver,
		 * By.xpath(shareACartNewEnrollmentPageElements.getString("input_firstName")),
		 * fName); } return false;
		 */
	}

	/*
	 * entering last name
	 * 
	 */
	public boolean enterLastName(String lastName) throws Exception {
		try {
			logger.info("Entering Last Name");
			return enterText(inputLastName, lastName);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Selecting Country
	 */
	public boolean selectCountry(String country) throws Exception {
		try {
			logger.info("Selecting Country");
			return selectByValueinDropDown(selectCountry, country);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	/*
	 * Selecting Preferred Language
	 */
	public boolean selectPreferredLang(String preferredLang) throws Exception {
		try {
			logger.info("Selecting Preferred Language");
			return selectByValueinDropDown(selectLanguage, preferredLang);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	/*
	 * Selecting Customer Button
	 */

	/*
	 * Clicking on CheckBox
	 */
	public boolean clickTermsCheckBox() throws Exception {
		try {
			logger.info("Clicking Terms Check Box");
			return click(checkboxTermsConditions);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Clicking on Continue Button
	 */
	public boolean clickContinue() throws Exception {
		try {
			logger.info("Clicking on Continue Button");
			return click(buttonContinue);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

}
