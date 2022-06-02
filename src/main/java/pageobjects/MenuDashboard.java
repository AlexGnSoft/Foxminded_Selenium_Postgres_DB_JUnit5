package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MenuDashboard extends BaseTestConfiguration {

    private static final By homePagePanel = By.xpath("//div[@class='main-panel']");
    public static final By minimizeSideBarBtn = By.xpath("//button[@id='minimizeSidebar']");
    public static final By dashboardTab = By.xpath("//a[@id='menu-dashboard']");
    private static final By ticketsTab = By.xpath("//a[@id='menu-tickets']");
    private static final By companiesTab = By.xpath("//a[@id='menu-companies']");
    private static final By contactsTab = By.xpath("//a[@id='menu-contacts']");
    private static final By devicesTab = By.xpath("//a[@id='menu-device-list']");
    private static final By departmentsTab = By.xpath("//a[@id='menu-departments']");
    private static final By managersTab = By.xpath("//a[@id='menu-managers']");
    public static final By categoryList = By.xpath("//span[@class='break-word fixed-span label label-info']");
    public static final By titleList = By.cssSelector("a[id='ticket-block-title']");
    public static final By needImmediateReactionButton = By.xpath("//tickets-block/div[@id='accordion1']");
    public static final By closeButton = By.cssSelector("button.close");
    public static final String razrabotka = "РАЗРАБОТКА";
    public static final String finance = "ФИНАНСЫ";
    public static final String education = "УЧЕБНЫЙ ЦЕНТР";


    public static void click(By webElement){
        driver.findElement(webElement).click();
    }

    public static ArrayList<String> returnTitleNameForCategory(By titleColumn, By category, String searchedCategory) {
        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleList = driver.findElements(titleColumn);
        List<WebElement> categoryList = driver.findElements(category);
        for (int i = 0; i < titleList.size(); i++) {
            if(categoryList.get(i).getText().contains(searchedCategory)){
                titleName.add(titleList.get(i).getText());
            }
        }

        for (int j = 0; j < titleName.size(); j++) {
            System.out.println(titleName.get(j));
        }
        return titleName;
    }


    public static void main(String[] args) throws InterruptedException {
        BaseTestConfiguration.createDriver();
        BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration();
        baseTestConfiguration.openBrowser();
        OpenPage.clickToSignIn();
        Thread.sleep(1000);
        returnTitleNameForCategory(titleList, categoryList, finance);
        driver.quit();
    }
}
