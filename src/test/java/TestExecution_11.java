import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.*;

public class TestExecution_11 extends BaseTestConfiguration {

    @Test
    public void CreateNewManager() throws InterruptedException {
        //Test data
        int firstNameLength = 10;
        int secondNameLength = 20;
        String department = "Комната добра";

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

        //Fill in First and Last names with random string
        ManagerNewManager.fillInFirstLastNameRandomly(firstNameLength, secondNameLength);

        //Fill in random email
        ManagerNewManager.fillInEmailRandomly();

        //Fill in login
        ManagerNewManager.fillInLogin();

        //Fill in phoneNumber
        ManagerNewManager.fillInPhoneRandomly();

        //Fill in skype
        ManagerNewManager.fillInSkypeRandomly();

        //Save data into
        ManagerNewManager.saveDataInMap("email","login", "phone", "skype");

        //Click on Department drop-down and select an option
        GlobalPages.click(ManagerNewManager.drpDepartment);
        GlobalPages.waitImplicitly();
        GlobalPages.selectFromDropDownListByVisibleText(ManagerNewManager.drpDepartment, ManagerNewManager.drpDepartmentOptions, department);

        //Click on checkboxes (if not clicked). Finding element is test is a temporary solution.
        GlobalPages.checkCheckboxStatusAndClick(driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span")));

        //click on Submit button
        GlobalPages.click(ManagerNewManager.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager.fullNameList);









    }
}
