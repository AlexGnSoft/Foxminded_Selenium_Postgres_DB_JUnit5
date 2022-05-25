import config.BaseTestConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;

public class TestExecution extends BaseTestConfiguration{

    @Test
    public void openApplication(){
        openBrowser();
        Assertions.assertTrue(OpenPage.loginPageIsVisible());
    }

    @Test
    public void closeApplication(){
        openBrowser();
        tearDown();
    }
}
