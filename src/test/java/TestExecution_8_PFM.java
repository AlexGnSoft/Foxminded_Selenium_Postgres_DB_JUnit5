import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageobjects.OpenPage_PFM;
import utils.ScreenshotWatcher;

public class TestExecution_8_PFM extends BaseTestConfiguration{

    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

    @Test
    public void testOpenApplication(){
        // Go to application Login page
        openBrowser();

        OpenPage_PFM.using(getDriver());

        //Verify that login page is visible
        Assertions.assertTrue(OpenPage_PFM.isLoginPageBodyVisible(), "Login page is not visible");
    }

    @Test
    public void testSignIn() {
        // Go to application Login page
        openBrowser();

        // Sing in test
        OpenPage_PFM.using(getDriver())
                .setLogin(PropertiesFile.getLoginCredentials())
                        .setPassword(PropertiesFile.getPasswordCredentials())
                                .clickSing();

        //Verify that home page is visible
        Assertions.assertTrue(OpenPage_PFM.isHomePageBodyVisible(), "Home page is not visible");
    }
}
