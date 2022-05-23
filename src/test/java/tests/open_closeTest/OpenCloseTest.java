package tests.open_closeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class OpenCloseTest extends BaseTest {

    @Test
    public void openApplication(){
        baseTestConfiguration.openBrowser(propertiesFile.getApplicationUrl());
        Assertions.assertTrue(openPage.loginPageIsVisible());
    }

    @Test
    public void closeApplication(){
        baseTestConfiguration.openBrowser(propertiesFile.getApplicationUrl());
        baseTestConfiguration.closeBrowser();
    }
}
