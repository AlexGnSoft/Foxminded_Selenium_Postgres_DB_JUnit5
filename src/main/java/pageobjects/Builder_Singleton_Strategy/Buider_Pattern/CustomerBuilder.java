package pageobjects.Builder_Singleton_Strategy.Buider_Pattern;

public class CustomerBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;

    public CustomerBuilder setFirstName(String fName) {
        this.firstName = fName;
        return this;
    }

    public CustomerBuilder setLastName(String lName) {
        this.lastName = lName;
        return this;
    }

    public CustomerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public CustomerBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    public CustomerBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public  Customer getCustomer(){
        return new Customer(firstName, lastName, age, height, weight);
    }

    public static Boolean isNamesStartsFromCapital(String namesAreCapital) {
        String regEx = "[A-Z]\\w*";

        if(namesAreCapital.matches(regEx)){
            return true;
        } else
            return false;
    }
}
