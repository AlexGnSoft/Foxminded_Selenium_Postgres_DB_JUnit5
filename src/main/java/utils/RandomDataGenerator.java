package utils;

import java.util.Random;

public class RandomDataGenerator {

    /**
     * Method is used to generate random Boolean state
     */
    public Boolean randomBoolean(){
        Random random = new Random();
        Boolean booleanState = random.nextBoolean();

        return booleanState;
    }

    /**
     * Method is used to generate random int values,
     * where intRange - sets the max int diapason value.
     */
    public int randomInt(int intRange){
        Random random = new Random();
        int randomInt = random.nextInt(intRange);

        return randomInt;
    }

    /**
     * Method is used to generate random Strings values,
     * where stringArray - is an array of strings
     */
    public String randomString(String[] stringArray){
        Random random = new Random();

        // Getting random index of a string in the array of strings
        int randomIndex = random.nextInt(stringArray.length);

        // Initializing randomString variable with random string value
        String randomString = stringArray[randomIndex];

        return randomString;
    }


    public static void main(String[] args) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        String [] arr = {"Jose", "Alex", "Ann", "Polina", "German"};
        randomDataGenerator.randomString(arr);

    }
}


