package pageobjects.loginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By loginPageBody = By.xpath("//body//login");
    private static final By login = By.xpath("//input[@id='username']");
    private static final By password = By.xpath("//input[@id='password']");


    public LoginPage loginPageIsVisible(){
        WebElement loginPage = driver.findElement(loginPageBody);
        waitElementIsVisible(loginPage);

        return this;
    }
}
