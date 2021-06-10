
package com.accelerator.automation.pages.identitymanagement;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class IdentityManagementUserDetailsPage extends BasePage {
	private World world;
	ResourceBundle userDetailsPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.OIM.UsersDetails");
	Logger logger = LogManager.getLogger(IdentityManagementUserDetailsPage.class);
	By textFname=By.xpath(userDetailsPageElements.getString("text_firstName"));
	By textLname=By.xpath(userDetailsPageElements.getString("text_lastName"));
	By textPhone=By.xpath(userDetailsPageElements.getString("text_phoneNum"));
	By textEmail=By.xpath(userDetailsPageElements.getString("text_Email"));
	By textLanguage=By.xpath(userDetailsPageElements.getString("text_preferencesLocale"));
	By textAttributes=By.xpath(userDetailsPageElements.getString("text_otherAttributes"));
	By textBillingStreet=By.xpath(userDetailsPageElements.getString("text_billing_address1"));
	By textBillingCity=By.xpath(userDetailsPageElements.getString("text_billing_city"));
	By textBillingZip=By.xpath(userDetailsPageElements.getString("text_billing_zipcode"));
	By textShippingStreet=By.xpath(userDetailsPageElements.getString("text_shipping_address1"));
	By textShippingCity=By.xpath(userDetailsPageElements.getString("text_shipping_city"));
	By textShippingZip=By.xpath(userDetailsPageElements.getString("text_shipping_zipcode"));

	public IdentityManagementUserDetailsPage(World world) {
		super(world, world.driver);
	}

	/*
	 * verifying first name
	 */
	public boolean verifyFirstName(String fname) throws Exception {
		try {
			logger.info("Verifying first name");
			return getTextFromElement(textFname)
					.equalsIgnoreCase(fname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying last name
	 */

	public boolean verifyLastName(String lname) throws Exception {
		try {
			logger.info("Verifying last name");
			return getTextFromElement(textLname)
					.equalsIgnoreCase(lname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying telephone number
	 */
	public boolean verifyTelephoneNumber(String number) throws Exception {
		try {
			logger.info("Verifying telephone number");
			return getTextFromElement(textPhone).trim()
					.equalsIgnoreCase(number.trim());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyEmail(String email) throws Exception {
		try {
			logger.info("Verifying email");
			return getTextFromElement(textEmail)
					.equalsIgnoreCase(email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * verify preference language
	 */
	public boolean verifyPreferencesLocale(String prelocale) throws Exception {
		try {
			logger.info("Verifying language preference");
			return getTextFromElement(textLanguage).trim()
					.equalsIgnoreCase(prelocale.trim());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying other attributes
	 */
	public boolean verifyOtherAttributes(String otherattributes) throws Exception {
		try {
			logger.info("Verifying other attributes");
			return getTextFromElement(textAttributes).trim()
					.equalsIgnoreCase(otherattributes.trim());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateCustomerDetails(String fname, String lname, String phone, String email) throws Exception {
		try{
			if (!verifyFirstName(fname)) {
				throw new RuntimeException("First name did not match");
			}
			if (!verifyLastName(lname)) {
				throw new RuntimeException("Last name did not match");
			}
			if (!verifyTelephoneNumber(phone)) {
				throw new RuntimeException("Phone did not match");
			}
			if (!verifyEmail(email)) {
				throw new RuntimeException("Email did not match");
			}
			    return true;
		}catch(Exception e) {
				throw new Exception(e.getMessage());
		}
      
	}
	
	/*
	 * verifying billing address street
	 */
	public boolean verifyBillingAddressStreet(String address) throws Exception {
		try {
			logger.info("Verifying billing address street");
			return getTextFromElement(textBillingStreet)
					.equalsIgnoreCase(address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * verifying billing city
	 */
	public boolean verifyBillingCity(String city) throws Exception {
		try {
			logger.info("Verifying billing address city");
			return getTextFromElement(textBillingCity)
					.equalsIgnoreCase(city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * verifying billing zip code
	 */
	public boolean verifyBillingZip(String zipcode) throws Exception {
		try {
			logger.info("Verifying billing address zipcode");
			return getTextFromElement(textBillingZip)
					.equalsIgnoreCase(zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean verifyBillingAddress(String address,String city,String zip) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Verifying billing address");
			if (!verifyBillingAddressStreet(address)) {
				throw new RuntimeException("address did not matched");
			}
			logger.info("Verifying billing city");
			if (!verifyBillingCity(city)) {
				throw new RuntimeException("city did not matched");
			}
			logger.info("Verifying billing zipcode");
			if (!verifyBillingZip(zip)) {
				throw new RuntimeException("zipcode did not matched");
			}
				return true;
		}catch(Exception e) {
				throw new Exception(e.getMessage());
		} 
	}

	/*
	 * verifying shipping address street
	 */
	public boolean verifyShippingAddressStreet(String address) throws Exception {
		try {
			logger.info("Verifying shipping address street");
			return getTextFromElement(textShippingStreet)
					.equalsIgnoreCase(address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * verifying shipping city
	 */
	public boolean verifyShippingCity(String city) throws Exception {
		try {
			logger.info("Verifying shipping address city");
			return getTextFromElement(textShippingCity)
					.equalsIgnoreCase(city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * verifying shipping zip code
	 */
	public boolean verifyShippingZip(String zipcode) throws Exception {
		try {
			logger.info("Verifying shipping address zipcode");
			return getTextFromElement(textShippingZip)
					.equalsIgnoreCase(zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean verifyShippingAddress(String address, String city,String zip) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Verifying shipping address");
			if (!verifyShippingAddressStreet(address)) {
				throw new RuntimeException("address did not matched");
			}
			logger.info("Verifying shipping city");
			if (!verifyShippingCity(city)) {
				throw new RuntimeException("city did not matched");
			}
			logger.info("Verifying shipping zipcode");
			if (!verifyShippingZip(zip)) {
				throw new RuntimeException("zipcode did not matched");
			}
				return true;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}