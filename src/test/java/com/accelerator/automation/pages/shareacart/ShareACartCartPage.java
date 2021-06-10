package com.accelerator.automation.pages.shareacart;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartCartPage extends BasePage {

	ResourceBundle shareACartCartPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.shareACartCartPageElements.SAC.CartPage");
	Logger logger = LogManager.getLogger(ShareACartCartPage.class);

	By titleCart = By.xpath(shareACartCartPageElements.getString("title_Cart"));
	By verifyOrderSummary = By.xpath(shareACartCartPageElements.getString("verify_OrderSummary"));
	By titleProduct = By.xpath(shareACartCartPageElements.getString("title_Product"));
	By selectQuantity = By.xpath(shareACartCartPageElements.getString("dropdown_Quantity"));
	By textPrice = By.xpath(shareACartCartPageElements.getString("text_Price"));
	By textSubTotal = By.xpath(shareACartCartPageElements.getString("text_SubTotal"));
	By buttonSendEmail = By.xpath(shareACartCartPageElements.getString("button_SendEmail"));

	public ShareACartCartPage(World world) {
		super(world, world.driver);
	}

	/*
	 * verifying Cart page Title
	 */
	public boolean verifyCartPage(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Cart Page");
			if (text.equalsIgnoreCase(getTextFromElement(titleCart))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * verifying Order Summary
	 */
	public boolean verifyOrderSummary(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Order Summary");
			if (text.equalsIgnoreCase(getTextFromElement(verifyOrderSummary))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * verifying Product Title
	 */
	public boolean verifyProductTitle(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Product Title");
			if (text.equalsIgnoreCase(getTextFromElement(titleProduct))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * verifying Quantity
	 */
	public boolean verifyQuantity(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Quantity");
			if (text.equalsIgnoreCase(getTextFromElement(selectQuantity))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * verifying Price
	 */
	public boolean verifyPrice(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Price");
			if (text.equalsIgnoreCase(getTextFromElement(textPrice))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * verifying Price
	 */
	public boolean verifySubTotal(String text) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Subtotal");
			if (text.equalsIgnoreCase(getTextFromElement(textSubTotal))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * clicking Send email button
	 */
	public boolean clickSendEmailButton() throws Exception {
		// driverUtils.pause();
		try {
			logger.info("Clicking on Send Email Button");
			return click(buttonSendEmail);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

}
