package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;

import com.accelerator.automation.utilities.ConfigFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import com.accelerator.automation.utilities.CommonUtilities;

public class TeamBeachBodyHomePage extends BasePage {
    private World world;
    public CommonUtilities Reusable = new CommonUtilities();
    ResourceBundle homePageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB.HomePage");
    Logger logger = LogManager.getLogger(TeamBeachBodyHomePage.class);

    By linkSignIn = By.xpath(homePageElements.getString("link_signin"));
    By linkMyAccount = By.xpath(homePageElements.getString("link_MyAccount"));
    By buttonHomePagePopup = By.xpath(homePageElements.getString("popup_HomePage"));
    By buttonBecomeCoach = By.xpath(homePageElements.getString("button_CoachSignup"));
    By textHomePageTitle = By.xpath(homePageElements.getString("text_HomePageTitle"));
    By mobile_textHomePageTitle = By.xpath(homePageElements.getString("mobile_text_HomePageTitle"));

    public TeamBeachBodyHomePage(World world) {
        super(world, world.driver);
        this.world = world;
    }


    /*
     * Navigates to Coach Home Page, URL will be retrieved from config properties
	 */
    public boolean navigateToTBBHomePage() throws Exception {
        try {
            logger.info("Navigating to Coach Office Login page");
            return navigateToWebPage(ConfigFileReader.getConfigFileReader().getTBBUrl());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // click on signin button
    public boolean clickOnSignin() throws Exception {
        try {
            logger.info("Clicking on signin button");
            return click(linkSignIn);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * clicking on myaccount
     */
    public boolean clickOnMyAccount() throws Exception {
        try {
            logger.info("Clicking on my account link");
            return click(linkMyAccount);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * clicking on menu
     */
    public boolean navigateToMenu(String menu) throws Exception {
        try {
            logger.info("Clicking on " + menu + "menu");
            if (world.isMobile()) {
                click(By.xpath(homePageElements.getString("mobile_grip")));
            }
            return click(By.xpath(homePageElements.getString("link_" + menu)));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    /*
     * clicking on submenu
     */
    public boolean navigateToSubMenu(String subMenu) throws Exception {
        try {
            logger.info("Clicking on" + subMenu + "submenu");
            return click(By.xpath(homePageElements.getString("link_" + subMenu)));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * closing the popup
     */
    public void closingHomePagePopUp() throws Exception {
        try {
            Thread.sleep(3000);
            if (isElementDisplayed(buttonHomePagePopup)) {
                click(buttonHomePagePopup);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
     * verifying home page
     */
    public boolean verifyHomePage() throws Exception {
        try {
            logger.info("Verifying homepage title");
            if (world.isMobile()) {
                if (verifyElementDisplayed(mobile_textHomePageTitle) == true) {
                    return true;
                } else {
                    throw new Exception("Not navigated to home page");
                }
            } else {
                if (verifyElementDisplayed(textHomePageTitle) == true) {
                    return true;
                } else {
                    throw new Exception("Not navigated to home page");
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting challenge pack
     */
    public boolean selectChallengePack(String packName) throws Exception {
        try {
            logger.info("Selecting challenge pack" + packName);
            String pack = homePageElements.getString("placeholder_button_Pack").replaceAll("PLACEHOLDER", packName);
            if (verifyElementDisplayed(By.xpath(pack)) == true) {
                click(By.xpath(pack));
                return true;
            } else {
                throw new Exception("Challenge pack not selected");
            }
        } catch (InterruptedException e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting challenge pack type
     */
    public boolean selectChallengePackType(String packType) throws Exception {
        try {
            logger.info("Selecting challenge pack type" + packType);
            String pack_type = homePageElements.getString("placeholder_button_PackType").replaceAll("PLACEHOLDER",
                    packType);
            return click(By.xpath(pack_type));
        } catch (InterruptedException e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Click on become a coach button
     */
    public boolean clickOnBecomeCoach() throws Exception {
        try {
            logger.info("Clicking on become a coach signup button");
            return click(buttonBecomeCoach);
        } catch (InterruptedException e) {
            throw new Exception(e.getMessage());
        }
    }

}
