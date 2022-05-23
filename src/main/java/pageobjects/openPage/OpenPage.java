package pageobjects.openPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.base.BasePage;

public class OpenPage extends BasePage {

    public OpenPage(WebDriver driver) {
        super(driver);
    }

    private static final By loginPageBody = By.xpath("//body//login");

    public Boolean loginPageIsVisible(){
        WebElement loginPage = driver.findElement(loginPageBody);

        return loginPage.isDisplayed();
    }
}
