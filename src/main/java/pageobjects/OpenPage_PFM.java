package pageobjects;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenPage_PFM extends BaseTestConfiguration {
    public static PropertiesFile propertiesFile = new PropertiesFile();

    @FindBy(xpath = "//body//login")
    private static WebElement loginPageBody;

    @FindBy(css = "input[name='username']")
    private WebElement login;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login-signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='main-panel']")
    private static WebElement homePageBody;

    public OpenPage_PFM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static OpenPage_PFM using(WebDriver driver) {
        return new OpenPage_PFM(driver);
    }

    public OpenPage_PFM setLogin(String login){
        this.login.sendKeys(login);
        return this;
    }

    public OpenPage_PFM setPassword(String password){
        this.password.sendKeys(password);
        return this;
    }

    public void clickSing(){
        this.signInButton.click();
    }

    public static Boolean isLoginPageBodyVisible() {
        return loginPageBody.isDisplayed();
    }

    public static Boolean isHomePageBodyVisible() {
        return homePageBody.isDisplayed();
    }

}
