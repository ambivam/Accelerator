package com.accelerator.automation.stepdefs.teambeachbody;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyMyAccountPage;

import cucumber.api.java.en.Then;

public class TBB_MyAccountPageStepDefs {
  private World world;
  TeamBeachBodyMyAccountPage tbbMyAccountpage;
  
    public TBB_MyAccountPageStepDefs(World world) {
	this.world=world;	
	tbbMyAccountpage = new TeamBeachBodyMyAccountPage(this.world);
    }
	
	@Then("I enter the existing customer email {string} and password {string}")
	public void i_enter_the_existing_customer_email_and_password(String email, String password) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.signinDetails(email,password);	
	}
	
	@Then("I click on Sign in button")
	public void i_click_on_sign_in_Button() throws Exception {
		tbbMyAccountpage.clickOnSigninButton();
	}
	@Then("I click on edit link in Account Address")
	public void i_click_on_edit_link_in_Account_Address() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		  tbbMyAccountpage.verifyMyAccountPage();
		  tbbMyAccountpage.accountAddressEditLink();   
	}
	@Then("I change the Billing Address fileds {string}, {string} and {string}")
	public void i_change_the_Billing_Address_fileds_and(String billingAddress, String billingCity, String billingZipCode) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.updateBillingAddress(billingAddress,billingCity,billingZipCode);
	}
	
	@Then("I click on update button")
	public void i_click_on_update_button() throws Exception {
	    tbbMyAccountpage.updateButton();
	    tbbMyAccountpage.closingAddresSuggestionPopUp();
	    tbbMyAccountpage.updateButton();
	}
	
	@Then("I should validate {string} popup message  in ATG")
	public void i_should_validate_popup_message_in_ATG(String message) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.validateUpdateSuccessfullMessage(message);
	    tbbMyAccountpage.closingPopUp();
	}
	@Then("I click on Shipping Address link")
	public void i_click_on_Shipping_Address_link() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.clickOnShippingLink();
	    tbbMyAccountpage.shippingAddrsEditLnk();
	}
	@Then("I change the Shipping Address fileds {string},{string} and {string}")
	public void i_change_the_Shipping_Address_fileds_and(String shippingAddress, String shippingCity, String shippingZipCode) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.updateShippingAddrs(shippingAddress,shippingCity,shippingZipCode);	
	}

	@Then("I click on shipping address update button")
	public void i_click_on_shipping_address_update_button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		tbbMyAccountpage.checkNoSubscriptionOrder();
	    tbbMyAccountpage.shippingUpdateButton();
	    tbbMyAccountpage.closingAddresSuggestionPopUp();
	    tbbMyAccountpage.shippingUpdateButton();
	}
}
