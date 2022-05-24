import config.BaseTestConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.OpenPage;

public class TestExecution extends BaseTestConfiguration {
    OpenPage openPage = new OpenPage(driver);

    public TestExecution(WebDriver driver) {
        super(driver);
    }

    @Test
    public void openApplication(){
        openBrowser(propertiesFile.getApplicationUrl());
        Assertions.assertTrue(openPage.loginPageIsVisible());
    }

    @Test
    public void closeApplication(){
        openBrowser(propertiesFile.getApplicationUrl());
        tearDown();
    }
}
