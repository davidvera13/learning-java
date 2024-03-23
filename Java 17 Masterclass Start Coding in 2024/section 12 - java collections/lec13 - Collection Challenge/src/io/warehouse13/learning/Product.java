package io.warehouse13.learning;

public record Product(
        String sku,
        String name,
        String manufacturer,
        Category category) {
}
