package com.accelerator.automation.stepdefs.identitymanagement;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.identitymanagement.IdentityManagementHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IdentityManagementHomePageSteps {

	private World world;
	IdentityManagementHomePage oimhomepage;

	public IdentityManagementHomePageSteps(World world) throws Exception {
	try {
		this.world = world;
		oimhomepage=new IdentityManagementHomePage(world);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@When("I click on manage")
	public void i_click_on_manage() throws Exception {
	try {
		//clicking on manage button top right corner
		oimhomepage.clickManage();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@When("I click on users under administration")
	public void i_click_on_users_under_administration() throws Exception {
	try {
		// clicking on users image
		oimhomepage.clickUsers();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	
	@Then("I logout from OIM")
	public void i_logout_from_OIM() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		oimhomepage.signOut();
	}
}
