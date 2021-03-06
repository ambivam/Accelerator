package com.accelerator.automation.common;

import com.accelerator.automation.drivers.OATSDriver;
import com.accelerator.automation.drivers.RESTDriver;
import com.accelerator.automation.drivers.SOAPDriver;
import com.accelerator.automation.drivers.SeleniumGridDriver;
import com.accelerator.automation.drivers.SauceLabsDriver;
import com.accelerator.automation.drivers.WebDriverManager;

import cucumber.api.Scenario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class World {

    private String browser;
    private String sauceTunnelId;
    private String tunnelRequired;
    private String locale;
    private String orderNum;
    private String browserVersion;
    private String browserPlatform;
    private String platform;
    private String platformVersion;
    private String sessionId;
    private List<String> sauceWebLink = new ArrayList<>();

    WebDriverManager webDriver = new WebDriverManager(this);
    SauceLabsDriver sauceDriver = new SauceLabsDriver(this);
    SeleniumGridDriver gridDriver = new SeleniumGridDriver(this);
    RESTDriver restDriver = new RESTDriver(this);
    SOAPDriver soapDriver = new SOAPDriver(this);
    OATSDriver oatsDriver = new OATSDriver(this);
    public WebDriver driver;
    public WebDriver ieDriver;
    public WebDriver exeDriver;
	public WebDriver ieSauceDriver;
    public WebDriver ieCommonDriver;
    public Scenario scenario;

    Map<String, String> customerDetails = new HashMap<String, String>();
    Map<String, String> creditCardDetails = new HashMap<String, String>();
    Map<String, String> orderDetails = new HashMap<String, String>();
    Map<String, String> coachId = new HashMap<String, String>();
    Map<String, String> existingCustomerDetails = new HashMap<String, String>();
    Map<String, String> updateAccountAddress = new HashMap<String, String>();
    Map<String, String> sacCustDetails = new HashMap<String, String>();

    private boolean isMobile;
    private String mobilePlatform;
    private String mobileDeviceName;
    private String mobileDeviceOrientation;
    private String mobilePlatformVersion;
    private String mobilePlatformName;
    private String mobileBrowser;
    private Constants.DRIVERTYPE driverType;
    private Constants.BROWSER browserName;

    public WebDriver getDriver() throws Exception {
        try {
            switch (this.driverType) {
                case SAUCE:
                    this.driver = sauceDriver.getDriver();
                    break;
                case GRID:
                    this.driver = gridDriver.getDriver();
                    break;
                default:
                    this.driver = webDriver.getDriver();
                    break;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return this.driver;
    }        
    
    public String getBrowser() {
        return browser;
    }

    public String getBrowserPlatform() {
        return browserPlatform;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public Map<String, String> getCoachID() {
        return coachId;
    }

    public Map<String, String> getCreditCardDetails() {
        return creditCardDetails;
    }

    public Map<String, String> getCustomerDetails() {
        return customerDetails;
    }

    public Map<String, String> getExistingCustomerdetails() {
        return existingCustomerDetails;
    }

    public WebDriver getIEDriver() {
        if(this.driverType.equals(Constants.DRIVERTYPE.SAUCE)) {
            return sauceDriver.getSauceIEDriver();
        }else {
            return this.ieDriver = webDriver.getIEDriver();
        }
    }

    public String getLocale() {
        return locale;
    }

    public OATSDriver getOatsDriver() {
        return oatsDriver;
    }

    public Map<String, String> getOrderDetails() {
        return orderDetails;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public WebDriver getSauceIEDriver() {
        return this.ieDriver = sauceDriver.getSauceIEDriver();
    }

    public String getSauceTunnelId() {
        return sauceTunnelId;
    }

    public List<String> getSauceWebLink() {
        return sauceWebLink;
    }

    public String getScenario() {
        return this.scenario.getName();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getTunnelRequired() {
        return tunnelRequired;
    }

    public Map<String, String> getUpdateAccountDetails() {
        return updateAccountAddress;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setBrowserPlatform(String browserPlatform) {
        this.browserPlatform = browserPlatform;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public void setCoachID(String key, String value) {

        this.coachId.put(key, value);
    }

    public void setCreditDetails(String key, String value) {

        this.creditCardDetails.put(key, value);
    }

    public void setCustomerDetails(String key, String value) {

        this.customerDetails.put(key, value);
    }

      public void setExistingCustomerdetails(String key, String value) {
        this.existingCustomerDetails.put(key, value);
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setOatsDriver(OATSDriver oatsDriver) {
        this.oatsDriver = oatsDriver;
    }

    public void setOrderDetails(String key, String value) {

        this.orderDetails.put(key, value);
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public void setSauceTunnelId(String sauceTunnelId) {
        this.sauceTunnelId = sauceTunnelId;
    }

    public void setSauceWebLink(String links) {
        sauceWebLink.add("<h2><a href=" + links + " target='_blank'>Please Click here for the Video</a><h2>");
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTunnelRequired(String tunnelRequired) {
        this.tunnelRequired = tunnelRequired;
    }

    public void setUpdateAccountDetails(String key, String value) {
        this.updateAccountAddress.put(key, value);
    }

    public Map<String, String> getSACDetails() {
        return sacCustDetails;
    }

    public void setSACDetails(String key, String value) {
        this.sacCustDetails.put(key, value);
    }

    public String getMobilePlatform() {
        return mobilePlatform;
    }

    public void setMobilePlatform(String mobilePlatform) {
        this.mobilePlatform = mobilePlatform;
    }

    public String getMobileDeviceName() {
        return mobileDeviceName;
    }

    public void setMobileDeviceName(String mobileDeviceName) {
        this.mobileDeviceName = mobileDeviceName;
    }

    public String getMobileDeviceOrientation() {
        return mobileDeviceOrientation;
    }

    public void setMobileDeviceOrientation(String mobileDeviceOrientation) {
        this.mobileDeviceOrientation = mobileDeviceOrientation;
    }

    public String getMobilePlatformVersion() {
        return mobilePlatformVersion;
    }

    public void setMobilePlatformVersion(String mobilePlatformVersion) {
        this.mobilePlatformVersion = mobilePlatformVersion;
    }

    public String getMobilePlatformName() {
        return mobilePlatformName;
    }

    public void setMobilePlatformName(String mobilePlatformName) {
        this.mobilePlatformName = mobilePlatformName;
    }

    public String getMobileBrowser() {
        return mobileBrowser;
    }

    public void setMobileBrowser(String mobileBrowser) {
        this.mobileBrowser = mobileBrowser;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public Constants.DRIVERTYPE getDriverType() {
        return driverType;
    }

    public void setDriverType(Constants.DRIVERTYPE driverType) {
        this.driverType = driverType;
    }

    public Constants.BROWSER getBrowserName() {
        return browserName;
    }

    public void setBrowserName(Constants.BROWSER browserName) {
        this.browserName = browserName;
    }
}
