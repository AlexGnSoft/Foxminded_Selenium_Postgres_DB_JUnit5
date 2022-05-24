import config.BaseTestConfiguration;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;

public class TestExecution extends BaseTestConfiguration {
    OpenPage openPage = new OpenPage();

    @Test
    public void openApplication(){
        createDriver();
        openBrowser(propertiesFile.getApplicationUrl());
        Assertions.assertTrue(openPage.loginPageIsVisible());
        tearDown();
    }

    @Test
    public void closeApplication(){
        createDriver();
        openBrowser(propertiesFile.getApplicationUrl());
        tearDown();
    }
}
