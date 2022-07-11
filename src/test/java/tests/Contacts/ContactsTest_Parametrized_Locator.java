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
        GlobalPages.click(ContactsNewContactPage_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, email);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContactPage_Param_Locator.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage_Param_Locator.submitBtn);
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage_Param_Locator.fullNameList), FName + " " + LName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage_Param_Locator.emailList), email));
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
        GlobalPages.clickOnVisibleElement(ContactsNewContactPage_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, LName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, email);

        //Click on 'Additional information+' button
        GlobalPages.click(ContactsNewContactPage_Param_Locator.addInfoBtn);

        //Fill in all fields
        ContactsNewContactPage_Param_Locator.fillInAllFields(country, street, zipCode, phone, website, city, building, roomNumber, skype, jobPosition);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //Select radio button if it's not already selected.
        ContactsNewContactPage_Param_Locator.checkRadioButtonStatusAndSelect();
        GlobalPages.sleepWait(3000);

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage_Param_Locator.submitBtn);
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Contacts page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage_Param_Locator.fullNameList), FName + " " + LName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ContactsNewContactPage_Param_Locator.emailList), email));
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
        GlobalPages.click(ContactsNewContactPage_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.firstNameField, randomFName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, randomLName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, randomEmail);

        GlobalPages.sleepWait(3000);

        //Scroll down the page to see the buttons on bottom of the page
        GlobalPages.scrollDown();

        //Click Submit button
        GlobalPages.click(ContactsNewContactPage_Param_Locator.submitBtn);
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

        //Click on Companies tab > 'New Company+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.contactsTab);
        GlobalPages.click(ContactsNewContactPage_Param_Locator.newContactBtn);
        GlobalPages.pageIsVisible(ContactsNewContactPage_Param_Locator.newContactPage);

        //Fill in First Name, Last Name, Email, Login, select Company
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.firstNameField, FName);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, LName);

        /**
         * 'Tickets prefix must be from 3 to 6 characters long' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.ticketPrefixField, oneLetter);
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.ticketPrefixField, twoLetters);

        //Check that pop-up is visible by using parametrized locator
        Assertions.assertTrue(GlobalPages.isElementVisible
                (ContactsNewContactPage_Param_Locator.parametrizedLocator(ticketPrefixAlertText)));

        //Check correctness of the text by using parametrized locator
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage_Param_Locator.parametrizedLocator(ticketPrefixAlertText), ticketPrefixAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.ticketPrefixField, threeLetters);
        GlobalPages.sleepWait(2000);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.validAlertAbsence));

        /**
         * Email must be valid' test
         */
        //Fill in Invalid and valid Email and check validation message
        //Check that pop-up is present
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, emailInvalid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.parametrizedLocator(emailMustBeValidText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage_Param_Locator.parametrizedLocator(emailMustBeValidText), emailMustBeValidText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, emailValid);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.validAlertAbsence));

        /**
         * Email is required' test
         */
        //Fill in valid and no Email and check validation message 'Email is required' pop-up and the text
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.emailField, emailValid);
        ContactsNewContactPage_Param_Locator.deleteEmailFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.parametrizedLocator(emailIsRequiredText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage_Param_Locator.parametrizedLocator(emailIsRequiredText), emailIsRequiredText));

        /**
         * 'Login is required' test
         */
        //Check that pop-up is visible
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.loginField, emailValid);
        ContactsNewContactPage_Param_Locator.deleteLoginFromTheField();
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.parametrizedLocator(loginRequiredText)));
        //Check correctness of the text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage_Param_Locator.parametrizedLocator(loginRequiredText), loginRequiredText));

        /**
         * 'Last name must be at least 2 characters long' test
         */
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, oneLetter);
        //Check pop-up is visible
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.parametrizedLocator(lastNameMinValueAlertText)));
        //Check pop-up text
        Assertions.assertTrue(GlobalPages.isValidationMessageIsCorrect(ContactsNewContactPage_Param_Locator.parametrizedLocator(lastNameMinValueAlertText), lastNameMinValueAlertText));
        //Check that pop-up disappeared by entering valid data. Class 'ng-valid' is activated
        GlobalPages.enterDataToTheField(ContactsNewContactPage_Param_Locator.lastNameField, twoLetters);
        Assertions.assertTrue(GlobalPages.isElementVisible(ContactsNewContactPage_Param_Locator.validAlertAbsence));
    }
}
