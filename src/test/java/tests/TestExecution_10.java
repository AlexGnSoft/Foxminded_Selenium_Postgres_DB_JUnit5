package tests;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class TestExecution_10 extends BaseTestConfiguration {

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

    @Test
    public void testCreateNewDepartmentWithoutAddInfo() {
        //Test data
        String departmentTitle = "My department 2";

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
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Refresh the page
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));
    }

    @Test
    public void testCreateNewDepartmentWithAddInfo() {
        //Test data
        String departmentTitle = "My department 8";
        String phone = "+4634342424";
        String skype = "alex";
        String website = "alex.com";
        String email = "alex@gmail.com";
        String country = "Universe";
        String city = "Paradise";
        String street = "this is my street";
        String building = "777";
        String zipCode = "12345";
        String roomNumber = "000";

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
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on 'Additional Information+' button
        GlobalPages.click(DepartmentsNewDepPage.additionalInfoBtn);

        //Fill in all fields
        DepartmentsNewDepPage.fillInAllFields(phone, skype,website,email,country,city, street, building, zipCode, roomNumber);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);
//
//        //Refresh the page
//        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList),departmentTitle));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depPhoneList),phone));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depEmailList),email));
    }

    @Test
    public void testCreateNewDepartmentAndDeleteCreatedDepartment() {
        //Test data
        String departmentTitle = "My department 14";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.departmentsTab);
        GlobalPages.click(DepartmentsNewDepPage.newDepartmentBtn);
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.newDepartmentPage);

        //Fill in department title
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));

        //Click on Delete button to delete created department
        GlobalPages.click(DepartmentsNewDepPage.deleteBtn);

        //Accept alert (if true we accept alert)
        GlobalPages.alertAcceptOrDismiss(true);

        //Thread sleep waiter
        GlobalPages.sleepWait(3000);

        //Verify absence of entered data on Departments page
        Assertions.assertFalse(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));
    }

    @Test
    public void testCreateNewContactWithoutAddInfo() {
        // Test data
        String FName = "My FName5";
        String LName = "LName5";
        String email = "copypusr@gmail.com";

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
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, email);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContactPage.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList), FName + " " + LName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.emailList), email));
    }

    @Test
    public void testCreateNewContactWithAddInfo() {
        // Test data
        String FName = "FNameXY";
        String LName = "NameYX";
        String email = "xyxyxyxyxyy@gmail.com";
        String country = "Uni";
        String city = "Parad";
        String street = "this is my street";
        String building = "7777";
        String zipCode = "123456";
        String roomNumber = "0000";
        String phone = "+46343424241";
        String skype = "alexx";
        String website = "alexx.com";
        String jobPosition = "QA AutomationJava";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.clickOnVisibleElement(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, email);

        //Click on 'Additional information+' button
        GlobalPages.click(ContactsNewContactPage.addInfoBtn);

        //Fill in all fields
        ContactsNewContactPage.fillInAllFields(country, street, zipCode, phone, website, city, building, roomNumber, skype, jobPosition);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContactPage.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList), FName + " " + LName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.emailList), email));
    }
}




