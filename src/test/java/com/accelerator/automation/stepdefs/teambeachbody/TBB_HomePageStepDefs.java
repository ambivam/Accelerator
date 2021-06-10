package com.accelerator.automation.stepdefs.teambeachbody;

import com.accelerator.automation.common.World;
import com.accelerator.automation.utilities.CommonUtilities;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyAccountPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyCheckOutPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyHomePage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyPaymentPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyProductDetailspage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyShippingPage;
import com.accelerator.automation.pages.teambeachbody.TeamBeachBodyShoppingCartPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TBB_HomePageStepDefs {

    private World world;

    public TBB_HomePageStepDefs(World world) {
        this.world = world;
        tbbHome = new TeamBeachBodyHomePage(world);
        tbbproductDetailsPage = new TeamBeachBodyProductDetailspage(world);
        tbbShoppingCartPage = new TeamBeachBodyShoppingCartPage(world);
        tbbCheckoutPage = new TeamBeachBodyCheckOutPage(world);
        tbbPaymentPage = new TeamBeachBodyPaymentPage(world);
        tbbAccountPage = new TeamBeachBodyAccountPage(world);
        tbbproductDetailsPage = new TeamBeachBodyProductDetailspage(world);
        utilities = new CommonUtilities();
    }

    TeamBeachBodyHomePage tbbHome;
    TeamBeachBodyProductDetailspage tbbproductDetailsPage;
    TeamBeachBodyShoppingCartPage tbbShoppingCartPage;
    TeamBeachBodyCheckOutPage tbbCheckoutPage;
    TeamBeachBodyShippingPage tbbShippingPage;
    TeamBeachBodyPaymentPage tbbPaymentPage;
    TeamBeachBodyAccountPage tbbAccountPage;
    CommonUtilities utilities;


    @Given("I am on TBB home page")
    public void i_am_on_TBB_home_page() throws Exception {
        // launching tbb on browser
        tbbHome.navigateToTBBHomePage();
        //world.driver.get(ConfigFileReader.getConfigFileReader().getTBBUrl());
        // maximizing the browser
        //world.driver.manage().window().maximize();
        String page_title = "Shop Fitness Programs, Nutritional Products, Gear & Apparel | Team Beachbody US";
        Assert.assertEquals("Not lauched in TBB URL", page_title.trim(), world.driver.getTitle().trim());
        // closing the popup on home page
        tbbHome.closingHomePagePopUp();
        // verifying home page
        tbbHome.verifyHomePage();
    }

    @When("I select Challenge pack {string}")
    public void i_select_Challenge_pack(String pack) throws Exception {
        // navigating to menu
        tbbHome.navigateToMenu("Shop");
        // navigating to sub menu
        tbbHome.navigateToSubMenu("ChallengePacks");
        // selecting a pack
        utilities.pause();
        tbbHome.selectChallengePack(pack);
    }

    @When("I select {string} for buying")
    public void i_select_for_buying(String packType) throws Exception {
        // selecting pack type
        tbbHome.selectChallengePackType(packType);
    }

    @When("I add to cart with {string},{string},{string},{string} and {string} options")
    public void i_add_to_cart_with_and_options(String flavor, String packaging, String recover, String RPacking,
                                               String qty) throws Exception {
        // validating PDP Page on product details page
        tbbproductDetailsPage.verifyPDPPage();
        // Selecting flavour on product details page
        tbbproductDetailsPage.selectFlavor(flavor);
        // Selecting Packaging on product details page
        tbbproductDetailsPage.selectPackaging(packaging);
        // selecting recover on product details page
        tbbproductDetailsPage.selectRecover(recover);
        // selecting recovering packaging
        tbbproductDetailsPage.selectRecoverPackaging(RPacking);
        // selecting quantity on product details page
        tbbproductDetailsPage.selectQuantity(qty);
        // Clicking Add to cart button
        // tbbproductDetailsPage.clickAddToCart();
        tbbproductDetailsPage.clickAddItemToCart();
    }

    @When("I view my cart")
    public void i_view_my_cart() throws Exception {
        // clicking view cart button
        tbbproductDetailsPage.clickViewCart();
    }

    @Then("I should be able to validate Title, Qty, Price and Order summary")
    public void i_should_be_able_to_validate_Title_Qty_Price_and_Order_summary() throws Exception {
        // validating title on shopping cart page
        tbbShoppingCartPage.validateTitle();
        // validating Quantity on shopping cart page
        tbbShoppingCartPage.validateQuantity();
        // validating Price on shopping cart page
        tbbShoppingCartPage.validatePrice();
        // validating Summary on shopping cart page
        tbbShoppingCartPage.validateSummary();
    }

    @Then("I should be able to validate {string} and {string}")
    public void i_should_be_able_to_validate_and(String subtotal, String estimatedtotal) throws Exception {
        // validating subtotal and estimated total
        tbbShoppingCartPage.validateSubTotal_EstimatedTotal(subtotal, estimatedtotal);
    }

    @When("I checkout")
    public void i_checkout() throws Exception {
        // clicking on checkout button
        tbbShoppingCartPage.clickCheckout();
    }

    @Then("I should be able to provide email to begin checkout")
    public void i_should_be_able_to_provide_to_begin_checkout() throws Exception {
        tbbCheckoutPage = new TeamBeachBodyCheckOutPage(world);
        // providing random email and clicking on begin checkout button
        tbbCheckoutPage.beginCheckout();
    }

    @When("I skip offers to continue shopping")
    public void i_skip_offers_to_continue_shopping() throws Exception {
        tbbShippingPage = new TeamBeachBodyShippingPage(world);
        // clicking on continue shipping
        tbbShippingPage.continueToShipping();
    }

    @When("I enter my shipping information {string},{string},{string},{string},{string},{string},{string}")
    public void i_enter_my_shipping_information(String fname, String lname, String phone, String address, String city,
                                                String state, String zip) throws Exception {
        // entering shipping details
        tbbShippingPage.enterShippingInfo(fname, lname, phone, address, city, state, zip);
        tbbShippingPage.enterShippingAddress(address, city, state, zip);
    }

    @When("validate the QAS address")
    public void validate_the_QAS_address() throws Exception {
        // validating Address
        tbbShippingPage.validateQASAddress();
    }

    @When("I select shipping option as {string} to continue")
    public void i_select_shipping_option_as_to_continue(String ship) throws Exception {
        // Selecting shipping
        tbbShippingPage.selectShipping(ship);
        // clicking on continue button
        tbbShippingPage.clickContinue();
    }

    @Then("shipping & handling and taxes should be updated")
    public void shipping_handling_and_taxes_should_be_updated() throws Exception {
        // Validating shipping handling taxes
        tbbShippingPage.ValidateShippingHandlingTaxes();
    }

    @Then("when I enter payment details to continue")
    public void when_I_enter_payment_details_to_continue() throws Exception {
        // entering CC details
        tbbPaymentPage.enterCCDetails();
        // clicking on continue button
        tbbPaymentPage.clickccContinue();
    }

    @Then("I create an account with {string},{string},{string},{string}")
    public void i_create_an_account_with(String rEmail, String password, String dob, String gender) throws Exception {

        // creating account
        tbbAccountPage.createAccount(rEmail, password, password, dob, gender);
    }

    @Then("I select {string} as option for coach")
    public void i_select_as_option_for_coach(String option) throws Exception {
        tbbAccountPage.selectCoachOption(option);
    }

    @Then("I submit order")
    public void i_submit_order() throws Exception {
        // selecting check box
        tbbAccountPage.acceptCheckboxes();
        // clicking on submit button
        tbbAccountPage.clickSubmitOrderButton();
    }

    @Then("I should be able to see a successful order placement with an Order ID")
    public void i_should_be_able_to_see_a_successful_order_placement_with_an_Order_ID() throws Exception {
        // Saving order number
        tbbAccountPage.saveOrderNumber();
    }


    @When("I click on MyAccount under Sign In link on the global header")
    public void i_click_on_MyAccount_under_Sign_In_link_on_the_global_header() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        tbbHome.clickOnSignin();
        tbbHome.clickOnMyAccount();
    }

    // Click on become coach from TBB site
    @When("I click on become a coach from coach menu")
    public void i_click_on_become_a_coach_from_coach_menu() throws Exception {
        // navigating to menu
        tbbHome.navigateToMenu("Coach");
        // click become coach button
        tbbHome.clickOnBecomeCoach();
    }

    @When("I select Shakeology pack {string}")
    public void i_select_Shakeology_pack(String pack) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        tbbHome.selectChallengePack(pack);
    }

    @Then("I add to cart shakeology order with {string},{string} and {string} options")
    public void i_add_to_cart_shakeology_order_with_and_options(String pack_size, String ordere_type, String qty) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // validating PDP Page on product details page
        tbbproductDetailsPage.verifyPDPPage();
        // Selecting Package size on product details page
        tbbproductDetailsPage.selectPackaging(pack_size);
        // selecting order type on product details page
        tbbproductDetailsPage.selectOrderType(ordere_type);
        // selecting quantity on product details page
        tbbproductDetailsPage.selectQuantity(qty);
        // Clicking Add to cart button
        tbbproductDetailsPage.clickAddToCart();
    }

    @Then("I click on No thanks buttons to navigate to offers page")
    public void i_click_on_No_thanks_buttons_to_navigate_to_offers_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // click on No thanks, Continue button to navigate to Top sellers page
        tbbproductDetailsPage.clickNoThanksButton();
        // click on No thanks, Just Complete my Enrollment to navigate to offers page
        tbbproductDetailsPage.clickNoThanksButton();
    }

}
