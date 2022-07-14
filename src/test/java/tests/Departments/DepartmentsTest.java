package tests.Departments;

import config.BaseTestConfiguration;
import databases.DataBase;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.Builder_Singleton_Strategy.Buider_Pattern.CustomerBuilder;
import pageobjects.DepartmentsNewDepPage;
import pageobjects.GlobalPages;
import pageobjects.MenuDashboard;
import pageobjects.OpenPage;
import utils.RandomDataGenerator;

import java.sql.SQLException;
import java.util.Locale;

public class DepartmentsTest extends BaseTestConfiguration {

    @Tag("create_new_department")
    @Test
    public void testCreateNewDepartmentWithoutAddInfo() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(15, false, false, true);

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
        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));
    }

    @Tag("create_new_department")
    @Test
    public void testCreateNewDepartmentWithAddInfo() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(20, false, false, true);
        String phone = generator.randomInt(9,10);
        String skype = generator.randomString(10, false, false, true);
        String website = generator.randomString(10, false, false, true);
        String email = generator.randomString(10, false, false, true).toLowerCase(Locale.ROOT)+"@gmail.com";
        String country = generator.randomString(10, false, false, true);
        String city = generator.randomString(10, false, false, true);
        String street = generator.randomString(10, false, false, true);
        String building = generator.randomInt(100,3);
        String zipCode = generator.randomInt(9,5);
        String roomNumber = generator.randomInt(100,3);

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

        //Click on 'Additional Information+' button
        GlobalPages.click(DepartmentsNewDepPage.additionalInfoBtn);

        //Fill in all fields
        DepartmentsNewDepPage.fillInAllFields(phone, skype,website,email,country,city, street, building, zipCode, roomNumber);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);
//
//        //Refresh the page
//        getDriver().navigate().refresh();
        GlobalPages.sleepWait(2000);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList),departmentTitle));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depPhoneList),phone));
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray(GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depEmailList),email));
    }

    @Tag("create_new_department")
    @Test
    public void testCreateNewDepartmentAndDeleteCreatedDepartment() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(10, false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Open sidebar
        GlobalPages.openLeftSideTab();

        //Click on Departments tab > 'New Department+' button > Wait for page to be visible
        GlobalPages.clickOnVisibleElement(MenuDashboard.departmentsTab);
        GlobalPages.click(DepartmentsNewDepPage.newDepartmentBtn);
        GlobalPages.pageIsVisible(DepartmentsNewDepPage.newDepartmentPage);

        //Fill in department title
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, departmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));

        //Click on Delete button to delete created department
        GlobalPages.click(DepartmentsNewDepPage.deleteBtn);

        //Accept alert (if true we accept alert)
        GlobalPages.alertAcceptOrDismiss(true);

        //Thread sleep waiter
        GlobalPages.sleepWait(3000);

        //Verify absence of entered data on Departments page
        Assertions.assertFalse(GlobalPages.stringIsPresentInArray
                (GlobalPages.getNamesOfAnyColumns(DepartmentsNewDepPage.depTitleList), departmentTitle));
    }

    @Tag("create_new_department_db_test")
    @Test
    public void testUIAndDataBaseCreateNewDepartment() throws SQLException {
        //Test data
        DataBase db = new DataBase();
        RandomDataGenerator rd = new RandomDataGenerator();
        String randomDepartmentTitle = rd.randomString(15, false, false, true);
        String sqlQuery = "select*from department";
        String keyMap = "name";

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
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.titleField, randomDepartmentTitle);

        //Click on Submit button
        GlobalPages.click(DepartmentsNewDepPage.submitBtn);

        //Compare UI and DB
        Assertions.assertTrue(db.stringIsPresentInArrayOfDbData(sqlQuery,randomDepartmentTitle), "Title isn't found in DB");
        Assertions.assertTrue(db.stringIsPresentInMap(sqlQuery, keyMap, randomDepartmentTitle), "Title isn't found in DB");
    }

    @Tag("create_new_department")
    @Test
    public void testCreateNewDepartmentWithoutAddInfoV2() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(10, false, false, true);

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

    @Tag("department")
    @Test
    public void testSearchCreatedDepartment() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(10, false, false, true);

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

        //Search for created Dep on Department page by using method from Interface
        DepartmentsNewDepPage depPage = new DepartmentsNewDepPage();
        depPage.search(departmentTitle);
        GlobalPages.sleepWait(3000);

        //Verify that Search Result page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(DepartmentsNewDepPage.searchResultPage), "Search result page is not visible");
    }

    @Tag("department")
    @Test
    public void testCheckNameCapitalization() {
        //Test data
        String fName = "Jose";
        String lName = "Aveiro";
        int age = 18;
        double height = 172d;
        double weight = 75d;

        CustomerBuilder builder = new CustomerBuilder()
                .setFirstName(fName)
                .setLastName(lName)
                .setAge(age)
                .setHeight(height)
                .setWeight(weight);

//        Customer customer = builder.getCustomer();
//        System.out.println(customer);
//        System.out.println(builder.getAge());

        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getFirstName()), "Name does not start from the capital");
        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getLastName()), "Name does not start from the capital");
    }

    @Tag("department")
    @Test
    public void testAccessByAgeCheck(){
        //Test data
        String fName = "Antonio";
        String lName = "Rodrigo";
        int age = 18;

        CustomerBuilder builder = new CustomerBuilder()
                .setFirstName(fName)
                .setLastName(lName)
                .setAge(age);

        Assertions.assertTrue(
                CustomerBuilder.isCustomerCanEnterNightClud(builder.getFirstName(),
                        builder.getLastName(),
                        builder.getAge()),
                "The customer can not enter");
    }
}





