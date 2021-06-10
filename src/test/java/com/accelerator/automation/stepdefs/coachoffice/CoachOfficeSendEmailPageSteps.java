package com.accelerator.automation.stepdefs.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeSendEmailPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Steps supporting Coach Office Home Page. All actions, validations as part of Coach office home page will be here.
 */
public class CoachOfficeSendEmailPageSteps {

    private World world;
    CoachOfficeSendEmailPage coachOfficeSendEmailPage;

    /**
     * Constructor, Initialize required Pages
     */
    public CoachOfficeSendEmailPageSteps(World world) {
        this.world = world;
        coachOfficeSendEmailPage = new CoachOfficeSendEmailPage(world);
    }

    /*
     * Navigate to coach home page
     **/
    @Then("I verify Send an Email page is displayed")
    public void verifyHomePageDisplayed() throws Exception {
        try {
            coachOfficeSendEmailPage.verifySendAnEmailPageLoaded();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
    * Select From And To
    * */
    @When("I select from email address as {string} and recipiants as {string}")
    public void selectEmailFromAndTo(String fromEmail, String recipient) throws Exception{
        try {
            coachOfficeSendEmailPage.selectEmailFromAndTo(fromEmail,recipient);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    

    @Then("I select couple of test customers and click on Compose button")
    public void i_select_couple_of_test_customers_and_click_on_Compose_button() throws Exception {
    	try {
    	coachOfficeSendEmailPage.clickCheckbox();
    	coachOfficeSendEmailPage.clickCompose();
    	} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @When("I enter email address {string} and subject {string} and body of the email {string} and click on SEND button")
    public void i_enter_email_address_and_subject_and_body_of_the_email_and_click_on_SEND_button(String emailid, String emailsub, String emailbody) throws Exception {
    	try {
    	coachOfficeSendEmailPage.enterEmailId(emailid);
    	coachOfficeSendEmailPage.enterEmailSubject(emailsub);
    	coachOfficeSendEmailPage.enterEmailbody(emailbody);
    	coachOfficeSendEmailPage.clickSendbutton();
    	} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Then("I verify snackbar sucess message")
    public void i_verify_snackbar_sucess_message() throws Exception {
    	try {
    	coachOfficeSendEmailPage.verifySnackbarmsg();
    	} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Then("I verify the emails are received by the test customers")
    public void i_verify_the_emails_are_received_by_the_test_customers() {
        
    }

}