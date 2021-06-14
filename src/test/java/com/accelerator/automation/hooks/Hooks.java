package com.accelerator.automation.hooks;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.accelerator.automation.common.Constants;
import com.accelerator.automation.common.World;


import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;



public class Hooks {

    private String scenDesc;
    private World world;

    public Hooks(World world) {
        this.world = world;
    }

    @Before
    public void before(Scenario scenario) throws Exception {
        try {

            this.scenDesc = scenario.getName();
            world.setScenario(scenario);

            //App Related properties
            String locale = System.getProperty("locale");

            if (locale != null && !locale.isEmpty()) {
                world.setLocale(locale);
            } else {
                world.setLocale(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("locale"));
            }

            String driverType = System.getProperty("driverType");
            if (driverType != null && !driverType.isEmpty()) {
            } else {
                driverType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("driverType");
            }

            switch (driverType.toLowerCase()) {
                case "local":
                    world.setDriverType(Constants.DRIVERTYPE.LOCAL);
                    break;
                case "sauce":
                    world.setDriverType(Constants.DRIVERTYPE.SAUCE);
                    break;
                case "grid":
                    world.setDriverType(Constants.DRIVERTYPE.GRID);
                    break;
                default:
                    world.setDriverType(Constants.DRIVERTYPE.LOCAL);
                    break;
            }



            //Browser Related Properties
            String browser = System.getProperty("browser");

            if (browser != null && !browser.isEmpty()) {
                world.setBrowser(browser);
            } else {
                browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
                world.setBrowser(browser);
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    world.setBrowserName(Constants.BROWSER.CHROME);
                    break;
                case "firefox":
                    world.setBrowserName(Constants.BROWSER.FIREFOX);
                    break;
                case "iexplorer":
                    world.setBrowserName(Constants.BROWSER.IEXPLORER);
                    break;
                case "safari":
                    world.setBrowserName(Constants.BROWSER.SAFARI);
                    break;
                case "edge":
                    world.setBrowserName(Constants.BROWSER.EDGE);
                    break;
                default:
                    world.setBrowserName(Constants.BROWSER.CHROME);
                    break;

            }



        if(driverType.toLowerCase().equalsIgnoreCase(String.valueOf(Constants.DRIVERTYPE.SAUCE))){

            System.out.println("SAUCE DRIVER TYPE IS "+ String.valueOf(Constants.DRIVERTYPE.SAUCE));

            //Sauce Properties
            world.setSauceTunnelId(System.getenv("TUNNEL_IDENTIFIER"));
            System.out.println("The Tunnel id is : "+world.getSauceTunnelId());


            String tunnelRequired = System.getProperty("tunnel");
            if (tunnelRequired != null && !tunnelRequired.isEmpty()) {
                world.setTunnelRequired(tunnelRequired);
            } else {
                world.setTunnelRequired(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("tunnel"));
            }

            String browserVersion = System.getProperty("browserVersion");
            String browserPlatform = System.getProperty("browserPlatform");

            if (browserVersion != null && !browserVersion.isEmpty()) {
                world.setBrowserVersion(browserVersion);
            } else {
                world.setBrowserVersion(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserVersion"));
            }
            if (browserPlatform != null && !browserPlatform.isEmpty()) {
                world.setBrowserPlatform(browserPlatform);
            } else {
                world.setBrowserPlatform(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserPlatform"));
            }
            }

            //Mobile Related Properties
            /*String isMobile = System.getProperty("isMobile");
            String mobilePlatform = System.getProperty("mobilePlatform");
            String mobileDeviceName = System.getProperty("mobileDeviceName");
            String mobileDeviceOrientation = System.getProperty("mobileDeviceOrientation");
            String mobilePlatformVersion = System.getProperty("mobilePlatformVersion");
            String mobilePlatformName = System.getProperty("mobilePlatformName");
            String mobileBrowser = System.getProperty("mobileBrowser");
            if (isMobile != null && !isMobile.isEmpty()) {
                world.setMobile(Boolean.parseBoolean(isMobile));
            } else {
                world.setMobile(Boolean.parseBoolean(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("isMobile")));
            }

            if (mobilePlatform != null && !mobilePlatform.isEmpty()) {
                world.setMobilePlatform(mobilePlatform);
            } else {
                world.setMobilePlatform(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobilePlatform"));
            }

            if (mobileDeviceName != null && !mobileDeviceName.isEmpty()) {
                world.setMobileDeviceName(mobileDeviceName);
            } else {
                world.setMobileDeviceName(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobileDeviceName"));
            }

            if (mobileDeviceOrientation != null && !mobileDeviceOrientation.isEmpty()) {
                world.setMobileDeviceOrientation(mobileDeviceOrientation);
            } else {
                world.setMobileDeviceOrientation(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobileDeviceOrientation"));
            }

            if (mobilePlatformVersion != null && !mobilePlatformVersion.isEmpty()) {
                world.setMobilePlatformVersion(mobilePlatformVersion);
            } else {
                world.setMobilePlatformVersion(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobilePlatformVersion"));
            }

            if (mobilePlatformName != null && !mobilePlatformName.isEmpty()) {
                world.setMobilePlatformName(mobilePlatformName);
            } else {
                world.setMobilePlatformName(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobilePlatformName"));
            }

            if (mobileBrowser != null && !mobileBrowser.isEmpty()) {
                world.setMobileBrowser(mobileBrowser);
            } else {
                world.setMobileBrowser(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mobileBrowser"));
            }*/

            world.getDriver();
            System.out.println("Scenario IS " + scenario.getName());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        //Thread.sleep(2000);
    }

    @AfterStep
    public void afterStep() throws InterruptedException {
        //Thread.sleep(2000);

    }

    @After
    public void after(Scenario scenario) {
        this.scenDesc = scenario.getName();
        System.out.println("im coming out of scenario " + this.scenDesc + world.getBrowser() + world.getLocale());
        embedScreenshot(scenario);
        try {
            System.out.println("Closing browser");
            if (this.world.driver != null) {
                world.driver.quit();
                System.out.println("Closing browser");
            }
            if (this.world.ieDriver != null) {
                world.ieDriver.quit();
            }
            Constants.world = world;
        } catch (Throwable e) {
            System.out.println("Unable to quit the driver");
            e.printStackTrace();
        }
    }

    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll("","_");
            byte [] sourcePath = ((TakesScreenshot)this.world.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }


    /*public void embedScreenshotInSauceLabs(Scenario scenario) {
        if (scenario.isFailed()) {
            List<String> scenarioFailed = world.getSauceWebLink();
            try {
                final byte[] screenshot = ((TakesScreenshot) this.world.driver).getScreenshotAs(OutputType.BYTES);
                for (String links : scenarioFailed) {
                    scenario.embed(links.getBytes(StandardCharsets.UTF_8), "text/html");

                }
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                System.out.println("Exception thrown while attaching screenshot");
            }
        }
    }*/


}