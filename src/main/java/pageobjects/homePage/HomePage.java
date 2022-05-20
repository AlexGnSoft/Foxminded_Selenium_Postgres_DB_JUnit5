package pageobjects.homePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By loginPageBody = By.xpath("//body//login");
    private static final By login = By.xpath("//input[@id='username']");
    private static final By password = By.xpath("//input[@id='password']");


    public HomePage loginPageIsVisible(){
        WebElement loginPage = driver.findElement(loginPageBody);
        Assertions.assertTrue(loginPage.isDisplayed());

        return this;
    }
}
