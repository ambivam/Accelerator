package com.accelerator.automation.pages.coachoffice;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class CoachOfficeMyOrdersPage extends BasePage {

	ResourceBundle CustomerordersPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.COO.MyOrdersPage");
	Logger logger = LogManager.getLogger(CoachOfficeMyOrdersPage.class);
	
	By textOrders = By.xpath(CustomerordersPageElements.getString("textdata_Order"));
	By inputOrderNumber = By.xpath(CustomerordersPageElements.getString("input_OrderNumber"));
	By buttonSearch = By.xpath(CustomerordersPageElements.getString("button_Search"));
	By textOrderDate = By.xpath(CustomerordersPageElements.getString("textdata_OrderDate"));
	By textCustomerId = By.xpath(CustomerordersPageElements.getString("textdata_CustomerID"));
	By textFname = By.xpath(CustomerordersPageElements.getString("textdata_FirstName"));
	By textLname = By.xpath(CustomerordersPageElements.getString("textdata_LastName"));
	By textOrderId = By.xpath(CustomerordersPageElements.getString("textdata_OrderID"));
	By textHomeDirect = By.xpath(CustomerordersPageElements.getString("textdata_HomeDirect"));
	By textEamil = By.xpath(CustomerordersPageElements.getString("textdata_Email"));
	By textAmunt = By.xpath(CustomerordersPageElements.getString("textdata_Amount"));
	By textPhone = By.xpath(CustomerordersPageElements.getString("textdata_Phone"));
	By textStatus = By.xpath(CustomerordersPageElements.getString("textdata_Status"));
	By textVolume = By.xpath(CustomerordersPageElements.getString("textdata_Volume"));
	By textTracking = By.xpath(CustomerordersPageElements.getString("textdata_Tracking"));
	By buttonOrderDate = By.xpath(CustomerordersPageElements.getString("textdata_OrderDate"));
	By textProducts = By.xpath(CustomerordersPageElements.getString("textdata_Products"));
	By textOrderType = By.xpath(CustomerordersPageElements.getString("textdata_OrderType"));

	public CoachOfficeMyOrdersPage(World world) {
		super(world, world.driver);

	}

	public boolean verifyOrdersPageLoaded() throws Exception {
		try {
			logger.info("Verifying orders page loaded");
			return verifyElementDisplayed(textOrders);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering an order number
	 */
	public boolean enterOrdernumber(String orderNumber) throws Exception {
		try {
			logger.info("Entering an order number");
			enterText(inputOrderNumber, orderNumber);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickSearch() throws Exception {
		try {
			logger.info("Clicking on search button");
			return click(buttonSearch);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Verifying order date
	 */
	public String getOrderDate() throws Exception {
		try {
			logger.info("Verifying order date");
			return getTextFromElement(textOrderDate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying customer Id
	 */
	public String getCustomerId() throws Exception {
		try {
			logger.info("Verifying customer ID");
			return getTextFromElement(textCustomerId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * verifying first name
	 */
	public String getFirstName() throws Exception {
		try {
			logger.info("Verifying first name");
			return getTextFromElement(textFname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getLastName() throws Exception {
		try {
			logger.info("Verifying last name");
			return getTextFromElement(textLname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getOrderNumber() throws Exception {
		try {
			logger.info("Verifying ordernumber ");
			return getTextFromElement(textOrderId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getHomedirect() throws Exception {
		try {
			logger.info("Verifying homedirect ");
			return getTextFromElement(textHomeDirect);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getEmail() throws Exception {
		try {
			logger.info("Verifying email ");
			return getTextFromElement(textEamil);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getAmount() throws Exception {
		try {
			logger.info("Verifying amount ");
			return getTextFromElement(textAmunt);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getPhonenumber() throws Exception {
		try {
			logger.info("Verifying phonenumber ");
			return getTextFromElement(textPhone);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getStatus() throws Exception {
		try {
			logger.info("Verifying Status ");
			return getTextFromElement(textStatus);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getVolume() throws Exception {
		try {
			logger.info("Verifying volume ");
			return getTextFromElement(textVolume);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getTrackingNumber() throws Exception {
		try {
			logger.info("Verifying TrackingNumber ");
			return getTextFromElement(textTracking);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickonTopJoindate() throws Exception {
		try {
			logger.info("Clicking on order date ");
			return click(buttonOrderDate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getProducts() throws Exception {
		try {
			logger.info("Verifying products ");
			return getTextFromElement(textProducts);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getOrderType() throws Exception {
		try {
			logger.info("Verifying orderType ");
			return getTextFromElement(textOrderType);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyfirstname(String fname) throws Exception {
		try {
			logger.info("Verifying first name");
			return getTextFromElement(textFname).equalsIgnoreCase(fname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	
	 */
	public boolean verifylastname(String lname) throws Exception {
		try {
			logger.info("Verifying last name");
			return getTextFromElement(textFname).equalsIgnoreCase(lname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyOrderdate(String orderNumber) throws Exception {
		try {
			logger.info("Verifying order number");
			return getTextFromElement(textOrderId).equalsIgnoreCase(orderNumber);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyEmailId(String EmailId) throws Exception {
		try {
			logger.info("Verifying email id");
			return getTextFromElement(textEamil).equalsIgnoreCase(EmailId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyPhonenumber(String Phone) throws Exception {
		try {
			logger.info("Verifying Phone number");
			return getTextFromElement(textPhone).equalsIgnoreCase(Phone);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean verifyAmount(String Amount) throws Exception {
		try {
			logger.info("Verifying Amount");
			return getTextFromElement(textAmunt).equalsIgnoreCase(Amount);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean validateOrderDetails(String fname, String lname, String orderNumber, String EmailId, String Phone,
			String Amount) throws Exception {
		try {
			logger.info("Verifying firtname");
			if (!verifyfirstname(fname)) {
				throw new RuntimeException("first did not matched");
			}
			logger.info("Verifying last name");
			if (!verifylastname(lname)) {
				throw new RuntimeException("did not matched");
			}
			logger.info("Verifying order ");
			if (!verifyOrderdate(orderNumber)) {
				throw new RuntimeException("order date did not matched");
			}
			logger.info("Verifying emailid");
			if (!verifyEmailId(EmailId)) {
				throw new RuntimeException("Emailid did not matched");
			}
			logger.info("Verifying phone number");
			if (!verifyPhonenumber(Phone)) {
				throw new RuntimeException("Phone number did not matched");
			}
			logger.info("Verifying Amount");
			if (!verifyAmount(Amount)) {
				throw new RuntimeException("Amount did not matched");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}