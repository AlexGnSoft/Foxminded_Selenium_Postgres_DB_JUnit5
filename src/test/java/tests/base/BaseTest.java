package tests.base;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.WebDriver;
import pageobjects.openPage.OpenPage;

public class BaseTest {
    protected static WebDriver driver = BaseTestConfiguration.createDriver();
    protected PropertiesFile propertiesFile = new PropertiesFile();
    protected OpenPage openPage = new OpenPage(driver);
    protected BaseTestConfiguration baseTestConfiguration = new BaseTestConfiguration(driver);

}
