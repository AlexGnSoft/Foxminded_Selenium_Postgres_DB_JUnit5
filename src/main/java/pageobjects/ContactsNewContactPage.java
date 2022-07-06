package pageobjects;

import config.BaseTestConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsNewContactPage extends BaseTestConfiguration {
    public static final By newContactBtn = By.xpath("//button[@id='new-contact']");
    public static final By newContactPage = By.xpath("//div[@class='card-content']");
    public static final By fullNameList = By.xpath("//tbody/tr/td");
    public static final By emailList = By.xpath("//tbody/tr/td");
    public static final By firstNameField = By.xpath("//input[@name='firstName']");
    public static final By lastNameField = By.xpath("//input[@name='lastName']");
    public static final By emailField = By.xpath("//input[@name='email']");
    public static final By loginField = By.xpath("//input[@name='login']");
    public static final By companyDropDownList = By.xpath("//select[@id='companySelect' and @name='companyId']");
    public static final By firstNameIsRequiredAlert = By.xpath("//div[contains(text(),'First name is required')]");
    public static final By firstNameFieldCanNotContainsOnlySpacesAlert = By.xpath("//div[@class='alert alert-danger']/div[2]"); //to get it you need to enter 1 digit in the field to invoke alert...
    public static final By firstNameMinValueAlert = By.xpath("//div[contains(text(),'First name must be at least 2 characters')]");
    public static final By firstNameMaxValueAlert = By.xpath("//div[contains(text(),'First name cannot be more than 25 characters')]");
    public static final By lastNameIsRequiredAlert = By.xpath("//div[contains(text(),'Last Name is required')]");
    public static final By lastNameFieldCanNotContainsOnlySpacesAlert = By.xpath("//div[@class='alert alert-danger']/div[2]");  //to get it you need to enter 1 digit in the field to invoke alert.
    public static final By lastNameMinValueAlert = By.xpath("//div[contains(text(),'Last name must be at least 2 characters')]");
    public static final By lastNameMaxValueAlert = By.xpath("//div[contains(text(),'Last name cannot be more than 25 characters')]");
    public static final By emailISRequiredAlert = By.xpath("//div[contains(text(),'Email is required')]");
    public static final By emailMustBeValidAlert = By.xpath("//div[contains(text(),'Email must be valid')]");
    public static final By loginIsRequiredAlert = By.xpath("//div[contains(text(),'Login is required')]");
    public static final By loginMinValueAlert = By.xpath("//div[contains(text(),'Login must be at least 4 characters long')]");
    public static final By loginMaxValueAlert = By.xpath("//div[contains(text(),'Login cannot be more than 50 characters long')]]");
    public static final By loginCanContainOnlyAlert = By.xpath("//div[contains(text(),'Login can contain only')]");
    public static final By addInfoBtn = By.xpath("//a[@id='addition-info']");
    public static final By countryField = By.xpath("//input[@name='country']");
    public static final By streetField = By.xpath("//input[@name='street']");
    public static final By zipCodeField = By.xpath("//input[@name='zipcode']");
    public static final By phoneField = By.xpath("//input[@name='phone']");
    public static final By websiteField = By.xpath("//input[@name='website']");
    public static final By cityField = By.xpath("//input[@name='city']");
    public static final By buildingField = By.xpath("//input[@name='building']");
    public static final By roomNumberField = By.xpath("//input[@name='roomNumber']");
    public static final By skypeField = By.xpath("//input[@name='skype']");
    public static final By jobPositionField = By.xpath("//input[@name='jobPosition']");
    public static final By radioButtonList = By.xpath("//input[@type='radio']");
    public static final By submitBtn = By.xpath("//button[@class='btn btn-success btn-outline']");
    public static final By cancelBtn = By.xpath("//button[@id='contact-form-cancel']");
    private static final Logger log = LogManager.getLogger(ContactsNewContactPage.class.getName());

    /**
     * Method fill in all the fields
     */
    public static void fillInAllFields(String country, String street, String zipCode, String phone, String website, String city, String building, String roomNumber, String skype, String jobPosition) {
        GlobalPages.enterDataToTheField(ContactsNewContactPage.countryField, country);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.streetField, street);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.zipCodeField, zipCode);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.phoneField, phone);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.websiteField, website);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.cityField, city);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.buildingField, building);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.roomNumberField, roomNumber);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.skypeField, skype);
        GlobalPages.enterDataToTheField(ContactsNewContactPage.jobPositionField, jobPosition);
        log.log(Level.INFO, "fillInAllFields method");
    }

    /**
     * Method is used to check radioButtons status.
     * If not selected > we click
     */
    public static void checkRadioButtonStatusAndSelect(){
        List<WebElement> radioButtons = getDriver().findElements(radioButtonList);
        for (int i = 0; i < radioButtons.size(); i++) {
            if(!radioButtons.get(i).isSelected()){
                radioButtons.get(i).click();
            }
        }
        log.log(Level.INFO, "checkRadioButtonStatusAndSelect method");
    }
}

