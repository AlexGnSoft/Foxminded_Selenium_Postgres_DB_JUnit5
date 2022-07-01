package helpfiles;

import config.BaseTestConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot extends BaseTestConfiguration {

    public static String takeScreenShot() throws Exception{

        Date currentDate = new Date();
        String path;
        String screenShotFileName = currentDate.toString()
                .replace(" ", "-")
                .replace(":", "-")
                .replace("WEST-", "");

        try{
            File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            path = "src/main/java/testdata/" + screenShotFileName + ".png";
            FileUtils.copyFile(screenshotFile, new File(path));
        }catch (IOException e){
            path = "Failed to capture screenshot" + e.getMessage();
        }
        return path;
    }
}
