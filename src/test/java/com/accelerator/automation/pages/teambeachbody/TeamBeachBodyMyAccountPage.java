package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import com.accelerator.automation.utilities.CommonUtilities;

public class TeamBeachBodyMyAccountPage extends BasePage {

	public CommonUtilities Reusable = new CommonUtilities();
	ResourceBundle myAccountPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.MyAccount");
	private World world;

	Logger logger = LogManager.getLogger(TeamBeachBodyMyAccountPage.class);
	
	By textExistingEmail=By.xpath(myAccountPageElements.getString("input_existing_email"));
	By textPassword=By.xpath(myAccountPageElements.getString("input_existing_password"));
	By buttonSignIn=By.xpath(myAccountPageElements.getString("button_signin"));
	By textMyAccountTitle=By.xpath(myAccountPageElements.getString("title_myaccount"));
	By linkAddressEdit=By.xpath(myAccountPageElements.getString("button_address_edit"));
	By inputBillingAddress=By.xpath(myAccountPageElements.getString("input_address"));
	By inputBillingCity=By.xpath(myAccountPageElements.getString("input_city"));
	By inputBillingZip=By.xpath(myAccountPageElements.getString("input_zipcode"));
	By buttonUpdate=By.xpath(myAccountPageElements.getString("button_update"));
	By textUpdateSuccessMsg=By.xpath(myAccountPageElements.getString("text_updatesuccess"));
	By buttonClose=By.xpath(myAccountPageElements.getString("button_close"));
	By linkShipping=By.xpath(myAccountPageElements.getString("link_shipping_addrs"));
	By linkShippingEdit=By.xpath(myAccountPageElements.getString("button_shipping_edit"));
	By textShippingAddress=By.xpath(myAccountPageElements.getString("input_address"));
	By textShippingCity=By.xpath(myAccountPageElements.getString("input_city"));
	By textShippingZip=By.xpath(myAccountPageElements.getString("input_zipcode"));
	By linkWelcome=By.xpath(myAccountPageElements.getString("link_welcometest"));
	By linkSignout=By.xpath(myAccountPageElements.getString("link_signout"));
	By buttonAddressSuggession=By.xpath(myAccountPageElements.getString("button_address_suggestion"));
	By radioNo=By.xpath(myAccountPageElements.getString("radio_no_option"));
	By buttonShippingUpdate = By.xpath(myAccountPageElements.getString("button_shipping_update"));
	
	
	public TeamBeachBodyMyAccountPage(World world) {
		super(world, world.driver);
		this.world = world;
	}

	public boolean enterExistingEmail(String email) throws Exception {
		try {
			logger.info("Entering customer existing email");
			return enterText(textExistingEmail, email.trim());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterExistingPassword(String password) throws Exception {
		try {
			logger.info("Entering customer email");
			return enterText(textPassword, password.trim());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean signinDetails(String email, String password) throws Exception {
		try {
			boolean emailrs = enterExistingEmail(email);
			boolean passwordrs = enterExistingPassword(password);
			world.setExistingCustomerdetails("Email", email);
			if(emailrs && passwordrs==true) {
				return true;
			}
			else {
				throw new Exception("Unable to enter sign in details");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickOnSigninButton() throws Exception {
		try {
			logger.info("Clicking on signin button");
			return click(buttonSignIn);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyMyAccountPage() throws Exception {
		try {
			logger.info("Verifying myaccount page");
			return verifyElementDisplayed(textMyAccountTitle);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean accountAddressEditLink() throws Exception {
		try {
			logger.info("Click on address edit button");
			return click(linkAddressEdit);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterBillingAddress(String address) throws Exception {
		try {
			logger.info("Entering billing address");
			return enterText(inputBillingAddress, address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterBillingCity(String city) throws Exception {
		try {
			logger.info("Entering billing city");
			return enterText(inputBillingCity, city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterBillingZipCode(String zipcode) throws Exception {
		try {
			logger.info("Entering billiing zipcode");
			return enterText(inputBillingZip, zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean updateBillingAddress(String billingAddress, String billingCity, String billingZipCode)
			throws Exception {
		try {
			logger.info("Updating address with user details");
			boolean adressrs = enterBillingAddress(billingAddress);
			boolean cityrs = enterBillingCity(billingCity);
			boolean zipcoders = enterBillingZipCode(billingZipCode);

			world.setUpdateAccountDetails("BillingAddress", billingAddress);
			world.setUpdateAccountDetails("BillingCity", billingCity);
			world.setUpdateAccountDetails("BillingZip", billingZipCode);
			if (adressrs && cityrs && zipcoders == true) {
				return true;
			} else {
				throw new Exception("Billing address not updated");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// clicking on update button
	public boolean updateButton() throws Exception {
		try {
			logger.info("Clicking on update button");
			verifyElementDisplayed(buttonUpdate);
			return click(buttonUpdate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateUpdateSuccessfullMessage(String message) throws Exception {
		try {
			logger.info("Verifying update success message");
			String successMessage = getTextFromElement(textUpdateSuccessMsg);
			if (!successMessage.equalsIgnoreCase(message)) {
				throw new RuntimeException("success message did not matches");
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean closingPopUp() throws Exception {
		try {
			logger.info("Clicking on closing popup button");
			return click(buttonClose);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickOnShippingLink() throws Exception {
		try {
			logger.info("Clicking on shipping address link");
			return click(linkShipping);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean shippingAddrsEditLnk() throws Exception {
		try {
			logger.info("Clicking on shipping address edit");
			return click(linkShippingEdit);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterShippingAddress(String address) throws Exception {
		try {
			logger.info("Entering billing address");
			return enterText(textShippingAddress, address);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterShippingCity(String city) throws Exception {
		try {
			logger.info("Entering billing city");
			return enterText(textShippingCity, city);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterShippingZipCode(String zipcode) throws Exception {
		try {
			logger.info("Entering billiing zipcode");
			return enterText(textShippingZip, zipcode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean updateShippingAddrs(String shippingAddress, String shippingCity, String shippingZipCode)
			throws Exception {
		try {
			logger.info("Updating shipping address with user details");
			boolean adressrs = enterShippingAddress(shippingAddress);
			boolean cityrs = enterShippingCity(shippingCity);
			boolean zipcoders = enterShippingZipCode(shippingZipCode);

			world.setUpdateAccountDetails("ShippingAddress", shippingAddress);
			world.setUpdateAccountDetails("ShippingCity", shippingCity);
			world.setUpdateAccountDetails("ShippingZip", shippingZipCode);
			if (adressrs && cityrs && zipcoders == true) {
				return true;
			} else {
				throw new Exception("Shipping address not updated");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean logOut() throws Exception {
		try {
			logger.info("Clicking on signout button");
			boolean welcomers = click(linkWelcome);
			boolean signoutrs = click(linkSignout);
			if (welcomers && signoutrs == true) {
				return true;
			} else {
				throw new Exception("Not clicked on logout button");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean closingAddresSuggestionPopUp() throws Exception {
		try {
			logger.info("Closing on address suggestation popup");
			verifyElementDisplayed(buttonAddressSuggession);
			return click(buttonAddressSuggession);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean checkNoSubscriptionOrder() throws Exception {
		try {
			logger.info("clicking on subscription order radio button");
			return click(radioNo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean shippingUpdateButton() throws Exception {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			if (verifyElementDisplayed(buttonShippingUpdate) == true) {
				click(buttonShippingUpdate);
				result=true;
			}
		} catch (WebDriverException e) {
			// TODO: handle exception
			JavascriptExecutor js = (JavascriptExecutor) world;
			js.executeScript("arguments[0].click();", buttonShippingUpdate);
			result=true;
		}
		return result;

	}
}
