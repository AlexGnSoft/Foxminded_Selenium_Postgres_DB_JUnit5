
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.*;
import java.util.ArrayList;


public class TestExecution_10 extends BaseTestConfiguration {

    @Test
    public void testCreateNewTicket() {
        //Test data
        String ticketTitle = "My ticket from automation 5";
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

        //Verify presence of entered data on Tickets page
        GlobalPages.getNamesOfAnyColumns(TicketsPage.titleList).contains(ticketTitle);
        GlobalPages.getNamesOfAnyColumns(TicketsPage.stageList).contains(stage);
        GlobalPages.getNamesOfAnyColumns(TicketsPage.assigneeList).contains(contactName);
    }

    @Test
    public void testCreateNewDepartmentWithoutAddInfo() {
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
    public void testCreateNewDepartmentWithAddInfo() {
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

        //Verify presence of entered data on Departments page
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList).contains(departmentTitle);
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depPhoneList).contains(phone);
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depEmailList).contains(email);
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
        GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList).contains(departmentTitle);

        //Click on Delete button to delete created department
        GlobalPages.click(DepartmentsNewDepPage.deleteBtn);

        //Accept alert (if true we accept alert)
        GlobalPages.alertAcceptOrDismiss(true);

        //Thread sleep waiter
        GlobalPages.sleepWait(3000);

        ArrayList<String> namesOfAnyColumns = GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList);
        for (String title2 : namesOfAnyColumns) {
            Assertions.assertFalse(title2.contains(departmentTitle));
        }
    }

    @Test
    public void testCreateNewContactWithoutAddInfo() {
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
        GlobalPages.click(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, email);

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

        //Verify presence of entered data on Contacts page
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(FName + " " + LName);
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(email);
    }

    @Test
    public void testCreateNewContactWithAddInfo() {
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

        //Verify presence of entered data on Contacts page
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(FName + " " + LName);
        GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage.fullNameList).contains(email);
    }
}




