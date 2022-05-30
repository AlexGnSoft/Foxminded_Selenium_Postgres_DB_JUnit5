package pageobjects;

import config.BaseTestConfiguration;
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

    private static final By idList = By.cssSelector("td[width='80px']");
    private static final By titleList = By.cssSelector(".ticket_title");
    private static final By assigneeList = By.xpath("tr[class='assigned-manager']");
    private static final By stageList = By.cssSelector("td[width='130px']");


    public String[] getNamesOfAllTitles(By webElements) {
        String [] titleName = new String[10];
        List<WebElement> titleNameList = driver.findElements(webElements);
        for (int i = 1; i < titleNameList.size(); i++) {
            titleName[i] = titleNameList.get(i).getText();
            System.out.println(titleName[i]);

        }
           return titleName;
    }

    public void printValueOfColumn(By webElements) {
        List<WebElement> titleNameList = driver.findElements(webElements);
        for (WebElement element : titleNameList) {
            System.out.println(element.getText());
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://rozetka.com.ua/");
//        Thread.sleep(3000);
//        List<WebElement> elements = driver.findElements(By.cssSelector(".menu-categories__link"));
//        for (int i = 0; i < elements.size(); i++) {
//            System.out.println(elements.get(i).getText());
//        }
//        driver.quit();


        BaseTestConfiguration.createDriver();
        BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration();
        baseTestConfiguration.openBrowser();
        OpenPage.clickToSignIn();
        Thread.sleep(3000);

        TicketsPage ticketsPage = new TicketsPage();

        ticketsPage.getNamesOfAllTitles(titleList);

    }
}
