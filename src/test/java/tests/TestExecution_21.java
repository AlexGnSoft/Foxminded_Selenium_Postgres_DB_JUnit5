package tests;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomDataGenerator;

import java.util.Locale;

public class TestExecution_21 extends BaseTestConfiguration {

    //To be able to take ScreenShots:
//    @RegisterExtension
//    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

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

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.managersTab);
        GlobalPages.click(ManagerNewManager.newManagerBtn);
        GlobalPages.pageIsVisible(ManagerNewManager.newManagerPage);

        // Fill in all manager's fields
        ManagerNewManager.fillInAllFields(rndFName, rndLName, rndEmail,rndLogin, rndPhone, rndSkype);

        //Click on Department drop-down and select an option
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

    @Test
    public void testCreateNewDepartmentWithoutAddInfo() {
        //Test data
        String departmentTitle = "My department 4";

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
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Departments page
        Assertions.assertNotNull(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));
    }
}
