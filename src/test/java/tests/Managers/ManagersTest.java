package tests.Managers;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomDataGenerator;

import java.util.Locale;

public class ManagersTest extends BaseTestConfiguration {

    @Tag("create_new_manager")
    @Test
    public void testCreateNewManager() {
        //Test data
        String department = "Комната добра";
        int srtLength = 8;
        int phoneRange = 10;
        int quantityOfPhoneDigits = 10;

        //Generating random data
        RandomDataGenerator generator = new RandomDataGenerator();
        String rndFName = generator.randomString(srtLength, false, false, true);
        String rndLName = generator.randomString(srtLength, false, false, true);
        String rndEmail = generator.randomString(srtLength, true, false, false).replace(" RESEND EMAIL FOR CONFIRMATION", "").toLowerCase(Locale.ROOT);
        String rndLogin = generator.randomString(srtLength, false, true, false);
        String rndSkype = generator.randomString(srtLength, false, true, false);
        String rndPhone = generator.randomInt(phoneRange, quantityOfPhoneDigits);
        String randomFullName = rndFName + " " + rndLName;

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Managers tab > 'New Manager+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.managersTab);
        GlobalPages.click(ManagerNewManager.newManagerBtn);
        GlobalPages.pageIsVisible(ManagerNewManager.newManagerPage);

        // Fill in all manager's fields
        ManagerNewManager.fillInAllFields(rndFName, rndLName, rndEmail,rndLogin, rndPhone, rndSkype);

        //Click on Managers drop-down and select an option
        GlobalPages.click(ManagerNewManager.drpDepartment);
        GlobalPages.waitImplicitly();
        GlobalPages.selectFromDropDownListByVisibleText(ManagerNewManager.drpDepartment, ManagerNewManager.drpDepartmentOptions, department);

        //Click on checkboxes (if not clicked).
        ManagerNewManager.checkCheckboxStatusAndClick();

        //click on Submit button
        GlobalPages.click(ManagerNewManager.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager.fullNameList);
        GlobalPages.sleepWait(3000);

        //Data validation
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ManagerNewManager.profileDataCreated), randomFullName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ManagerNewManager.profileDataCreated), rndEmail));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ManagerNewManager.profileDataCreated), rndLogin));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ManagerNewManager.profileDataCreated), rndSkype));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(ManagerNewManager.profileDataCreated), rndPhone));
    }

    @Tag("create_new_manager_db_test")
    @Test
    public void testCreateNewManagerValidateDB() {
        //Test data(1)
        String department = "Комната добра";
        int srtLength = 7;
        int phoneRange = 9;
        int quantityOfPhoneDigits = 10;

        //Generating random data
        RandomDataGenerator generator = new RandomDataGenerator();
        String rndFName = generator.randomString(srtLength, false, false, true);
        String rndLName = generator.randomString(srtLength, false, false, true);
        String rndEmail = generator.randomString(srtLength, true, false, false);
        String rndLogin = generator.randomString(srtLength, false, true, false);
        String rndSkype = generator.randomString(srtLength, false, true, false);
        String rndPhone = generator.randomInt(phoneRange, quantityOfPhoneDigits);
        String randomFullName = rndFName + " " + rndLName;

        //Test data(2)
        String name = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("name");
        String phone = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("phone");
        String skype = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("skype");
        String email = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("email");
        String login = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("login");

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Managers tab > 'New Manager+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.managersTab);
        GlobalPages.click(ManagerNewManager.newManagerBtn);
        GlobalPages.pageIsVisible(ManagerNewManager.newManagerPage);

        // Fill in all manager's fields
        ManagerNewManager.fillInAllFields(rndFName, rndLName, rndEmail,rndLogin, rndPhone, rndSkype);

        //Click on Managers drop-down and select an option
        GlobalPages.click(ManagerNewManager.drpDepartment);
        GlobalPages.waitImplicitly();
        GlobalPages.selectFromDropDownListByVisibleText(ManagerNewManager.drpDepartment, ManagerNewManager.drpDepartmentOptions, department);

        //Click on Check-boxes if it's not checked.
        ManagerNewManager.checkCheckboxStatusAndClick();

        //click on Submit button
        GlobalPages.click(ManagerNewManager.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager.fullNameList);
        GlobalPages.sleepWait(3000);

        //Data validation
        Assertions.assertEquals(randomFullName, name);
        Assertions.assertEquals(rndPhone, phone);
        Assertions.assertEquals(rndSkype, skype);
        Assertions.assertEquals(rndEmail, email);
        Assertions.assertEquals(rndLogin, login);
    }
}
