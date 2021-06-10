package com.accelerator.automation.stepdefs.bydesign;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.bydesign.ByDesignCustomerDetailsPage;

import cucumber.api.java.en.Then;

public class ByDesignCustomerDetailsPageSteps {

	private World world;
	ByDesignCustomerDetailsPage bydcustomerdetailspage;

	public ByDesignCustomerDetailsPageSteps(World world) {
		// TODO Auto-generated constructor stub
		this.world = world;
		bydcustomerdetailspage = new ByDesignCustomerDetailsPage(world,world.ieDriver);
	}

	
	@Then("I should be able to validate the customer details in ByDesign")
	public void i_should_be_able_to_validate_the_customer_details_in_ByDesign() throws Exception {
	try {		
		String fname = world.getCustomerDetails().get("FirstName");
		String lname = world.getCustomerDetails().get("LastName");
		String phone = world.getCustomerDetails().get("Phone");
		String email = world.getCustomerDetails().get("Email");
		bydcustomerdetailspage.validateCustomerDetails(email, fname, lname, phone);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	@Then("I should validate Billing and Shipping adressess in ByDesign")
	public void i_should_validate_Billing_and_Shipping_adressess_in_ByDesign() throws Exception {
	 try {
		// Write code here that turns the phrase above into concrete actions
//		 bydcustomerdetailspage=new ByDesignCustomerDetailsPage(this.world);
		 String billingAddress=world.getUpdateAccountDetails().get("BillingAddress");
		 String billingCity =world.getUpdateAccountDetails().get("BillingCity");
		 String billingZip=world.getUpdateAccountDetails().get("BillingZip");
		 bydcustomerdetailspage.validateBillingAddressUpdate(billingAddress, billingCity, billingZip);
		 String shippingAddress=world.getUpdateAccountDetails().get("ShippingAddress");
		 String shippingCity =world.getUpdateAccountDetails().get("ShippingCity");
		 String shippingZip=world.getUpdateAccountDetails().get("ShippingZip");
		 bydcustomerdetailspage.validateShippingAddressUpdate(shippingAddress, shippingCity, shippingZip);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	
	@Then("I should be able to validate the order details in ByDesign")
	public void i_should_be_able_to_validate_the_order_details_in_ByDesign() throws Exception {
	try {
		bydcustomerdetailspage.clickOnOrderNumber();
		String orderNo=world.getCustomerDetails().get("OrderNum");
		String orderDate =world.getCustomerDetails().get("OrderDate");
		String network=world.getCustomerDetails().get("CustomerRole");
		String fname =world.getCustomerDetails().get("FirstName");
		String lname=world.getCustomerDetails().get("LastName");
		bydcustomerdetailspage.verifyOrderDetails(orderNo, orderDate, network, fname, lname);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

}