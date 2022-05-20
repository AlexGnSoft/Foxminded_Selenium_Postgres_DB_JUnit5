package pageobjects.base;

import helpfiles.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    static PropertiesFile propertiesFile;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElementIsVisible(WebElement element){
        propertiesFile = new PropertiesFile();
        new WebDriverWait(driver, Duration.ofSeconds(propertiesFile.getExplicitWait())).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
