package tests.Authorization;

import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;

public class TestExecution_8 extends BaseTestConfiguration{

    @Tag("production")
    @Test
    public void testOpenApplication() {
        // Go to application Login page
        openBrowser();

        // Verify that login page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.loginPageBody), "Login page is not visible");
    }

    @Tag("production")
    @Test
    public void testCloseApplication() {
        // Go to application Login page
        openBrowser();

        // Close the application
//        tearDown();
    }

    @Tag("production")
    @Test
    public void testSignIn(){
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Verify that home page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.homePage), "Home page is not visible");
    }
}
