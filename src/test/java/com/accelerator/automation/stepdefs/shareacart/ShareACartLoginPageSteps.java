package com.accelerator.automation.stepdefs.shareacart;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.shareacart.ShareACartLoginPage;
import com.accelerator.automation.utilities.ConfigFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ShareACartLoginPageSteps {
	private World world;
	ShareACartLoginPage loginpage;
	ResourceBundle configLib;
	
	public ShareACartLoginPageSteps(World world){
		this.world=world;
	}

	@Given("I am logged in to ShareACart")
	public void i_am_logged_in_to_ShareACart() throws Exception {
	try {
		File file = new File("config");
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		// Write code here that turns the phrase above into concrete actions
		world.driver.get(ConfigFileReader.getConfigFileReader().getShareACartUrl());
		world.driver.manage().window().maximize();
		world.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		loginpage = new ShareACartLoginPage(this.world);
		loginpage.enterUsername(configLib.getString("SHAREACART_Username"));
		loginpage.enterPassword(configLib.getString("SHAREACART_Password"));
		loginpage.clickSignIn();
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
	
	@Then("I navigate back to share cart site")
	public void i_navigate_back_to_share_cart_site() throws Exception {
	try {
		ArrayList<String> tabs= new ArrayList<String>(world.driver.getWindowHandles());
		world.driver.switchTo().window((String)tabs.get(0));
	} catch (Exception e) {
        throw new Exception(e.getMessage());
    }
	}
}
