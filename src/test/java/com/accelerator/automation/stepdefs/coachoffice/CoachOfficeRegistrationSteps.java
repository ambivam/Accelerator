package com.accelerator.automation.stepdefs.coachoffice;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeRegistrationPage;
import com.accelerator.automation.utilities.ConfigFileReader;
import org.testng.Assert;

import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyAccountPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyHomePage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyPaymentPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyProductDetailspage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyShippingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoachOfficeRegistrationSteps {

	private World world;

	CoachOfficeRegistrationPage cooRegistration;
	TeamBeachBodyHomePage tbbHome;
	TeamBeachBodyProductDetailspage tbbProductDetails;
	TeamBeachBodyShippingPage tbbShippingPage;
	TeamBeachBodyPaymentPage tbbPaymentPage;
	TeamBeachBodyAccountPage tbbAccountPage;
	
	public CoachOfficeRegistrationSteps(World world) {
		this.world = world;
		cooRegistration = new CoachOfficeRegistrationPage(this.world);
		tbbHome = new TeamBeachBodyHomePage(this.world);
		tbbShippingPage = new TeamBeachBodyShippingPage(this.world);
		tbbProductDetails = new TeamBeachBodyProductDetailspage(this.world);
		tbbPaymentPage = new TeamBeachBodyPaymentPage(this.world);
		tbbAccountPage = new TeamBeachBodyAccountPage(this.world);
	}

	
	
	@Given("I am on COO home page")
	public void i_am_on_COO_home_page() {
		world.driver.manage().deleteAllCookies();
		world.driver.get(ConfigFileReader.getConfigFileReader().getCOOUrl());
		world.driver.manage().window().maximize();
		String page_title ="Sign In – Coach Office";
		Assert.assertEquals(world.driver.getTitle().trim(), page_title.trim(), "Not launched COO Application");
		
	}

	@When("I click on Become Coach Link")
	public void i_click_on_Become_Coach_Link() throws Exception {
		// clicking on signup link
		cooRegistration.clickSignUpLink();
	}

	@Then("signup page should be displayed")
	public void signup_page_should_be_displayed() throws Exception {
		cooRegistration = new CoachOfficeRegistrationPage(this.world);
		cooRegistration.verifySignUpStatus("in-progress");
	}

	@Then("I enter my information {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_enter_my_information(String country, String language, String pswd, String phone, String month,
			String day, String year, String govtid, String sign) throws Exception {
		cooRegistration.fillInfo(country, language, pswd, phone, month, day, year, govtid, sign);
		cooRegistration.clickNoCoachButton();
		cooRegistration.clickDisclaimerCheckBox();
		cooRegistration.clickTermsCheckBox();
	}

	@When("I click on Continue")
	public void i_click_on_Continue() throws Exception {
		cooRegistration.clickContinueButton();
	}

	@Then("Coach registered sucessfully and navigated to challenge pack step")
	public void coach_registered_sucessfully_and_navigated_to_challenge_pack_step() throws Exception {
		cooRegistration.verifySignUpStatus("finished");
		cooRegistration.verifyChallengePackStatus("in-progress");
	}

	@When("I selects challenge pack {string}")
	public void i_selects_challenge_pack(String pack) throws Exception {
		tbbHome.selectChallengePack(pack);
	}

	@When("I selects {string} for buying")
	public void i_selects_for_buying(String packType) throws Exception {
		tbbHome.selectChallengePackType(packType);
	}

	@When("I fill product details with {string},{string},{string} , {string} and {string} options")
	public void i_fill_product_details_with_and_options(String flavor, String packaging, String recover,
			String recovpackaging, String qty) throws Exception {
		tbbProductDetails.selectFlavor(flavor);
		tbbProductDetails.selectPackaging(packaging);
		tbbProductDetails.selectRecover(recover);
		tbbProductDetails.selectRecoverPackaging(recovpackaging);
		tbbProductDetails.selectQuantity(qty);
	}

	@When("I click on select and continue to cart")
	public void i_click_on_select_and_continue_to_cart() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		tbbProductDetails.clickAddToCart();

	}

	@Then("Navigated to topsellers step")
	public void navigated_to_topsellers_step() throws Exception {
		cooRegistration.verifyChallengePackStatus("finished");
		cooRegistration.verifyTopSellersStatus("in-progress");
	}

	@When("I click on no thanks complete my enrollment button")
	public void i_click_on_no_thanks_complete_my_enrollment_button() throws Exception {
		tbbProductDetails.clickNoThanksButton();
	}

	@When("I click on continue to shopping")
	public void i_click_on_continue_to_shopping() throws Exception {
		tbbShippingPage.continueToShipping();
	}

	@Then("I enter my shipping information {string},{string},{string},{string}")
	public void i_enter_my_shipping_information(String address, String city, String state, String zip)
			throws Exception {
		//tbbShippingPage = new TeamBeachBodyShippingPage(this.world);
		tbbShippingPage.enterShippingAddress(address, city, state, zip);
	}

	@Then("I validates the QAS address")
	public void i_validates_the_QAS_address() throws Exception {
		tbbShippingPage.validateQASAddress();
	}

	@Then("I select shipping option {string} and click on continue")
	public void i_select_shipping_option_and_click_on_continue(String shipping) throws Exception {
		tbbShippingPage.selectShipping(shipping);
		tbbShippingPage.clickContinue();
	}

	@Then("I enter payment information {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_enter_payment_information(String ccfname, String cclname, String cardno, String ccmonth,
			String ccyear, String cvv) throws Exception {
		//tbbPaymentPage = new TeamBeachBodyPaymentPage(this.world);
		tbbPaymentPage.enterCreditDetails(ccfname, cclname, cardno, ccmonth, ccyear, cvv);
		// tbbPaymentPage.enterCCDetails();
	}

	@Then("I click on submit")
	public void i_click_on_submit() throws Exception {
		tbbAccountPage.acceptCheckboxes();
		tbbAccountPage.clickSubmitOrderButton();
	}

	/*
	 * Shakeology step
	 */
	@Then("I click on No thanks button to navigate to shakeology step")
	public void i_click_on_No_thanks_button_to_navigate_to_shakeology_step() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		//tbbProductDetails= new TeamBeachBodyProductDetailspage(this.world);
		tbbProductDetails.clickNoThanksButton();
		cooRegistration.verifyShakeologyStatus("in-progress");
	}

}
