import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import helpfiles.ScreenShot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;

public class TestExecution_8 extends BaseTestConfiguration{

    @Test
    public void testOpenApplication() throws Exception {
        // Go to application Login page
        openBrowser();

        ScreenShot.takeScreenShot();

        // Verify that login page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.loginPageBody), "Login page is not visible");
    }

    @Test
    public void testCloseApplication() throws Exception {
        // Go to application Login page
        openBrowser();

        // Take screenShot
        ScreenShot.takeScreenShot();

        // Close the application
        tearDown();
    }

    @Test
    public void testSignIn() throws Exception {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Verify that home page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.homePage), "Home page is not visible");

        // Take screenShot
        ScreenShot.takeScreenShot();
    }
}
