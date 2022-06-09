package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class ContactsNewContactPage extends BaseTestConfiguration {
    public static final By newContactBtn = By.xpath("//button[@id='new-contact']");
    public static final By newContactPage = By.xpath("//div[@class='card-content']");
    public static final By fullNameList = By.xpath("//tbody/tr/td/a");
    public static final By emailList = By.xpath("//tbody/tr/td/a");
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

    public static final By notificationOnStageChangeCheckBox = By.xpath("//div[@class='contact-form-checkbox_mini-wrap'][1]");
    public static final By notificationOnDoneStageCheckBox = By.xpath("//div[@class='contact-form-checkbox_mini-wrap'][2]");
    public static final By notificationOnNewCommentCheckBox = By.xpath("//div[@class='contact-form-checkbox_mini-wrap'][3]");
    public static final By firstServiceLevelRadioBtn = By.xpath("//input[@id='sla-level-6']");
    public static final By secondServiceLevelRadioBtn = By.xpath("//input[@id='sla-level-7']");
    public static final By thirdServiceLevelRadioBtn = By.xpath("//input[@id='sla-level-8']");
    public static final By zeroServiceLevelRadioBtn = By.xpath("//input[@id='sla-level-5']");

    public static final By submitBtn = By.xpath("//button[@type='submit' and @id='search-bar-submit']");
    public static final By cancelBtn = By.xpath("//button[@id='contact-form-cancel']");




}
