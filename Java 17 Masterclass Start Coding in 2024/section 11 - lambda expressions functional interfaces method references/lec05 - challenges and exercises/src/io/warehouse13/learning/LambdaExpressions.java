package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaExpressions {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // This challenge, is to exercise your skills with Arrays, ArrayLists, and the methods on these, which are targets
        // for lambda expressions.
        //First, I want you to create an array of String, which is populated with first names, in mixed case.
        //Include at least one name, which is spelled the same backwards, and forwards, like Bob, or Anna.
        //Use Arrays.setAll, or List.replaceAll, to change the values in this array.
        //If you use List methods, you'll need a list backed by the array, so that changes get made to the initial array.
        // Using one of those two methods, perform the following functions on the elements in the array, with appropriate
        // lambda expressions.
        //Transform names to all uppercase.
        //Add a randomly generated middle initial, and include a period.
        //Add a last name that is the reverse of the first name.
        //Print your array or the array elements, after each change, using the forEach method, at least once.
        //Finally, create a new modifiable ArrayList from your names array, removing any names where the last name
        //equals the first name.
        //Use removeIf with a lambda expression to do this last operation.
        String[] names = { "Anna", "Bob", "Charles", "Daniel", "Eric", "Franck", "Gary", "Harols" };
        Arrays.setAll(names, i -> names[i].toUpperCase());
        // to uppercase
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("# Add random middle initial:");
        System.out.println(Arrays.toString(names));
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("# Add reversed name");
        //Arrays.asList(names).forEach(name -> System.out.println(name));
        Arrays.asList(names).forEach(System.out::println);

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));
        System.out.println("# remove names if first = last");
        newList.forEach(System.out::println);


    }

    // get random char
    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
