package com.accelerator.automation.stepdefs.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeLoginPage;
import com.beachbody.automation.pages.coachoffice.*;

import cucumber.api.java.en.Given;

/**
 * Steps supporting Coach Office Login Page. All actions, validations as part of Coach office login page will be here.
 */
public class CoachOfficeLoginSteps {

    private World world;
    CoachOfficeLoginPage coachOfficeLoginPagePage;

    /**
     * Constructor, Initialize required Pages
     */
    public CoachOfficeLoginSteps(World world) {
        this.world = world;
        coachOfficeLoginPagePage = new CoachOfficeLoginPage(world);
    }

    /*
     * Navigate to coach home page
     **/
    @Given("I am on Coach Office login page")
    public void navigateToCoachOfficeLoginPage() throws Exception {
        try {
            coachOfficeLoginPagePage.navigateToCoachLoginPage();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

    /*
     * Login Implemenation, in future if type of user(user/admin/executive) is required,
     * pass login type. Use Enums.
     * */
	
	 /*@When("I login as user in coach office") public void loginAsUser() throws
	  Exception { 
		 try { 
			 coachOfficeLoginPagePage.login(); 
			 } catch (Exception e) {
	  throw new Exception(e.getMessage()); } }
	 

}*/