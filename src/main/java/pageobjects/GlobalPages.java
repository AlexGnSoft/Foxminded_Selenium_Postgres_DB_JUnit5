package pageobjects;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GlobalPages extends BaseTestConfiguration {

    private static final Logger log = LogManager.getLogger(DepartmentsNewDepPage.class.getName());

    /**
     * Method is used to close email popo-up and open ledft side bar, to be able to click on any category
     */
    public static void openLeftSideTab(){
        GlobalPages.click(MenuDashboard.closeButton);
        GlobalPages.click(MenuDashboard.minimizeSideBarBtn);
        log.log(Level.INFO, "openLeftSideTab method");
    }

    /**
     * Click on a web element
     */
    public static void click(By webElement){
        getDriver().findElement(webElement).click();
    }

    /**
     * Clicks on the web element + check its visibility first
     */
    public static void clickOnVisibleElement(By element){
        WebElement webElement = getDriver().findElement(element);
        waitExplicitly(webElement).click();
        log.log(Level.INFO, "clickOnVisibleElement method");
    }

    /**
     * Method waits for a page to be visible and active
     */
    public static Boolean pageIsVisible(By webElement){
        new WebDriverWait(getDriver(), Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(webElement));

        log.log(Level.INFO, "pageIsVisible method");

        return true;
    }

    /**
     * Method is used to clear possible placeholder text and then fill in user data to the field
     */
    public static void enterDataToTheField(By webElement, String data) {
        getDriver().findElement(webElement).clear();
        getDriver().findElement(webElement).sendKeys(data);

        log.log(Level.INFO, "enterDataToTheField method");
    }

    /**
     * Method is used to go to the previous page and come back
     */
    public static Boolean navigateBackAndForth(By webElement) {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        log.log(Level.INFO, "navigateBackAndForth method");

        return pageIsVisible(webElement);
    }

    /**
     * Method is used to verify weather placeholder text is visible
     */
    public static Boolean placeHolderIsVisible(By webElement, String expectPlaceHolderText) {
        WebElement element = getDriver().findElement(webElement);
        boolean actualPlaceholder = false;
        if (element.getAttribute("placeholder").contains(expectPlaceHolderText)) {
            actualPlaceholder = true;
        }

        log.log(Level.INFO, "placeHolderIsVisible method");

        return actualPlaceholder;
    }

    /**
     * Method waits while the element is visible (Explicit wait)
     */
    public static WebElement waitExplicitly(WebElement webElement){
        new WebDriverWait(getDriver(), Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.visibilityOf(webElement));

        log.log(Level.INFO, "waitExplicitly method");

        return webElement;
    }

    /**
     * Method waits while the element is visible (Implicit wait)
     */
    public static void waitImplicitly(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesFile.getImplicitWait()));
        log.log(Level.INFO, "waitImplicitly method");
    }

    /**
     * Method suspends the current thread for the specified amount of time.
     */
    public static void sleepWait(int waitTime){
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.log(Level.INFO, "sleepWait method");
    }

    /**
     * Method returns title names (of id, title, assignee, stage) using getText().
     * As a parameter is receives a list of elements in a column
     * from which we expect to get title names
     */
    public static ArrayList<String> getNamesOfAnyColumns(By webElements) {
        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleNameList = getDriver().findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            titleName.add(titleNameList.get(i).getText());
        }

        log.log(Level.INFO, "getNamesOfAnyColumns method");

        return titleName;
    }

    /**
     * Method is used to click on the first element in a list
     */
    public static void clickOnTheFirstElementInAList(By webElements){
        List<WebElement> webElementList = getDriver().findElements(webElements);
        webElementList.get(0).click();
        log.log(Level.INFO, "clickOnTheFirstElementInAList method");
    }

    /**
     * Method prints in console values of column using getText() method.
     * As a parameter is receives a list of elements in a column
     * from which we expect to get and print
     */
    public static void printValueOfColumn(By webElements) {
        List<WebElement> titleNameList = getDriver().findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            System.out.println(titleNameList.get(i).getText());
        }
        log.log(Level.INFO, "printValueOfColumn method");
    }

    /**
     * Method is used to select any option by visible text in drop-down options list
     */
    public static void selectFromDropDownListByVisibleText(By dropDownElement, By drpOptions, String searchedVisibleText) {
        getDriver().findElement(dropDownElement).click();
        GlobalPages.sleepWait(2000);
        Select select = new Select((getDriver().findElement(drpOptions)));
        select.selectByVisibleText(searchedVisibleText);
        log.log(Level.INFO, "selectFromDropDownListByVisibleText method");
    }

    /**
     * Method is used to select any option by Index in drop-down options list
     */
    public static void selectDataFromDropDownListByIndex(By dropDownElement, int searchedElementIndex) {
        getDriver().findElement(dropDownElement).click();
        GlobalPages.sleepWait(3000);
        Select select = new Select((getDriver().findElement(dropDownElement)));
        select.selectByIndex(searchedElementIndex);
        log.log(Level.INFO, "selectDataFromDropDownListByIndex method");
    }

    /**
     * Method is used to perform action on Alert pop up:
     * if true - Accept click
     * if false - Dismiss click
     */
    public static void alertAcceptOrDismiss(Boolean isAccept){
        if(isAccept){
            getDriver().switchTo().alert().accept();
        }else{
            getDriver().switchTo().alert().dismiss();
        }
        log.log(Level.INFO, "alertAcceptOrDismiss method");
    }


    /**
     * Method is used to check checkBox status.
     * If not checked > we make it checked
     */
    public static void checkCheckboxStatusAndClick(WebElement checkBox) {
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        log.log(Level.INFO, "checkCheckboxStatusAndClick method");
    }

    /**
     * Method is used to check radioButton status.
     * If not selected > we make it selected
     */
    public static void checkRadioButtonStatusAndSelect(WebElement checkBox) {
        List<WebElement> checkBoxList = new ArrayList<>();

        for (int i = 0; i < checkBoxList.size(); i++) {
            if (!checkBoxList.get(i).isSelected()) {
                checkBox.click();
            }
        }
        log.log(Level.INFO, "checkRadioButtonStatusAndSelect method");
    }
}
