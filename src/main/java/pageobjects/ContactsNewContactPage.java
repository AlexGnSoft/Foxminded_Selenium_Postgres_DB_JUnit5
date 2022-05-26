package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class ContactsNewContactPage extends BaseTestConfiguration {
    private static final By newContactBtn = By.xpath("//button[@id='new-contact']");
    private static final By newContactPage = By.xpath("//div[@class='card-content']");

    private static final By firstNameField = By.xpath("//input[@name='firstName']");
    private static final By lastNameField = By.xpath("//input[@name='lastName']");
    private static final By emailField = By.xpath("//input[@name='email']");
    private static final By loginField = By.xpath("//input[@name='login']");

    private static final By companyDropDownList = By.xpath("//select[@id='companySelect' and @name='companyId']");
    private static final By firstNameIsRequiredAlert = By.xpath("//div[contains(text(),'First name is required')]");
    private static final By firstNameFieldCanNotContainsOnlySpacesAlert = By.xpath("//div[@class='alert alert-danger']/div[2]"); //to get it you need to enter 1 digit in the field to invoke alert...
    private static final By firstNameMinValueAlert = By.xpath("//div[contains(text(),'First name must be at least 2 characters')]");
    private static final By firstNameMaxValueAlert = By.xpath("//div[contains(text(),'First name cannot be more than 25 characters')]");
    private static final By lastNameIsRequiredAlert = By.xpath("//div[contains(text(),'Last Name is required')]");
    private static final By lastNameFieldCanNotContainsOnlySpacesAlert = By.xpath("//div[@class='alert alert-danger']/div[2]");  //to get it you need to enter 1 digit in the field to invoke alert.
    private static final By lastNameMinValueAlert = By.xpath("//div[contains(text(),'Last name must be at least 2 characters')]");
    private static final By lastNameMaxValueAlert = By.xpath("//div[contains(text(),'Last name cannot be more than 25 characters')]");
    private static final By emailISRequiredAlert = By.xpath("//div[contains(text(),'Email is required')]");
    private static final By emailMustBeValidAlert = By.xpath("//div[contains(text(),'Email must be valid')]");
    private static final By loginIsRequiredAlert = By.xpath("//div[contains(text(),'Login is required')]");
    private static final By loginMinValueAlert = By.xpath("//div[contains(text(),'Login must be at least 4 characters long')]");
    private static final By loginMaxValueAlert = By.xpath("//div[contains(text(),'Login cannot be more than 50 characters long')]]");

    private static final By loginCanContainOnlyAlert = By.xpath("//div[contains(text(),'Login can contain only')]");
    private static final By addInfoBtn = By.xpath("//a[@id='addition-info']");
    private static final By countryField = By.xpath("//input[@name='country']");
    private static final By streetField = By.xpath("//input[@name='street']");
    private static final By zipCodeField = By.xpath("//input[@name='zipcode']");
    private static final By phoneField = By.xpath("//input[@name='phone']");
    private static final By websiteField = By.xpath("//input[@name='website']");
    private static final By cityField = By.xpath("//input[@name='city']");
    private static final By buildingField = By.xpath("//input[@name='building']");
    private static final By roomNumberField = By.xpath("//input[@name='roomNumber']");
    private static final By skypeField = By.xpath("//input[@name='skype']");
    private static final By jobPositionField = By.xpath("//input[@name='jobPosition']");
    private static final By notificationOnStageChangeCheckBox = By.xpath("//div[@class='checkbox-radios checkbox']//input[@id='notify-on-stage-change']");
    private static final By notificationOnDoneStageCheckBox = By.xpath("//div[@class='checkbox-radios checkbox']//input[@id='notify-on-done-stage']");
    private static final By notificationOnNewCommentCheckBox = By.xpath("//div[@class='checkbox-radios checkbox']//input[@id='notify-on-new-comment']");
    private static final By firstServiceLevelRadioBtn = By.xpath("//input[@id='sla-level-6']");

    private static final By submitBtn = By.xpath("//button[@type='submit' and @id='search-bar-submit']");
    private static final By cancelBtn = By.xpath("//button[@id='contact-form-cancel']");















}
