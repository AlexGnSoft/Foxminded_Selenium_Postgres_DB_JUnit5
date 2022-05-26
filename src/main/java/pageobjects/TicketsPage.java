package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class TicketsPage extends BaseTestConfiguration {

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

}
