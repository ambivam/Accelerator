package com.accelerator.automation.pages.coachoffice;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class CoachOfficeMyEFTMgmtPage extends BasePage {

	ResourceBundle MyEFTMgmetPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.MyEFTMgmtPage");
	Logger logger = LogManager.getLogger(CoachOfficeMyEFTMgmtPage.class);

	By textMyEFTMgmt = By.xpath(MyEFTMgmetPageElements.getString("textdata_myeftmgmt"));
	By selectPhisicalCheck = By.xpath(MyEFTMgmetPageElements.getString("select_physicalcheck"));
	By buttonUpdateInformation = By.xpath(MyEFTMgmetPageElements.getString("button_updateinformation"));
	By buttonYes = By.xpath(MyEFTMgmetPageElements.getString("option_yes"));
	By textSucessMessage = By.xpath(MyEFTMgmetPageElements.getString("text_updationSuccessMsg"));

	public CoachOfficeMyEFTMgmtPage(World world) {
		super(world, world.driver);
	}

	/**
	 * Verify My EFT Management Page loaded, an element is displayed
	 */
	public boolean verifyMyEFTManagementPage() throws Exception {
		try {
			logger.info("Verifying My EFT Management page loaded");
			boolean result = verifyElementPresence(textMyEFTMgmt);
			if (result == true) {
				return true;
			} else {
				throw new Exception("Not landed in EFT management page");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	/*
	 * Selecting Physical check option
	 */

	public boolean selectPhysicalcheck(String Physical_Check) throws Exception {
		try {
			logger.info("Selecting physical check option");
			return selectByValueinDropDown(selectPhisicalCheck, Physical_Check);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on update information button
	 */
	public boolean clickUpadateinformation() throws Exception {
		try {
			logger.info("Clicking on update information button");
			return click(buttonUpdateInformation);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	/*
	 * Clicking on Yes option
	 */

	public boolean clickYesoption() throws Exception {
		try {
			logger.info("Clicking on YES option");
			return click(buttonYes);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying success message
	 */
	public boolean verifySuccessMsg() throws Exception {
		try {
			logger.info("Verifying success message");
			boolean result=verifyElementPresence(textSucessMessage);
			if (result==true) {
				return true;
			} else {
				throw new Exception("Not able to see updated success message");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
