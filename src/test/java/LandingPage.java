import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by dmg01 on 7/5/2017.
 */


public class LandingPage extends HomePage {
    public static final String LANDING_PAGE = ".//span[@class='original-keyword u__regular' and contains(text(),'TO_REPLACE')]";
    public static final String ADD_TO_CART_ITEM = "(.//span[@class='bttn__content' and text() = 'Add To Cart'])[]";
    public static final String ADD_TO_CART_ITEM_GALVANIZED = "(.//button[@class='bttn bttn--primary']//span[@class='bttn__content' and text() = 'Add To Cart'])";
    public static final String ADD_QTY_TO_CART = ".//input[@class='form-input__field']";
    public static final String WRAPPER = ".//div[contains(@class,'plp-pod plp-pod--default pod-item--')]";
    public static final String PRICE = ".//div[@class='price']";
    public static final String DESCRIPTION = ".//div[@class='pod-plp__description js-podclick-analytics']//a";
    public static final String GALVANIZED = ".//*[contains(text(),'Galvanized')]";
    public static final String HUSKY = ".//*[contains(text(),'Husky')]";
    public static final String PICKITUP = "(.//div[contains(text(),'Pick it up')])";
    public static final String CLOSE_OVERLAY = ".//a[@class='u__default-link' and  contains(text(),'Continue Shopping')]";
    public static final String GAL_DESC = "(.//header[@class='thd-overlay__header']//h2[@class='u__medium' and contains(text(),'Galvanized')])";
    public static final String CART_ITEM_COUNT = "(.//span[@class='MyCart__itemCount' and text() = '[]'])";


    ///////// Using the By class /////////
    public static final By DESC = By.xpath(".//div[@class='pod-plp__description js-podclick-analytics']//a");


    public boolean verifyLandingPage(String item) {
        String str = LANDING_PAGE;
        str = str.replace("TO_REPLACE", item);
        System.out.println("Got to here: item = " + item);
        System.out.println(str);
        if (super.verifyLandingPage(str)) {
            return true;
        }
        return false;
    }


    public boolean validateItemDescriptionFromPrice() {
        if (waitUntilElementDisplayed(WRAPPER)) {
            for (WebElement element : getElements(WRAPPER)) {
                String price = element.findElement(By.xpath(PRICE)).getText();
                price = price.substring(1, price.length() - 2);
                int thePrice = Integer.parseInt(price);
                if (thePrice >= 10 && thePrice < 15) {
                    String desc = element.findElement(By.xpath(DESCRIPTION)).getText();
                    System.out.println("          " + desc);
                    System.out.println("          Price ~ " + price);

                    // Store the item description for future reference
                    Metrics.setTestItem1(desc);

                    // Actually add the item to the cart by clicking
                    String element2 = insertIndexIntoXpath(ADD_TO_CART_ITEM, 1);
                    element.findElement(By.xpath(element2)).click();

                    return true;
                }
            }
        }
        return false;
    }


    public boolean closeCartOverlayWindow(){
        if (driver.findElement(By.xpath(CLOSE_OVERLAY)).isDisplayed()) {   // Verify displayed...
            driver.findElement(By.xpath(CLOSE_OVERLAY)).click();           // Actually click
            return true;
        }
        return false;
    }
}

