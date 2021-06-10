package com.accelerator.automation.stepdefs.identitymanagement;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.identitymanagement.IdentityManagementUserDetailsPage;

import cucumber.api.java.en.Then;

public class IdentityManagementUserDetailsSteps {

	private World world;
	IdentityManagementUserDetailsPage oimuserdetails;

	public IdentityManagementUserDetailsSteps(World world) {
		this.world = world;
		oimuserdetails = new IdentityManagementUserDetailsPage(this.world);
	}

	@Then("I should validate Billing and Shipping adressess in OIM")
	public void i_should_validate_Billing_and_Shipping_adressess_in_OIM() throws Exception {
		try {
			// Write code here that turns the phrase above into concrete actions
			
			String billingAddress = world.getUpdateAccountDetails().get("BillingAddress");
			String billingCity = world.getUpdateAccountDetails().get("BillingCity");
			String billingZip = world.getUpdateAccountDetails().get("BillingZip");
			String shippingAddress = world.getUpdateAccountDetails().get("ShippingAddress");
			String shippingCity = world.getUpdateAccountDetails().get("ShippingCity");
			String shippingZip = world.getUpdateAccountDetails().get("ShippingZip");
			oimuserdetails.verifyBillingAddress(billingAddress, billingCity, billingZip);
			oimuserdetails.verifyShippingAddress(shippingAddress, shippingCity, shippingZip);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Then("I should be able to validate the customer details in OIM")
	public void i_should_be_able_to_validate_the_customer_details_in_OIM() throws Exception{
		try {
//			oimuserdetails = new IdentityManagementUserDetailsPage(this.world);
			String fname = world.getCustomerDetails().get("FirstName");
			String lname = world.getCustomerDetails().get("LastName");
			String phone = world.getCustomerDetails().get("Phone");
			String email = world.getCustomerDetails().get("Email");
			oimuserdetails.validateCustomerDetails(fname, lname, phone, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
