package config;

import helpfiles.PropertiesFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ScreenshotWatcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestConfiguration {
    protected static PropertiesFile propertiesFile;

    //Singleton approach for driver instance
    private static WebDriver driver;

    public static WebDriver getDriver() {
//        log.log(Level.INFO, "getDriver method");
        return driver;
    }

    /**
     * Method is used to signal that the annotated method is executed before all tests in the current test class.
     * '@BeforeAll' method is only executed once for a given test class.
     * Method creates webDriver and run test on a certain browser, depending on set browser in PropertiesFile class.
     */
    @BeforeEach
    public void createDriver() {
        propertiesFile = new PropertiesFile();

        switch (propertiesFile.getBrowser()) {
            case "chrome":
               //in case we want to run our test in Docker:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                chromeOptions.setCapability("browserName", "chrome");

                try {
                    driver = new RemoteWebDriver(new URL(propertiesFile.getRemoteRunUrl()), chromeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                System.setProperty("webdriver.chrome.driver", propertiesFile.getDriverPathChrome());
                //in case we want to run our test locally (activate driver = new ChromeDriver() and comment  ChromeOptions):
//                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", propertiesFile.getDriverPathFireFox());
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser name specified in Config class is not equal to : " + propertiesFile.getBrowser());
        }
        assert driver != null;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesFile.getImplicitWait()));
    }


    /**
     * Method is used to signal that the annotated method should be executed after all tests in the current test class.
     * '@AfterAll' method is only executed once for a given test class.
     * Method quit the whole browser session along with all the associated browser windows, tabs and pop-ups.
     */
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        String className = this.getClass().getSimpleName();
        String methodName = testInfo.getDisplayName();
        String screenShotName = className + " - " + methodName;

        ScreenshotWatcher watcher = new ScreenshotWatcher(driver, "screenshots");
        watcher.captureScreenshot(driver, screenShotName);

        if(driver != null){
            driver.quit();
        }
    }

    /**
     * Method open an application
     */
    public void openBrowser() {
        driver.get(propertiesFile.getApplicationUrl());
    }

    /**
     * Method scrolls cursor down on a page
     */
    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
}