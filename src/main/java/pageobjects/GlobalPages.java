package pageobjects;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GlobalPages extends BaseTestConfiguration {

    /**
     * Method is used to close email popo-up and open ledft side bar, to be able to click on any category
     */
    public static void openLeftSideTab(){
        GlobalPages.click(MenuDashboard.closeButton);
        GlobalPages.click(MenuDashboard.minimizeSideBarBtn);
    }

    /**
     * Click on a web element
     */
    public static void click(By webElement){
        driver.findElement(webElement).click();
    }

    /**
     * Clicks on the web element + check its visibility first
     */
    public static void clickOnVisibleElement(By element){
        WebElement webElement = driver.findElement(element);
        waitExplicitly(webElement).click();
    }

    /**
     * Method waits for a page to be visible and active
     */
    public static Boolean pageIsVisible(By webElement){
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(webElement));

        return true;
    }

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

    /**
     * Method waits while the element is visible (Explicit wait)
     */
    public static WebElement waitExplicitly(WebElement webElement){
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.visibilityOf(webElement));

        return webElement;
    }

    /**
     * Method waits while the element is visible (Implicit wait)
     */
    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesFile.getImplicitWait()));
    }

    /**
     * Method returns title names (of id, title, assignee, stage) using getText().
     * As a parameter is receives a list of elements in a column
     * from which we expect to get title names
     */
    public static ArrayList<String> getNamesOfAnyColumns(By webElements) {
        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleNameList = driver.findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            titleName.add(titleNameList.get(i).getText());
        }
        return titleName;
    }

    /**
     * Method prints in console values of column using getText() method.
     * As a parameter is receives a list of elements in a column
     * from which we expect to get and print
     */
    public static void printValueOfColumn(By webElements) {
        List<WebElement> titleNameList = driver.findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            System.out.println(titleNameList.get(i).getText());
        }
    }


    /**
     * Method is used to accept Alert action
     */
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * Method is used to dismiss Alert action
     */
    public static void dismissAlert(){
        driver.switchTo().alert().accept();
    }







}
