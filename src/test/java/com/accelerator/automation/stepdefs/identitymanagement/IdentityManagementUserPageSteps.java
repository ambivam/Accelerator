package com.accelerator.automation.stepdefs.identitymanagement;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.identitymanagement.IdentityManagementHomePage;
import com.accelerator.automation.pages.identitymanagement.IdentityManagementUserPage;

import cucumber.api.java.en.When;

public class IdentityManagementUserPageSteps {
	IdentityManagementUserPage oimuserpage;
	IdentityManagementHomePage oimhomepage;
	private World world;

	public IdentityManagementUserPageSteps(World world) {
		this.world = world;
		oimuserpage = new IdentityManagementUserPage(world);
		oimhomepage = new IdentityManagementHomePage(world);
	}

	@When("I search for user with email in OIM application")
	public void i_search_for_user_with_email_in_OIM_application() throws Exception {
		try {

			// Write code here that turns the phrase above into concrete actions
			
			// click on manage
			oimhomepage.clickManage();
			// click on users
			oimhomepage.clickUsers();
			// select dropdown value
			oimuserpage.selectSearchDropDown("4");
			// entering email
			oimuserpage.enterSearchText(world.getExistingCustomerdetails().get("Email"));
			// clicking on search icon
			oimuserpage.clickOnSearchIcon();
			// click on userlogin
			oimuserpage.clickOnUserLogin();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@When("I search for user with customer email in OIM")
	public void i_search_for_user_with_customer_email_in_OIM() throws Exception {
		try {

			// Write code here that turns the phrase above into concrete actions
			oimuserpage = new IdentityManagementUserPage(world);
			oimhomepage = new IdentityManagementHomePage(world);
			// click on manage
			oimhomepage.clickManage();
			// click on users
			oimhomepage.clickUsers();
			// select dropdown value
			oimuserpage.selectSearchDropDown("4");
			// entering email
			oimuserpage.enterSearchText(world.getCustomerDetails().get("Email"));
			// clicking on search icon
			oimuserpage.clickOnSearchIcon();
			// click on userlogin
			oimuserpage.clickOnUserLogin();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
