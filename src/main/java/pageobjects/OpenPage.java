package pageobjects;
import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class OpenPage extends BaseTestConfiguration{
    public static final By loginPageBody = By.xpath("//body//login");
    public static final By login = By.cssSelector("input[name='username']");
    public static final By password = By.cssSelector("input[name='password']");
    public static final By signInButton = By.xpath("//button[@id='login-signin']");
    public static final By homePage = By.xpath("//div[@class='main-panel']");

    public static void makeSignIn(String username, String pass) {
        driver.findElement(login).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();
    }
}
