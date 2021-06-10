package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class TeamBeachBodyShoppingCartPage extends BasePage {

	private World world;
	ResourceBundle productDetailsPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.ProductDetailsPage");
	Logger logger = LogManager.getLogger(TeamBeachBodyShoppingCartPage.class);
	
	By textCartTitle=By.xpath(productDetailsPageElements.getString("Validate_CartTitle"));
	By textCartQty=By.xpath(productDetailsPageElements.getString("Validate_CartQuantity"));
	By textCartPrice=By.xpath(productDetailsPageElements.getString("Validate_CartPrice"));
	By textOrderSummary =By.xpath(productDetailsPageElements.getString("Validate_CartOrderSummary"));
	By textCartSubTotal=By.xpath(productDetailsPageElements.getString("Validate_CartSubTotal"));
	By textCartEstTotal=By.xpath(productDetailsPageElements.getString("Validate_CartEstimatedTotal"));
	By buttonCheckout=By.xpath(productDetailsPageElements.getString("button_Checkout"));
	

	public TeamBeachBodyShoppingCartPage(World world) {
		super(world, world.driver);
	}

	/*
	 * validating title
	 */
	public boolean validateTitle() throws Exception {
		try {
			logger.info("Validating cart title");
			return verifyElementDisplayed(textCartTitle);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * validating quantity
	 */
	public boolean validateQuantity() throws Exception {
		try {
			logger.info("Validating cart quantity");
			return verifyElementDisplayed(textCartQty);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * validating price
	 */
	public boolean validatePrice() throws Exception {
		try {
			logger.info("Validating cart price");
			return verifyElementDisplayed(textCartPrice);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * Validating order cart summary
	 */
	public boolean validateSummary() throws Exception {
		try {
			logger.info("Validating cart order summary");
			return verifyElementDisplayed(textOrderSummary);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Validating subtotal and estimated total
	 */
	public boolean validateSubTotal_EstimatedTotal(String subtotal, String estimatedtotal) throws Exception {
		try {
			logger.info("Validating cart subtotal and estimated total");
			boolean sub =verifyElementDisplayed(textCartSubTotal);
			boolean est = verifyElementDisplayed(textCartEstTotal);
			if(sub && est ==true) {
				return true;
			}else {throw new Exception("subtotal and estimated total fields not displayed");}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on checkout button
	 */
	public boolean clickCheckout() throws Exception {
		try {
		logger.info("Clicking on checkout button");
		return click(buttonCheckout);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
