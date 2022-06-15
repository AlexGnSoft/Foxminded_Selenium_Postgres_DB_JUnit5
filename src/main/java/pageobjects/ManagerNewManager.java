package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.RandomDataGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerNewManager extends BaseTestConfiguration {
    public static final By ManagerPage = By.cssSelector(".card-content");
    public static final By newManagerBtn = By.cssSelector("#managers-new-manager");
    public static final By newManagerPage = By.cssSelector(".container-fluid");
    public static final By fullNameList = By.xpath("//tbody/tr/td[1]/a");
    public static final By departmentList = By.xpath("//tbody/tr/td[2]");
    public static final By phoneList = By.cssSelector("//tbody/tr/td[3]");
    public static final By emailList = By.cssSelector("//tbody/tr/td[4]");
    public static final By firstNameSearch = By.cssSelector("#search-manager-firstname");
    public static final By lastNameSearch = By.cssSelector("#search-manager-lastname");
    public static final By departmentNameSearch = By.cssSelector("#search-manager-department");
    public static final By filterBtn = By.cssSelector("#search-manager-filter");
    public static final By clearBtn = By.cssSelector("#search-manager-clear");
    public static final By firstName = By.cssSelector("#firstName");
    public static final By lastName = By.cssSelector("#lastName");
    public static final By email = By.cssSelector("#email");
    public static final By login = By.cssSelector("#login");
    public static final By drpDepartment = By.cssSelector("#manager-form-department-select");
    public static final By drpDepartmentOptions = By.xpath("//select[@id='manager-form-department-select']");
    public static final By phone = By.cssSelector("#phone");
    public static final By skype = By.cssSelector("#skype");
    //    public static WebElement checkBoxList = driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span"));
    public static final By submitBtn = By.cssSelector("#manager-form-submit");
    public static final By cancelBtn = By.cssSelector("#manager-form-cancel");
    public static final By profileDataCreated = By.xpath("//div[@class='col-sm-7']/p");
    public static final By managerDataList = By.cssSelector(".text-left");

    /**
     * Method enters First and Last Names
     */
    public static void enterFirstLastName(){
        RandomDataGenerator generator = new RandomDataGenerator();
        String fName = generator.randomString(7, false, false, true);
        String lName = generator.randomString(7, false, false, true);
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }

    /**
     * Method enters Email
     */
    public static void enterEmail(){
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomEmail = generator.randomString(7, true, false, false);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(randomEmail);
    }

    /**
     * Method enters Login
     */
    public static void enterLogin(){
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomLogin = generator.randomString(7, false, true, false);
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(randomLogin);
    }

    /**
     * Method enters Phone number
     */
    public static void enterPhoneNumber(){
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomPhone = generator.randomInt(9, 10);
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(randomPhone);
    }

    /**
     * Method enters Skype
     */
    public static void enterSkype(){
        RandomDataGenerator generator = new RandomDataGenerator();
        String randomSkype = generator.randomString(7, false, true, false);
        driver.findElement(skype).clear();
        driver.findElement(skype).sendKeys(randomSkype);
    }

    /**
     * Method saves data to Hash Map
     */
    public static HashMap<String, String> saveManagerData() {
        RandomDataGenerator generator = new RandomDataGenerator();

        HashMap<String, String> data = new HashMap<String, String>();
        data.put("phone", generator.randomInt(9, 10));
        data.put("login", generator.randomString(10, false, true, false));
        data.put("email", generator.randomString(10, true, false, false));
        data.put("skype", generator.randomString(10, false, true, false));
        data.put("name", generator.randomString(10, false, false, true));

        return data;
    }

    /**
     * Method is used to get created user data
     */
    public static ArrayList<String> getCreatedManagerData(){
        ArrayList<String> managerArrayData = new ArrayList<>();
        List<WebElement> managerData = driver.findElements(managerDataList);
        for (int i = 0; i < managerData.size(); i++) {
            managerArrayData.add(managerData.get(i).getText());
        }

        return managerArrayData;
    }
}

