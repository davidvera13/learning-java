package io.warehouse13.learning;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // Challenge 1:
        // Write the following anonymous class that you can see on screen, as a lambda expression.
        // Try to do it manually on your own, and don't rely on IntelliJ's tools to do it for you.
        // This will help you understand lambdas better.
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part: parts)
                    System.out.println(part);
            }
        };
        // Challenge 1 solutions
        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts)
                System.out.println(part);
        };
        // solution 1 using foreach:
        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        // solution 1 one line:
        Consumer<String> printWordsConcise = sentence ->
            //Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s))
            Arrays.asList(sentence.split(" ")).forEach(System.out::println)
        ;

        printWords.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");
        printWordsForEach.accept("Let's split this up into an array");
        printWordsConcise.accept("Let's split this up into an array");

        // challenge 2 solution:
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // challenge 3 solution
        // The lambda expression we created in Challenge 2 doesn't do anything right now.
        //I want you to write the code to execute this lambda expression's functional method, using 1234567890,
        // as the argument to that method, and print the result out.
        // could be also : Function<String, String> everySecondChar
        System.out.println(everySecondChar.apply("1234567890"));

        // Challenge 5:
        // Call the method you created from Challenge 4, passing the lambda variable we created
        // earlier, and the string 1234567890, then print the result returned from the method.

        String result = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result);


        // Chalenge 6:
        // Write a lambda expression that is declared with the Supplier interface.
        // This lambda should return the String, "I love Java", and assign it to a variable called,
        // iLoveJava.
        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava2 = () -> {return "I love Java!";};

        // challenge 7:
        // As with the Function example, the Supplier lambda won't do anything until we use it.
        // Remember, lambdas represent deferred execution of snippets of code.
        // Use this Supplier to assign a String, "I love Java", to a variable called supplierResult.
        // Print that variable to the console.
        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());


    }

    // Challenge 2:
    // Write the following method as a lambda expression.
    // In other words, create a variable, using a type that makes sense for this method.
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            returnVal.append(source.charAt(i));
        }
        return returnVal.toString();
    }

    // challenge 4:
    // Instead of executing this function directly, suppose that we want to pass it to a method.
    // Write another method on your class, called everySecondCharacter.
    // This method should accept a Function, or UnaryOperator, as a parameter, as well as a second parameter that lets us pass, "1234567890".
    // In other words, don't hard code that string in your method code.
    // The method code should execute the functional method on the first argument, passing it the value of the string passed, from the enclosing method.
    // It should return the result of the call to the functional method.
    public static String everySecondCharacter(
            Function<String, String> func,
            String source) {
        return func.apply(source);
    }
}
