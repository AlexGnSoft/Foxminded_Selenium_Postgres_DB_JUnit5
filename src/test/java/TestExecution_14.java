import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.Builder_Singleton_Strategy.Buider_Pattern.Customer;
import pageobjects.Builder_Singleton_Strategy.Buider_Pattern.CustomerBuilder;

public class TestExecution_14 {

    @Test
    public void checkName() {
        CustomerBuilder builder = new CustomerBuilder()
                .setFirstName("Jose")
                .setLastName("Aveiro");

        Customer customer = builder.getCustomer();
        System.out.println(customer);

        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getFirstName()));
        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getLastName()));
    }
}





