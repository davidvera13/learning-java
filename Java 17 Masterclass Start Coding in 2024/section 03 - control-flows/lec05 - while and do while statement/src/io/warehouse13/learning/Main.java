package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        System.out.println("****************");
        count = 1;
        while (true) {
            if (count == 6)
                break;
            System.out.println("Count value is " + count);
            count++;
        }
        System.out.println("****************");
        // be executed at least once
        count = 1;
        do {
            System.out.println("Count value is " + count);
            count++;
        } while (count != 6);


        System.out.println("****************");
        // be executed at least once
        // count = 1;
        do {
            System.out.println("Count value is " + count);
            count++;
            // to avoid infinite loop
            if(count == 10)
                break;
        } while (count != 6);

        System.out.println("****************");
        // similar to for loop
        for(count = 1; count != 6; count++) {
            System.out.println("Count value is " + count);
        }

        System.out.println("****************");
        // create a method call isEvenNumber that takes a parameter of type int
        // its purpose is to determine if a number is odd or even
        // return true if we have even number, false otherwise
        int number = 4;
        int finishedAt = 22;
        while (number < finishedAt) {
            number++;
            // will not break, will go out the loop and start again
            if(!isEvenNumber(number))
                continue;

            System.out.println("Even number " + number);
        }

        System.out.println("****************");
        // make the above code also record the total number of even numbers it has found
        // and break once 5 are found
        // display the total of even number found
        number = 4;
        finishedAt = 20;
        int evenNumberFound = 0;
        while (number < finishedAt) {
            number++;
            // will not break, will go out the loop and start again
            if(!isEvenNumber(number))
                continue;

            evenNumberFound++;
            System.out.println("Even number " + number);
            if(evenNumberFound >= 5)
                break;
        }
        System.out.println("Even number found = " + evenNumberFound);


    }
    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
