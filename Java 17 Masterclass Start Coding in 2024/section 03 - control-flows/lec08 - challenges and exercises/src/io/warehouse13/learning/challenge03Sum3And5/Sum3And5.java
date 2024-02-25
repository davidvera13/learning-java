package io.warehouse13.learning.challenge03Sum3And5;

public class Sum3And5 {
    public static void main(String[] args) {
        // create a for statement using a range of numbers from 1 to 1000 inclusive
        // sum all numbers that can be divided by 3 and 5
        // print out the numbers that are meeting the above conditions
        // break out the loop once 5 numbers are found

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if((i % 5 == 0) && (i % 3 ==0)) {
                System.out.println(i + " can be divided by 3 and 5");
                count++;
                sum += i;
            }
            if(count == 5) {
                break;
            }
        }
        System.out.println("Total sum = " + sum);
    }
}
