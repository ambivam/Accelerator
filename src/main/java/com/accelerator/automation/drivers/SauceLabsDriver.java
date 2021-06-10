package com.accelerator.automation.drivers;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import com.accelerator.automation.common.World;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.saucerest.SauceREST;


public class SauceLabsDriver {

    private World world;
    private ResourceBundle configLib;
    ;
    private WebDriver driver;
    private String USERNAME, ACCESS_KEY, SAUCE_URL;

    public SauceLabsDriver(World world) {
        this.world = world;
    }

    //To initialize Sauce ie driver
    public WebDriver getSauceIEDriver() {

        DesiredCapabilities caps = null;

        String PLATFORM = null;
        SauceREST sauceRest = null;
        try {
            //Reading config info from config file
            File file = new File("config");
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            configLib = ResourceBundle.getBundle("config", Locale.getDefault(), loader);
            //Sauce user name
            caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("platform", configLib.getString("IE_PLATFORM"));
            caps.setCapability("version", configLib.getString("IE_VERSION"));
            caps.setCapability("name", world.scenario.getName());
            caps.setCapability("commandTimeout", 600);
            caps.setCapability("idleTimeout", 1000);
            this.driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        } catch (Exception e) {
            driver = null;
        }
        //String sessionId = ((RemoteWebDriver) this.driver).getSessionId().toString();
        //String tempWebLink = sauceRest.getPublicJobLink(sessionId);
        return driver;
    }

    //To initialize Sauce webdriver instances depending on parameters passed in testng
    public WebDriver getDriver() throws Exception {
        DesiredCapabilities caps = null;
        String PLATFORM = null;
        SauceREST sauceRest = null;
        try {
            //Reading config info from config file
            File file = new File("config");
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            configLib = ResourceBundle.getBundle("config", Locale.getDefault(), loader);

            //Sauce user name
            USERNAME = configLib.getString("SAUCE_USERNAME");
            //Sauce key
            ACCESS_KEY = configLib.getString("SAUCE_ACCESS_KEY");
            //Sauce connection url
            SAUCE_URL = configLib.getString("SAUCE_URL").replaceFirst("USERNAME", USERNAME).replaceFirst("ACCESS_KEY", ACCESS_KEY);

            sauceRest = new SauceREST(USERNAME, ACCESS_KEY);

            if (!world.isMobile()) {
                switch (world.getBrowser()) {
                    case "firefox":
                        caps = DesiredCapabilities.firefox();
                        break;
                    case "chrome":
                        caps = DesiredCapabilities.chrome();
                        break;
                    case "safari":
                        caps = DesiredCapabilities.safari();
                        break;
                    case "iexplorer":
                        caps = DesiredCapabilities.internetExplorer();
                        break;
                    case "edge":
                        caps = DesiredCapabilities.edge();
                        break;
                    default:
                        caps = DesiredCapabilities.chrome();
                }
                caps.setCapability("platform", world.getBrowserPlatform());
                caps.setCapability("version", world.getBrowserVersion());
                caps.setCapability("name", world.scenario.getName());
                caps.setCapability("commandTimeout", 600);
                caps.setCapability("idleTimeout", 1000);
            } else {
                //Mobile
                caps = DesiredCapabilities.iphone();
                caps.setCapability("deviceName", world.getMobileDeviceName());
                caps.setCapability("deviceOrientation", world.getMobileDeviceOrientation());
                caps.setCapability("platformVersion", world.getMobilePlatformVersion());
                caps.setCapability("platformName", world.getMobilePlatformName());
                caps.setCapability("browserName", world.getMobileBrowser());
            }
            if (world.getTunnelRequired().equalsIgnoreCase("yes")) {
                caps.setCapability("tunnelIdentifier", world.getSauceTunnelId());
            }
            this.driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
            String sessionId = ((RemoteWebDriver) this.driver).getSessionId().toString();
            String tempWebLink = sauceRest.getPublicJobLink(sessionId);
            world.setSauceWebLink(tempWebLink);

        } catch (Exception e) {
            throw new Exception("Sauce Driver failed due to " + e.getMessage());
        }
        return driver;
    }
}
