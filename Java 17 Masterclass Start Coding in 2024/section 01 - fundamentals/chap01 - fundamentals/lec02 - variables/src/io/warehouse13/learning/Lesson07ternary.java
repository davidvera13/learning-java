package io.warehouse13.learning;

public class Lesson07ternary {
    public static void main(String[] args) {
        boolean isCar = true;
        boolean wasCar = isCar ? true: false;
        if(wasCar) {
            System.out.println("wasCar was true");
        }

        String wasCarString = isCar ? "Yes of course": "Not at all";
        System.out.println(wasCarString);
    }
}
