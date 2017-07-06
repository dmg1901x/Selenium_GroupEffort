import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by dmg01 on 6/27/2017.
 */
public class MainTest {
    public static final String HOME_PAGE = "http://homedepot.com/";

    // Instantiation of our Utilities class
    //SeleniumUtils utils = new SeleniumUtils();
    static LandingPage utils = new LandingPage();

    // All my DOM objects
    public static String item;

    @BeforeClass
    public static void startTestHere() {
        Assert.assertTrue("Setup(1.1) Could not validate main page.",
                utils.navigateURL(HOME_PAGE));
        System.out.println("Setup(1.1) Validated successful navigation to " + HOME_PAGE);
    }

    public void setup(String item) {
        //Search for header search bar and enter 'item'
        Assert.assertTrue("Setup(1.2) Could not validate search box.",
                utils.validateSearchBox(item));
        System.out.println("Setup(1.2) Validated search box is present and entered " + item);


        // Click on search button
        Assert.assertTrue("Setup(1.3) Could not validate search button.",
                utils.clickButton(utils.SEARCH_BUTTON));
        System.out.println("Setup(1.3) Validated search button is present and event = click.");


        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("Setup(2.1) Could not validate that the landing page contained the item",
                utils.verifyLandingPage(item));
        System.out.println("Setup(2.1) Validated landing contains word " + item);
    }


    @Test
    public void getDescriptionHammer() {
        item = "hammer";
        setup(item);


//        Assert.assertTrue("(3.1) Could not verify the item from price",
//                utils.validateItemDescriptionFromPrice());
//        System.out.println("(3.1) Validated the item price between $10 & $15");

    }


    @AfterClass
    public static void cleanUp() {
        // Close the driver
        utils.driver.close();
    }
}







/*
/    public static final String HOME_PAGE = "http://homedepot.com/";
/    // Instantiation of our Utilities class
/    static Overlay utils = new Overlay();
/
/    // All my DOM objects
/    public static String item;
/
/
/    @BeforeClass
/    public static void setupTHD() {
/        // Open URL page based on the driver object
/        Assert.assertTrue("Setup(1.1) Could not validate main page.",
/                utils.navigateURL(HOME_PAGE));
/        System.out.println("Setup(1.1) Validated successful navigation to " + HOME_PAGE);
/    }
/
/    public void setup(String item) {
/        //Search for header search bar and enter 'item'
/        Assert.assertTrue("Setup(1.2) Could not validate search box.",
/                utils.enterItemIntoSearchBox(utils.SEARCH_BOX, item));
/        System.out.println("Setup(1.2) Validated search box is present and entered " + item);
/
/
/        // Click on search button
/        Assert.assertTrue("Setup(1.3) Could not validate search button.",
/                utils.clickButton(utils.SEARCH_BUTTON));
/        System.out.println("Setup(1.3) Validated search button is present and event = click.");
/
/
/        // Verify we land on the correct page = Landing Page
/        Assert.assertTrue("Setup(2.1) Could not validate that the landing page contained the item",
/                utils.verifyLandingPage(item));
/        System.out.println("Setup(2.1) Validated landing contains word " + item);
/    }
/
/
/    @Test
/    public void getDescriptionHammer() {
/        item = "hammer";
/        setup(item);
/
        Assert.assertTrue("(3.1) Could not verify the item from price",
                utils.validateItemDescriptionFromPrice());
        System.out.println("(3.1) Validated the item price between $10 & $15");

        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(3.2) Could not verify Overlay division and Item Added to Cart phrase.",
                utils.verifyOverlayPage());
        System.out.println("(3.2) Validated Overlay for 'Item Added to Cart'");
        System.out.println("(3.3) and... Validated the 'Item Added to Cart' phrase");
//        utils.driver.switchTo().defaultContent();   // Switch focus back to the default   (No need here; the switch is done in the verifyOverlayPage method)

        // Verify that the original item selected matches the item actually added to the cart
        Assert.assertTrue("(3.4) Could not verify Overlay Item description matches the original item selected.",
                utils.verifyOverlayPage2(1));
        System.out.println("(3.4) and... The selected item does match the originally identified item.");

        // Verify the Overlay can be closed
        Assert.assertTrue("(4.1) Could not close the Cart Overlay",
                utils.closeCartOverlayWindow());
        System.out.println("(4.1) The Cart Overlay successfully closed");

        utils.driver.switchTo().defaultContent();   // Switch focus back to the default

        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("4.2) Could not validate that focus was returned to landing page",
                utils.verifyLandingPage(item));
        System.out.println("(4.2) Validated the return to focus to the landing page for " + item);
    }


    @Test
    public void getDescriptionGalvanizedNail() {
        item = "nail";
        setup(item);

        item = "nail galvanized";
        setup(item);


        Assert.assertTrue("(5.1) Could not verify the Galvanized nail",
                utils.validateItemDescriptionForGalvanized());
        System.out.println("(5.1) Validated the Galvanized nail");


        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(5.2) Could not verify Overlay division with: Show Nearby Stores phrase etc.",
                utils.verifyOverlayPage4());
        System.out.println("(5.2) Validated the Show Nearby Stores phrase");
        System.out.println("(5.3) and... Validated the 'Add to Cart' phrase");
        System.out.println("(5.4) and... added '1' to the Quantity");


        // Verify we land at the Overlay after selecting Add To Cart
        Assert.assertTrue("(5.5) Could not verify Overlay division and Item Added to Cart phrase.",
                utils.verifyOverlayPage());
        System.out.println("(5.5) Validated Overlay for 'Item Added to Cart'");
        System.out.println("(5.6) and... Validated the 'Item Added to Cart' phrase");


        // Verify that the original item selected matches the item actually added to the cart
        Assert.assertTrue("(5.7) Could not verify Overlay Item description matches the original item selected.",
                utils.verifyOverlayPage2(2));
        System.out.println("(5.7) and... The selected item does match the originally identified item.");


        // Verify the Overlay can be closed
        Assert.assertTrue("(5.8) Could not close the Cart Overlay",
                utils.closeCartOverlayWindow());
        System.out.println("(5.8) The Cart Overlay successfully closed");

        utils.driver.switchTo().defaultContent();   // Switch focus back to the default

        // Verify we land on the correct page = Landing Page
        Assert.assertTrue("5.9) Could not validate that focus was returned to landing page",
                utils.verifyLandingPage(item));
        System.out.println("(5.9) Validated the return to focus to the landing page for " + item);


        // Verify the Cart Item count
        Assert.assertTrue("(5.10) Could not validate the item count",
                utils.verifyCartItemCount(2));
        System.out.println("(5.10) Validated the item count");
    }


    @Test
    public void getDescriptionScrewDriver() {
        item = "screwdriver";
        setup(item);

        Assert.assertTrue("(6.1) Could not verify the Husky screwdriver",
                utils.validateItemDescriptionScrewdriver());
        System.out.println("(6.1) Validated the Husky screwdriver");
    }
/
/
/
/    @AfterClass
/    public static void cleanUp() {
/        // Close the driver
/        utils.driver.close();
/    }
*/

