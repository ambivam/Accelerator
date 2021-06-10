package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartCartPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShareACartCartPageSteps {
private World world;
	
	public ShareACartCartPageSteps(World world){
		this.world=world;
	}
	ShareACartCartPage cartPage;
	
	@Then("I should be navigated to cartpage")
	public void i_should_be_navigated_to_cartpage() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		cartPage=new ShareACartCartPage(this.world);
	    cartPage.verifyCartPage("Cart");
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I verify product,qty,price and subtotal")
	public void i_verify_product_qty_price_and_subtotal() {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("I select send email button")
	public void i_select_send_email_button() throws Exception {
	 try {
		// Write code here that turns the phrase above into concrete actions
		cartPage=new ShareACartCartPage(this.world);
	    cartPage.clickSendEmailButton();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}


}
