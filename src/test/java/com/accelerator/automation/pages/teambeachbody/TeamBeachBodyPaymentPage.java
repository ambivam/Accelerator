package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;

public class TeamBeachBodyPaymentPage extends BasePage {
	private World world;
	ResourceBundle paymentPageElements = ResourceBundle
			.getBundle("com.beachbody.automation.elementlib.TBB.PaymentPage");
	Logger logger = LogManager.getLogger(TeamBeachBodyPaymentPage.class);
	WebDriver driver;
	
	By inputCCFname=By.xpath(paymentPageElements.getString("input_ccfName"));
	By inputCCLname=By.xpath(paymentPageElements.getString("input_cclName"));
	By inputCCNumber=By.xpath(paymentPageElements.getString("input_ccNum"));
	By inputCvv=By.xpath(paymentPageElements.getString("input_ccCVV"));
	By inputExpMonth=By.xpath(paymentPageElements.getString("select_ccMonth"));
	By inputExpYear=By.xpath(paymentPageElements.getString("select_ccYear"));
	By buttonContinue=By.xpath(paymentPageElements.getString("button_ccContinue"));

	public TeamBeachBodyPaymentPage(World world) {
		super(world, world.driver);
		this.world=world;
	}

	/*
	 * Verifying payment page
	 */
	private boolean verifyPaymentPage() throws Exception {
		try {
			logger.info("Verifying payment page");
			boolean result = verifyElementDisplayed(inputCCFname);
			return result;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering CC first name
	 */
	public boolean enter_CCFirstName(String ccfname) throws Exception {
		try {
			logger.info("Entering CC fisrt name");
			return enterText(inputCCFname, ccfname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering CC last name
	 */
	public boolean enter_CCLastName(String cclname) throws Exception {
		try {
			logger.info("Entering CC last name");
			return enterText(inputCCLname, cclname);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Credit card number
	 */
	public boolean enter_CCNumber(String ccno) throws Exception {
		try {
			logger.info("Entering CC last name");
			return enterText(inputCCNumber, ccno);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Credit card cvv
	 */
	public boolean enter_Cvv(String cvv) throws Exception {
		try {
			logger.info("Entering Card cvv");
			return enterText(inputCvv, cvv);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting Expire month
	 */
	public boolean selectExpMonth(String ccmonth) throws Exception {
		try {
			logger.info("Selecting expire month");
			return selectByValueinDropDown(inputExpMonth, ccmonth);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Selecting Expire year
	 */
	public boolean selectExpYear(String ccyear) throws Exception {
		try {
			logger.info("Selecting expire year");
			return selectByValueinDropDown(inputExpYear, ccyear);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Entering Credit card details
	 */
	public boolean enterCCDetails() throws Exception {
		try {
			logger.info("Entering user credit card details");
			// System.out.println("enter CCDetails");
			boolean result = verifyPaymentPage();
			if (result == false) {
				throw new Exception("CC Details not displaying");
			} else {
				boolean ccf = enter_CCFirstName("testing");
				world.setCreditDetails("CCFname", "testing");
				boolean ccl = enter_CCLastName("test");
				world.setCreditDetails("CCLname", "test");
				boolean ccn = enter_CCNumber("4111111111111111");
				boolean ccm = selectExpMonth("08");
				boolean ccy = selectExpYear("2024");
				boolean ccv = enter_Cvv("123");
				if (ccf && ccl && ccn && ccm && ccy && ccv == true) {
					return true;
				} else {
					throw new Exception("Credit details not updated");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * clicking on continue button
	 */
	public boolean clickccContinue() throws Exception {
		try {
			logger.info("Clicking on payment continue button");
			return click(buttonContinue);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean enterCreditDetails(String ccfname, String cclname, String cardno, String ccmonth, String ccyear,
			String cvv) throws Exception {
		try {
			logger.info("Entering credit card details");
			boolean result = verifyPaymentPage();
			if (result == false) {
				throw new Exception("Not able to see CC Details");
			} else {
				// TODO Auto-generated method stub
				boolean ccf = enter_CCFirstName(ccfname);
				world.setCreditDetails("CCFname", ccfname);
				boolean ccl = enter_CCLastName(cclname);
				world.setCreditDetails("CCLname", cclname);
				boolean ccn = enter_CCNumber(cardno);
				boolean ccm = selectExpMonth(ccmonth);
				boolean ccy = selectExpYear(ccyear);
				boolean ccv = enter_Cvv(cvv);
				if (ccf && ccl && ccn && ccm && ccy && ccv == true) {
					return true;
				} else {
					throw new Exception("Credit details not updated");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
