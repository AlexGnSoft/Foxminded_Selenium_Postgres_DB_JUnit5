import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;
import utils.ScreenshotWatcher;


public class TestExecution_8 extends BaseTestConfiguration{

    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

    @Test
    public void testOpenApplication() {
        // Go to application Login page
        openBrowser();

        // Verify that login page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.loginPageBody), "Login page is not visible");
    }

    @Test
    public void testCloseApplication() {
        // Go to application Login page
        openBrowser();

        // Close the application
        tearDown();
    }

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
