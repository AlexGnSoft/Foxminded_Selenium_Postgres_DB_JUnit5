package pageobjects;
import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenPage extends BaseTestConfiguration{

    private static final By loginPageBody = By.xpath("//body//login");

    public Boolean loginPageIsVisible(){
        driver = new ChromeDriver();
        WebElement loginPage = driver.findElement(loginPageBody);

        return loginPage.isDisplayed();
    }
}
