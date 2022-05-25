package pageobjects;
import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class OpenPage extends BaseTestConfiguration{

    private static final By loginPageBody = By.xpath("//body//login");

    public static Boolean loginPageIsVisible(){
        WebElement loginPage = driver.findElement(loginPageBody);

        return loginPage.isDisplayed();
    }
}
