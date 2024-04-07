package io.warehouse13.learning.domain;

import java.time.LocalDate;
import java.time.Period;

public class CourseEngagement {
    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(
            Course course,
            LocalDate enrollmentDate,
            String engagementType) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.lastActivityDate = enrollmentDate; // make sense that last activity match with enrollment date on setup
        this.engagementType = engagementType;
    }

    public Course getCourse() {
        return course;
    }

    // custom
    public String getCourseCode() {
        return course.courseCode();
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    // custom
    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }
    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }

    // custom
    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    // custom
    public String getLastActivityMonth() {
        return "%tb".formatted(lastActivityDate);
    }

    // custom
    public double getPercentComplete() {
        return (double) (lastLecture * 100) / course.lectureCount();
    }

    // custom
    public int getMonthsSinceActive() {
        LocalDate now = LocalDate.now();
        var month = Period.between(lastActivityDate, now).toTotalMonths();
        return (int) month;
    }

    // custom
    void watchLecture(int lectureNumber, LocalDate currentDate) {
        lastLecture = Math.max(lectureNumber, lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture " + lastLecture;
    }

    @Override
    public String toString() {
        return "%s: %s %d %s [%d]".formatted(course.courseCode(),
                getLastActivityMonth(), getLastActivityYear(), engagementType,
                getMonthsSinceActive());
    }
}
