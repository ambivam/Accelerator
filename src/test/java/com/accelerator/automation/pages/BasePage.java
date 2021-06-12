package com.accelerator.automation.pages;

import com.accelerator.automation.utilities.ConfigFileReader;
import com.accelerator.automation.common.Constants;
import com.accelerator.automation.common.World;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Super Class of All Pages, every page should inherit this page
 */
public class BasePage {
    private World world;
    private WebDriver driver;

    public BasePage(World world, WebDriver driver) {
        this.world = world;
        this.driver = driver;
    }

    private void checkSomethingServed() {
        try {
            driver.findElement(By.tagName("body"));
        } catch (WebDriverException e) {
            System.out.println(" ### RETRYING To Find Body tag ###");
            driver.findElement(By.tagName("body"));
            System.out.println("Failed in verifying page and the reason for failure is " + e.getMessage());
        }
        WebElement titleTag = null;
        try {
            if (driver.findElements(By.tagName("title")).size() > 0) {
                titleTag = driver.findElement(By.tagName("title"));
            }
        } catch (StaleElementReferenceException e) {
            if (driver.findElements(By.tagName("title")).size() > 0) {
                titleTag = driver.findElement(By.tagName("title"));
            }
            System.out.println("Failed in verifying page and the reason for failure is " + e.getMessage());
        }
    }

    private void verifyJavaScriptDone() throws InterruptedException {
        int retries = 20;
        int wait = 0;
        while (!isJavaScriptsDoneLoading()) {
            Thread.sleep(100);
            if (wait >= retries)
                break;
            wait++;
        }
    }

    private boolean isJavaScriptsDoneLoading() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return new Boolean((Boolean) executor
                .executeScript("return (typeof window.CJS === 'undefined' || window.CJS.done === true)"))
                .booleanValue();
    }

    public boolean navigateToWebPage(String url) throws Exception {
        try {
            if (world.getDriverType() == Constants.DRIVERTYPE.SAUCE && world.isMobile()) {
                driver.get(url);
            } else if (world.getDriverType() == Constants.DRIVERTYPE.LOCAL && world.isMobile()) {
                driver.get(url);
                driver.manage().window().setSize(new Dimension(370, 801));
            } else {
                driver.get(url);
                driver.manage().window().maximize();
            }
            checkSomethingServed();
            return true;
        } catch (Exception e) {
            throw new Exception("Not able to navigate to " + url + " due to " + e.getMessage());
        }
    }

    public boolean enterText(By element, String toEnter) throws Exception {
        try {
            ((JavascriptExecutor) driver).executeScript("window.focus();");
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                webElement.clear();
                webElement.sendKeys(toEnter);
                return true;
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to enter text due to " + e.getMessage());
        }
    }

    public boolean click(By element) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                webElement.click();
                return true;
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to click element due to " + e.getMessage());
        }
    }

    public int getElementsCount(By element) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            return driver.findElements(element).size();
        } catch (Exception e) {
            throw new Exception("Unable to find Count of Elements " + e.getMessage());
        }
    }

    public List<WebElement> getElements(By element) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            return driver.findElements(element);
        } catch (Exception e) {
            throw new Exception("Unable to Get List Of Elements " + e.getMessage());
        }
    }



    public boolean verifyElementDisplayed(By element) throws Exception {
        try {
            Thread.sleep(4000);
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                return true;
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Element not displayed due to " + e.getMessage());
        }
    }

    public boolean selectByValueinDropDown(By element, String value) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                Select s = new Select(webElement);
                s.selectByValue(value);
                return true;
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to Select by value due to " + e.getMessage());
        }
    }

    public boolean selectByIndexinDropDown(By element, int index) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                Select s = new Select(webElement);
                s.selectByIndex(index);
                return true;
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to Select by index due to " + e.getMessage());
        }
    }

    public String getTextFromElement(By element) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                return webElement.getText();
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to get text from element due to " + e.getMessage());
        }
    }

    public String getAttributeValueFromElement(By element, String attribute) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                return webElement.getAttribute(attribute);
            } else {
                throw new Exception("Element is not displayed / enabled ");
            }
        } catch (Exception e) {
            throw new Exception("Not able to get element attribute value due to " + e.getMessage());
        }
    }

    public boolean ScrollToElementAndClick(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(locator))).click()
                    .build().perform();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean verifyElementPresence(By element) throws Exception {
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElement webElement = driver.findElement(element);
            if (webElement != null) {
                return true;
            } else {
                throw new Exception("Element is not present on page");
            }
        } catch (Exception e) {
            throw new Exception("Element not present on page due to " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(By element) throws Exception {
        boolean isDisplayed = false;
        try {
            new WebDriverWait(driver, ConfigFileReader.getConfigFileReader().getImplicitlyWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElement webElement = driver.findElement(element);
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                return isDisplayed = true;
            }
        } catch (Exception e) {
            return isDisplayed;
        }
        return isDisplayed;
    }

    public boolean scrollTillEndOfPage() throws Exception {
        boolean isDisplayed = false;
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            return true;
        } catch (Exception e) {
            return isDisplayed;
        }
    }

    public boolean selectFromMobileFauxDropDown(String xPath, String valueToSelect) throws Exception {
        boolean isDisplayed = false;
        try {
            click(By.xpath(xPath + "//following::div[@class='select-faux mod show-for-small-only']//li"));
            return click(By.xpath("//li[@data-value='" + valueToSelect + "']"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String returnPageTitle() throws Exception {
        String title = "";
        try {
            title = driver.getTitle().trim();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return title;
    }


}
