package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class TeamBeachBodyAccountPage extends BasePage {
	private World world;
	public String mail;
	ResourceBundle accountPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.AccountPage");

	ResourceBundle shippingPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.ShippingPage");
	Logger logger = LogManager.getLogger(TeamBeachBodyAccountPage.class);

	By inputEmail = By.xpath(accountPageElements.getString("input_AccEmail"));
	By inputConfirmEmail = By.xpath(accountPageElements.getString("input_reenterEmail"));
	By inputPassword = By.xpath(accountPageElements.getString("input_password"));
	By inputConfirmPassword = By.xpath(accountPageElements.getString("input_reenterpassword"));
	By selectMonth = By.xpath(accountPageElements.getString("select_birthMonth"));
	By selectDate = By.xpath(accountPageElements.getString("select_birthDay"));
	By selectYear = By.xpath(accountPageElements.getString("select_birthYear"));
	By selectMale = By.xpath(accountPageElements.getString("radio_genderMale"));
	By selectFemale = By.xpath(accountPageElements.getString("radio_genderFemale"));

	By textSubTotal = By.xpath(shippingPageElements.getString("text_SubTotal"));
	By textTotal = By.xpath(shippingPageElements.getString("text_Total"));
	By textTax = By.xpath(shippingPageElements.getString("text_Tax"));
	By textSnH = By.xpath(shippingPageElements.getString("text_SnH"));

	By buttonCoachYes = By.xpath(accountPageElements.getString("button_coachYes"));
	By buttonCoachNo = By.xpath(accountPageElements.getString("button_coachNo"));
	By selectCoachType = By.xpath(accountPageElements.getString("select_coachType"));
	By inputCoachEmail = By.xpath(accountPageElements.getString("input_coachSearch"));
	By checkboxContinuityDisclaimer = By.xpath(accountPageElements.getString("checkbox_ContinuityDisclaimer"));
	By checkboxTerms = By.xpath(accountPageElements.getString("checkbox_termsAndConditions"));
	By buttonSubmitOrder = By.xpath(accountPageElements.getString("button_submitOrder"));
	By textOrderNumber = By.xpath(accountPageElements.getString("text_orderNumber"));

	public TeamBeachBodyAccountPage(World world) {
		super(world, world.driver);
		this.world = world;
	}

	/*
	 * Verifying account email
	 */
	public boolean verifyAccountEmail() throws Exception {
		try {
			logger.info("Verifying account email field");
			return verifyElementDisplayed(inputEmail);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting email
	 */
	public String getEmail() throws Exception {
		try {
			logger.info("Getting email field value");
			String email = getAttributeValueFromElement(inputEmail, "value");
			return email;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering confirmation email
	 */
	public boolean enterConfirmEmail() throws Exception {
		try {
			logger.info("Entering confirmation email");
			String email = getEmail();
			return enterText(inputConfirmEmail, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering password
	 */
	public boolean enterPassword(String password) throws Exception {
		try {
			logger.info("Entering password");
			return enterText(inputPassword, password);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering confirmation password
	 */
	public boolean enterConfirmPassword(String password) throws Exception {
		try {
			logger.info("Entering confirmation password");
			return enterText(inputConfirmPassword, password);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting birth month
	 */
	public boolean selectBirthMonth(String dob) throws Exception {
		try {
			logger.info("Selecting birth month");
			return selectByValueinDropDown(selectMonth, dob.split("-")[0]);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting birth date
	 */
	public boolean selectBirthDay(String dob) throws Exception {
		try {
			logger.info("Selecting birth date");
			return selectByValueinDropDown(selectDate, dob.split("-")[1]);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting birth year
	 */
	public boolean selectBirthYear(String dob) throws Exception {
		try {
			logger.info("Selecting birth year");
			return selectByValueinDropDown(selectYear, dob.split("-")[2]);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on male option
	 */
	public boolean clickMale() throws Exception {
		try {
			logger.info("Clicking on male radio button");
			return click(selectMale);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on female option
	 */
	public boolean clickFemale() throws Exception {
		try {
			logger.info("Clicking on female radio button");
			return click(selectFemale);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting subtotal value
	 */
	public String getSubTotal() throws Exception {
		try {
			logger.info("Getting subtotal value");
			String subtotal = getTextFromElement(textSubTotal);
			return subtotal.trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting total value
	 */
	public String getTotal() throws Exception {
		try {
			logger.info("Getting total value");
			String total = getTextFromElement(textTotal);
			return total.trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting tax value
	 */
	public String getTax() throws Exception {
		try {
			logger.info("Getting tax value");
			String tax = getTextFromElement(textTax);
			return tax.trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting SnH value
	 */
	public String getSnH() throws Exception {
		try {
			logger.info("Getting SnH value");
			String snh = getTextFromElement(textSnH);
			return snh.trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Creating account
	 */
	public boolean createAccount(String rEmail, String password, String rpassword, String dob, String gender)
			throws Exception {
		try {
			logger.info("Creating account with user details");
			// verifying account page
			boolean result = verifyAccountEmail();
			if (result == true) {
				// get email
				String email = getEmail();
				// enterting confirmation email
				boolean remailrs = enterConfirmEmail();
				// entering password
				boolean passwdrs = enterPassword(password);
				// entering reenter password
				boolean rpasswdrs = enterConfirmPassword(password);
				// Entering DOB
				boolean monthrs = selectBirthMonth(dob);
				boolean dayrs = selectBirthDay(dob);

				boolean yearrs = selectBirthYear(dob);
				// Save all the values
				world.setCustomerDetails("Email", email);

				// Select the appropriate gender
				if (gender.equalsIgnoreCase("male")) {
					clickMale();
				} else {
					clickFemale();
				}

				// Read all the order details
				world.setOrderDetails("SubTotal", getSubTotal());
				world.setOrderDetails("Total", getTotal());
				world.setOrderDetails("Tax", getTax());
				world.setOrderDetails("SnH", getSnH());

				if (remailrs && rpasswdrs && monthrs && dayrs && yearrs == true) {
					return true;
				} else {
					throw new Exception("Not entered account details");
				}

			} else {
				throw new Exception("Not navigated account page");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on coach yes button
	 */
	public boolean clickCoachYes() throws Exception {
		try {
			logger.info("Clicking on coach yes button");
			return click(buttonCoachYes);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on coach no button
	 */
	public boolean clickCoachNo() throws Exception {
		try {
			logger.info("Clicking on coach no button");
			return click(buttonCoachNo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting Coach option
	 */
	public boolean selectCoachWithType(String type) throws Exception {
		try {
			logger.info("Selecting coach with" + type);
			return selectByValueinDropDown(selectCoachType, type);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering coach email
	 */
	public boolean enterCoachEmail(String email) throws Exception {
		try {
			logger.info("Entering coach email");
			return enterText(inputCoachEmail, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Select the coach option
	 */
	public boolean selectCoachOption(String option) throws Exception {
		boolean result = false;
		try {
			logger.info("Selecting coach option" + option + " for the customer");
			if (option.equalsIgnoreCase("no")) {
				clickCoachNo();
				result = true;
			} else {
				clickCoachYes();
				// Select the type of search for coach to email
				selectCoachWithType("email");

				// Enter the coach email id
				enterCoachEmail("wave11uscoach19@yopmail.com");
				// Click on yes again to trigger event
				clickCoachYes();
				result = true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}

	/*
	 * Clicking on continuity disclaimer checkbox
	 */
	public boolean clickContinuityDisclaimerCheckbox() throws Exception {
		try {
			logger.info("Clicking on ContinuityDisclaimer Checkbox");
			return click(checkboxContinuityDisclaimer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on terms and conditions checkbox
	 */
	public boolean clickTermsConditionsCheckbox() throws Exception {
		try {
			logger.info("Clicking on Terms and Conditions Checkbox");
			return click(checkboxTerms);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Select all the checkboxes
	 */
	public boolean acceptCheckboxes() throws Exception {
		logger.info("Clicking on disclaimer and terms conditions checkboxes");
		boolean rs1 = clickContinuityDisclaimerCheckbox();
		boolean rs2 = clickTermsConditionsCheckbox();
		if (rs1 && rs2 == true) {
			return true;
		} else {
			throw new Exception("Not clicking on disclaimer and terms checkboxes");
		}
	}

	// Submit the order and wait for process to finish
	public boolean clickSubmitOrderButton() throws Exception {
		try {
			logger.info("Clicking on Submit Order Button");
			return click(buttonSubmitOrder);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying order number
	 */
	public boolean verifyOrderNumber() throws Exception {
		try {
			logger.info("Verifying order number prsence");
			return verifyElementPresence(textOrderNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting order number
	 */
	public String getOrderNumber() throws Exception {
		try {
			logger.info("Getting order number");
			String orderno = getTextFromElement(textOrderNumber);
			return orderno;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Saving order number
	 */
	public boolean saveOrderNumber() throws Exception  {
		boolean result = false;		
		try {
			logger.info("Saving order number");
			boolean order = verifyOrderNumber();
			if (order == true) {
				System.out.println(world.getCustomerDetails());
				System.out.println(world.getOrderDetails());
				// Save the value for other tests to use
				world.setOrderNum(getOrderNumber());
				result = true;
			} else {
				throw new Exception("Order number not displayed");
			}

		} catch (Exception e1) {
			throw new RuntimeException("order no not saved" + e1);
		}
		return result;
	}

}
