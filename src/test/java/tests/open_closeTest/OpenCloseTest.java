package tests.open_closeTest;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;


public class OpenCloseTest extends BaseTest {

    @Test
    public void openApplication(){
        baseTestConfiguration.openBrowser(propertiesFile.getApplicationUrl());
        Assertions.assertTrue(openPage.loginPageIsVisible());

        // closeBrowser() с аннотацией @AfterAll не запусукаеться по завершению теста openApplication()
    }

    @Test
    public void closeApplication(){
        baseTestConfiguration.openBrowser(propertiesFile.getApplicationUrl());
        baseTestConfiguration.closeBrowser();  //принудительно вызывая метод closeBrowser, он естественно отрабатывает.
    }
}
