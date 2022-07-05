package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 *
 * @author steve
 *
 * to use, add the following to your JUnit5 tests:
 *
 * @RegisterExtension
 * ScreenshotWatcher watcher = new ScreenshotWatcher(driver, "target/surefire-reports");
 *
 */
public class ScreenshotWatcher implements TestWatcher {

    WebDriver driver;
    String path;

    public ScreenshotWatcher(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        System.out.println("This test was Aborted");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        System.out.println("This test was Disabled");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        System.out.println("This test is Failed");
        captureScreenshot(driver, context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        System.out.println("This test is Successful");
    }

    public void captureScreenshot(WebDriver driver, String screenShotName) {
        try {
            new File(path).mkdirs();
            try ( FileOutputStream out = new FileOutputStream(path + File.separator + screenShotName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }
}