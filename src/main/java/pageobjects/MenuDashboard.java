package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MenuDashboard extends BaseTestConfiguration {

    private static final By homePagePanel = By.xpath("//div[@class='main-panel']");
    private static final By minimizeSideBarBtn = By.xpath("//button[@id='minimizeSidebar']");
    private static final By dashboardTab = By.xpath("//a[@id='menu-dashboard']");
    private static final By ticketsTab = By.xpath("//a[@id='menu-tickets']");
    private static final By companiesTab = By.xpath("//a[@id='menu-companies']");
    private static final By contactsTab = By.xpath("//a[@id='menu-contacts']");
    private static final By devicesTab = By.xpath("//a[@id='menu-device-list']");
    private static final By departmentsTab = By.xpath("//a[@id='menu-departments']");
    private static final By managersTab = By.xpath("//a[@id='menu-managers']");
    private static final By categoryList = By.xpath("//span[@class='break-word fixed-span label label-info']");
    private static final By titleList = By.cssSelector("a[id='ticket-block-title']");
    private static final By needImmediateReactionButton = By.xpath("//tickets-block/div[@id='accordion1']");
    private static final By closeButton = By.cssSelector("button.close");

    public ArrayList<String> returnTitleNameIfCategory(By titleColumn, String category) {
        driver.findElement(closeButton).click();
        driver.findElement(minimizeSideBarBtn).click();
        driver.findElement(dashboardTab).click();
        driver.findElement(needImmediateReactionButton).click();

        ArrayList<String> titleName = new ArrayList<>();
        List<WebElement> titleElementsList = driver.findElements(titleColumn);

        for (int i = 0; i < titleElementsList.size(); i++) {
            List<WebElement> categoryElementsList = driver.findElements(categoryList);
            if(categoryElementsList.get(i).getText().contains(category)){
                titleName.add(titleElementsList.get(i).getText());
            }
        }
        System.out.println(titleName);
        return titleName;
    }



    public static void main(String[] args) throws InterruptedException {
        BaseTestConfiguration.createDriver();
        BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration();
        baseTestConfiguration.openBrowser();
        OpenPage.clickToSignIn();
        Thread.sleep(2000);
        MenuDashboard menuTab = new MenuDashboard();
        menuTab.returnTitleNameIfCategory(titleList, "УЧЕБНЫЙ ЦЕНТР");
        driver.quit();
    }
}
