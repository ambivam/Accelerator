package com.accelerator.automation.stepdefs.ecom;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.ecom.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class LoginPageSteps {
    private static String title;
    private World world;
    private LoginPage loginPage;


    public LoginPageSteps(World world) {
        this.world = world;

        loginPage = new LoginPage(world);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() throws Exception {
        loginPage.navigateToLoginPage();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() throws Exception {
        title = loginPage.getLoginPageTitle();
        System.out.println("Login Page Title is "+ title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() throws Exception {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) throws Exception {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) throws Exception {
        loginPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws Exception {
        loginPage.clickOnLogin();
    }

}