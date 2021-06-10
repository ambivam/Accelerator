package com.accelerator.automation.pages.shareacart;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class ShareACartShopPage extends BasePage {

	ResourceBundle shareACartShopPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.shareACartShopPageElements.SAC.ShopPage");
	Logger logger = LogManager.getLogger(ShareACartShopPage.class);

	By textShopTitle = By.xpath(shareACartShopPageElements.getString("title_Shop"));
	By optionChallengePack = By.xpath(shareACartShopPageElements.getString("option_ChallengePacks"));

	public ShareACartShopPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Verifying Shop page title
	 */

	public boolean verifyShopPage(String shoppage) throws Exception {
		boolean result = false;
		try {
			logger.info("Verifying Shop Page Title");
			if (shoppage.equalsIgnoreCase(getTextFromElement(textShopTitle))) {
				result = true;
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
		return result;
	}

	/*
	 * Clicking on Challenge Pack
	 */
	public boolean clickChallengePack() throws Exception {
		try {
			logger.info("Clicking on Challenge Pack");
			return click(optionChallengePack);
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

	/*
	 * Selecting challenge pack
	 */
	public boolean selectChallengePack(String packName) throws Exception {
		// driverUtils.pause();
		// Thread.sleep(3000);
		try {
		String pack = shareACartShopPageElements.getString("placeholder_select_ChallengePack").replaceAll("PLACEHOLDER",
				packName);
			logger.info("Selecting Challenge Pack");
			if ((By.xpath(pack)) != null) {
				click(By.xpath(pack));
			}
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
			//e.printStackTrace();
		}
		return false;
	}

	/*
	 * Selecting challenge pack type
	 */
	public boolean selectChallengePackType(String packType) throws Exception {
		// driverUtils.pause();
		try {
		logger.info("Selecting Challenge Pack Type");
		String pack = shareACartShopPageElements.getString("placeholder_select_ChallengePackType")
				.replaceAll("PLACEHOLDER", packType);
	    verifyElementDisplayed(By.xpath(pack));
		return true;
		} catch(Exception e1) {
			throw new Exception(e1.getMessage());
		}
	}

}
