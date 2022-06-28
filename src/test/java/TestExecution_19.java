import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;
import utils.RandomDataGenerator;

import java.sql.SQLException;

public class TestExecution_19 extends BaseTestConfiguration {

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
        String sqlQuery = "select*from ticket";
        String keyMapValue = "title";

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
        TicketsPage.selectDateInCalendar();

        //Select department by first option in the drop-down list
        GlobalPages.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, TicketsPage.drpDepartmentOptions, departmentName);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file
        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        GlobalPages.clickOnVisibleElement(TicketsPage.submitBtn);

        //Compare UI and DB
        db.getListOfValues(sqlQuery).contains(randomTitle);
        db.getListOfValues(sqlQuery).contains(randomDescription);
        db.getMapDataFromDataBase(db.getResultSet(sqlQuery), keyMapValue).containsValue(randomTitle);
    }
}
