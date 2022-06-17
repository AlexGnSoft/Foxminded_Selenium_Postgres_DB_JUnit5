package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerNewManager_PFM extends BaseTestConfiguration {
    public static final By ManagerPage = By.cssSelector(".card-content");
    public static final By newManagerBtn = By.cssSelector("#managers-new-manager");
    public static final By newManagerPage = By.cssSelector(".container-fluid");
    public static final By departmentList = By.xpath("//tbody/tr/td[2]");
    public static final By phoneList = By.cssSelector("//tbody/tr/td[3]");
    public static final By emailList = By.cssSelector("//tbody/tr/td[4]");
    public static final By firstNameSearch = By.cssSelector("#search-manager-firstname");
    public static final By lastNameSearch = By.cssSelector("#search-manager-lastname");
    public static final By departmentNameSearch = By.cssSelector("#search-manager-department");
    public static final By filterBtn = By.cssSelector("#search-manager-filter");
    public static final By clearBtn = By.cssSelector("#search-manager-clear");

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(xpath = "//tbody/tr/td[1]/a")
    private By fullNameList;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "login")
    private WebElement loginElement;

    @FindBy(id = "phone")
    private WebElement phoneElement;

    @FindBy(id = "skype")
    private WebElement skypeElement;

    @FindBy(id = "manager-form-submit")
    private WebElement submitBtn;

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    @FindBy(id = "manager-form-cancel")
    private WebElement cancelBtn;

    @FindBy(className = "text-left")
    private static List<WebElement> managerDataList;

    @FindBy(id = "manager-form-department-select")
    private static By drpDepartment;

    public static By getDrpDepartment() {
        return drpDepartment;
    }

    public By getFullNameList() {
        return fullNameList;
    }

    @FindBy(xpath = "//select[@id='manager-form-department-select']")
    private static By drpDepartmentOptions;

    public static By getDrpDepartmentOptions() {
        return drpDepartmentOptions;
    }

    // Initialize driver and webElements
    public ManagerNewManager_PFM(WebDriver driver){
        BaseTestConfiguration.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

//    public static ManagerNewManager_PFM using(WebDriver driver) {
//        return new ManagerNewManager_PFM(driver);
//    }

    public void clearFirstNamePHolder() {
        this.firstNameElement.clear();
    }

    public ManagerNewManager_PFM setFirstName(String firstName) {
        this.firstNameElement.sendKeys(firstName);
        return this;
    }

    public void clearLastNamePHolder() {
        this.lastNameElement.clear();
    }

    public ManagerNewManager_PFM setLastName(String lastName) {
        this.lastNameElement.sendKeys(lastName);
        return this;
    }

    public void clearEmailPHolder() {
        this.emailElement.clear();
    }

    public ManagerNewManager_PFM setEmail(String email) {
        this.emailElement.sendKeys(email);
        return this;
    }

    public void clearLoginPHolder() {
        this.loginElement.clear();
    }

    public ManagerNewManager_PFM setLogin(String login) {
        this.loginElement.sendKeys(login);
        return this;
    }

    public void clearPhonePHolder() {
        this.phoneElement.clear();
    }

    public ManagerNewManager_PFM setPhone(String phone) {
        this.phoneElement.sendKeys(phone);
        return this;
    }

    public void clearSkypePHolder() {
        this.skypeElement.clear();
    }

    public ManagerNewManager_PFM setSkype(String skype) {
        this.skypeElement.sendKeys(skype);
        return this;
    }

//    public void clickOnDrpDepartment() {
//        this.drpDepartment.click;
//    }

    public void clickOnSubmitBtn() {
        this.submitBtn.click();
    }

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

        return data;
    }

    /**
     * Method enters all manager's fields
     */
    public static void fillInAllFields(String fNameTest, String lNameTest,String emailTest, String loginTest, String phoneTest, String skypeTest){
        //enter enterFirstLastName
        ManagerNewManager_PFM manager = new ManagerNewManager_PFM(driver);
        manager.clearFirstNamePHolder();
        manager.setFirstName(fNameTest);
        manager.clearLastNamePHolder();
        manager.setLastName(lNameTest);
        //enter Email
        manager.clearEmailPHolder();
        manager.setLastName(emailTest);
        //enter Login
        manager.clearLoginPHolder();
        manager.setLogin(loginTest);
        //enter Phone
        manager.clearPhonePHolder();
        manager.setPhone(phoneTest);
        //enter Skype
        manager.clearSkypePHolder();
        manager.setSkype(skypeTest);
    }

    /**
     * Method is used to get created user data
     */
    public static ArrayList<String> getCreatedManagerData(){
        ArrayList<String> managerArrayData = new ArrayList<>();
        List<WebElement> managerData = managerDataList;
        for (int i = 0; i < managerData.size(); i++) {
            managerArrayData.add(managerData.get(i).getText());
        }
        return managerArrayData;
    }
}

