package pageobjects.Builder_Singleton_Strategy.Buider_Pattern;

public class Customer {
    private final String fName;
    private final String lName;
    private final int age;
    private final double height;
    private final double weight;

    public Customer(String fName, String lName, int age, double height, double weight) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
