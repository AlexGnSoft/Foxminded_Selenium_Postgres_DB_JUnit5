package tests.base;

import helpfiles.PropertiesFile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageobjects.base.BasePage;
import pageobjects.homePage.HomePage;
import utils.WebDriverSetup;
import static config.Config.CLEAR_COOKIES_AND_STORAGE;
import static config.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected static WebDriver driver = WebDriverSetup.createDriver();
    protected static BasePage basePage = new BasePage(driver);
    protected static HomePage homePage = new HomePage(driver);
    protected static PropertiesFile propertiesFile = new PropertiesFile();

    @BeforeEach
    public void openBrowser(){
        driver.get(propertiesFile.getApplicationUrl());

        if(!driver.getTitle().equals(propertiesFile.getTitle())){
            throw new IllegalStateException("You're not at 'http://176.36.27.131:8180/#/login' website. The current page is " + driver.getTitle());
        }
    }

    @AfterEach
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES_AND_STORAGE)
        {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll()
    public static void closeBrowser(){
        if(HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}
