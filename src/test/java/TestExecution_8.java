import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;

public class TestExecution_8 extends BaseTestConfiguration{

    @Test
    public void testOpenApplication(){
        // Go to application Login page
        openBrowser();

        // Verify that login page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.loginPageBody));
    }

    @Test
    public void testCloseApplication(){
        // Go to application Login page
        openBrowser();

        // Close the application
        tearDown();
    }

    @Test
    public void testSignIn() {
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        // Verify that home page is visible
        Assertions.assertTrue(GlobalPages.pageIsVisible(OpenPage.homePage));
    }
}
