package com.accelerator.automation.pages.coachoffice;

import java.util.ResourceBundle;

import com.accelerator.automation.utilities.CommonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class CoachOfficeRegistrationPage extends BasePage {

	ResourceBundle registrationPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.RegistationPage");
	Logger logger = LogManager.getLogger(CoachOfficeRegistrationPage.class);

	By linkSignup = By.xpath(registrationPageElements.getString("link_signup"));
	By selectCountry = By.xpath(registrationPageElements.getString("select_country"));
	By selectLanguage = By.xpath(registrationPageElements.getString("select_language"));
	By inputFirstName = By.xpath(registrationPageElements.getString("input_firstname"));
	By inputLastName = By.xpath(registrationPageElements.getString("input_lastname"));
	By inputEmail = By.xpath(registrationPageElements.getString("input_email"));
	By inputConfirmEmail = By.xpath(registrationPageElements.getString("input_confirmemail"));
	By inputPassword = By.xpath(registrationPageElements.getString("input_password"));
	By inputConfirmPassword = By.xpath(registrationPageElements.getString("input_confirmpassword"));
	By inputPhone = By.xpath(registrationPageElements.getString("input_phone"));
	By selectMonth = By.xpath(registrationPageElements.getString("select_month"));
	By selectDay = By.xpath(registrationPageElements.getString("select_day"));
	By selectYear = By.xpath(registrationPageElements.getString("select_year"));
	By clickMale = By.xpath(registrationPageElements.getString("radio_genderMale"));
	By inputGovtid = By.xpath(registrationPageElements.getString("input_govtid"));
	By buttonSign = By.xpath(registrationPageElements.getString("input_sign"));
	By buttonCoachNumber = By.xpath(registrationPageElements.getString("button_coachNo"));
	By clickDisclaimer = By.xpath(registrationPageElements.getString("checkbox_disclaimer"));
	By clickTerms = By.xpath(registrationPageElements.getString("checkbox_terms"));
	By buttonContinue = By.xpath(registrationPageElements.getString("button_continue"));

	public CoachOfficeRegistrationPage(World world) {
		super(world, world.driver);

	}

	public boolean clickSignUpLink() throws Exception {
		try {
			logger.info("Clicking on signup link");
			return click(linkSignup);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting Country
	 */
	public boolean selectCountry(String country) throws Exception {
		try {
			logger.info("Selecting country");
			return selectByValueinDropDown(selectCountry, country);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting language
	 */
	public boolean selectLanguage(String language) throws Exception {
		try {
			logger.info("Selecting language");
			return selectByValueinDropDown(selectLanguage, language);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering First Name
	 */
	public boolean enterFname(String fname) throws Exception {
		try {
			logger.info("Entering first name");
			return enterText(inputFirstName, fname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Last Name
	 */
	public boolean enterLastName(String lname) throws Exception {
		try {
			logger.info("Entering last name");
			return enterText(inputLastName, lname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Email
	 */
	public boolean enterEmail(String email) throws Exception {
		try {
			logger.info("Entering email");
			return enterText(inputEmail, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering confirmation email
	 */
	public boolean enterConfirmationEmail(String email) throws Exception {
		try {
			logger.info("Entering confirmation email");
			return enterText(inputConfirmEmail, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Password
	 */
	public boolean enterPassword(String pswd) throws Exception {
		try {
			logger.info("Entering email");
			return enterText(inputPassword, pswd);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering confirmation password
	 */
	public boolean enterConfirmationPassword(String pswd) throws Exception {
		try {
			logger.info("Entering confirmation password");
			return enterText(inputConfirmPassword, pswd);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering phone
	 */
	public boolean enterPhone(String phone) throws Exception {
		try {
			logger.info("Entering confirmation email");
			return enterText(inputPhone, phone);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting month
	 */
	public boolean selectBirthMonth(String month) throws Exception {
		try {
			logger.info("Selecting birth month");
			return selectByValueinDropDown(selectMonth, month);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting birth date
	 */
	public boolean selectBirthDay(String date) throws Exception {
		try {
			logger.info("Selecting birth date");
			return selectByValueinDropDown(selectDay, date);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting birth year
	 */
	public boolean selectBirthYear(String year) throws Exception {
		try {
			logger.info("Selecting birth year");
			return selectByValueinDropDown(selectYear, year);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on male option
	 */
	public boolean clickMale() throws Exception {
		try {
			logger.info("Clicking on male radio button");
			return click(clickMale);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Govt Id
	 */
	public boolean enterGovtId(String govId) throws Exception {
		try {
			logger.info("Entering govt id");
			return enterText(inputGovtid, govId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering sign
	 */
	public boolean enterSign(String sign) throws Exception {
		try {
			logger.info("Entering confirmation email");
			return enterText(buttonSign, sign);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifySignUpStatus(String status) throws Exception {
		try {
			logger.info("Verifying signup status");
			String signup = registrationPageElements.getString("placeholder_button_signup").replaceAll("PLACEHOLDER",
					status);
			if (verifyElementDisplayed(By.xpath(signup)) == true) {
				return true;
			} else {
				throw new Exception("Signup status not changed");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean fillInfo(String country, String language, String pswd, String phone, String month, String date,
			String year, String govtid, String sign) throws Exception {
		logger.info("Verifying fill information");

		boolean count = selectCountry(country);

		boolean lang = selectLanguage(language);
		String fname = CommonUtilities.randomString(6);
		String lname = CommonUtilities.randomString(3);
		String email = fname + "@yopemail.com";

		boolean fnme = enterFname(fname);

		boolean lnme = enterLastName(lname);

		boolean emailrs = enterEmail(email);

		boolean emailrs1 = enterConfirmationEmail(email);

		boolean passwdrs = enterPassword(pswd);

		boolean paswd = enterConfirmationPassword(pswd);

		boolean phoners = enterPhone(phone);

		boolean monthrs = selectBirthMonth(month);

		boolean daters = selectBirthDay(date);

		boolean yearrs = selectBirthYear(year);

		boolean male = clickMale();
		boolean govt = enterGovtId(govtid);
		boolean signrs = enterSign(sign);

		if (count && lang && male && monthrs & yearrs && govt && signrs && daters && fnme && lnme && emailrs && emailrs1
				&& passwdrs && paswd && phoners) {
			return true;
		} else {
			throw new Exception("Not filling account details");
		}

	}

	public boolean clickNoCoachButton() throws Exception {
		try {
			logger.info("Clicking on NO coach button");
			return click(buttonCoachNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickDisclaimerCheckBox() throws Exception {
		try {
			logger.info("Clicking on disclaimer checkbox");
			return click(clickDisclaimer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickTermsCheckBox() throws Exception {
		try {
			logger.info("Clicking on terms checkbox");
			return click(clickTerms);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickContinueButton() throws Exception {
		try {
			logger.info("Clicking on continue button");
			verifyElementDisplayed(buttonContinue);
			return click(buttonContinue);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyChallengePackStatus(String status) throws Exception {
		try {
			logger.info("Verifying challenge pack status");
			String challengePack = registrationPageElements.getString("placeholder_button_challengepack")
					.replaceAll("PLACEHOLDER", status);
			if (verifyElementDisplayed(By.xpath(challengePack)) == true) {
				return true;
			} else {
				throw new Exception("Challenge pack page status not changed");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyTopSellersStatus(String status) throws Exception {
		try {
			logger.info("Verifying top seller status");
			String topSeller = registrationPageElements.getString("placeholder_button_topsellers")
					.replaceAll("PLACEHOLDER", status);
			if (verifyElementDisplayed(By.xpath(topSeller)) == true) {
				return true;
			} else {
				throw new Exception("top sellerts page status not changed");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyShakeologyStatus(String status) throws Exception {
		try {
			logger.info("Verifying shakeology status");
			String shakeology = registrationPageElements.getString("placeholder_button_shakeology")
					.replaceAll("PLACEHOLDER", status);
			if (verifyElementDisplayed(By.xpath(shakeology)) == true) {
				return true;
			} else {
				throw new Exception("Shakeology page status not changed");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
