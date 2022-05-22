package helpfiles;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    private final Properties properties;

    public PropertiesFile(){
        BufferedReader reader;
        String propertyFilePath = "src/main/java/helpfiles/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties file not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser is not specified in the config.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url is not specified in the config.properties file.");
    }

    public String getTitle() {
        String title = properties.getProperty("title");
        if(title != null) return title;
        else throw new RuntimeException("browser is not specified in the config.properties file.");
    }

    public String getLoginCredentials() {
        String login = properties.getProperty("login");
        if(login != null) return login;
        else throw new RuntimeException("login is not specified in the config.properties file.");
    }

    public String getPasswordCredentials() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password is not specified in the config.properties file.");
    }

    public String getDriverPathChrome(){
        String driverPath_Chrome = properties.getProperty("driverPath_Chrome");
        if(driverPath_Chrome!= null) return driverPath_Chrome;
        else throw new RuntimeException("driverPath for Chrome not specified in the config.properties file.");
    }

    public String getDriverPathFireFox(){
        String driverPath_Firefox = properties.getProperty("driverPath_Firefox");
        if(driverPath_Firefox!= null) return driverPath_Firefox;
        else throw new RuntimeException("driverPath for FireFox not specified in the config.properties file.");
    }

    public long getImplicitWait() {
        String implicitWait = properties.getProperty("implicit_Wait");
        if(implicitWait != null) return Long.parseLong(implicitWait);
        else throw new RuntimeException("implicitlyWait is not specified in the config.properties file.");
    }

    public long getExplicitWait() {
        String explicitWait = properties.getProperty("explicit_Wait");
        if(explicitWait != null) return Long.parseLong(explicitWait);
        else throw new RuntimeException("explicitWait is not specified in the config.properties file.");
    }
}
