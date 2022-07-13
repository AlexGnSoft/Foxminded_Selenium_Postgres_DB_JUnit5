package pageobjects;

import config.BaseTestConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class ContactsNewContact_Param_Locator extends BaseTestConfiguration {
    public static final By contactPage = By.xpath("//div[@class='container-fluid']");
    public static final By newContactBtn = By.xpath("//button[@id='new-contact']");
    public static final By newContactPage = By.xpath("//div[@class='card-content']");
    public static final By fullNameList = By.xpath("//tbody/tr/td");
    public static final By emailList = By.xpath("//tbody/tr/td");
    public static final By firstNameField = By.xpath("//input[@name='firstName']");
    public static final By lastNameField = By.xpath("//input[@name='lastName']");
    public static final By emailField = By.xpath("//input[@name='email']");
    public static final By loginField = By.xpath("//input[@name='login']");
    public static final By ticketPrefixField = By.xpath("//input[@id='ticketPrefix']");
    public static final By validAlertAbsence = By.xpath("//input[@class='form-control ng-dirty ng-touched ng-valid']");
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
    public static final By editBtnList = By.xpath("//a[@title='Edit']");
    public static final By editEmailBtn = By.xpath("//div[@class='several-emails_action-btns']");
    public static final By editEmailField = By.xpath("//input[@id='email']");
    public static final By emailOkBtn = By.xpath("//div[@class='col-sm-6']/button[@id='contact-form-submit']");
    public static final By emailSuccessfullUpdateSign = By.xpath("//div[@class='btn-info']");
    public static final By emailUpdated = By.xpath("//div[@class='several-emails_email']");
    public static final By deleteBtnList = By.xpath("//a[@id='delete-btn']");


    private static final Logger log = LogManager.getLogger(ContactsNewContact_Param_Locator.class.getName());

    /**
     * Method fill in all the fields
     */
    public static void fillInAllFields(String country, String street, String zipCode, String phone, String website, String city, String building, String roomNumber, String skype, String jobPosition) {
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.countryField, country);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.streetField, street);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.zipCodeField, zipCode);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.phoneField, phone);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.websiteField, website);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.cityField, city);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.buildingField, building);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.roomNumberField, roomNumber);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.skypeField, skype);
        GlobalPages.enterDataToTheField(ContactsNewContact_Param_Locator.jobPositionField, jobPosition);
        log.log(Level.INFO, "fillInAllFields method");
    }

    /**
     * Method is used to check radioButtons status.
     * If not selected > we click
     */
    public static void checkRadioButtonStatusAndSelect() {
        List<WebElement> radioButtons = getDriver().findElements(radioButtonList);
        for (int i = 0; i < radioButtons.size(); i++) {
            if (!radioButtons.get(i).isSelected()) {
                radioButtons.get(i).click();
            }
        }
        log.log(Level.INFO, "checkRadioButtonStatusAndSelect method");
    }

    /**
     * Method is used to clear text in a field
     */
    public static void deleteEmailFromTheField() {
        WebElement element = getDriver().findElement(emailField);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();

        log.log(Level.INFO, "deleteEmailFromTheField method");
    }

    /**
     * Method is used to clear text in a field
     */
    public static void deleteLoginFromTheField() {
        WebElement element = getDriver().findElement(loginField);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();

        log.log(Level.INFO, "deleteLoginFromTheField method");
    }

    /**
     * Method is used to return Parametrized Locator
     */
    public static By parametrizedLocator(String validationText){
        return By.xpath("//div[contains(text(),'" + validationText + "')]");
    }
}

