package com.accelerator.automation.stepdefs.bydesign;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.bydesign.ByDesignCoachDetailsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ByDesignCoachDetailsPageSteps {

	private World world;
	ByDesignCoachDetailsPage bydCoachDetails;

	public ByDesignCoachDetailsPageSteps(World world) {
		this.world = world;
		bydCoachDetails = new ByDesignCoachDetailsPage(world,world.ieDriver);
	}
	

	@When("I enter coachID and click on go")
	public void i_enter_coachID_and_click_on_go() throws Exception {
	try{		
		System.out.println(world.getCoachID().get("Coach_ID"));
		bydCoachDetails.enterCoachId(world.getCoachID().get("Coach_ID"));
		bydCoachDetails.clickGoButton();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I verify coach Id")
	public void i_verify_coach_Id() throws Exception {
	try {
		String coach = world.getCoachID().get("Coach_ID");
		bydCoachDetails.verifyCoachId(coach);
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }

	}

	@When("I click on Payout Method from left side menu")
	public void i_Click_on_Payout_Method_from_left_side_menu() throws Exception {
	try {
		bydCoachDetails.clickPayOutMethod();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

	@Then("I verify Payout Method is saved as {string}")
	public void i_verify_Payout_Method_is_saved_as(String string) throws Exception {
	try {
		bydCoachDetails.verifyPayOutMethod();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}

}
