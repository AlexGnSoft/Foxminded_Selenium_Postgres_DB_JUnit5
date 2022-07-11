package tests.CreateNew;

import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomDataGenerator;
import java.sql.SQLException;

public class TestExecution_19 extends BaseTestConfiguration {

    @Tag("create_new_ticket")
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

    @Tag("create_new_department")
    @Test
    public void testUIAndDataBaseCreateNewDepartment() throws SQLException{
        //Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomDepartmentTitle = rd.randomString(15, false, false, true);
        String sqlQuery = "select*from department";
        String keyMap = "name";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.departmentsTab);
        GlobalPages.clickOnVisibleElement(DepartmentsNewDepPage.newDepartmentBtn);
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.newDepartmentPage);

        //Fill in department title
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, randomDepartmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Compare UI and DB
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery,randomDepartmentTitle), "Title isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInMap(sqlQuery, keyMap, randomDepartmentTitle), "Title isn't found in DB");
    }

    @Tag("create_new_contact")
    @Test
    public void testUIAndDataBaseCreateNewContact() throws SQLException{
        // Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomFName = rd.randomString(10, false, false, true);
        String randomLName = rd.randomString(15, false, false, true);
        String randomEmail = rd.randomString(15, true, false, false);
        String sqlQuery = "select*from contact";
        String keyMap = "first_name";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, randomFName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, randomLName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, randomEmail);

        GlobalPages.sleepWait(3000);

        //Scroll down the page to see the buttons on bottom of the page
        GlobalPages.scrollDown();

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);
        GlobalPages.sleepWait(3000);

        //Compare UI and DB
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery,randomFName), "First name isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, randomLName), "Last name isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, randomEmail), "Email isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInMap(sqlQuery, keyMap, randomFName), "First name isn't found in DB");
    }
}
