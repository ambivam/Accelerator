package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartHomePage;
import cucumber.api.java.en.When;

public class ShareACartHomePageSteps {
private World world;
	
	public ShareACartHomePageSteps(World world){
		this.world=world;
	}
	
	ShareACartHomePage homepage;
	
	@When("I click on new enrollment button and navigated to start page")
	public void i_click_on_new_enrollment_button_and_navigated_to_start_page() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		homepage = new ShareACartHomePage(this.world);
		homepage.clickNewEnrollmentOrderButton();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
		
	}
}
