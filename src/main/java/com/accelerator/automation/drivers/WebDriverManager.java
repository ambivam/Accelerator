package com.accelerator.automation.drivers;

import com.accelerator.automation.common.World;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {
    private World world;
    private WebDriver driver;

    public WebDriverManager(World world) {
        this.world = world;
    }

    public WebDriver getIEDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.iedriver().arch32().setup();
        return this.driver = new InternetExplorerDriver();
    }
    
    /**
     * Local Driver Initialization
     *
     * @return
     * @throws Exception
     */
    public WebDriver getDriver() throws Exception {
        try {

            switch (world.getBrowser()) {
                case "firefox":
                    io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                    this.driver = new FirefoxDriver();
                    break;
                case "chrome":
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver();
                    break;
                case "safari":
                    this.driver = new SafariDriver();
                    break;
                case "iexplorer":
                    io.github.bonigarcia.wdm.WebDriverManager.iedriver().arch32().setup();
                    this.driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
                    this.driver = new EdgeDriver();
                    break;
                default:
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver();
            }
        } catch (Exception e) {
            throw new Exception("Get Driver Initialization failed due to " + e.getMessage());

        }
        return driver;
    }
}




