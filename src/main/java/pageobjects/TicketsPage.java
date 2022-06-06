package pageobjects;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TicketsPage extends BaseTestConfiguration{

    private static final By ticketsTab = By.xpath("//a[@id='menu-tickets']");
    private static final By minimizeSideBarBtn = By.xpath("//button[@id='minimizeSidebar']");
    private static final By searchField = By.xpath("//input[@type='search']");
    private static final By searchButton = By.xpath("//i[@class='search-bar_icon material-icons']");
    private static final By languageBtn = By.xpath("//a[concat(@class,'language_button') and @id='current-language']");
    private static final By allCategoriesBtn = By.xpath("//li[contains(@class,'select-category')]/a[contains(@class,'dropdown-toggle')]");
    private static final By notificationsBtn = By.xpath("//a[@class='dropdown-toggle']/i[text()='notifications']");
    private static final By mailBoxBtn = By.xpath("//a[@id='navbar-mail-backlog']");
    private static final By personNavBar = By.xpath("//a[@id='navbar-person']");
    private static final By totalTicketsBtn = By.xpath("//a[@name='stage-status-button' and @id='stage-total']");
    private static final By closedTicketsBtn = By.xpath("//a[@id='stage-closed']");
    private static final By openBtn = By.xpath("//a[@id='OPEN']");
    private static final By inProgressBtn = By.xpath("//a[@id='IN PROGRESS']");
    private static final By rejectedBtn = By.xpath("//a[@id='Rejected/SaaS']");
    private static final By doneBtn = By.xpath("//a[@id='DONE']");
    public static final By newTicketBtn = By.xpath("//button[@id='create-new-ticket']");
    public static final By allTicketsBtn = By.xpath("//li[@id='tickets']//a[@tooltipplacement='bottom']");
    public static final By myTicketsBtn = By.xpath("//li[@id='user_tickets']/a[@class='btn btn-primary']");
    public static final By followedTicketsBtn = By.xpath("//li[@id='followed_tickets']");
    public static final By unprocessedTicketsBtn = By.xpath("//li[@id='unprocessed_tickets']");
    public static final By unprocessedTasksBtn = By.xpath("//li[@id='unprocessedTasks']");
    public static final By myTasksBtn = By.xpath("//li[@id='myTasks']");
    public static final By ProgressBarList = By.xpath("//div[@class='progress-bar']");
    public static final By editBtnList = By.xpath("//a[@title='Edit']");
    public static final By followBtnList = By.xpath("//div[@class='following-wrapper']");
    public static final By checkBoxBtnList = By.xpath("//span[@class='checkbox-material']//span[@class='check']");
    public static final By nextBtn = By.xpath("//a[@aria-label='Next page']");
    public static final By previousBtn = By.xpath("//a[@aria-label='Previous page']");
    public static final By idList = By.cssSelector("td[width='80px']");
    public static final By titleList = By.cssSelector(".ticket_title");
    public static final By assigneeList = By.cssSelector(".ticket_assignee");
    public static final By stageList = By.cssSelector("td[width='130px']");


    public static final By createTicketPage = By.cssSelector("div[class='container-fluid']");
    public static final By titleField = By.cssSelector("#title");
    public static final By descriptionField = By.cssSelector("textarea[id='description']");
    public static final By descriptionFieldPlaceHolder = By.cssSelector("textarea[placeholder='Please input your description here...']");
    public static final By drpCategory = By.cssSelector("#categoryId");
    public static final By drpStage = By.cssSelector("#stageId");
    public static final By drpCompany = By.cssSelector("#company");
    public static final By drpContact = By.cssSelector("#contactId");
    public static final By drpPriority = By.cssSelector("#priority");
    public static final By calendarDataPicker = By.cssSelector(".ui-datepicker-trigger.ui-calendar-button");
    public static final By calendarDataField = By.cssSelector("#done-deadline-date");
    public static final By drpDepartment = By.cssSelector("#department");
    public static final By drpManager = By.cssSelector("#manager");
    public static final By selectFiltersBtn = By.cssSelector("#add-files");
    public static final By submitBtn = By.cssSelector("#submit-btn");
    public static final By cancelBtn = By.cssSelector("#cancel-btn");

    /**
     * Method returns title names (of id, title, assignee, stage) using getText().
     * As a parameter is receives a list of elements in a column
     * from which we expect to get title names
     */
    public ArrayList<String> getNamesOfAnyColumns(By webElements) {
        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleNameList = driver.findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            titleName.add(titleNameList.get(i).getText());
        }
           return titleName;
    }

    /**
     * Method returns a list of Stage names using getText() method.
     */
    public ArrayList<String> getNamesOfStages(By webElements) {
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
     * Method prints stage names using getText() from Stage column.
     * "OPEN", "DONE", "IN PROGRESS" stages are used in "if" method because there were are not unique selectors found
     */
    public static void printStages(By webElements) {
        List<WebElement> stageNameList = driver.findElements(webElements);
        for (int i = 0; i < stageNameList.size(); i++) {
            String text = stageNameList.get(i).getText();
            if(text.contains("OPEN") || text.contains("IN PROGRESS") || text.contains("DONE")){
                System.out.println(text);
            }
        }
    }

    public static void enterDataToTheField(By webElement, String data){
        driver.findElement(webElement).sendKeys(data);
    }

    public static Boolean navigateBackAndForth(){
        driver.navigate().back();
        driver.navigate().forward();
        return pageIsVisible(createTicketPage);
    }

    public static void selectDataFromDropDownListByIndex(By dropDownElement, int searchedElementIndex) {
        driver.findElement(dropDownElement).click();
        Select select = new Select((driver.findElement(dropDownElement)));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            option.isDisplayed();
        }
        select.selectByIndex(searchedElementIndex);
    }

    public static void selectFromDropDownListByVisibleText(By dropDownElement, String searchedVisibleText) {
        driver.findElement(dropDownElement).click();
        Select select = new Select((driver.findElement(dropDownElement)));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            option.isDisplayed();
        }
        select.selectByVisibleText(searchedVisibleText);
    }

    public static void selectOptionOneByOne(By dropDownElement, String searchedVisibleText) {
        Select select = new Select(driver.findElement(dropDownElement));
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            driver.findElement(dropDownElement).click();
            options.get(i).click();
            if(options.get(i).getText().contains(searchedVisibleText)){
                break;
            }
        }
    }

    public static void selectFirstOptionFromDropDownList(By dropDownElement){
        driver.findElement(dropDownElement).click();
        Select select = new Select(driver.findElement(dropDownElement));
        select.getFirstSelectedOption().isDisplayed();
    }


    public static void selectLastOptionFromDropDownList(By dropDownElement){
        Select select = new Select(driver.findElement(dropDownElement));
        int optionsSize = select.getOptions().size();
        select.selectByIndex(optionsSize - 1);
    }

    public static Boolean placeHolderInVisible(By webElement, String expectPlaceHolderText){
        WebElement element = driver.findElement(webElement);
        boolean actualPlaceholder = false;
        if(element.getAttribute("placeholder").contains(expectPlaceHolderText)){
            actualPlaceholder = true;
        }
        return actualPlaceholder;
    }

    public static void








    public static void main(String[] args) throws InterruptedException {
        BaseTestConfiguration.createDriver();
        BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration();
        baseTestConfiguration.openBrowser();
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        Thread.sleep(1000);
        baseTestConfiguration.clickOnWebElement(TicketsPage.newTicketBtn);
        Thread.sleep(2000);

        placeHolderInVisible(descriptionField, "Please input your description here...");
        Thread.sleep(2000);
        System.out.println("Ok");
        driver.quit();
    }
}
