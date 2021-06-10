package com.accelerator.automation.pages.bydesign;

import java.util.ResourceBundle;

import com.accelerator.automation.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import org.openqa.selenium.WebDriver;

/**
 * By Design Customer Details Page Functionality..
 */
public class ByDesignCustomerDetailsPage extends BasePage {

	ResourceBundle customerDetailsPageElements = ResourceBundle.getBundle("com.beachbody.automation.elementlib.BYDESIGN.CustomerDetailsPage");
	Logger logger = LogManager.getLogger(ByDesignCustomerDetailsPage.class);

	//By textCustomerInfo = By.xpath(customerDetailsPageElements.getString("text_Customer_Info"));
	By textOrderNumber = By.xpath(customerDetailsPageElements.getString("text_OrderNumber"));
	By textEmail = By.xpath(customerDetailsPageElements.getString("text_Email"));
	By textName = By.xpath(customerDetailsPageElements.getString("text_Name"));
	By textPhone = By.xpath(customerDetailsPageElements.getString("text_Phone"));
	//By textCompleteShippingAndBillingAddresss = By.xpath(customerDetailsPageElements.getString("text_Complete_Shipping_and_Billing_Address"));
	By textOrderDate = By.xpath(customerDetailsPageElements.getString("text_OrderDate"));
	By textNetwork = By.xpath(customerDetailsPageElements.getString("text_Network"));
	By textBillingAddress1 = By.xpath(customerDetailsPageElements.getString("text_BillingAddress1"));
	By textBillingAddress2 = By.xpath(customerDetailsPageElements.getString("text_BillingAddress2"));
	By textShippingAddress1 = By.xpath(customerDetailsPageElements.getString("text_ShippingAddress1"));
	By textShippingAddress2 = By.xpath(customerDetailsPageElements.getString("text_ShippingAddress2"));

	public ByDesignCustomerDetailsPage(World world, WebDriver driver) {
		super(world, driver);
	}

	/*public boolean verifyOtherCustomerDetails(String text) throws Exception {
		try {
			logger.info("Verifying customer details");
			return getTextFromElement(textCustomerInfo).equalsIgnoreCase(text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}*/

	/*public boolean verifyOrderDetails(String text) throws Exception {
		try {
			logger.info("Verifying order details");
			return getTextFromElement(textCustomerInfo).equalsIgnoreCase(text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}*/

	/*
	 * Click on order number
	 */
	public boolean clickOnOrderNumber() throws Exception {
		try {
			logger.info("Clicking on order number");
			return click(textOrderNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Email
	 */

	public String getEmail() throws Exception {
		try {
			logger.info("Getting email");
			String email = getTextFromElement(textEmail);
			return email;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting First Name
	 */

	public String getFirstName() throws Exception {
		try {
			logger.info("Getting First Name");
			String name = getTextFromElement(textName);
			String[] firstname = name.split(" ");
			return firstname[0];
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Last Name
	 */

	public String getLastName() throws Exception {
		try {
			logger.info("Getting Last Name");
			String name = getTextFromElement(textName);
			String[] lastname = name.split(" ");
			return lastname[1];
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Phone Number
	 */

	public String getPhoneNumber() throws Exception {
		try {
			logger.info("Getting Phone");
			String phone = getTextFromElement(textPhone);
			String phoneNumber = phone.replace('(', ' ').replace(')', ' ').replace('-', ' ').replaceAll(" ", "");
			return phoneNumber;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateCustomerDetails(String email, String fname, String lname, String phone) throws Exception {
		try {
			logger.info("Validating customer details");
			// Validate Email
			String Email = getEmail();
			if (!email.equalsIgnoreCase(Email)) {
				throw new RuntimeException("Email did not match");
			}
			// validate FirstName
			String FirstName = getFirstName();
			if (!fname.equalsIgnoreCase(FirstName)) {
				throw new RuntimeException("FirstName did not match");
			}
			// validate LastName
			String LastName = getLastName();
			if (!lname.equalsIgnoreCase(LastName)) {
				throw new RuntimeException("LastName did not match");
			}
			// validate Phone
			String Phone = getPhoneNumber();
			if (!phone.equalsIgnoreCase(Phone)) {
				throw new RuntimeException("Phone did not match");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying billing address
	 */
	/*public boolean verifyBillingAddress(String text) throws Exception {
		try {
			logger.info("Verifying billing address");
			return getTextFromElement(textCompleteShippingAndBillingAddresss).equalsIgnoreCase(text);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}*/

	public boolean verifyOrderDetails(String orderNo, String orderDate, String network, String fname, String lname)
			throws Exception {
		logger.info("Verifying order details");
		// Validate OrderNum
		String OrderNum = getOrderNumber();
		if (!orderNo.equalsIgnoreCase(OrderNum)) {
			throw new RuntimeException("OrderNumber did not match");
		}
		// validate OrderDate
		String OrderDate = getOrderDate();
		if (!orderDate.equalsIgnoreCase(OrderDate)) {
			throw new RuntimeException("OrderDate did not match");
		}
		// validate CustomerRole
		String CustomerRole = getCustomerRole();
		if (!network.equalsIgnoreCase(CustomerRole)) {
			throw new RuntimeException("CustomerRole did not match");
		}
		// validate FirstName
		String FirstName = getFirstName();
		if (!fname.equalsIgnoreCase(FirstName)) {
			throw new RuntimeException("FirstName did not match");
		}
		// validate LastName
		String LastName = getLastName();
		if (!lname.equalsIgnoreCase(LastName)) {
			throw new RuntimeException("LastName did not match");
		}
		return false;
	}

	/*
	 * Getting Order Number
	 */
	public String getOrderNumber() throws Exception {
		try {
			logger.info("Getting Order Number");
			String ordernum = getTextFromElement(textOrderNumber);
			return ordernum;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Order Date
	 */

	public String getOrderDate() throws Exception {
		try {
			logger.info("Getting Order Date");
			String orderdate = getTextFromElement(textOrderDate);
			return orderdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Customer Role
	 */

	public String getCustomerRole() throws Exception {
		try {
			logger.info("Getting Customer Role");
			String customerrole = getTextFromElement(textNetwork);
			return customerrole;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateBillingAddressUpdate(String billingAddress, String billingCity,String billingZip) throws Exception {
		logger.info("Validating billing address");
		// Validate address
		String Address = getBillingAddress();
		if (!billingAddress.equalsIgnoreCase(Address)) {
			throw new RuntimeException("Address did not match");
		}
		// validating city
		String City = getBillingCity();
		if (!billingCity.equalsIgnoreCase(City)) {
			throw new RuntimeException("city did not matched ");
		}
		// validating zipcode
		String zipcode = getBillingZipCode();
		if (!billingZip.equalsIgnoreCase(zipcode)) {
			throw new RuntimeException("zipcode did not matched ");
		}
		return false;
	}

	/*
	 * Getting Billing Address
	 */
	public String getBillingAddress() throws Exception {
		try {
			logger.info("Getting Billing Address1");
			String address1 = getTextFromElement(textBillingAddress1);
			return address1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Billing City
	 */

	public String getBillingCity() throws Exception {
		try {
			logger.info("Getting Billing City");
			String address2 = getTextFromElement(textBillingAddress2);
			String replacingBySpace = address2.replace(',', ' ').replaceAll(" ", " ");
			String[] city = replacingBySpace.split(" ");
			return city[0].trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Billing ZipCode
	 */

	public String getBillingZipCode() throws Exception {
		try {
			logger.info("Getting Billing City");
			String address2 = getTextFromElement(textBillingAddress2);
			String replacingBySpace = address2.replace(',', ' ').replaceAll(" ", " ");
			String[] city = replacingBySpace.split(" ");
			return city[3].trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateShippingAddressUpdate(String shippingAddress,String shippingCity,String shippingZip) throws Exception {
		logger.info("Validating shipping address");
		// Validate address
		String Address = getShippingAddress();
		if (!shippingAddress.equalsIgnoreCase(Address)) {
			throw new RuntimeException("Address did not match");
		}
		// validating city
		String City = getShippingCity();
		if (!shippingCity.equalsIgnoreCase(City)) {
			throw new RuntimeException("city did not matched ");
		}
		// validating zipcode
		String zipcode = getShippingZipCode();
		if (!shippingZip.equalsIgnoreCase(zipcode)) {
			throw new RuntimeException("zipcode did not matched ");
		}
		return false;
	}

	/*
	 * Getting Shipping Address
	 */
	public String getShippingAddress() throws Exception {
		try {
			logger.info("Getting Shipping Address1");
			String address = getTextFromElement(textShippingAddress1);

			return address;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Shipping City
	 */

	public String getShippingCity() throws Exception {
		try {
			logger.info("Getting Shipping Address2");
			String address2 = getTextFromElement(textShippingAddress2);
			String[] city = address2.split(" ");
			return city[0].trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Getting Shipping ZipCode
	 */
	public String getShippingZipCode() throws Exception {
		try {
			logger.info("Getting Shipping Address2");
			String address2 = getTextFromElement(textShippingAddress2);
			String[] city = address2.split(" ");
			return city[2].trim();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
