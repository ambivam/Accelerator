package com.accelerator.automation.stepdefs.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeMyEFTMgmtPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoachOfficeMyEFTMgmtSteps {

	
	 private World world;
	 
	 public CoachOfficeMyEFTMgmtSteps(World world) { this.world = world; }
	  
	  CoachOfficeMyEFTMgmtPage coomyeftmgmtpage;
	  
	  @Then("I verify My EFT Management Page is displayed")
	  public void i_verify_My_EFT_Management_Page() throws Exception {
		  coomyeftmgmtpage= new CoachOfficeMyEFTMgmtPage(world);
		  coomyeftmgmtpage.verifyMyEFTManagementPage();  
	 
	 }
	 
	 @When("I select {string} and click on UPDATE INFORMATION button") 
	 public void i_select_and_click_on_UPDATE_INFORMATION_button(String Physical_Check) throws Exception {
		 coomyeftmgmtpage.selectPhysicalcheck(Physical_Check);
	     coomyeftmgmtpage.clickUpadateinformation(); }
	 
	 @When("I click on yes on EFT Management Confirmation pop up") 
	  public void i_click_on_yes_on_EFT_Management_Confirmation_pop_up() throws Exception {
	  coomyeftmgmtpage.clickYesoption(); 
	  }
	 
	 @Then("I verify changes saved message")
	 public void i_Verify_changes_saved_message() throws Exception { 
		 coomyeftmgmtpage.verifySuccessMsg(); 
	 }
	 
}