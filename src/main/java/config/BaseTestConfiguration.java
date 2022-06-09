package config;

import helpfiles.PropertiesFile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTestConfiguration {
    protected static PropertiesFile propertiesFile;
    protected static WebDriver driver;

    /**
     * Method is used to signal that the annotated method is executed before all tests in the current test class.
     * '@BeforeAll' method is only executed once for a given test class.
     * Method creates webDriver and run test on a certain browser, depending on set browser in PropertiesFile class.
     */
    @BeforeAll
    public static void createDriver(){
        propertiesFile = new PropertiesFile();

        switch(propertiesFile.getBrowser()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertiesFile.getDriverPathChrome());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", propertiesFile.getDriverPathFireFox());
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser name specified in Config class is not equal to : " + propertiesFile.getBrowser());
        }
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesFile.getImplicitWait()));
    }


    /**
     * Method open an application
     */
    public void openBrowser(){
        driver.get(propertiesFile.getApplicationUrl());
    }

    /**
     * Method is used to signal that the annotated method should be executed after all tests in the current test class.
     * '@AfterAll' method is only executed once for a given test class.
     * Method quit the whole browser session along with all the associated browser windows, tabs and pop-ups.
     */
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
