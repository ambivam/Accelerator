package com.accelerator.automation.pages.shareacart;

import java.util.ArrayList;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartStatusPage extends BasePage {
	private World world;
	ResourceBundle shareACartStatusPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.shareACartStatusPageElements.SAC.StatusPage");
	Logger logger = LogManager.getLogger(ShareACartStatusPage.class);

	By linkSent = By.xpath(shareACartStatusPageElements.getString("link_Sent"));
	By textCustomerName=By.xpath(shareACartStatusPageElements.getString("text_CustomerName"));
	By textCustomerEmail=By.xpath(shareACartStatusPageElements.getString("text_CustomerEmail"));
	By textSent=By.xpath(shareACartStatusPageElements.getString("text_Sent"));
	By linkViewed = By.xpath(shareACartStatusPageElements.getString("link_Viewed"));
	By linkBack = By.xpath(shareACartStatusPageElements.getString("link_Back"));
    By buttonCopySharableLink=By.xpath(shareACartStatusPageElements.getString("button_CopyShareableLink"));
	
    public ShareACartStatusPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Clicking on Sent
	 */
	public boolean clickSent() throws Exception {
		try {
			logger.info("Clicking on Sent");
			return click(linkSent);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * verifying Order Details
	 */
	public boolean clickOrderDetails() throws Exception {
		try {
			logger.info("Clicking on Order Details");
			String orderEmail = world.getSACDetails().get("UserEmail");
			System.out.println(orderEmail);
			String orderDetail = shareACartStatusPageElements.getString("placeholder_button_OrderDetails")
					.replaceAll("PLACEHOLDER", orderEmail);
			return click(By.xpath(orderDetail));
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Verify customer name
	 */
	public boolean verifyCustomerName(String customername) {
		boolean result = false;
		try {
			logger.info("Verifying Customer Name");
			String CustomerName = getTextFromElement(textCustomerName);
			System.out.println(CustomerName);
			if (customername.equalsIgnoreCase(CustomerName)) {
				result = true;
			}
		} catch (Exception e1) {
			throw new RuntimeException("Customer Name not matched" + e1);
		}
		return result;
	}

	public boolean verifyCustomerEmail(String customeremail) {
		boolean result = false;
		try {
			logger.info("Verifying Customer Email");
			String CustomerEmail = getTextFromElement(textCustomerEmail);
			System.out.println(CustomerEmail);
			if (customeremail.equalsIgnoreCase(CustomerEmail)) {
				result = true;
			}
		} catch (Exception e1) {
			throw new RuntimeException("Customer Email not matched" + e1);
		}
		return result;
	}

	/*
	 * Verify customer status
	 */
	public boolean verifyCartStatus(String cartstatus) {
		boolean result = false;
		try {
			logger.info("Verifying Cart Status");
			String Status = getTextFromElement(textSent);
			System.out.println(Status);
			if (cartstatus.equalsIgnoreCase(Status)) {
				result = true;
			}
		} catch (Exception e1) {
			throw new RuntimeException("Customer Status not matched" + e1);
		}
		return result;
	}

	/*
	 * Clicking on Copy Sharable link
	 */
	public String clickCopyShareableLink() throws Exception {
		verifyElementDisplayed(buttonCopySharableLink);
		String url =getAttributeValueFromElement(buttonCopySharableLink, "onclick");
		String updated_url = url.replace("'", "").replace("http:", "https:").trim();
		System.out.println(updated_url);
		return updated_url;
	}

	public boolean openLinkInNewTab(String link) {
		((JavascriptExecutor) world.driver).executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs = new ArrayList<String>(world.driver.getWindowHandles());
		world.driver.switchTo().window((String) tabs.get(1));
		world.driver.get(link);
		return false;

	}

	/*
	 * Clicking on Viewed
	 */
	public boolean clickViewed() throws Exception {
		try {
			return click(linkViewed);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Clicking on back link
	 */
	public boolean clickOnBackLink() throws Exception {
		try {
			return click(linkBack);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

}
