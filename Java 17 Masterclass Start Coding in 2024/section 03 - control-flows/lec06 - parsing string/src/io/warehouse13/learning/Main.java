package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        String numberAsString = "2020";
        int number = Integer.parseInt(numberAsString);
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);

        System.out.println("******************");
        numberAsString += 1;
        number+=1;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);

        System.out.println("******************");
        String currentYear = "2024";
        String yearOfBirth = "1975";

        System.out.println("Age: " + (Integer.parseInt(currentYear) - Integer.parseInt(yearOfBirth)));

        String currentPrice = "22.5";
        String bargain = "12.3";
        System.out.println("Final price : " + (Double.parseDouble(currentPrice) - Double.parseDouble(bargain)));
    }
}
