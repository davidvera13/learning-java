package io.warehouse13.learning;

// immutable, shorter than POJO
public record RecordStudent(String id, String name, String dateOfBirth, String classList) {
}