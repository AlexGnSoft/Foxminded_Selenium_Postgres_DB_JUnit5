package tests.login.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void openApplication(){
        openBrowser();
        loginPage.loginPageIsVisible();
    }
}
