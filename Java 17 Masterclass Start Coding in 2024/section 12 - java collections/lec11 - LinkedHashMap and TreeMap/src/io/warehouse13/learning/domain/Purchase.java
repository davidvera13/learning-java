package io.warehouse13.learning.domain;

import java.time.LocalDate;

public record Purchase(String courseId, int studentId, double price, int year, int dayOfYear) {
    public LocalDate purchaseDate() {
        return LocalDate.ofYearDay(year, dayOfYear);
    }
}