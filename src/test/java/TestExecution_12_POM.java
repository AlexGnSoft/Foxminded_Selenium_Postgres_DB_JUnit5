import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.*;
import utils.RandomDataGenerator;

public class TestExecution_12_POM extends BaseTestConfiguration {

    @Test
    public void createNewManager() {
        //Test data
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

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.managersTab);
        GlobalPages.click(ManagerNewManager_POM.newManagerBtn);
        GlobalPages.pageIsVisible(ManagerNewManager_POM.newManagerPage);

        // Fill in all manager's fields
        ManagerNewManager_POM.fillInAllFields(rndFName, rndLName, rndEmail,rndLogin, rndPhone, rndSkype);

        //Click on Department drop-down and select an option
        GlobalPages.click(ManagerNewManager_POM.drpDepartment);
        GlobalPages.waitImplicitly();
        GlobalPages.selectFromDropDownListByVisibleText(ManagerNewManager_POM.drpDepartment, ManagerNewManager_POM.drpDepartmentOptions, department);

        //Click on checkboxes (if not clicked). Finding element is test is a temporary solution.
        GlobalPages.checkCheckboxStatusAndClick(driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span")));

        //click on Submit button
        GlobalPages.click(ManagerNewManager_POM.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager_POM.fullNameList);
        GlobalPages.sleepWait(3000);

        //Data validation
        ManagerNewManager_POM.getCreatedManagerData().contains(ManagerNewManager_POM.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName+rndLName).get("name"));
        ManagerNewManager_POM.getCreatedManagerData().contains(ManagerNewManager_POM.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName+rndLName).get("phone"));
        ManagerNewManager_POM.getCreatedManagerData().contains(ManagerNewManager_POM.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName+rndLName).get("skype"));
        ManagerNewManager_POM.getCreatedManagerData().contains(ManagerNewManager_POM.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName+rndLName).get("email"));
        ManagerNewManager_POM.getCreatedManagerData().contains(ManagerNewManager_POM.saveManagerData(rndPhone, rndLogin, rndEmail, rndSkype, rndFName+rndLName).get("login"));
    }
}
