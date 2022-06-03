import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;

public class TestExecution_8 extends BaseTestConfiguration{

    @Test
    public void openApplication(){
        openBrowser();
        Assertions.assertTrue(OpenPage.webElementIsVisible(OpenPage.loginPageBody));
    }

    @Test
    public void closeApplication(){
        openBrowser();
        tearDown();
    }

    @Test
    public void signIn() {
        openBrowser();
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        Assertions.assertTrue(OpenPage.homePageIsVisible());
    }


}
