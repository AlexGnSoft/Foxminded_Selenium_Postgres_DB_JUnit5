package pageobjects;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OpenPage extends BaseTestConfiguration{
    public static PropertiesFile propertiesFile = new PropertiesFile();

    public static final By loginPageBody = By.xpath("//body//login");

    private static final By login = By.cssSelector("input[name='username']");
    private static final By password = By.cssSelector("input[name='password']");

    private static final By signInButton = By.xpath("//button[@id='login-signin']");
    public static final By homePage = By.xpath("//div[@class='main-panel']");

    public static Boolean pageIsVisible(By webElement){
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(webElement));

        return true;
    }

    public static void makeSignIn(String username, String pass) {
        driver.findElement(login).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();
    }
}
