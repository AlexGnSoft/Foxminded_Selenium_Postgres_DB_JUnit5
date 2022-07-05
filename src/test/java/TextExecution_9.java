import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageobjects.GlobalPages;
import pageobjects.MenuDashboard;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;
import utils.ScreenshotWatcher;

public class TextExecution_9 extends BaseTestConfiguration{

    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

    @Test
    public void testReturnTitleByCategoryRazrabotka(){
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
    public void testReturnTitleByCategoryFinance(){
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
    public void testReturnIDsByPriority(){
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

    @Test
    public void testPrintIdValue() {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        GlobalPages.sleepWait(3000);
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(3000);

        //Print text of ID from Tickets page
        GlobalPages.printValueOfColumn(TicketsPage.idList);
    }

    @Test
    public void testPrintTitleValue() {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        GlobalPages.sleepWait(3000);
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(3000);

        //Print text of ID from Tickets page
        GlobalPages.printValueOfColumn(TicketsPage.titleList);
    }

    @Test
    public void testPrintAssigneeValue() {

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        GlobalPages.sleepWait(3000);
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(3000);

        //Print text of assigned list from Tickets page
        GlobalPages.printValueOfColumn(TicketsPage.assigneeList);
    }

    @Test
    public void testPrintStagesValue() {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Due to bug on FE side of home page we reload the home page
        GlobalPages.sleepWait(3000);
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(3000);

        //Print text of stage list from Tickets page
        TicketsPage.printStages(TicketsPage.stageList);
    }
}
