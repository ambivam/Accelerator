package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartNewEnrollmentPage;
import com.accelerator.automation.utilities.CommonUtilities;

import cucumber.api.java.en.Then;

public class ShareACartNewEnrollmentPageSteps {
	private World world;
	CommonUtilities utilities;
	
	public ShareACartNewEnrollmentPageSteps(World world){
		this.world=world;
	}

	ShareACartNewEnrollmentPage newenrollmentpage;

	@Then("I enter customer email ,firstname and lastname")
	public void i_enter_customer_email_firstname_and_lastname() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		utilities = new CommonUtilities();
		newenrollmentpage = new ShareACartNewEnrollmentPage(this.world);
		utilities = new CommonUtilities();
		String newEmail = utilities.randomEmail();
	    String fName =randomString(6);
	    String lName = randomString(3);
		System.out.println("Email "+newEmail+" Fist Name "+fName+" Last Name "+lName);
		newenrollmentpage.enterNewEmailAddress(newEmail);
		newenrollmentpage.enterFirstName(fName);
		newenrollmentpage.enterLastName(lName);
		this.world.setSACDetails("UserEmail", newEmail);
		this.world.setSACDetails("FirstName", fName);
		this.world.setSACDetails("LastName", lName);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
		
	}

	private String randomString(int i) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Then("I select {string} and {string}")
	public void i_select_and(String Country, String PrefLang) throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		newenrollmentpage.selectCountry(Country);
		newenrollmentpage.selectPreferredLang(PrefLang);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I select new customer button")
	public void i_select_new_customer_button() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		newenrollmentpage = new ShareACartNewEnrollmentPage(this.world);
		newenrollmentpage.clickCustomerButton();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I accept the permissions and click on continue")
	public void i_accept_the_permissions_and_click_on_continue() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		newenrollmentpage.clickTermsCheckBox();
		newenrollmentpage.clickContinue();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
}
