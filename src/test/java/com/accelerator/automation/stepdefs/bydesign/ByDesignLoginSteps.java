package com.accelerator.automation.stepdefs.bydesign;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import com.accelerator.automation.common.Constants;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.bydesign.ByDesignLoginPage;

import cucumber.api.java.en.Given;

/**
 * Steps supporting Coach Office Login Page. All actions, validations as part of Coach office login page will be here.
 */
public class ByDesignLoginSteps {

    private World world;
    ByDesignLoginPage byDesignLoginPage;
    ResourceBundle configLib;

    /**
     * Constructor, Initialize required Pages
     */
    public ByDesignLoginSteps(World world) {
        this.world = world;
        if (!world.getBrowserName().equals(Constants.BROWSER.IEXPLORER)) {
            if ((world.ieDriver) == null) {
                world.ieDriver = world.getIEDriver();
            }
        }
        byDesignLoginPage = new ByDesignLoginPage(world, world.ieDriver);
    }

    @Given("I am logged in to ByDesign")
    public void i_am_logged_in_to_ByDesign() throws Exception {
        File file = new File("config");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        configLib = ResourceBundle.getBundle("config", Locale.getDefault(), loader);
        String page_title = "Welcome to Freedom";
        try {
            byDesignLoginPage.navigateToByDesignLoginPage();
            //byDesignLoginPage.login(configLib.getString("BYD_Username"), configLib.getString("BYD_Password"));
            //byDesignLoginPage.navigateToByDesignCustomerSearchPage();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}