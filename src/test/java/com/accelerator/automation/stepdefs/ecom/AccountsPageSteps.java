package com.accelerator.automation.stepdefs.ecom;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.ecom.AccountsPage;
import com.accelerator.automation.pages.ecom.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private World world;
    private LoginPage loginPage;
    private AccountsPage accountsPage;

    public AccountsPageSteps(World world) {
        this.world = world;
        accountsPage = new AccountsPage(world);
        loginPage = new LoginPage(world);
    }

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) throws Exception {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        try {
            loginPage.navigateToLoginPage();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        loginPage.doLogin(userName, password);

    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() throws Exception {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) throws Exception {
        List<String> expAccountSectionsList = sectionsTable.asList();

        System.out.println("Expected accounts section list: " + expAccountSectionsList);

        List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionsList);

        Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) throws Exception {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }

}