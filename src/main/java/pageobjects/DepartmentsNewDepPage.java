package pageobjects;
import org.openqa.selenium.By;

public class DepartmentsNewDepPage {

    public static final By DepartmentPage = By.cssSelector("div.card-content");
    public static final By newDepartmentBtn = By.xpath("//button[@id='new-department']");
    public static final By newDepartmentPage = By.xpath("//div[@class='card col-md-8']");
    public static final By deleteBtn = By.cssSelector("a[title='Delete']");
    public static final By depTitleList = By.xpath("//tbody/tr/td/a[@href]");
    public static final By depPhoneList = By.xpath("//tbody/tr/td");
    public static final By depEmailList = By.xpath("//tbody/tr/td");
    public static final By titleField = By.xpath("//input[@name='name']");
    public static final By additionalInfoBtn = By.xpath("//a[@id='department-form-additional-info']");
    public static final By phoneField = By.xpath("//input[@name='phone']");
    public static final By emailField = By.xpath("//input[@name='email']");
    public static final By skypeField = By.cssSelector("#skype");
    public static final By websiteField = By.cssSelector("#website");
    public static final By countryField = By.cssSelector("#country");
    public static final By cityField = By.cssSelector("#city");
    public static final By streetField = By.cssSelector("#street");
    public static final By buildingField = By.cssSelector("#building");
    public static final By zipCodeField = By.cssSelector("#zipcode");
    public static final By roomNumberField = By.cssSelector("#roomNumber");
    public static final By submitBtn = By.xpath("//button[@id='department-form-submit']");
    public static final By cancelBtn = By.xpath("//button[@id='department-form-cancel']");

    public static void fillInAllFields(String phone, String skype, String website, String email, String country, String city, String street, String building, String zipCode, String roomNumber){
        GlobalPages.click(DepartmentsNewDepPage.additionalInfoBtn);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.phoneField, phone);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.skypeField, skype);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.websiteField, website);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.emailField, email);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.countryField, country);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.cityField, city);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.streetField, street);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.buildingField, building);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.zipCodeField, zipCode);
        GlobalPages.enterDataToTheField(DepartmentsNewDepPage.roomNumberField, roomNumber);
    }
}
