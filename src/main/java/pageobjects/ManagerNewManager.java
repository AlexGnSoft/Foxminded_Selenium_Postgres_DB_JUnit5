package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.RandomDataGenerator;

import java.util.HashMap;
import java.util.List;

public class ManagerNewManager extends BaseTestConfiguration {
    public static final By ManagerPage = By.cssSelector(".card-content");
    public static final By newManagerBtn = By.cssSelector("#managers-new-manager");
    public static final By newManagerPage = By.cssSelector(".container-fluid");
    public static final By fullNameList = By.xpath("//tbody/tr/td[1]/a");
    public static final By departmentList = By.xpath("//tbody/tr/td[2]");
    public static final By phoneList = By.cssSelector("//tbody/tr/td[3]");
    public static final By emailList = By.cssSelector("//tbody/tr/td[4]");
    public static final By firstNameSearch = By.cssSelector("#search-manager-firstname");
    public static final By lastNameSearch = By.cssSelector("#search-manager-lastname");
    public static final By departmentNameSearch = By.cssSelector("#search-manager-department");
    public static final By filterBtn = By.cssSelector("#search-manager-filter");
    public static final By clearBtn = By.cssSelector("#search-manager-clear");
    public static final By firstName = By.cssSelector("#firstName");
    public static final By lastName = By.cssSelector("#lastName");
    public static final By email = By.cssSelector("#email");
    public static final By login = By.cssSelector("#login");
    public static final By drpDepartment = By.cssSelector("#manager-form-department-select");
    public static final By drpDepartmentOptions = By.xpath("//select[@id='manager-form-department-select']");
    public static final By phone = By.cssSelector("#phone");
    public static final By skype = By.cssSelector("#skype");
//    public static WebElement checkBoxList = driver.findElement(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span"));
    public static final By submitBtn = By.cssSelector("#manager-form-submit");
    public static final By cancelBtn = By.cssSelector("#manager-form-cancel");

    /**
     * Method randomly generates first and last names (strings), where
     * firstNameLength - length of the first name
     * lastNameLength -  length of the last name
     */
    public static void fillInFirstLastNameRandomly(int firstNameLength, int lastNameLength) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        String randomFirstName = randomDataGenerator.randomString(firstNameLength);
        String randomLastName = randomDataGenerator.randomString(lastNameLength);

        GlobalPages.enterDataToTheField(firstName, randomFirstName);
        GlobalPages.enterDataToTheField(lastName, randomLastName);
    }

    /**
     * Method randomly generates email in certain format (randomString@randomString.com  )
     */
    public static String fillInEmailRandomly() {
        int firstEmailPartLength = 8;
        int secondEmailPartLength = 5;
        String at = "@";
        String domain = ".com";

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        String randomBeforeAtPart = randomDataGenerator.randomString(firstEmailPartLength);
        String randomAfterAtPart = randomDataGenerator.randomString(secondEmailPartLength);
        String randomEmail = randomBeforeAtPart.toLowerCase() + at + randomAfterAtPart.toLowerCase() + domain;
        GlobalPages.enterDataToTheField(email, randomEmail);

        return randomEmail;
    }

    /**
     * Method randomly generates login (with First Capital letter and length has to be more than 3 symbols)
     */
    public static String fillInLogin() {
        driver.findElement(login).clear();
        int minStringLength = 4;
        driver.findElement(login).clear();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        String randomString = "";
        String randomLogin = "";
        String firstLetter = "";
        if(minStringLength >= 4){
            randomString = randomDataGenerator.randomString(minStringLength);
            for (int i = 0; i < randomString.length(); i++) {
                boolean flag = Character.isAlphabetic(randomString.charAt(i));
                if(flag){
                    firstLetter = randomString.substring(0,1).toUpperCase();
                }
            }
            String remainingLetters = randomString.substring(1, randomString.length());
            randomLogin = firstLetter + remainingLetters;
        }else{
            System.out.println("Login should be more then 3 symbols");
        }
        driver.findElement(login).sendKeys(randomLogin);

        return randomLogin;
    }


    /**
     * Method randomly generates random phone number (10 symbols)
     */
    public static String fillInPhoneRandomly() {
        driver.findElement(phone).clear();
        int maxInt = 9;
        String plusSign = "+";
        String phoneNumber;
        String randomPhoneNumber;
        int randomNumbers = 0;
        StringBuilder sb = new StringBuilder();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        for (int i = 0; i < 10; i++) {
            randomNumbers = randomDataGenerator.randomInt(maxInt);
            sb.append(randomNumbers);
        }

        phoneNumber = sb.toString();
        randomPhoneNumber = plusSign + phoneNumber;
        driver.findElement(phone).sendKeys(randomPhoneNumber);

        return randomPhoneNumber;
    }

    /**
     * Method randomly generates random skype (alphanumeric string)
     */
    public static String fillInSkypeRandomly() {
        driver.findElement(skype).clear();
        String randomS1;
        String randomS2;
        String randomSkype;
        String randomString;
        int randomInt;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        for (int i = 0; i < 3; i++) {
            randomString = randomDataGenerator.randomString(3);
            randomInt = randomDataGenerator.randomInt(3);
            sb1.append(randomString);
            sb2.append(randomInt);
        }

        randomS1 = sb1.toString();
        randomS2 = sb2.toString();
        randomSkype = randomS1 + randomS2;

        driver.findElement(skype).sendKeys(randomSkype);

        return randomSkype;
    }

    /**
     * Method saves data in Map
     */
    public static HashMap<String, String> saveDataInMap(String email, String login, String phone, String skype) {
        HashMap<String, String> data = new HashMap<>();
        data.put(email, fillInEmailRandomly());
        data.put(login, fillInLogin());
        data.put(phone, fillInPhoneRandomly());
        data.put(skype, fillInSkypeRandomly());

        return data;
    }

    /**
     * Method is used to compare Hash Map values
     */
    public static void compareHashMapValues(){
       saveDataInMap()

    }
















    public static void main(String[] args) {


    }
}
