import config.BaseTestConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;

public class TestExecution extends BaseTestConfiguration {
    OpenPage openPage = new OpenPage();

    @Test
    public void openApplication(){
        openBrowser();
        Assertions.assertTrue(openPage.loginPageIsVisible());
    }

    @Test
    public void closeApplication(){
        openBrowser();
        tearDown();
    }
}
