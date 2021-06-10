package com.accelerator.automation.stepdefs.shareacart;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartShopPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShareACartShopPageSteps {
private World world;
	
	public ShareACartShopPageSteps(World world){
		this.world=world;
	}
	ShareACartShopPage shopPage;
	
	@Then("I should be navigated to shop page")
	public void i_should_be_navigated_to_shop_page() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		shopPage = new ShareACartShopPage(this.world);
		shopPage.verifyShopPage("Shop");
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@When("I click on challenge pack menu")
	public void i_click_on_challenge_pack_menu() throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		shopPage.clickChallengePack();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I select challenge pack {string}")
	public void i_select_challenge_pack(String pack) throws Exception {
	try {
		
		// Write code here that turns the phrase above into concrete actions
		 shopPage.selectChallengePack(pack);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I select pack type {string}")
	public void i_select_pack_type(String packtype) throws Exception {
	try {
		// Write code here that turns the phrase above into concrete actions
		shopPage.selectChallengePackType(packtype);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
}
