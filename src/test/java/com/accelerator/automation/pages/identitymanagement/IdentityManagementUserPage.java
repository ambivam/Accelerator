package com.accelerator.automation.pages.identitymanagement;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class IdentityManagementUserPage extends BasePage {


	ResourceBundle usersPageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.OIM.UsersPage");
	Logger logger = LogManager.getLogger(IdentityManagementUserPage.class);
	By selectDropdown=By.xpath(usersPageElements.getString("dropdown_search"));
	By inputSearch=By.xpath(usersPageElements.getString("textbox_search"));
	By buttonSearch=By.xpath(usersPageElements.getString("image_search"));
	By linkLogin=By.xpath(usersPageElements.getString("text_userLogin"));
	By textUserRow=By.xpath(usersPageElements.getString("text_userRow"));
	

	public IdentityManagementUserPage(World world) {
		super(world,world.driver);
	}

	/*
	 * selecting search option from drop down
	 */
	public boolean selectSearchDropDown(String text) throws Exception {
		try {
			logger.info("Selecting email from dropdown");
			return selectByValueinDropDown(selectDropdown, text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * entering text in search box
	 */
	public boolean enterSearchText(String searchText) throws Exception {
		try {
			logger.info("Entering text in to search box");
			verifyElementDisplayed(inputSearch);
			return enterText(inputSearch, searchText);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * click on search icon
	 */
	public boolean clickOnSearchIcon() throws Exception {
		try {
			logger.info("Clicking on search icon");
			return click(buttonSearch);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * click on UserLogin link
	 */
	public boolean clickOnUserLogin() throws Exception {
		try {
			logger.info("Clicking on user login link");
			return click(linkLogin);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
	}

	/*
	 * verifying users page
	 */
	public boolean verifyUsersPage(String text) throws Exception {
		try {
			logger.info("Verifying users page");
			return getTextFromElement(textUserRow).equalsIgnoreCase(text);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
	}

}
