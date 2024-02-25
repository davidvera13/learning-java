package io.warehouse13.learning;

public class Main {
    //public static void main(String[] args) {
    //}
    public static void main(String... args) {
        String str = "Hello world again";
        System.out.println(str);
        String[] split = str.split(" ");
        printText(split);
        System.out.println("**************");
        printText("hello! ".repeat(5));
        System.out.println("**************");
        printText("Goodbye", "everybody");
        System.out.println("**************");
        printText();
        System.out.println("**************");
        String[] arr =  {"one", "two", "three", "four"};
        System.out.println(String.join(", ",  arr));
    }


    private static void printText(String... textList) {
        for (String str: textList)
            System.out.println(str);
    }
}
