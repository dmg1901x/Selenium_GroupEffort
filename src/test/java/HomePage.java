/**
 * Created by dmg01 on 6/27/2017.
 */
public class HomePage extends SeleniumUtils {
    public static final String SEARCH_BOX = ".//input[@id='headerSearch']";
    public static final String SEARCH_BUTTON = ".//button[@id='headerSearchButton']";
    public static final String STORE_LOCATOR = ".//*[@class='MyStore__store']";

    //public boolean enterItemIntoSearchBox(String element, String text) {
    public boolean validateSearchBox(String text) {
    //    if (syncStoreLocation()) {
            if (waitUntilElementDisplayed(SEARCH_BOX)){
            //if (waitUntilElementDisplayed(element)){
            //if (validateTextBox(element)) {
            //    if (enterTextIntoTextBox(element, text)) {
                if (enterTextIntoTextBox(SEARCH_BOX, text)) {
                    return true;
                }
            }
    //    }
        return false;
    }



}
