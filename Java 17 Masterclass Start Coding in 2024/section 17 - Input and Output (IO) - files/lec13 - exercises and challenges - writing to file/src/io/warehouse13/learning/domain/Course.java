package io.warehouse13.learning.domain;

import java.util.StringJoiner;

public record Course(String courseCode, String title) {

    public int getLectureCount() {
        return 15;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }

    public String toJson() {
        return new StringJoiner(", ", "{", "}")
                .add("\"courseCode\":\"" + courseCode + "\"")
                .add("\"title\":\"" + title + "\"")
                .toString();
    }
}
