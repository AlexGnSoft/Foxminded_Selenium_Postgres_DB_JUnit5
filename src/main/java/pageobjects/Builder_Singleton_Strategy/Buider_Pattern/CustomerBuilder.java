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

    /**
     * Method is used to verify whether entered name starts with capital letter
     */
    public static Boolean isNamesStartsFromCapital(String namesAreCapital) {
        String regEx = "[A-Z]\\w*";

        if(namesAreCapital.matches(regEx)){
            return true;
        } else
            return false;
    }

    /**
     * Method is used to verify whether age of a visitor is old enough
     * if age is < then ageLimit - such a visitor can not enter a club
     * if age is > then ageLimit - such a visitor can enter a club
     */
    public static Boolean  isCustomerCanEnterNightClud(String firstName, String lastName, int age){
        int ageLimit = 18;

        if(age >=ageLimit){
            System.out.println(firstName + " " + lastName + " you can enter our club!");
            return true;

        }else{
            System.out.println(firstName + " " + lastName + ", we're really sorry, but due to your age you can't enter our club :(");
        }
        return false;
    }
}
