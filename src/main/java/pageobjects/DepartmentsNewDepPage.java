package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class DepartmentsNewDepPage extends BaseTestConfiguration {
    private static final By newDepartmentBtn = By.xpath("//button[@id='new-department']");
    private static final By newDepartmentPage = By.xpath("//div[@class='card col-md-8']");

    private static final By titleField = By.xpath("//input[@name='name']");
    private static final By additionalInfoBtn = By.xpath("//a[@id='department-form-additional-info']");
    private static final By phoneField = By.xpath("//input[@name='phone']");
    private static final By emailField = By.xpath("//input[@name='email']");

    private static final By submitBtn = By.xpath("//button[@id='department-form-submit']");
    private static final By cancelBtn = By.xpath("//button[@id='department-form-cancel']");
}
