package com.accelerator.automation.pages.ecom;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ResourceBundle;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage extends BasePage {


    ResourceBundle accountsPageElements = ResourceBundle.getBundle("com.accelerator.automation.elementlib.ECOM.AccountsPage");
    Logger logger = LogManager.getLogger(LoginPage.class);

    private By accountsSections = By.cssSelector(accountsPageElements.getString("link_AccountsSection"));

    public AccountsPage(World world) {
        super(world, world.driver);
    }

    public String getAccountsPageTitle() throws Exception {
        try {
            logger.info("Get Login Page Title");
            return returnPageTitle();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public int getAccountsSectionCount() throws Exception {

        try {
            logger.info("Get Account Sections Count");
            return getElementsCount(accountsSections);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<String> getAccountsSectionsList() throws Exception{

        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = getElements(this.accountsSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;

    }

}
