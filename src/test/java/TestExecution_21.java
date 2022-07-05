import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import pageobjects.*;
import utils.RandomDataGenerator;
import utils.ScreenshotWatcher;

public class TestExecution_21 extends BaseTestConfiguration {

    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

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
        String rndEmail = generator.randomString(srtLength, true, false, false);
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

        //Click on checkboxes (if not clicked). Finding element is test is a temporary solution.
        GlobalPages.checkCheckboxStatusAndClick(getDriver().findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span")));

        //click on Submit button
        GlobalPages.click(ManagerNewManager.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager.fullNameList);
        GlobalPages.sleepWait(3000);

        //Data validation
        String name = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("name");
        String phone = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("phone");
        String skype = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("skype");
        String email = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("email");
        String login = ManagerNewManager.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName + " " + rndLName).get("login");

        Assertions.assertEquals(randomFullName, name);
        Assertions.assertEquals(rndPhone, phone);
        Assertions.assertEquals(rndSkype, skype);
        Assertions.assertEquals(rndEmail, email);
        Assertions.assertEquals(rndLogin, login);
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
