package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartSuccessPage;

import cucumber.api.java.en.Then;

public class ShareACartSuccessPageSteps {
	private World world;

	public ShareACartSuccessPageSteps(World world){
		this.world=world;
	}
	ShareACartSuccessPage successPage;
	
	@Then("I verify sucesspage")
	public void i_verify_sucesspage() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		successPage = new ShareACartSuccessPage(this.world);
		successPage.verifySuccessPage("Success");
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I click on menu bar and view status")
	public void i_click_on_menu_bar_and_view_status() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		successPage.clickMenuBar();
		successPage.clickViewStatus();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

}
