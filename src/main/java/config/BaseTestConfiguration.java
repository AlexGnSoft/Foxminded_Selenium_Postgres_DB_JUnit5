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


    public void openBrowser(){
        driver.get(propertiesFile.getApplicationUrl());
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
