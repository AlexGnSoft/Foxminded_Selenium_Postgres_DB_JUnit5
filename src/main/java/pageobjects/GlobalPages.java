package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GlobalPages extends BaseTestConfiguration {

    /**
     * Method is used to enter any text data to the field
     */
    public static void enterDataToTheField(By webElement, String data) {
        driver.findElement(webElement).sendKeys(data);
    }

    /**
     * Method is used to go to the previous page and come back
     */
    public static Boolean navigateBackAndForth(By webElement) {
        driver.navigate().back();
        driver.navigate().forward();
        return pageIsVisible(webElement);
    }

    /**
     * Method is used to verify weather placeholder text is visible
     */
    public static Boolean placeHolderInVisible(By webElement, String expectPlaceHolderText) {
        WebElement element = driver.findElement(webElement);
        boolean actualPlaceholder = false;
        if (element.getAttribute("placeholder").contains(expectPlaceHolderText)) {
            actualPlaceholder = true;
        }
        return actualPlaceholder;
    }



}
