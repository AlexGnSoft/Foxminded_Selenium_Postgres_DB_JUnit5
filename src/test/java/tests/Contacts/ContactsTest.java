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

public class ContactsTest extends BaseTestConfiguration {

    @Tag("create_new_contact")
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

    @Tag("create_new_contact")
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

    @Tag("create_new_contact_db_test")
    @Test
    public void testUIAndDataBaseCreateNewContact() throws SQLException {
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

    @Tag("create_new_contact_validation_test")
    @Test
    public void testCheckValidationMessagesForNewContactWithoutAddInfo() {
        // Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String FName = generator.randomString(10, false, false, true);
        String LName = generator.randomString(10, false, false, true);
        String emailValid = generator.randomString(15, true, false, false).toLowerCase(Locale.ROOT);
        String emailInvalid = generator.randomString(15, true, false, false).toLowerCase(Locale.ROOT).replace("@", "");
        String fullName = FName + " " + LName;
        String oneLetter = "a";
        String twoLetters = "aB";
        String threeLetters = "sdA";
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

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContactPage.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, LName);

        /**
         * 'Tickets prefix must be from 3 to 6 characters long' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage.ticketPrefixField, oneLetter);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.ticketPrefixField, twoLetters);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.ticketPrefixAlert));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage.ticketPrefixAlert, ticketPrefixAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage.ticketPrefixField, threeLetters);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.validAlertAbsence));

        /**
         * Email must be valid' test
         */
        //Fill in Invalid and valid Email and check validation message
        //Check that pop-up is present
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, emailInvalid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.emailMustBeValidAlert));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage.emailMustBeValidAlert, emailMustBeValidText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, emailValid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.validAlertAbsence));

        /**
         * Email is required' test
         */
        //Fill in valid and no Email and check validation message 'Email is required' pop-up and the text
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage.emailField, emailValid);
        ContactsNewContactPage.deleteEmailFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.emailValidAlertAbsence2));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage.emailIsRequiredAlert, emailIsRequiredText));

        /**
         * 'Login is required' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage.loginField, emailValid);
        ContactsNewContactPage.deleteLoginFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.loginIsRequiredAlert));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage.loginIsRequiredAlert, loginRequiredText));

        /**
         * 'Last name must be at least 2 characters long' test
         */
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, oneLetter);
        //Check pop-up is visible
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.lastNameMinValueAlert));
        //Check pop-up text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage.lastNameMinValueAlert, lastNameMinValueAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage.lastNameField, twoLetters);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage.validAlertAbsence));
    }
}
