package com.accelerator.automation.stepdefs.bydesign;

import java.util.ResourceBundle;

import com.accelerator.automation.utilities.ConfigFileReader;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.bydesign.ByDesignCustomersPage;

import cucumber.api.java.en.When;

public class ByDesignCustomerPageSteps {

	private World world;
	ByDesignCustomersPage bydcustomerpage;
	ResourceBundle configLib;

	public ByDesignCustomerPageSteps(World world) {
		// TODO Auto-generated constructor stub		
		this.world=world;
		bydcustomerpage = new ByDesignCustomersPage(world,world.ieDriver);
		//world.driver = world.getIEDriver();
	}
		
	
	@When("I search for customer with email in ByDesign")
	public void i_search_for_customer_with_in_ByDesign() throws Exception {
	try {
		bydcustomerpage.navigateToWebPage(ConfigFileReader.getConfigFileReader().getBYDSearchUrl());
		bydcustomerpage.enterEmail(world.getCustomerDetails().get("Email"));
		bydcustomerpage.clickOnSearch();
		bydcustomerpage.clickOnResultsTab();
		bydcustomerpage.clickOnCustomerData();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
		
	@When("I search for customer with email in ByDesign application")
	public void i_search_for_customer_with_email_in_ByDesign_application() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		bydcustomerpage.navigateToWebPage(ConfigFileReader.getConfigFileReader().getBYDSearchUrl());		
		bydcustomerpage.enterEmail(world.getExistingCustomerdetails().get("Email"));
		bydcustomerpage.clickOnSearch();
		bydcustomerpage.clickOnResultsTab();
		bydcustomerpage.clickOnCustomerData();
		bydcustomerpage.clickOnExpandButton();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	}