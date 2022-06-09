
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import java.util.ArrayList;


public class TestExecution_10 extends BaseTestConfiguration {
    @Test
    public void verifyThatCreateNewTicketPageIsVisible() {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(GlobalPages.pageIsVisible(TicketsPage.createTicketPage));
    }

    @Test
    public void navigationBackAndForward() {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);

        //While being on  create new ticker page go back and forward
        GlobalPages.navigateBackAndForth(TicketsPage.createTicketPage);
    }

    @Test
    public void visibilityOfPlaceholders() throws InterruptedException {
        //Test data
        String expectedPlaceHolder = "Please input your description here...";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        Thread.sleep(1000);


        //Click on 'New Ticket +' button
        GlobalPages.click(TicketsPage.newTicketBtn);
        GlobalPages.waitImplicitly();

        //While being on  create new ticker page go back and forward
        GlobalPages.placeHolderInVisible(TicketsPage.descriptionField, expectedPlaceHolder);
    }

    @Test
    public void createNewTicket() {
        //Test data
        String ticketTitle = "My ticket from automation 4";
        String description = "My description to the ticket";
        String stage = "IN PROGRESS";
        String departmentName = "Комната добра";
        String contactName = "Drozdh Udahvxadb";
        int indexOfOption = 4;
        String managerName = "Ярослав Коваленко";
        String pathToTheFileOnPc = "/Users/aleksandrgnuskin/Downloads/photo_2022-06-02 08.46.39.jpeg";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        GlobalPages.clickOnVisibleElement(TicketsPage.newTicketBtn);
        GlobalPages.pageIsVisible(TicketsPage.createTicketPage);

        //Enter title name into title field
        GlobalPages.enterDataToTheField(TicketsPage.titleField, ticketTitle);

        //Enter description into description field
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, description);

        //Select category by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfOption);

        //Select stage by visible text
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpStage, stage);

        //Select company by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpCompany, 0);

        //Select contact
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpContact, contactName);

        //Select priority by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpPriority, indexOfOption);

        //Select random, but accessible date in the calendar
        TicketsPage.selectDateInCalendar();

        //Select department by visible option in the drop-down list
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, departmentName);

        //Select department by first option in the drop-down list
        TicketsPage.selectFirstOptionFromDropDownList(TicketsPage.drpDepartment);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file from pc

        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        GlobalPages.clickOnVisibleElement(TicketsPage.submitBtn);

        //Verify presence of entered data on Tickets page
        GlobalPages.getNamesOfAnyColumns(TicketsPage.titleList).contains(ticketTitle);
        GlobalPages.getNamesOfAnyColumns(TicketsPage.stageList).contains(stage);
        GlobalPages.getNamesOfAnyColumns(TicketsPage.assigneeList).contains(contactName);
    }

    @Test
    public void createNewDepartmentWithoutAdditionalInfo() {
        //Test data
        String departmentTitle = "My department 1";

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

        //Verify presence of entered data on Departments page
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList).contains(departmentTitle);
    }

    @Test
    public void createNewDepartmentWithAdditionalInfo() {
        //Test data
        String departmentTitle = "My department 2";
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
        GlobalPages.waitImplicitly();
        GlobalPages.clickOnVisibleElement(DepartmentsNewDepPage.newDepartmentBtn);
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.newDepartmentPage);

        //Fill in department title
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on 'Additional Information+' button
        GlobalPages.click(DepartmentsNewDepPage.additionalInfoBtn);
        GlobalPages.waitImplicitly();

        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.phoneField, phone);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.skypeField, skype);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.websiteField, website);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.emailField, email);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.countryField, country);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.cityField, city);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.streetField, street);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.buildingField, building);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.zipCodeField, zipCode);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.roomNumberField, roomNumber);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Verify presence of entered data on Departments page
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList).contains(departmentTitle);
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depPhoneList).contains(phone);
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depEmailList).contains(email);
    }

    @Test
    public void createNewDepartmentAndDeleteCreatedDepartment() throws InterruptedException {
        //Test data
        String departmentTitle = "My department 10";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.departmentsTab);
        Thread.sleep(1000);
        GlobalPages.click(DepartmentsNewDepPage.newDepartmentBtn);
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.newDepartmentPage);

        //Fill in department title
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Verify presence of entered data on Departments page
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList).contains(departmentTitle);

        //Click on Delete button to delete created department
        GlobalPages.click(DepartmentsNewDepPage.deleteBtn);

        //Click on OK button in Alert
        GlobalPages.acceptAlert();

        //Wait for page is visible
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.DepartmentPage);
        Thread.sleep(1000);

        ArrayList<String> namesOfAnyColumns = GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList);
        for (String title2 : namesOfAnyColumns) {
            Assertions.assertFalse(title2.contains(departmentTitle));
        }
    }

    @Test
    public void createNewContactWithoutAdditionalInfo() throws InterruptedException {
        // Test data
        String FName = "First Name";
        String LName = "Last Name";
        String email = "xxx@gmail.com";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.waitImplicitly();
        GlobalPages.clickOnVisibleElement(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, email);

        //Fill in Check-boxes
        GlobalPages.click(ContactsNewContactPage.notificationOnStageChangeCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnNewCommentCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnDoneStageCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnStageChangeCheckBox);

        //Fill in Radio
        GlobalPages.click(ContactsNewContactPage.firstServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.secondServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.thirdServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.zeroServiceLevelRadioBtn);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);

        //Verify presence of entered data on Contacts page
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(FName + " " + LName);
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(email);
    }

    @Test
    public void createNewContactWithAdditionalInfo() throws InterruptedException {
        // Test data
        String FName = "First Name";
        String LName = "Last Name";
        String email = "xxx@gmail.com";
        String country = "Universe";
        String city = "Paradise";
        String street = "this is my street";
        String building = "777";
        String zipCode = "12345";
        String roomNumber = "000";
        String phone = "+4634342424";
        String skype = "alex";
        String website = "alex.com";
        String jobPosition = "QA Automation";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();
        GlobalPages.waitImplicitly();

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.waitImplicitly();
        GlobalPages.clickOnVisibleElement(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, email);

        //Click on 'Additional information+' button
        GlobalPages.click(ContactsNewContactPage.addInfoBtn);

        //Fill in fields
        GlobalPages.enterDataToTheField(ContactsNewContactPage.countryField, country);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.cityField, city);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.streetField, street);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.buildingField, building);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.zipCodeField, zipCode);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.roomNumberField, roomNumber);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.phoneField, skype);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.phoneField, skype);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.websiteField, website);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.jobPositionField, jobPosition);

        //Fill in Check-boxes
        GlobalPages.click(ContactsNewContactPage.notificationOnStageChangeCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnNewCommentCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnDoneStageCheckBox);
        GlobalPages.click(ContactsNewContactPage.notificationOnStageChangeCheckBox);

        //Fill in Radio
        GlobalPages.click(ContactsNewContactPage.firstServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.secondServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.thirdServiceLevelRadioBtn);
        GlobalPages.click(ContactsNewContactPage.zeroServiceLevelRadioBtn);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage.submitBtn);

        //Verify presence of entered data on Contacts page
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(FName + " " + LName);
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(email);
    }
}




