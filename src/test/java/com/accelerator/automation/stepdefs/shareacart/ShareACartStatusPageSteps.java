package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartStatusPage;
import cucumber.api.java.en.Then;

public class ShareACartStatusPageSteps {
	private World world;

	public ShareACartStatusPageSteps(World world) {
		this.world = world;
	}

	ShareACartStatusPage statuspage;

	@Then("I go to view sent page and verify name , email and {string}")
	public void i_go_to_view_sent_page_and_verify_name_email_and(String cartstatus) throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		statuspage = new ShareACartStatusPage(this.world);
		statuspage.clickSent();
		statuspage.clickOrderDetails();
		String name = this.world.getSACDetails().get("FirstName") + this.world.getSACDetails().get("LastName");
		String email = this.world.getSACDetails().get("UserEmail");
		System.out.println(name + " " + email);
		statuspage.verifyCustomerName(name);
		statuspage.verifyCustomerEmail(email);
		statuspage.verifyCartStatus(cartstatus);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I copy sharable link and paste it on next tab")
	public void i_copy_sharable_link_and_paste_it_on_next_tab() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		statuspage = new ShareACartStatusPage(this.world);
		String sharable_link = statuspage.clickCopyShareableLink();
		statuspage.openLinkInNewTab(sharable_link);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I go to viewed page and verify name , email and {string}")
	public void i_go_to_viewed_page_and_verify_name_email_and(String cart_status) throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		statuspage = new ShareACartStatusPage(this.world);
		statuspage.clickViewed();
		statuspage.clickOrderDetails();
		String name = this.world.getSACDetails().get("FirstName") + this.world.getSACDetails().get("LastName");
		String email = this.world.getSACDetails().get("UserEmail");
		System.out.println(name + " " + email);
		statuspage.verifyCustomerName(name);
		statuspage.verifyCustomerEmail(email);
		statuspage.verifyCartStatus(cart_status);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I navigate back to order details page")
	public void i_navigate_back_to_order_details_page() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		statuspage = new ShareACartStatusPage(this.world);
		statuspage.clickOnBackLink();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }

	}
}
