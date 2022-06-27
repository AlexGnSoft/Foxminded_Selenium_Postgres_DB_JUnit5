import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage_PFM;

public class TestExecution_8_PFM extends BaseTestConfiguration{


    @Test
    public void testOpenApplication(){
        // Go to application Login page
        openBrowser();

        OpenPage_PFM.using(getDriver());

        //Verify that login page is visible
        Assertions.assertTrue(OpenPage_PFM.isLoginPageBodyVisible());
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
        Assertions.assertTrue(OpenPage_PFM.isHomePageBodyVisible());
    }
}
