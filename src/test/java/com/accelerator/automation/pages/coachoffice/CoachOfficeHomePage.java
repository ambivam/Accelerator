package com.accelerator.automation.pages.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ResourceBundle;

/**
 * Coach Office Home Page Actions, Validations etc...
 */
public class CoachOfficeHomePage extends BasePage {

	ResourceBundle homePageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.COO.HomePage");
	Logger logger = LogManager.getLogger(CoachOfficeHomePage.class);
	
	By linkGrowMyBusiness = By.xpath(homePageElements.getString("link_growmybusiness"));
	By linkMonitorMyBusiness = By.xpath(homePageElements.getString("link_MonitorMyBusiness"));
	By linkCustomersAndOrders = By.xpath(homePageElements.getString("link_CustomersandOrders"));
	By linkQualification = By.xpath(homePageElements.getString("link_Qualification"));
	By linkDownLine = By.xpath(homePageElements.getString("link_Downline"));
	By linkCompensation = By.xpath(homePageElements.getString("link_Compensation"));
	By linkMyCustomers = By.xpath(homePageElements.getString("link_MyCustomers"));
	By linkMyPersonalCustomerOrders = By.xpath(homePageElements.getString("link_MyPersonalandCustomerOrders"));
	By linkMyEFTManagement = By.xpath(homePageElements.getString("link_myEFTManagement"));
	By linkChallenegGroupTools = By.xpath(homePageElements.getString("link_challengegrouptools"));
	By linkSharebleMedia = By.xpath(homePageElements.getString("link_shareablemedia"));
	By linkLogosAndMedia = By.xpath(homePageElements.getString("link_logosandimages"));
	By linkMyWebsites = By.xpath(homePageElements.getString("link_mywebsites"));
	By linkSendAnEmail = By.xpath(homePageElements.getString("link_sendanemail"));
	By linkShareACart = By.xpath(homePageElements.getString("link_shareacart"));
	By textCoachId=By.xpath(homePageElements.getString("text_coachId"));

	public CoachOfficeHomePage(World world) {
		super(world, world.driver);
	}

	/**
	 * Verify Home Page loaded, an element is displayed
	 */
	public boolean verifyHomePageLoaded() throws Exception {
		try {
			logger.info("Verifying home page loaded");
			return verifyElementDisplayed(linkGrowMyBusiness);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Click Grow My Business Header
	 */
	public boolean clickGrowMyBusinessHeader() throws Exception {
		try {
			logger.info("Clicking on Grow My Business header");
			return click(linkGrowMyBusiness);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Click on Monitor My Business Header
	 */
	public boolean clickMonitorMyBusiness() throws Exception {
		try {
			logger.info("Clicking on Monitor My Business ");
			return click(linkMonitorMyBusiness);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying Header Menu Options when clicked on Monitor My Business
	 */
	public boolean verifyMonitorMyBusinessMenuOptionsDisplayed() throws Exception {
		try {
			logger.info("Verifying Monitor My Business Menu Options");
			verifyElementDisplayed(linkCustomersAndOrders);
			verifyElementDisplayed(linkQualification);
			verifyElementDisplayed(linkDownLine);
			return verifyElementDisplayed(linkCompensation);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public String getCoachID() throws Exception {
		try {
			logger.info("Verifying Getting coach ID");
			return getTextFromElement(textCoachId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Click on My Customers
	 */
	public boolean clickMyCustomers() throws Exception {
		try {
			logger.info("Clicking on My Customers");
			return click(linkMyCustomers);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Click on My Personal Customer Orders
	 */
	public boolean clickMyPersonalCustomerOrders() throws Exception {
		try {
			logger.info("Clicking MyPersonalCustomerOrders");
			return click(linkMyPersonalCustomerOrders);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Click on My EFT Management
	 */
	public boolean clickMyEFTManagement() throws Exception {
		try {
			logger.info("Clicking on My EFT Management ");
			return click(linkMyEFTManagement);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verify Header Menu Options when clicked on Grow My Business Link
	 */
	public boolean verifyGrowMyBusinessMenuOptionsDisplayed() throws Exception {
		try {
			logger.info("Verifying Grow My Business Menu Options");
			verifyElementDisplayed(linkChallenegGroupTools);
			verifyElementDisplayed(linkSharebleMedia);
			verifyElementDisplayed(linkLogosAndMedia);
			verifyElementDisplayed(linkMyWebsites);
			verifyElementDisplayed(linkSendAnEmail);
			return verifyElementDisplayed(linkShareACart);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Click Send an Email in Grow my Business
	 */
	public boolean clickSendAnEmailInGrowMyBusiness() throws Exception {
		try {
			logger.info("Clicking on Grow My Business header");
			return click(linkSendAnEmail);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
