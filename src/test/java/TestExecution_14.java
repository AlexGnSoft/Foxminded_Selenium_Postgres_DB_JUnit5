import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageobjects.Builder_Singleton_Strategy.Buider_Pattern.CustomerBuilder;
import utils.ScreenshotWatcher;
import static config.BaseTestConfiguration.getDriver;

public class TestExecution_14 {

    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher(getDriver(), "target/surefire-reports");

    @Test
    public void testCheckNameCapitalization() {
        //Test data
        String fName = "Jose";
        String lName = "Aveiro";
        int age = 18;
        double height = 172d;
        double weight = 75d;

        CustomerBuilder builder = new CustomerBuilder()
                .setFirstName(fName)
                .setLastName(lName)
                .setAge(age)
                .setHeight(height)
                .setWeight(weight);

//        Customer customer = builder.getCustomer();
//        System.out.println(customer);
//        System.out.println(builder.getAge());

        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getFirstName()), "Name does not start from the capital");
        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getLastName()), "Name does not start from the capital");
    }

    @Test
    public void testAccessByAgeCheck(){
        //Test data
        String fName = "Antonio";
        String lName = "Rodrigo";
        int age = 18;

        CustomerBuilder builder = new CustomerBuilder()
                .setFirstName(fName)
                .setLastName(lName)
                .setAge(age);

        Assertions.assertTrue(
                CustomerBuilder.isCustomerCanEnterNightClud(builder.getFirstName(),
                        builder.getLastName(),
                        builder.getAge()),
                "The customer can not enter");
    }
}





