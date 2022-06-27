import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.Builder_Singleton_Strategy.Buider_Pattern.CustomerBuilder;

public class TestExecution_14 {

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

        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getFirstName()));
        Assertions.assertTrue(CustomerBuilder.isNamesStartsFromCapital(builder.getLastName()));
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

        Assertions.assertTrue(CustomerBuilder.isCustomerCanEnterNightClud(builder.getFirstName(), builder.getLastName(), builder.getAge()));
    }
}





