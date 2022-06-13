package utils;

import net.bytebuddy.utility.RandomString;

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
    public String randomString(int strLength){
        //create a string for all characters
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

        //create a random string builder
        StringBuilder sb = new StringBuilder();

        //create an object of random string
        Random random = new Random();

        for (int i = 0; i < strLength; i++) {

            //initialize length of index, which we get as our method input value
            int index = random.nextInt(AlphaNumericStr.length());

            //get character specified by index from string
            char randomChar = AlphaNumericStr.charAt(index);

            //append the character to String builder
            sb.append(randomChar);
        }

        //initializing out random string
        String randomString = sb.toString();
        System.out.println(randomString);

        return randomString;
    }


    public static void main(String[] args) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        randomDataGenerator.randomString(7);
    }
}


