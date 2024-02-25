package io.warehouse13.challenge;

public class Challenge {
    public static void main(String[] args) {
        // create a double with value 20
        // create a double with value 80
        // add both together and multiply by 100
        // use remainder operator from the previous result and 40
        // create boolean to check if remainder is 0 or not
        // output the boolean
        // write if then statement to display the message: Got some remainder
        System.out.println("Recap");
        System.out.println("**********************");
        double d1 = 20.0d;
        double d2 = 80.0d;
        double d3 = 100.0d;
        double output = d1 + d2;
        output *=d3;
        output = output % 40;
        //boolean hasRemainder = output == 0 ? true: false;
        boolean hasRemainder = output == 0;
        System.out.println(hasRemainder);
        if(!hasRemainder)
            System.out.println("Got remainder " + output);
        else
            System.out.println("No remainder");

        // single line : be aware of precedence !!!
        output = ((d1+d2) * 100d) % 40d;
        System.out.println("Remainder ? " + output);

    }
}
