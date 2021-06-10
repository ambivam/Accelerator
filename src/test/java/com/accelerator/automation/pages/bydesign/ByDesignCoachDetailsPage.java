package com.accelerator.automation.pages.bydesign;

import java.util.ResourceBundle;

import com.accelerator.automation.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import org.openqa.selenium.WebDriver;

/**
 * By Design Coach Details Page Functionality...
 */
public class ByDesignCoachDetailsPage extends BasePage {
	ResourceBundle coachDetailsPageElements = ResourceBundle.getBundle("com.beachbody.automation.coachDetailsPageElements.BYDESIGN.CoachDetailsPage");
	Logger logger = LogManager.getLogger(ByDesignCoachDetailsPage.class);

	By textBoxSearchCoachID = By.xpath(coachDetailsPageElements.getString("textbox_SearchCoachID"));
	By buttonGo = By.xpath(coachDetailsPageElements.getString("button_go"));
	By linkPayOutMethod = By.xpath(coachDetailsPageElements.getString("link_payoutmethod"));
	By textPayOutMethod = By.xpath(coachDetailsPageElements.getString("text_payoutmethod"));


	public ByDesignCoachDetailsPage(World world, WebDriver driver) {
		super(world, driver);
	}

	/**
	 * Entering CoachId
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public boolean enterCoachId(String coachId) throws Exception {
		try {
			logger.info("Entering coach ID");
			return enterText(textBoxSearchCoachID, coachId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	/**
	 * Click on Go button
	 * @return
	 * @throws Exception
	 */
	public boolean clickGoButton() throws Exception {
		try {
			logger.info("Clicking on go button");
			return click(buttonGo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Click on Payout Method from menu
	 * @return
	 * @throws Exception
	 */
	public boolean clickPayOutMethod() throws Exception {
		try {
			logger.info("Clicking on payout method");
			return click(linkPayOutMethod);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Verifying PayOut Method
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPayOutMethod() throws Exception {
		try {
			logger.info("Validating Payout Method");
			return verifyElementDisplayed(textPayOutMethod);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Getting CoachId
	 * @return
	 * @throws Exception
	 */
	public String getCoachId() throws Exception {
		try {
			logger.info("Validating payout method");
			String value = getTextFromElement(textPayOutMethod);
			String coachid = value.replaceAll("[a-zA-Z]", "").replace('(', ' ').replace(')', ' ').replace('-', ' ')
					.replace('1', ' ').replaceAll(" ", "");
			return coachid;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Verifying CoachId
	 * @param coach
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCoachId(String coach) throws Exception {
		try {
			logger.info("Verifying coach ID");
			// TODO Auto-generated method stub
			String actual = getCoachId();
			String expected = coach.replaceAll("[a-zA-Z]", "").replace('(', ' ').replace(')', ' ').replace('-', ' ')
					.replace('1', ' ').replaceAll(" ", "");
			int exp = Integer.parseInt(expected);
			int act = Integer.parseInt(actual);
			if (exp == act) {
				return true;
			} else {
				throw new Exception("Coach ID is not matched");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
