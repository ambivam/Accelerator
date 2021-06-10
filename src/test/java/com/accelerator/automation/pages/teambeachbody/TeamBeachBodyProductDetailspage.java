package com.accelerator.automation.pages.teambeachbody;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.BasePage;;

public class TeamBeachBodyProductDetailspage extends BasePage {
    private World world;
    ResourceBundle productDetailsPageElements = ResourceBundle
            .getBundle("com.beachbody.automation.elementlib.TBB.ProductDetailsPage");
    Logger logger = LogManager.getLogger(TeamBeachBodyProductDetailspage.class);

    By textPDPPageTitle = By.xpath(productDetailsPageElements.getString("title_PDP"));
    By mobile_textPDPPageTitle = By.xpath(productDetailsPageElements.getString("mobile_title_PDP"));
    By selectFlavor = By.xpath(productDetailsPageElements.getString("select_Flavor"));
    By selectRecover = By.xpath(productDetailsPageElements.getString("select_Recover"));
    By selectRecoverPackaging = By.xpath(productDetailsPageElements.getString("select_RecoverPackaging"));
    By selectPackaging = By.xpath(productDetailsPageElements.getString("select_Packaging"));
    By selectOrderType = By.xpath(productDetailsPageElements.getString("select_OrderType"));
    By selectQty = By.xpath(productDetailsPageElements.getString("select_Quantity"));
    By buttonAddToCart = By.xpath(productDetailsPageElements.getString("button_AddToCart"));
    By buttonAddItemToCart = By.xpath(productDetailsPageElements.getString("button_AddItemToCart"));
    By linkViewCart = By.xpath(productDetailsPageElements.getString("link_ViewCart"));
    By textProductTitle = By.xpath(productDetailsPageElements.getString("text_ProductTitle"));
    By buttonNoThanks = By.xpath(productDetailsPageElements.getString("button_nothanks"));

    public TeamBeachBodyProductDetailspage(World world) {
        super(world, world.driver);
        this.world = world;
    }

    /*
     * Verifying PDP page
     */
    public boolean verifyPDPPage() throws Exception {
        try {
            logger.info("Verifying PDP page title ");
            if (world.isMobile()) {
                boolean result = verifyElementDisplayed(mobile_textPDPPageTitle);
                if (result == true) {
                    return true;
                } else {
                    throw new Exception("Not navigated to Product Details Page");
                }
            } else {
                boolean result = verifyElementDisplayed(textPDPPageTitle);
                if (result == true) {
                    return true;
                } else {
                    throw new Exception("Not navigated to Product Details Page");
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting flavor
     */
    public boolean selectFlavor(String flavor) throws Exception {
        try {
            logger.info("Selecting flavor option");
            return selectByValueinDropDown(selectFlavor, flavor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting Recover
     */
    public boolean selectRecover(String recover) throws Exception {
        try {
            logger.info("Selecting recover");
            return selectByValueinDropDown(selectRecover, recover);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting RecoverPackaging
     */
    public boolean selectRecoverPackaging(String recoverpackaging) throws Exception {
        try {
            logger.info("Selecting Recoverpackaging");
            return selectByValueinDropDown(selectRecoverPackaging,
                    recoverpackaging);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting packaging
     */
    public boolean selectPackaging(String packaging) throws Exception {
        try {
            logger.info("Selecting packaging option");
            if(world.isMobile()) {
                return selectFromMobileFauxDropDown(productDetailsPageElements.getString("select_Packaging"),packaging);
                //click(By.xpath(productDetailsPageElements.getString("select_Packaging")+"//following::div[@class='select-faux mod show-for-small-only']//li"));
                //return click(By.xpath("//li[@data-value='"+packaging+"']"));
            }else {
                return selectByValueinDropDown(selectPackaging, packaging);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

	/*
     * Selecting shakeology order type
	 */

    public boolean selectOrderType(String order_type) throws Exception {
        try {
            logger.info("Selecting shakelogy order type");
            if(world.isMobile()) {
                return selectFromMobileFauxDropDown(productDetailsPageElements.getString("select_OrderType"),order_type);
                //click(By.xpath(productDetailsPageElements.getString("select_OrderType")+"//following::div[@class='select-faux mod show-for-small-only']//li"));
                //return click(By.xpath("//li[@data-value='"+order_type+"']"));
            }else {
                return selectByValueinDropDown(selectOrderType,order_type);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Selecting quantity
     */
    public boolean selectQuantity(String qty) throws Exception {
        try {
            logger.info("Selecting product quantity");
            if(world.isMobile()) {
               return selectFromMobileFauxDropDown(productDetailsPageElements.getString("select_Quantity"),qty);
            }else {
                return selectByValueinDropDown(selectQty, qty);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * clicking on add to cart button
     */
    public boolean clickAddToCart() throws Exception {
        try {
            logger.info("Click on add to cart button");
            return click(buttonAddToCart);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * clicking on add item to cart button
     */
    public boolean clickAddItemToCart() throws Exception {
        boolean result = false;
        try {
            logger.info("Click on add item to cart button ");
            if (verifyElementDisplayed(buttonAddItemToCart) == true) {
                click(buttonAddItemToCart);
                result = true;
            } else {
                result = false;
            }
        } catch (WebDriverException e) {
            // TODO: handle exception
            JavascriptExecutor js = (JavascriptExecutor) world.driver;
            js.executeScript("arguments[0].click();", buttonAddItemToCart);
            result = true;
        }
        return result;
    }

    /*
     * Clicking on view cart button
     */
    public boolean clickViewCart() throws Exception {
        try {
            logger.info("Click on view cart");
            return click(linkViewCart);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * Verifying popup with pack
     */
    public boolean ValidatePopUpWithPack() throws Exception {
        try {
            logger.info("Verifying product popup with pack");
            return verifyElementDisplayed(textProductTitle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * clicking on no thanks button
     */
    public boolean clickNoThanksButton() throws Exception {
        try {
            logger.info("Click on no thanks button");
            scrollTillEndOfPage();
            boolean result = verifyElementDisplayed(buttonNoThanks);
            if (result == true) {
                return click(buttonNoThanks);
            } else {
                throw new Exception("Not clicked on no thanks button");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
