package pageobjects;

import config.BaseTestConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public static final By firstNameElement = By.cssSelector("#firstName");
    public static final By lastNameElement = By.cssSelector("#lastName");
    public static final By emailElement = By.cssSelector("#email");
    public static final By loginElement = By.cssSelector("#login");
    public static final By drpDepartment = By.cssSelector("#manager-form-department-select");
    public static final By drpDepartmentOptions = By.xpath("//select[@id='manager-form-department-select']");
    public static final By phoneElement = By.cssSelector("#phone");
    public static final By skypeElement = By.cssSelector("#skype");
    //    public static WebElement checkBoxList = driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span"));
    public static final By submitBtn = By.cssSelector("#manager-form-submit");
    public static final By cancelBtn = By.cssSelector("#manager-form-cancel");
    public static final By profileDataCreated = By.xpath("//div[@class='col-sm-7']/p");
    public static final By managerDataList = By.xpath("//table/tbody/tr/td");
    public static final By checkboxesList = By.xpath("//label[@class='manager-form-checkbox_label2']/span/span");
    private static final Logger log = LogManager.getLogger(ManagerNewManager.class.getName());

    /**
     * Method saves data to HashMap
     */
    public static HashMap<String, String> saveManagerData(String phoneTest, String loginTest, String emailTest, String skypeTest, String nameTest) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("phone", phoneTest);
        data.put("login", loginTest);
        data.put("email", emailTest);
        data.put("skype", skypeTest);
        data.put("name", nameTest);

        log.log(Level.INFO, "saveManagerData method");

        return data;
    }

    /**
     * Method enters all manager's fields
     */
    public static void fillInAllFields(String fNameTest, String lNameTest,String emailTest, String loginTest, String phoneTest, String skypeTest){
        //enter enterFirstLastName
        getDriver().findElement(firstNameElement).clear();
        getDriver().findElement(firstNameElement).sendKeys(fNameTest);
        getDriver().findElement(lastNameElement).clear();
        getDriver().findElement(lastNameElement).sendKeys(lNameTest);
        //enter Email
        getDriver().findElement(emailElement).clear();
        getDriver().findElement(emailElement).sendKeys(emailTest);
        //enter Login
        getDriver().findElement(loginElement).clear();
        getDriver().findElement(loginElement).sendKeys(loginTest);
        //enter Phone
        getDriver().findElement(phoneElement).clear();
        getDriver().findElement(phoneElement).sendKeys(phoneTest);
        //enter Skype
        getDriver().findElement(skypeElement).clear();
        getDriver().findElement(skypeElement).sendKeys(skypeTest);

        log.log(Level.INFO, "fillInAllFields method");
    }

    /**
     * Method is used to get created user data
     */
    public static ArrayList<String> getCreatedManagerData(){
        ArrayList<String> managerArrayData = new ArrayList<>();
        List<WebElement> managerData = getDriver().findElements(managerDataList);
        for (int i = 0; i < managerData.size(); i++) {
            managerArrayData.add(managerData.get(i).getText());
        }

        log.log(Level.INFO, "getCreatedManagerData method");

        return managerArrayData;
    }

    /**
     * Method is used to check checkBox status.
     * If not checked > we make it checked
     */
    public static void checkCheckboxStatusAndClick() {
        List<WebElement> checkboxes = getDriver().findElements(checkboxesList);
        for (int i = 0; i < checkboxes.size(); i++) {
            if (!checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }
        log.log(Level.INFO, "checkCheckboxStatusAndClick method");
    }
}

