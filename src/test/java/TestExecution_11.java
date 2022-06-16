import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.*;

public class TestExecution_11 extends BaseTestConfiguration {

    @Test
    public void createNewManager() {
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

        // Fill in First and Last names with random string
        ManagerNewManager.fillInAllFields();

        //Click on Department drop-down and select an option
        GlobalPages.click(ManagerNewManager.drpDepartment);
        GlobalPages.waitImplicitly();
        GlobalPages.selectFromDropDownListByVisibleText(ManagerNewManager.drpDepartment, ManagerNewManager.drpDepartmentOptions, department);

        //Save data to Hash Map
        ManagerNewManager.saveManagerData();

        //Click on checkboxes (if not clicked). Finding element is test is a temporary solution.
        GlobalPages.checkCheckboxStatusAndClick(driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span")));

        //click on Submit button
        GlobalPages.click(ManagerNewManager.submitBtn);

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagerNewManager.fullNameList);
        GlobalPages.sleepWait(3000);

        //Data validation
        ManagerNewManager.getCreatedManagerData().contains(ManagerNewManager.saveManagerData().get("name"));
        ManagerNewManager.getCreatedManagerData().contains(ManagerNewManager.saveManagerData().get("phone"));
        ManagerNewManager.getCreatedManagerData().contains(ManagerNewManager.saveManagerData().get("skype"));
        ManagerNewManager.getCreatedManagerData().contains(ManagerNewManager.saveManagerData().get("email"));
        ManagerNewManager.getCreatedManagerData().contains(ManagerNewManager.saveManagerData().get("login"));
    }
}
