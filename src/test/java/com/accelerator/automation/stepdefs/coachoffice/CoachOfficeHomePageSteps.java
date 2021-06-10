package com.accelerator.automation.stepdefs.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Steps supporting Coach Office Home Page. All actions, validations as part of Coach office home page will be here.
 */
public class CoachOfficeHomePageSteps {

    private World world;
    CoachOfficeHomePage coachOfficeHomePage;
    

    /**
     * Constructor, Initialize required Pages
     */
    public CoachOfficeHomePageSteps(World world) {
        this.world = world;
        coachOfficeHomePage = new CoachOfficeHomePage(world);
    }

    /*
     * Navigate to coach home page
     **/
    @Then("I verify Coach Office home page is displayed")
    public void verifyHomePageDisplayed() throws Exception {
        try {
            coachOfficeHomePage.verifyHomePageLoaded();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    

    @When("I click on Grow My Business header")
    public void clickGrowMyBusiness() throws Exception {
        try {
            coachOfficeHomePage.clickGrowMyBusinessHeader();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Then("I verify Grow My Business menu options displayed")
    public void verifyGrowMyBusinessMenuOptions() throws Exception {
        try {
            coachOfficeHomePage.verifyGrowMyBusinessMenuOptionsDisplayed();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @When("I click on Send an Email link in Grow My Business section")
    public void clickSendAnEmailInGrowMyBusiness() throws Exception {
        try {
            coachOfficeHomePage.clickSendAnEmailInGrowMyBusiness();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @When("I get coach Id")
    public void i_get_coach_Id() throws Exception {
    	String coachID =coachOfficeHomePage.getCoachID(); 
    	System.out.println(coachID);
    	world.setCoachID("Coach_ID", coachID);
    	System.out.println(world.getCoachID().get("Coach_ID"));
        
    }

    @Then("I click on Monitor My Business")
    public void i_click_on_Monitor_My_Business() throws Exception {
    	coachOfficeHomePage.clickMonitorMyBusiness();
        
    }

    @And("I click on My EFT Management under Compensation")
    public void i_click_on_My_EFT_Management_under_Compensation() throws Exception {
    	coachOfficeHomePage.clickMyEFTManagement();
        
    }
}