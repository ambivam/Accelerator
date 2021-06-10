package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;

import com.accelerator.automation.utilities.CommonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class TeamBeachBodyCheckOutPage extends BasePage {
	ResourceBundle productDetailsPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.ProductDetailsPage");
	private World world;
	WebDriver driver;
	Logger logger = LogManager.getLogger(TeamBeachBodyCheckOutPage.class);

	By inputEmail = By.xpath(productDetailsPageElements.getString("input_Email"));
	By buttonBeginCheckout = By.xpath(productDetailsPageElements.getString("button_BeginCheckout"));

	public TeamBeachBodyCheckOutPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Verifying email field exists
	 */
	public boolean verifyEmail() throws Exception {
		try {
			logger.info("Verifying email field");
			return verifyElementDisplayed(inputEmail);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering email
	 */
	public boolean enter_Email(String email) throws Exception {
		try {
			logger.info("Entering email");
			return enterText(inputEmail, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on begin checkout button
	 */
	public boolean clickBeginCheckout() throws Exception {
		try {
			return click(buttonBeginCheckout);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * entering the email and clicking on begin checkout
	 */
	public boolean beginCheckout() throws Exception {
		try {
			logger.info("Entering new customer email and clicking on begin checkout button");
			// System.out.println("begin checkout");
			boolean result = verifyEmail();
			if (result == true) {
				boolean rmail = enter_Email(CommonUtilities.randomEmail());
				boolean check = clickBeginCheckout();
				if (rmail && check == true) {
					return true;
				} else {
					throw new Exception("Not clicked on begin checkout");
				}
			} else {
				throw new Exception("Not navigated to begin checkout page");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
