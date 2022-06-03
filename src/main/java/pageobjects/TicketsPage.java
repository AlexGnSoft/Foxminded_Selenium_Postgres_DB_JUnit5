package pageobjects;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    private static final By newTicketBtn = By.xpath("//button[@id='create-new-ticket']");
    private static final By allTicketsBtn = By.xpath("//li[@id='tickets']//a[@tooltipplacement='bottom']");
    private static final By myTicketsBtn = By.xpath("//li[@id='user_tickets']/a[@class='btn btn-primary']");
    private static final By followedTicketsBtn = By.xpath("//li[@id='followed_tickets']");
    private static final By unprocessedTicketsBtn = By.xpath("//li[@id='unprocessed_tickets']");
    private static final By unprocessedTasksBtn = By.xpath("//li[@id='unprocessedTasks']");
    private static final By myTasksBtn = By.xpath("//li[@id='myTasks']");

    private static final By ProgressBarList = By.xpath("//div[@class='progress-bar']");
    private static final By editBtnList = By.xpath("//a[@title='Edit']");
    private static final By followBtnList = By.xpath("//div[@class='following-wrapper']");
    private static final By checkBoxBtnList = By.xpath("//span[@class='checkbox-material']//span[@class='check']");

    private static final By nextBtn = By.xpath("//a[@aria-label='Next page']");
    private static final By previousBtn = By.xpath("//a[@aria-label='Previous page']");

    public static final By idList = By.cssSelector("td[width='80px']");
    public static final By titleList = By.cssSelector(".ticket_title");
    public static final By assigneeList = By.cssSelector(".ticket_assignee");
    public static final By stageList = By.cssSelector("td[width='130px']");


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


    /**
     * Method clicks on a certain webElement
     */

    public void clickOnWebElement(By element){
        WebElement webElement = driver.findElement(element);
        waitElementIsVisible(webElement).click();
    }







    public static void main(String[] args) throws InterruptedException {
        BaseTestConfiguration.createDriver();
        BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration();
        baseTestConfiguration.openBrowser();
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials() );
        Thread.sleep(3000);
//        OpenPage.implicitWait();
        TicketsPage.printStages(stageList);
        driver.quit();
    }
}
