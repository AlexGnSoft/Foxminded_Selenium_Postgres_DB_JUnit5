package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenPage {

    public WebDriver driver;

    public OpenPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By loginPageBody = By.xpath("//body//login");

    public Boolean loginPageIsVisible(){
        WebElement loginPage = driver.findElement(loginPageBody);

        return loginPage.isDisplayed();
    }
}
