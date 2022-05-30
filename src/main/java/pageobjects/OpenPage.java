package pageobjects;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenPage extends BaseTestConfiguration{
    public static PropertiesFile propertiesFile = new PropertiesFile();

    private static final By loginPageBody = By.xpath("//body//login");

    private static final By login = By.cssSelector("input[name='username']");
    private static final By password = By.cssSelector("input[name='password']");

    private static final By signInButton = By.xpath("//button[@id='login-signin']");
    private static final By homePage = By.xpath("//div[@class='main-panel']");

    public static Boolean loginPageIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(loginPageBody));

        return true;
    }

    public static void clickToSignIn() {
        driver.findElement(login).sendKeys(propertiesFile.getLoginCredentials());
        driver.findElement(password).sendKeys(propertiesFile.getPasswordCredentials());
        driver.findElement(signInButton).click();
    }

    public static Boolean homePageIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(homePage));

        return true;
    }
}
