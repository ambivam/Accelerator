package com.accelerator.automation.stepdefs.identitymanagement;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.identitymanagement.IdentityManagementLoginPage;
import com.accelerator.automation.utilities.ConfigFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class IdentityManagementLoginPageSteps {
	
  private World world;
    IdentityManagementLoginPage oimloginpage;
	public IdentityManagementLoginPageSteps(World world){
		this.world=world;
		oimloginpage=new IdentityManagementLoginPage(world);
		//oimloginpage=new IdentityManagementLoginPage(world);
	}
	
	@Given("I am on OIM Login Page")
	public void i_am_on_OIM_Login_Page() throws Exception {
	try {
		File file = new File("config");
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		oimloginpage.navigateToWebPage(ConfigFileReader.getConfigFileReader().getOIMUrl());
		//world.driver.get(ConfigFileReader.getConfigFileReader().getOIMUrl());		
		//oim=new OIM_Page(this.world);
		
		oimloginpage.login(configLib.getString("OIM_Username"),configLib.getString("OIM_Password"));
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	
	@When("I login with userName {string} and password {string}")
	public void i_login_with_userName_and_password(String LoginUsername, String LoginPassword) throws Exception {
	try {
		
		oimloginpage.enterUserName(LoginUsername);
		oimloginpage.enterPassword(LoginPassword);
		oimloginpage.clickOnSignInButton();	
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
}
