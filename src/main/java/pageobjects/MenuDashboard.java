package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MenuDashboard extends BaseTestConfiguration {

    public static final By homePagePanel = By.xpath("//div[@class='main-panel']");
    public static final By minimizeSideBarBtn = By.xpath("//button[@id='minimizeSidebar']");
    public static final By dashboardTab = By.xpath("//a[@id='menu-dashboard']");
    public static final By ticketsTab = By.xpath("//a[@id='menu-tickets']");
    public static final By companiesTab = By.xpath("//a[@id='menu-companies']");
    public static final By contactsTab = By.xpath("//a[@id='menu-contacts']");
    public static final By devicesTab = By.xpath("//a[@id='menu-device-list']");
    public static final By departmentsTab = By.xpath("//a[@id='menu-departments']");
    public static final By managersTab = By.xpath("//a[@id='menu-managers']");
    public static final By idsList = By.cssSelector("td[style='width: 5% !important;']");
    public static final By prioritiesList = By.xpath("//td[contains(text(), 'P')]");
    public static final By categoryList = By.xpath("//span[@class='break-word fixed-span label label-info']");
    public static final By titleList = By.cssSelector("a[id='ticket-block-title']");
    public static final By needImmediateReactionButton = By.xpath("//tickets-block/div[@id='accordion1']");
    public static final By closeButton = By.cssSelector("button.close");

    /**
     * Method is used to get to NeedImmediateReactionPage
     */
    public static void getToNeedImmediateReactionPage(){
        GlobalPages.click(closeButton);
        GlobalPages.click(minimizeSideBarBtn);
        GlobalPages.click(dashboardTab);
        GlobalPages.click(needImmediateReactionButton);
    }

    /**
     * Depending on a category, this method returns and prints corresponding title names.
     */
    public static ArrayList<String> returnTitleNameByCategory(By titleColumn, By category, String searchedCategory) {
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

    /**
     * Depending on a priority, this method returns and prints all IDs.
     */
    public static ArrayList<String> returnIDsByPriority(String priority){
        ArrayList<String> ids = new ArrayList<>();
        List<WebElement> idList = driver.findElements(idsList);
        List<WebElement> priorityList = driver.findElements(prioritiesList);
        for (int i = 0; i < idList.size(); i++) {
            if (priorityList.get(i).getText().contains(priority)){
                ids.add(idList.get(i).getText());
            }
        }

        for (int j = 0; j < ids.size(); j++) {
            System.out.println(ids.get(j));
        }
        return ids;
    }
}
