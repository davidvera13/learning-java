package io.warehouse13.learning.ex39PrinterEncapsulation;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("Initial pagee count = " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(5);
        System.out.println("Pages printed was " + pagesPrinted +
                " new total print count for printer is : " + printer.getPagesPrinted());

        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted +
                " new total print count for printer is : " + printer.getPagesPrinted());

    }
}
