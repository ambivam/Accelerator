package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class TeamBeachBodyShippingPage extends BasePage {
	private World world;
	ResourceBundle productDetailsPageElemements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.ProductDetailsPage");
	ResourceBundle shippingPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.ShippingPage");
	Logger logger = LogManager.getLogger(TeamBeachBodyShippingPage.class);

	By buttonContinueToShipping = By.xpath(productDetailsPageElemements.getString("link_continueToShipping"));
	By inputFname = By.xpath(shippingPageElements.getString("input_firstName"));
	By inputLname = By.xpath(shippingPageElements.getString("input_lastName"));
	By inputPhone = By.xpath(shippingPageElements.getString("input_phoneNumber"));
	By inputAddress = By.xpath(shippingPageElements.getString("input_address1"));
	By inputZip = By.xpath(shippingPageElements.getString("input_zip"));
	By inputCity = By.xpath(shippingPageElements.getString("input_city"));
	By selectState = By.xpath(shippingPageElements.getString("select_state"));
	By buttonQASNo = By.xpath(shippingPageElements.getString("button_qasNo"));
	By selectShippingMethod = By.xpath(shippingPageElements.getString("select_shippingMethod"));
	By buttonContinue = By.xpath(shippingPageElements.getString("button_Continue"));
	By textShippingTaxes = By.xpath(shippingPageElements.getString("Validate_ShippingTaxes"));

	public TeamBeachBodyShippingPage(World world) {
		super(world, world.driver);
		this.world = world;
	}

	/*
	 * clicking on continue shipping button
	 */
	public boolean continueToShipping() throws Exception {
		try {
			logger.info("Clicking on continue to shipping button");
			return click(buttonContinueToShipping);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering first name
	 */
	public boolean enterFirstName(String fname) throws Exception {
		try {
			logger.info("Entering first name");
			return enterText(inputFname, fname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering last name
	 */
	public boolean enterLastName(String lname) throws Exception {
		try {
			logger.info("Entering last name");
			return enterText(inputLname, lname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering phone number
	 */
	public boolean enterPhoneNumber(String phone) throws Exception {
		try {
			logger.info("Entering phone number");
			return enterText(inputPhone, phone);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering shipping address
	 */
	public boolean enterShippingInfo(String fname, String lname, String phone, String address, String city,
			String state, String zip) throws Exception {
		boolean result = false;
		try {
			logger.info("Entering shipping address with user details");
			boolean data = verifyElementDisplayed(inputFname);
			if (data == true) {
				enterFirstName(fname);
				enterLastName(lname);
				enterPhoneNumber(phone);

				world.setCustomerDetails("FirstName", fname);
				world.setCustomerDetails("LastName", lname);
				world.setCustomerDetails("Phone", phone);

				result = true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}

	/*
	 * Entering address
	 */
	public boolean enterAddress(String address) throws Exception {
		try {
			logger.info("Entering address");
			return enterText(inputAddress, address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering zip
	 */
	public boolean enterZip(String zip) throws Exception {
		try {
			logger.info("Entering state");
			return enterText(inputZip, zip);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering city
	 */
	public boolean enterCity(String city) throws Exception {
		try {
			logger.info("Entering city");
			return enterText(inputCity, city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting state
	 */
	public boolean selectState(String state) throws Exception {
		try {
			logger.info("Selecting state");
			return selectByValueinDropDown(selectState, state);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterShippingAddress(String address, String city, String state, String zip) throws Exception {
		boolean result = false;
		try {
			logger.info("Entering shipping address details");
			boolean data = verifyElementDisplayed(inputAddress);
			if (data == true) {
				enterAddress(address);
				enterCity(city);
				selectState(state);
				enterZip(zip);
				// Click any object outside to show the QAS pop up
				click(selectShippingMethod);

				world.setCustomerDetails("Address1", address);
				world.setCustomerDetails("City", city);
				world.setCustomerDetails("State", state);
				world.setCustomerDetails("Zip", zip);

				result = true;
			} else {
				throw new Exception("Not entered to shipping page");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}

	/*
	 * Validating Address
	 */
	public boolean validateQASAddress() throws Exception {
		try {
			logger.info("Clicking QAaddress button");
			return click(buttonQASNo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting shipping
	 */
	public boolean selectShipping(String ship) throws Exception {
		try {
			logger.info("Selecting shipping method");
			boolean result = verifyElementDisplayed(selectShippingMethod);
			if (result == true) {
				return selectByValueinDropDown(selectShippingMethod, ship);
			} else {
				throw new Exception("Not selecting shipping method");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on continue button
	 */
	public boolean clickContinue() throws Exception {
		try {
			logger.info("Clicking on continue button");
			boolean ele = verifyElementDisplayed(buttonContinue);
			if (ele == true) {
				return click(buttonContinue);
			} else {
				throw new Exception("Not clicked on continue button");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Validating shipping taxes
	 */
	public boolean ValidateShippingHandlingTaxes() throws Exception {
		try {
			logger.info("Verifying shipping handling taxes");
			boolean result = verifyElementDisplayed(textShippingTaxes);
			if (result == true) {
				return true;
			} else {
				throw new Exception("Not navigated to Payment page");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
