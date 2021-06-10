package com.accelerator.automation.pages.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import com.accelerator.automation.utilities.ConfigFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ResourceBundle;

/**
 * Coach Office Home Page Actions, Validations etc...
 */
public class CoachOfficeSendEmailPage extends BasePage {

	ResourceBundle sendEmailPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.SendEmailPage");
	ResourceBundle composePageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.ComposeEmailPage");
	Logger logger = LogManager.getLogger(CoachOfficeSendEmailPage.class);
	By selectEmail = By.xpath(sendEmailPageElements.getString("select_email"));
	By selectRecipiants = By.xpath(sendEmailPageElements.getString("select_recipiants"));
	By checkboxCustomers_QA = By.xpath(sendEmailPageElements.getString("checkbox_customers_QA"));
    By checkboxCustomers_UAT = By.xpath(sendEmailPageElements.getString("checkbox_customers_UAT"));
	By composeButton = By.xpath(sendEmailPageElements.getString("button_compose"));
	By inputEmail = By.xpath(composePageElements.getString("text_emaiid"));
	By inputEmailSubject = By.xpath(composePageElements.getString("text_subject"));
	By inputEmailBody = By.xpath(composePageElements.getString("text_body"));
	By buttonSend = By.xpath(composePageElements.getString("button_send"));
	By textMessage = By.xpath(sendEmailPageElements.getString("snackbar_message"));

	public CoachOfficeSendEmailPage(World world) {
		super(world, world.driver);
	}

	/**
	 * Verify Send Email Page loaded, an element is displayed
	 */
	public boolean verifySendAnEmailPageLoaded() throws Exception {
		try {
			logger.info("Verifying Send An Email page loaded");
			return verifyElementDisplayed(selectEmail);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Select Email From and Recipient
	 */
	public boolean selectEmailFromAndTo(String emailFrom, String emailTo) throws Exception {
		try {
			logger.info("Selecting Email From and To");
			selectByValueinDropDown(selectEmail, emailFrom);
			return selectByValueinDropDown(selectRecipiants, emailTo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on Checkbox
	 */
	public boolean clickCheckbox() throws Exception {
        try {
            logger.info("Clicking on checkbox");
            if(ConfigFileReader.getConfigFileReader().getTBBUrl().contains("qa3")) {
                
                return click(checkboxCustomers_UAT);
            }else {
                return click(checkboxCustomers_QA);
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

	/*
	 * Clicking on compose button
	 */
	public boolean clickCompose() throws Exception {
		try {
			logger.info("Clicking on compose button");
			return click(composeButton);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering email id
	 */
	public boolean enterEmailId(String email_id) throws Exception {
		try {
			logger.info("Entering an Email id");
			enterText(inputEmail, email_id);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Email subject
	 */
	public boolean enterEmailSubject(String email_sub) throws Exception {
		try {
			logger.info("Entering an email subject");
			enterText(inputEmailSubject, email_sub);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	/*
	 * Entering an Email body
	 */

	public boolean enterEmailbody(String email_body) throws Exception {
		try {
			logger.info("Entering an email body");
			enterText(inputEmailBody, email_body);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on send button
	 */
	public boolean clickSendbutton() throws Exception {
		try {
			logger.info("Clicking on send button");
			return click(buttonSend);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying Snackbar message
	 */
	public boolean verifySnackbarmsg() throws Exception {
		try {
			logger.info("Verifying snack bar message");
			return verifyElementDisplayed(textMessage);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
