package com.accelerator.automation.pages.shareacart;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartHomePage extends BasePage {
	Boolean result;
	// public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle shareACartHomePageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.SAC.HomePage");
	Logger logger = LogManager.getLogger(ShareACartHomePage.class);

	By buttonNewEnrollment = By.xpath(shareACartHomePageElements.getString("button_New_Enrollment"));

	public ShareACartHomePage(World world) {
		super(world, world.driver);
	}

	/*
	 * clicking New Enrollment button
	 */
	public boolean clickNewEnrollmentOrderButton() throws Exception {
		try {
			logger.info("Clicking New Enrollment Button");
			verifyElementDisplayed(buttonNewEnrollment);
			return click(buttonNewEnrollment);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}
}
