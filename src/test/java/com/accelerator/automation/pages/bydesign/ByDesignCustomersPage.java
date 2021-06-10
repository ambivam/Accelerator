package com.accelerator.automation.pages.bydesign;

import java.util.ResourceBundle;

import com.accelerator.automation.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.accelerator.automation.common.World;
import org.openqa.selenium.WebDriver;

/**
 * By Design Customers Page Functionality..
 */
public class ByDesignCustomersPage extends BasePage {
	ResourceBundle customersPageElements=ResourceBundle.getBundle("com.beachbody.automation.elementlib.BYDESIGN.CustomersPage");
	Logger logger = LogManager.getLogger(ByDesignCustomersPage.class);
	
	By textboxCustomerEmail=By.xpath(customersPageElements.getString("textbox_CustomerEmail"));
	By buttonSearch=By.xpath(customersPageElements.getString("button_Search"));
	By linkResultsTab=By.xpath(customersPageElements.getString("link_ResultsTab"));
	By tableResultsRow=By.xpath(customersPageElements.getString("table_ResultsRow"));
	By tableOrders=By.xpath(customersPageElements.getString("table_orders"));
	By buttonExpandContactInformation=By.xpath(customersPageElements.getString("button_expandContactInformation"));
	
	public ByDesignCustomersPage(World world, WebDriver driver){
		super(world,driver);
	}
		
	/*
	 * Entering email
	 */
	public boolean enterEmail(String email) throws Exception {
		try {
		logger.info("Entering email");
		verifyElementDisplayed(textboxCustomerEmail);
	    return enterText(textboxCustomerEmail,email );
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
			
	/*
	 * Clicking on search button
	 */
	public boolean clickOnSearch() throws Exception {
		try {
		logger.info("Clicking on search button");
	   return click(buttonSearch);
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
			
	/*
	 * Clicking on results tab
	 */
	public boolean clickOnResultsTab() throws Exception {
		try {
		logger.info("Clicking on results tab");
	   return click(linkResultsTab);
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean verifyCustomerDetails(String text) throws Exception {
		try {
		logger.info("Verifying customer details");
		//String verifycustdetails= getTextFromElement(tableResultsRow);
		//return verifycustdetails;
		return getTextFromElement(tableResultsRow).equalsIgnoreCase(text);
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
			
	/*
	 * Click on customer data
	 */
	public boolean clickOnCustomerData() throws Exception {
		try {
		logger.info("Clicking on customer data");
	   return click(tableResultsRow);
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * Clicking on Orders Tab
	 */
	
	public boolean clickOnOrdersTab() throws Exception {
		try {
		logger.info("Clicking on order tab");
		// TODO Auto-generated method stub
		return click(tableOrders);
		} catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public boolean clickOnExpandButton() throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Clicking on expand button in contact information");
			return click(buttonExpandContactInformation);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
