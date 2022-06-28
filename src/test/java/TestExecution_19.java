import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.*;
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
//        System.out.println(db.getStringValue(sqlQuery, "ticket", 9).equals("TestTitle2"));

//        db.getListOfValues(sqlQuery).contains(randomTitle);
//        db.getListOfValues(sqlQuery).contains(randomDescription);
//        db.getMapDataFromDataBase(db.getResultSet(sqlQuery), keyMapValue).containsValue(randomTitle);
    }

    @Test
    public void testUIAndDataBaseCreteNewDepartment() throws SQLException{
        //Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomDepartmentTitle = rd.randomString(15, false, false, true);
        String sqlQuery = "select*from department";
        String keyMapValue = "name";

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
        db.getListOfValues(sqlQuery).contains(randomDepartmentTitle);
        db.getMapDataFromDataBase(db.getResultSet(sqlQuery), keyMapValue).containsValue(randomDepartmentTitle);
    }

    @Test
    public void testUIAndDataBaseCreateNewContact() throws SQLException{
        // Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomFName = "VanDamPeredam";
//        String randomFName = rd.randomString(10, false, false, true);
        String randomLName = rd.randomString(15, false, false, true);
        String randomEmail = rd.randomString(15, true, false, false);
        String sqlQuery = "select*from contact";
        String keyMapValue = "first_name";

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

        //Click on Check-boxes if it's not checked. Finding element is test is a temporary solution.
        GlobalPages.checkCheckboxStatusAndClick(getDriver().findElement(By.xpath("//label/input[@id='notify-on-stage-change']")));
        GlobalPages.checkCheckboxStatusAndClick(getDriver().findElement(By.xpath("//input[@name='notificationOnDoneStage']")));
        GlobalPages.checkCheckboxStatusAndClick(getDriver().findElement(By.xpath("//input[@name='notificationOnNewComment']")));
        GlobalPages.checkCheckboxStatusAndClick(getDriver().findElement(By.xpath("//label/input[@id='notify-on-stage-change']")));

        //Select radio button if it's not already selected. Finding element is test is a temporary solution.
        GlobalPages.checkRadioButtonStatusAndSelect(getDriver().findElement(By.xpath("//input[@value='0']")));
        GlobalPages.checkRadioButtonStatusAndSelect(getDriver().findElement(By.xpath("//input[@value='1']")));
        GlobalPages.checkRadioButtonStatusAndSelect(getDriver().findElement(By.xpath("//input[@value='2']")));
        GlobalPages.checkRadioButtonStatusAndSelect(getDriver().findElement(By.xpath("//input[@value='3']")));

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);
        GlobalPages.sleepWait(5000);

        //Compare UI and DB


    }
}
