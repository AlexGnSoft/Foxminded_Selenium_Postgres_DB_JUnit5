package tests.Contacts;

import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomDataGenerator;
import java.sql.SQLException;
import java.util.Locale;

public class ContactsTest_Parametrized_Locator extends BaseTestConfiguration {

    @Tag("create_new_contact")
    @Test
    public void testCreateNewContactWithoutAddInfo() {
        // Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomEmail = generator.randomString(5,true, false, false).toLowerCase(Locale.ROOT);
        String randomLastName = generator.randomString(5,false, false, true);
        String randomFirstName = generator.randomString(5,false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contacts tab > 'New Contact+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContact_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameField, randomFirstName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, randomLastName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, randomEmail);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContact_Param_Locator.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContact_Param_Locator.submitBtn);
        GlobalPages.sleepWait(3000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.emailList), randomEmail));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList), randomFirstName + " " + randomLastName));
    }

    @Tag("create_new_contact")
    @Test
    public void testCreateNewContactWithAddInfo() {
        // Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String FName = generator.randomString(7, false, false, true);
        String LName = generator.randomString(7, false, false, true);
        String email = generator.randomString(5, true, false, false).toLowerCase(Locale.ROOT);
        String country = generator.randomString(7, false, false, true);
        String city = generator.randomString(7, false, false, true);
        String street = generator.randomString(7, false, false, true);
        String building = generator.randomInt(20,1);
        String zipCode = generator.randomInt(9,5);
        String roomNumber =  generator.randomInt(9,2);
        String phone = generator.randomInt(9,10);
        String skype = generator.randomString(7, false, true, false);
        String website = generator.randomString(7, false, false, true);
        String jobPosition = generator.randomString(7, false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contacts tab > 'New Contact+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.clickOnVisibleElement(ContactsNewContact_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, email);

        //Click on 'Additional information+' button
        GlobalPages.click(ContactsNewContact_Param_Locator.addInfoBtn);

        //Fill in all fields
        ContactsNewContact_Param_Locator.fillInAllFields(country, street, zipCode, phone, website, city, building, roomNumber, skype, jobPosition);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContact_Param_Locator.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContact_Param_Locator.submitBtn);
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList), FName + " " + LName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.emailList), email));
    }

    @Tag("create_new_contact_db_test")
    @Test
    public void testUIAndDataBaseCreateNewContact() throws SQLException {
        // Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomFName = rd.randomString(10, false, false, true);
        String randomLName = rd.randomString(15, false, false, true);
        String randomEmail = rd.randomString(15, true, false, false).toLowerCase(Locale.ROOT);
        String sqlQuery = "select*from contact";
        String keyMap = "first_name";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contacts tab > 'New Contact+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContact_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameField, randomFName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, randomLName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, randomEmail);

        GlobalPages.sleepWait(3000);

        //Scroll down the page to see the buttons on bottom of the page
        GlobalPages.scrollDown();

        //Click Submit button
        GlobalPages.click(ContactsNewContact_Param_Locator.submitBtn);
        GlobalPages.sleepWait(3000);

        //Compare UI and DB
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery,randomFName), "First name isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, randomLName), "Last name isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery, randomEmail), "Email isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInMap(sqlQuery, keyMap, randomFName), "First name isn't found in DB");
    }

    @Tag("create_new_contact_validation_test")
    @Test
    public void testCheckValidationMessagesForNewContactWithoutAddInfo() {
        // Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String FName = generator.randomString(10, false, false, true);
        String LName = generator.randomString(10, false, false, true);
        String emailValid = generator.randomString(15, true, false, false).toLowerCase(Locale.ROOT);
        String emailInvalid = generator.randomString(15, true, false, false).toLowerCase(Locale.ROOT).replace("@", "");
        String oneLetter = "a";
        String twoLetters = "aB";
        String threeLetters = "sdS";
        String emailMustBeValidText = "Email must be valid";
        String emailIsRequiredText = "Email is required";
        String loginRequiredText = "Login is required";
        String lastNameMinValueAlertText = "Last name must be at least 2 characters";
        String ticketPrefixAlertText = "Tickets prefix must be from 3 to 6 characters long";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contact tab > 'New Contact+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContact_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, LName);

        /**
         * 'Tickets prefix must be from 3 to 6 characters long' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.ticketPrefixField, oneLetter);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.ticketPrefixField, twoLetters);

        //Check that pop-up is visible by using parametrized locator
        Assertions.assertTrue(GlobalPages.isElementVisible
                (ContactsNewContact_Param_Locator.parametrizedLocator(ticketPrefixAlertText)));

        //Check correctness of the text by using parametrized locator
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContact_Param_Locator.parametrizedLocator(ticketPrefixAlertText), ticketPrefixAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.ticketPrefixField, threeLetters);
        GlobalPages.sleepWait(2000);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.validAlertAbsence));

        /**
         * Email must be valid' test
         */
        //Fill in Invalid and valid Email and check validation message
        //Check that pop-up is present
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, emailInvalid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.parametrizedLocator(emailMustBeValidText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContact_Param_Locator.parametrizedLocator(emailMustBeValidText), emailMustBeValidText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, emailValid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.validAlertAbsence));

        /**
         * Email is required' test
         */
        //Fill in valid and no Email and check validation message 'Email is required' pop-up and the text
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.emailField, emailValid);
        ContactsNewContact_Param_Locator.deleteEmailFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.parametrizedLocator(emailIsRequiredText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContact_Param_Locator.parametrizedLocator(emailIsRequiredText), emailIsRequiredText));

        /**
         * 'Login is required' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.loginField, emailValid);
        ContactsNewContact_Param_Locator.deleteLoginFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.parametrizedLocator(loginRequiredText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContact_Param_Locator.parametrizedLocator(loginRequiredText), loginRequiredText));

        /**
         * 'Last name must be at least 2 characters long' test
         */
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, oneLetter);
        //Check pop-up is visible
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.parametrizedLocator(lastNameMinValueAlertText)));
        //Check pop-up text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContact_Param_Locator.parametrizedLocator(lastNameMinValueAlertText), lastNameMinValueAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, twoLetters);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.validAlertAbsence));
    }

    @Tag("edit_contact")
    @Test
    public void testEditContact() {
        // Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomEmail = generator.randomString(4,true, false, false).toLowerCase(Locale.ROOT);;
        String randomLastName = generator.randomString(7,false, false, true);
        String randomFirstName = generator.randomString(6,false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        GlobalPages.sleepWait(1000);

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contact tab > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);

        //Click on the first contact Edit button
        GlobalPages.clickOnTheFirstElementInAList(ContactsNewContact_Param_Locator.editBtnList);
        Assertions.assertTrue(GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.newContactPage));

        //Update Email
        GlobalPages.click(ContactsNewContact_Param_Locator.editEmailBtn);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.editEmailField, randomEmail);
        GlobalPages.click(ContactsNewContact_Param_Locator.emailOkBtn);

        //Check presence of the success sign and email (to be displayed as an updated email)
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContact_Param_Locator.emailSuccessfullUpdateSign));
        Assertions.assertEquals(GlobalPages.getTextFromLocator(ContactsNewContact_Param_Locator.emailUpdated), randomEmail);

        //Update First and Last name
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameField, randomLastName);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.lastNameField, randomFirstName);

        //Update Service Program
        ContactsNewContact_Param_Locator.checkRadioButtonStatusAndSelect();

        //Click Submit button
        GlobalPages.click(ContactsNewContact_Param_Locator.submitBtn);
        Assertions.assertTrue(GlobalPages.pageIsVisible(ContactsNewContact_Param_Locator.contactPage));

        //Validate that updated data is displayed on Contacts home page
        GlobalPages.sleepWait(2000);
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.emailList), randomEmail));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList), randomFirstName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList), randomLastName));
    }

    @Tag("delete_contact")
    @Test
    public void testDeleteContact() {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        GlobalPages.sleepWait(1000);

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Contact tab > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);

        //Find current full names and save to variable
        GlobalPages.sleepWait(1000);
        String namesOfFirstTitleOfAnyColumns = GlobalPages.getNamesOfFirstTitleOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList);
        String firstNameLetters = namesOfFirstTitleOfAnyColumns.substring(0, 5);

        //Click on the first contact Delete button
        GlobalPages.clickOnTheFirstElementInAList(ContactsNewContact_Param_Locator.deleteBtnList);
        GlobalPages.alertAcceptOrDismiss(true);
        GlobalPages.sleepWait(1000);

        //Verify that namesOfFirstTitleOfAnyColumns is not present in the list of contacts
        Assertions.assertFalse(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContact_Param_Locator.fullNameList), namesOfFirstTitleOfAnyColumns));

        //Verify that deleted contact is not present by using search module
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.firstNameSearchField, firstNameLetters);
        GlobalPages.click(ContactsNewContact_Param_Locator.filterBtn);
        GlobalPages.sleepWait(1000);
        Assertions.assertFalse(GlobalPages.isElementVisibleOnPageSource(firstNameLetters));
    }
}
