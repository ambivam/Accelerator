package com.accelerator.automation.pages.coachoffice;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class CoachOfficeMyCustomersPage extends BasePage {

	ResourceBundle MyCustomersPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.MyCustomersPage");

	Logger logger = LogManager.getLogger(CoachOfficeMyCustomersPage.class);

	By textCustomer = By.xpath(MyCustomersPageElements.getString("textdata_Customer"));
	By inputEmail = By.xpath(MyCustomersPageElements.getString("input_Email"));
	By buttonSearch = By.xpath(MyCustomersPageElements.getString("button_Search"));
	By textJoindate = By.xpath(MyCustomersPageElements.getString("textdata_JoinDate"));
	By textFirstName = By.xpath(MyCustomersPageElements.getString("textdata_FirstName"));
	By textLastName = By.xpath(MyCustomersPageElements.getString("textdata_LastName"));
	By textCustomerId = By.xpath(MyCustomersPageElements.getString("textdata_CustomerID"));
	By textCustomerType = By.xpath(MyCustomersPageElements.getString("textdata_CustomerType"));
	By textCustomerSource = By.xpath(MyCustomersPageElements.getString("textdata_CustomerSource"));
	By textLastOrderDate = By.xpath(MyCustomersPageElements.getString("textdata_LastOrderDate"));
	By textEamil = By.xpath(MyCustomersPageElements.getString("textdata_Email"));
	By textPhone = By.xpath(MyCustomersPageElements.getString("textdata_Phone"));
	By buttonJoinDate = By.xpath(MyCustomersPageElements.getString("textdata_JoinDate"));
	By textHomedirect = By.xpath(MyCustomersPageElements.getString("textdata_HomeDirect"));
	By textlanguagePreference = By.xpath(MyCustomersPageElements.getString("textdata_LanguagePreference"));
	By textCustomerDetails = By.xpath(MyCustomersPageElements.getString("textdata_CustomerDetails"));
	By textSearchResults = By.xpath(MyCustomersPageElements.getString("textdata_SearchResults"));
	By textCustomerIdNumber = By.xpath(MyCustomersPageElements.getString("textdata_idNumber"));
	By textEmptyRow = By.xpath(MyCustomersPageElements.getString("textdata_EmptyResults"));
	// Shipping and Billing address fields
	By textshippingStreet1 = By.xpath(MyCustomersPageElements.getString("textdata_Street1"));
	By textShippingCity = By.xpath(MyCustomersPageElements.getString("textdata_City"));
	By textShippingZipcode = By.xpath(MyCustomersPageElements.getString("textdata_PostalCode"));
	By textBillingStreet = By.xpath(MyCustomersPageElements.getString("textdata_billing_street"));
	By textBillingCity = By.xpath(MyCustomersPageElements.getString("textdata_billing_city"));
	By textBillingZipcode = By.xpath(MyCustomersPageElements.getString("textdata_billing_zip"));

	public CoachOfficeMyCustomersPage(World world) {
		super(world, world.driver);
	}

	/*
	 * Verifying Customers page is loaded an element is displayed
	 */
	public boolean verifyCustomersPageLoaded() throws Exception {
		try {
			logger.info("Verifying Customers page loaded");
			return verifyElementDisplayed(textCustomer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering an email address
	 */
	public boolean enterEmailAddress(String email) throws Exception {
		try {
			logger.info("Entering an Email address");
			verifyElementPresence(inputEmail);
			enterText(inputEmail, email);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on search button
	 */
	public boolean clickSearch() throws Exception {
		try {
			logger.info("Clicking on search button");
			verifyElementPresence(buttonSearch);
			return click(buttonSearch);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying join date
	 */
	public String joinDate() throws Exception {
		try {
			logger.info("Verifying join date");
			return getTextFromElement(textJoindate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying first name
	 */
	public String firstName() throws Exception {
		try {
			logger.info("Verifying first name");
			return getTextFromElement(textFirstName);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying last name
	 */
	public String lastName() throws Exception {
		try {
			logger.info("Verifying last name");
			return getTextFromElement(textLastName);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying customer Id
	 */
	public String customerId() throws Exception {
		try {
			logger.info("Verifying customer Id ");
			return getTextFromElement(textCustomerId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying customerType
	 */
	public String customerType() throws Exception {
		try {
			logger.info("Verifying customerType ");
			return getTextFromElement(textCustomerType);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying customerSource
	 */
	public String customerSource() throws Exception {
		try {
			logger.info("Verifying customerSource ");
			return getTextFromElement(textCustomerSource);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying lastOrderDate
	 */
	public String lastOrderDate() throws Exception {
		try {
			logger.info("Verifying textdata_LastOrderDate ");
			return getTextFromElement(textLastOrderDate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying Email
	 */
	public String verifyEmailId() throws Exception {
		try {
			logger.info("Verifying Email ");
			return getTextFromElement(textEamil);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying phoneNumber
	 */
	public String phoneNumber() throws Exception {
		try {
			logger.info("Verifying phoneNumber ");
			return getTextFromElement(textPhone);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Clicking on join date button
	 */
	public boolean clickonTopJoindate() throws Exception {
		try {
			logger.info("Clicking on join date button");
			return click(buttonJoinDate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying homeDirect
	 */
	public String getHomeDirect() throws Exception {
		try {
			logger.info("Verifying home direct");
			return getTextFromElement(textHomedirect);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying langPref
	 */
	public String getLangPref() throws Exception {
		try {
			logger.info("Verifying language Preference");
			return getTextFromElement(textlanguagePreference);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying customer details
	 */
	public boolean verifyCustomerDetails(String text) throws Exception {
		try {
			logger.info("Verifying customer details");
			return getTextFromElement(textCustomerDetails).equalsIgnoreCase(text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying first name
	 */
	public boolean verifyfirstname(String fname) throws Exception {
		try {
			logger.info("Verifying first name");
			return getTextFromElement(textFirstName).equalsIgnoreCase(fname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying last name
	 */
	public boolean verifyBillingCity(String lname) throws Exception {
		try {
			logger.info("Verifying last name");
			return getTextFromElement(textLastName).equalsIgnoreCase(lname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying billing Phone number
	 */
	public boolean verifyPhonenumber(String PhoneNumber) throws Exception {
		try {
			logger.info("Verifying Phone number");
			return getTextFromElement(textPhone).equalsIgnoreCase(PhoneNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying Email
	 */
	public boolean verifyEmail(String Email) throws Exception {
		try {
			logger.info("Verifying Email");
			return getTextFromElement(textEamil).equalsIgnoreCase(Email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyCustomerDetails(String fname, String lname, String PhoneNumber, String Email)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Verifying first name");
			if (!verifyfirstname(fname)) {
				throw new RuntimeException("first name did not matched");
			}
			logger.info("Verifying last name");
			if (!verifyBillingCity(lname)) {
				throw new RuntimeException("last name did not matched");
			}
			logger.info("Verifying phone number");
			if (!verifyPhonenumber(PhoneNumber)) {
				throw new RuntimeException("PhoneNumber did not matched");
			}
			logger.info("Verifying email");
			if (!verifyEmail(Email)) {
				throw new RuntimeException("Email did not matched");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public boolean verifySearchResults() throws Exception {
		try {
			logger.info("Verifying search results");
			return verifyElementDisplayed(textSearchResults);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyshippingaddress(String address1) throws Exception {
		try {
			logger.info("Verifying shipping address");
			return getTextFromElement(textshippingStreet1).equalsIgnoreCase(address1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * 
	 */
	public boolean verifyshippincity(String city) throws Exception {
		try {
			logger.info("Verifying shipping city");
			return getTextFromElement(textShippingCity).equalsIgnoreCase(city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyshippingzipcode(String zipcode) throws Exception {
		try {
			logger.info("Verifying zipcode");
			return getTextFromElement(textShippingZipcode).equalsIgnoreCase(zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateshippingaddress(String shippingAddress,String shippingCity,String shippingZip) throws Exception {
		try {
			logger.info("Verifying address");
			if (!verifyshippingaddress(shippingAddress)) {
				throw new RuntimeException("Address did not matched");
			}
			logger.info("Verifying shipping city");
			if (!verifyshippincity(shippingCity)) {
				throw new RuntimeException("shipping city did not matched");
			}
			logger.info("Verifying zipcode");
			if (!verifyshippingzipcode(shippingZip)) {
				throw new RuntimeException("zipcode did not matched");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public boolean verifyBillingAddress(String address) throws Exception {
		try {
			logger.info("Verifying billing address");
			return getTextFromElement(textBillingStreet).equalsIgnoreCase(address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * 
	 */
	public boolean verifybillingcity(String city) throws Exception {
		try {
			logger.info("Verifying billing city");
			return getTextFromElement(textBillingCity).equalsIgnoreCase(city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyBillingzipcode(String zipcode) throws Exception {
		try {
			logger.info("Verifying billing zipcode");
			return getTextFromElement(textBillingZipcode).equalsIgnoreCase(zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateUpdatedBillingAddress(String billingAddress,String billingCity,String billingZip) throws Exception {
		try {
			logger.info("Verifying address");
			if (!verifyBillingAddress(billingAddress)) {
				throw new RuntimeException("Address did not matched");
			}
			logger.info("Verifying shipping city");
			if (!verifybillingcity(billingCity)) {
				throw new RuntimeException("shipping city did not matched");
			}
			logger.info("Verifying zipcode");
			if (!verifyBillingzipcode(billingZip)) {
				throw new RuntimeException("zipcode did not matched");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickOnCustomerID() throws Exception {
		try {
			logger.info("Clicking on customer ID");
			return click(textCustomerIdNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyResult() throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Clicking on customer ID");
			boolean result= verifyElementPresence(textEmptyRow);
			if(result==false) {
				return true;
			}
			else {
				throw new Exception("No search results found.");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}