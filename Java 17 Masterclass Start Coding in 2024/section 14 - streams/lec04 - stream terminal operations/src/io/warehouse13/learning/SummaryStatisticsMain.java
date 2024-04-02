package io.warehouse13.learning;

import java.util.stream.IntStream;

public class SummaryStatisticsMain {
    public static void main(String[] args) {
        System.out.println("# Using summaryStatistics");
        var result = IntStream
                .iterate(0, i -> i <= 1000, i -> i = i+3)
                .summaryStatistics();
        System.out.println("Result : " + result);

        System.out.println();

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i += 1)
                .filter(i -> i % 4 == 0)
                // good place for peek
                .peek(System.out::println)
                .summaryStatistics();

        System.out.println("leapYearData : " + leapYearData);
    }
}
