package com.accelerator.automation.pages.ecom;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;
import com.accelerator.automation.utilities.ConfigFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ResourceBundle;

public class LoginPage extends BasePage {
    ResourceBundle loginPageElements = ResourceBundle.getBundle("com.accelerator.automation.elementlib.ECOM.LoginPage");
    Logger logger = LogManager.getLogger(LoginPage.class);

    private By emailId = By.id(loginPageElements.getString("input_Email"));
    private By password = By.id(loginPageElements.getString("input_Password"));
    private By signInButton = By.id(loginPageElements.getString("button_SubmitLogin"));
    private By forgotPwdLink = By.linkText(loginPageElements.getString("link_ForgetYourPassword"));

    public LoginPage(World world) {
        super(world, world.driver);
    }

    public boolean navigateToLoginPage() throws Exception {
        try {
            logger.info("Navigating to Coach Office Login page");
            return navigateToWebPage(ConfigFileReader.getConfigFileReader().getECOMUrl());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getLoginPageTitle() throws Exception {
        try {
            logger.info("Get Login Page Title");
            return returnPageTitle();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public boolean isForgotPwdLinkExist() throws Exception {

        try{
            logger.info("Verify Forgot Password Link Displayed");
            return verifyElementDisplayed(forgotPwdLink);

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean enterUserName(String username) throws Exception {
        try {
            logger.info("Entering UserName");
            return enterText(emailId, username);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean enterPassword(String pwd) throws Exception {
        try {
            logger.info("Entering Password");
            return enterText(password, pwd);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean clickOnLogin() throws Exception{
        try {
            logger.info("Clicking on SignIn button");
            return click(signInButton);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean doLogin(String un, String pwd) throws Exception {
        boolean status = false;
        try {
            logger.info("Entering userName and Password");
            enterUserName(un);
            enterPassword(pwd);
            clickOnLogin();
            status  = true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
            return status;
    }

}
