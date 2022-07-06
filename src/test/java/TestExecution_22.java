import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class TestExecution_22 extends BaseTestConfiguration {

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
}
