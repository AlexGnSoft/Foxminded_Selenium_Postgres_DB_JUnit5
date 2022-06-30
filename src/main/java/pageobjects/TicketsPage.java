package pageobjects;

import config.BaseTestConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.Builder_Singleton_Strategy.Strategy_Pattern.ISearchStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketsPage extends BaseTestConfiguration implements ISearchStrategy {

    public static final By ticketsTab = By.xpath("//a[@id='menu-tickets']");
    public static final By minimizeSideBarBtn = By.xpath("//button[@id='minimizeSidebar']");
    public static final By searchField = By.xpath("//input[@id='search-bar']");
    public static final By searchBtn = By.xpath("//button[@id='search-bar-submit']");
    public static final By searchResultPage = By.xpath("//div[@class='card-content']");
    public static final By languageBtn = By.xpath("//a[concat(@class,'language_button') and @id='current-language']");
    public static final By allCategoriesBtn = By.xpath("//li[contains(@class,'select-category')]/a[contains(@class,'dropdown-toggle')]");
    public static final By notificationsBtn = By.xpath("//a[@class='dropdown-toggle']/i[text()='notifications']");
    public static final By mailBoxBtn = By.xpath("//a[@id='navbar-mail-backlog']");
    public static final By personNavBar = By.xpath("//a[@id='navbar-person']");
    public static final By totalTicketsBtn = By.xpath("//a[@name='stage-status-button' and @id='stage-total']");
    public static final By closedTicketsBtn = By.xpath("//a[@id='stage-closed']");
    public static final By openBtn = By.xpath("//a[@id='OPEN']");
    public static final By inProgressBtn = By.xpath("//a[@id='IN PROGRESS']");
    public static final By rejectedBtn = By.xpath("//a[@id='Rejected/SaaS']");
    public static final By doneBtn = By.xpath("//a[@id='DONE']");
    public static final By newTicketBtn = By.cssSelector("#create-new-ticket");
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
    public static final By drpCategory = By.cssSelector("#categoryId");
    public static final By drpStage = By.cssSelector("#stageId");
    public static final By drpStageOptions = By.cssSelector("#stageId");
    public static final By drpContact = By.xpath("//div[@class='inline']");
    public static final By drpContactOptions = By.xpath("//select[@id='contactId']");
    public static final By drpPriority = By.cssSelector("#priority");
    public static final By calendarDataPicker = By.cssSelector(".ui-datepicker-trigger.ui-calendar-button");
    public static final By selectNextMonth = By.xpath("//span[@class='fa fa-angle-right']");
    public static final By selectPreviousMonth = By.xpath("//span[@class='fa fa-angle-left']");
    public static final By minutePickerList = By.xpath("//div[@class='ui-minute-picker']/a[@class='ng-tns-c10-2']");
    public static final By hoursPickerList = By.xpath("//div[@class='ui-hour-picker']/a[@class='ng-tns-c10-2']");
    public static final By drpDepartment = By.xpath("//div/select[@id='department']");
    public static final By drpDepartmentOptions = By.xpath("//select[@id='department']");
    public static final By drpManager = By.cssSelector("#manager");
    public static final By selectFiltersBtn = By.xpath("//div[@class='col-sm-10']/button[@class='btn btn-success btn-outline']");
    public static final By submitBtn = By.cssSelector("#submit-btn");
    public static final By accessibleCalendarDatesList = By.xpath("//td[@class='ng-tns-c10-3']/a[@class='ui-state-default ng-tns-c10-3']");

    private static final Logger log = LogManager.getLogger(TicketsPage.class.getName());

    /**
     * Method returns a list of Stage names using getText() method.
     */
    public ArrayList<String> getNamesOfStages(By webElements) {
        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleNameList = getDriver().findElements(webElements);
        for (int i = 0; i < titleNameList.size(); i++) {
            titleName.add(titleNameList.get(i).getText());

        }

        log.log(Level.INFO, "getNamesOfStages method");

        return titleName;
    }

    /**
     * Method prints stage names using getText() from Stage column.
     * "OPEN", "DONE", "IN PROGRESS" stages are used in "if" method because there were are not unique selectors found
     */
    public static void printStages(By webElements) {
        List<WebElement> stageNameList = getDriver().findElements(webElements);
        for (int i = 0; i < stageNameList.size(); i++) {
            String text = stageNameList.get(i).getText();
            if (text.contains("OPEN") || text.contains("IN PROGRESS") || text.contains("DONE")) {
                System.out.println(text);
            }
        }
        log.log(Level.INFO, "printStages method");
    }


    /**
     * Method is used reach searched option from drop-down options list,
     * by clicking on every option until it reaches the searched one
     */
    public static void selectOptionOneByOne(By dropDownElement, String searchedVisibleText) {
        Select select = new Select(getDriver().findElement(dropDownElement));
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            getDriver().findElement(dropDownElement).click();
            options.get(i).click();
            if (options.get(i).getText().contains(searchedVisibleText)) {
                break;
            }
        }
        log.log(Level.INFO, "selectOptionOneByOne method");
    }

    /**
     * Method is used to select the 1st option from drop-down options list
     */
    public static void selectFirstOptionFromDropDownList(By dropDownElement) {
        getDriver().findElement(dropDownElement).click();
        Select select = new Select(getDriver().findElement(dropDownElement));
        select.getFirstSelectedOption().isDisplayed();
        log.log(Level.INFO, "selectFirstOptionFromDropDownList method");
    }

    /**
     * Method is used to select the last option from drop-down options list
     */
    public static void selectLastOptionFromDropDownList(By dropDownElement) {
        Select select = new Select(getDriver().findElement(dropDownElement));
        int optionsSize = select.getOptions().size();
        select.selectByIndex(optionsSize - 1);
        log.log(Level.INFO, "selectLastOptionFromDropDownList method");
    }

    /**
     * Method clicks on calendar months, hours, minutes and random accessible date
     */
    public static void selectDateInCalendar() {
        getDriver().findElement(calendarDataPicker).click();
        getDriver().findElement(selectNextMonth).click();
        getDriver().findElement(selectPreviousMonth).click();

        List<WebElement> hoursPickers = getDriver().findElements(hoursPickerList);
        for (WebElement hours : hoursPickers) {
            hours.click();
        }

        List<WebElement> minutesPickers = getDriver().findElements(minutePickerList);
        for (WebElement minutes : minutesPickers) {
            minutes.click();
        }

        //a list of webElements with accessible dates
        List<WebElement> accessibleCalendarDates = getDriver().findElements(accessibleCalendarDatesList);

        //in a loop we click on a random and accessible date in a calendar
        Random random;
        for (int i = 1; i < accessibleCalendarDates.size(); i++) {
            random = new Random();
            random.nextInt(accessibleCalendarDates.size());
            accessibleCalendarDates.get(i).click();
        }
        log.log(Level.INFO, "selectDateInCalendar method");
    }

    /**
     * Method uploads a file from certain directory on your PC
     */
    public static void fileUpload(String filePath) {
        WebElement uploadBtn = getDriver().findElement(selectFiltersBtn);
        uploadBtn.click();
        uploadBtn.sendKeys(filePath);
        log.log(Level.INFO, "fileUpload method");
    }

    @Override
    public void search(String searchFor) {
        getDriver().findElement(searchField).sendKeys(searchFor);
        GlobalPages.click(searchBtn);
        log.log(Level.INFO, "search method");
    }
}



