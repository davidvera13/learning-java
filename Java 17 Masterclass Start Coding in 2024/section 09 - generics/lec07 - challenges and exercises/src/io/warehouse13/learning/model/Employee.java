package io.warehouse13.learning.model;

import io.warehouse13.learning.util.QueryItem;

public record Employee(String name) implements QueryItem {
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}