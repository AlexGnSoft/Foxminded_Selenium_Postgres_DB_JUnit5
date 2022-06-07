import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.MenuDashboard;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;


public class TextExecution_9 extends BaseTestConfiguration{

    @Test
    public void printIdValue() throws InterruptedException {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Print text of ID from Tickets page
        TicketsPage.printValueOfColumn(TicketsPage.idList);
    }

    @Test
    public void printTitleValue() throws InterruptedException {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Print text of ID from Tickets page
        TicketsPage.printValueOfColumn(TicketsPage.titleList);
    }

    @Test
    public void printAssigneeValue() throws InterruptedException {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Print text of assigned list from Tickets page
        TicketsPage.printValueOfColumn(TicketsPage.assigneeList);
    }

    @Test
    public void printStagesValue() throws InterruptedException {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Print text of stage list from Tickets page
        TicketsPage.printStages(TicketsPage.stageList);
    }

    @Test
    public void returnTitleByCategoryRazrabotka(){
        //Test data
        final String razrabotka = "РАЗРАБОТКА";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Go to Dashboard page > 'Need immediate reaction' drop-down list
        MenuDashboard.getToNeedImmediateReactionPage();

        // Run test method
        MenuDashboard.returnTitleNameByCategory(MenuDashboard.titleList, MenuDashboard.categoryList, razrabotka);
    }

    @Test
    public void returnTitleByCategoryFinance(){
        //Test data
        final String finance = "ФИНАНСЫ";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Go to Dashboard page > 'Need immediate reaction' drop-down list
        MenuDashboard.getToNeedImmediateReactionPage();

        // Run test method
        MenuDashboard.returnTitleNameByCategory(MenuDashboard.titleList, MenuDashboard.categoryList, finance);
    }

    @Test
    public void returnIDsByPriority(){
        //Test data
        final String priority = "P3";

        // Go to application login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Go to Dashboard page > 'Need immediate reaction' drop-down list
        MenuDashboard.getToNeedImmediateReactionPage();

        // Run test method
        MenuDashboard.returnIDsByPriority(priority);
    }
}
