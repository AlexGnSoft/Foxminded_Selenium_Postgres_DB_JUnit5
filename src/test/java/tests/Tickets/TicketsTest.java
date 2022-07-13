package tests.Tickets;

import com.sun.security.sasl.util.AbstractSaslImpl;
import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.MenuDashboard;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;
import utils.RandomDataGenerator;

import java.sql.SQLException;

public class TicketsTest extends BaseTestConfiguration{

    @Tag("create_new_ticket")
    @Test
    public void testCreateNewTicket() {
        //Test data
        String ticketTitle = "My ticket from automation 24";
        String description = "My description to the ticket";
        String stage = "IN PROGRESS";
        String departmentName = "Посетители";
        String contactName = "Drozdh Udahvxadb";
        int indexOfOption = 4;
        String managerName = "Ярослав Коваленко";
        String pathToTheFileOnPc = "src/main/java/helpfiles/Ukraine-Sign.jpeg";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.createTicketPage));

        //Enter title name into title field
        GlobalPages.enterDataToTheField(TicketsPage.titleField, ticketTitle);

        //Enter description into description field
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, description);

        //Select category by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfOption);

        //Select stage by visible text
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpStage, TicketsPage.drpStageOptions,stage);

        //Select contact
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpContact, TicketsPage.drpContactOptions, contactName);

        //Select priority by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpPriority, indexOfOption);

        //Select random, but accessible date in the calendar
//        TicketsPage.selectDateInCalendar();

        GlobalPages.sleepWait(2000);

        //Select department by first option in the drop-down list
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, TicketsPage.drpDepartmentOptions, departmentName);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file
        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        GlobalPages.clickOnVisibleElement(TicketsPage.submitBtn);
        GlobalPages.sleepWait(1000);

        //Refresh the page
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Tickets page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(TicketsPage.titleList), ticketTitle));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(TicketsPage.stageList), stage));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(TicketsPage.ticketCompanyList), contactName));
    }

    @Tag("create_new_ticket_db_test")
    @Test
    public void testUIAndDataBaseCreateNewTicket() throws SQLException {
        //Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomTitle = rd.randomString(20, false, false, true);
        String randomDescription = rd.randomString(25, false, false, true);
        String stage = "IN PROGRESS";
        String departmentName = "Комната добра";
        String contactName = "Drozdh Udahvxadb";
        int indexOfOption = 4;
        String managerName = "Ярослав Коваленко";
        String pathToTheFileOnPc = "src/main/java/helpfiles/Ukraine-Sign.jpeg";
        String sqlQuery = "select * from ticket";
        String keyMap = "title";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.createTicketPage));

        //Enter title name into title field
        GlobalPages.enterDataToTheField(TicketsPage.titleField, randomTitle);

        //Enter description into description field
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, randomDescription);

        //Select category by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfOption);

        //Select stage by visible text
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpStage, TicketsPage.drpStageOptions,stage);

        //Select contact
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpContact, TicketsPage.drpContactOptions, contactName);

        //Select priority by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpPriority, indexOfOption);

        //Select random, but accessible date in the calendar
//        TicketsPage.selectDateInCalendar();

        //Select department by first option in the drop-down list
        GlobalPages.sleepWait(2000);

        //Select department by first option in the drop-down list
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, TicketsPage.drpDepartmentOptions, departmentName);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file
        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        GlobalPages.clickOnVisibleElement(TicketsPage.submitBtn);

        //Compare UI and DB
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery,randomDescription), "Description isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, randomTitle), "Title isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInMap(sqlQuery, keyMap, randomTitle), "Title isn't found in DB");
    }

    @Tag("ticket")
    @Test
    public void testSearchCreatedTicket() {
        //Test data
        String ticketTitle = "My ticket from automation 8";
        String description = "My description to the ticket";
        String stage = "IN PROGRESS";
        String departmentName = "Комната добра";
        String contactName = "Drozdh Udahvxadb";
        int indexOfOption = 4;
        String managerName = "Ярослав Коваленко";
        String pathToTheFileOnPc = "src/main/java/helpfiles/Ukraine-Sign.jpeg";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.createTicketPage));

        //Enter title name into title field
        GlobalPages.enterDataToTheField(TicketsPage.titleField, ticketTitle);

        //Enter description into description field
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, description);

        //Select category by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfOption);

        //Select stage by visible text
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpStage, TicketsPage.drpStageOptions, stage);

        //Select contact
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpContact, TicketsPage.drpContactOptions, contactName);

        //Select priority by index
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpPriority, indexOfOption);

        //Select random, but accessible date in the calendar
        TicketsPage.selectDateInCalendar();

        //Select department by first option in the drop-down list
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, TicketsPage.drpDepartmentOptions, departmentName);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file
        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        GlobalPages.clickOnVisibleElement(TicketsPage.submitBtn);

        //Search for created Dep on Department page by using method from Interface
        TicketsPage ticketsPage = new TicketsPage();
        ticketsPage.search(ticketTitle);
        GlobalPages.sleepWait(3000);

        //Verify that Search Result page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.searchResultPage), "Search result page is not visible");
    }

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("ticket")
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

    @Tag("edit_ticket")
    @Test
    public void testEditTicket() throws SQLException {
        //Test data
        DataBase db = new DataBase();
        RandomDataGenerator generator = new RandomDataGenerator();
        int indexOfCategory = Integer.parseInt(generator.randomInt(5, 1));
        String rndTitle = generator.randomString(20, false, false, true);
        String rndDescription = generator.randomString(40, false, false, true);
        String priority = "P5";
        String sqlQuery = "select * from ticket";

        //Go to the application
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        GlobalPages.sleepWait(2000);

        //Refresh the page (bug on the FE > need to refresh several time for data to be loaded)
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);
        getDriver().navigate().refresh();

        //Verify that ticket page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.ticketPage));

        //Click on "Edit" button for the first ticket in a list
        GlobalPages.sleepWait(2000);
        GlobalPages.clickOnTheFirstElementInAList(TicketsPage.editBtnList);
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.createTicketPage));

        //Update title and description
        GlobalPages.enterDataToTheField(TicketsPage.titleField, rndTitle);
        GlobalPages.sleepWait(2000);
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, rndDescription);

        //Update category and priority
        GlobalPages.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfCategory);
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpPriority, TicketsPage.drpPriorityOptions,priority);

        //Click "Submit" button
        GlobalPages.click(TicketsPage.submitBtn);
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.searchResultPage));
        GlobalPages.sleepWait(2000);

        //Validate that updated data is displayed on Tickets home page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(TicketsPage.titleList),rndTitle));

        //Validate that updated data in dataBase
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, rndTitle), "Title is not found in DB");
    }
}
