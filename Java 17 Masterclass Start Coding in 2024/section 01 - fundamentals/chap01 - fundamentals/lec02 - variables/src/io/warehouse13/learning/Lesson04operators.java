package io.warehouse13.learning;

public class Lesson04operators {
    public static void main(String[] args) {
        // operators and operators precedence
        // +, -, *, /, %

        int result = 1 + 2; // 1 + 2 = 3
        int previousResult = result;

        System.out.println("1 + 2 = " + result);
        System.out.println("previousResult = result => " + previousResult);

        result = result - 1;
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult => " + previousResult );

        result = result * 10;
        System.out.println("result * 10 = " + result);
        System.out.println("previousResult => " + previousResult );

        result = result / 5;
        System.out.println("result / 5 = " + result);

        result = result % 3; // 4 / 3 = 1 remains 1
        System.out.println("4 % 3 = " + result);

        // shorcuts
        result++;
        System.out.println("result + 1 = " + result);

        result--;
        System.out.println("result - 1 = " + result);

        result+=2;
        System.out.println("result + 2 = " + result);

        result*=20;
        System.out.println("result + 20 = " + result);

        result/=3;
        System.out.println("result / 7 = " + result);

    }
}
