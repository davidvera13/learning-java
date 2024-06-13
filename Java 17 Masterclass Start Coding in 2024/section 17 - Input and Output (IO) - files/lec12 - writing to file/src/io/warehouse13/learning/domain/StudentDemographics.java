package io.warehouse13.learning.domain;

public record StudentDemographics(
        String countryCode,
        int enrolledMonth,
        int enrolledYear,
        int ageAtEnrollment,
        String gender,
        boolean previousProgrammingExperience ) {

    @Override
    public String toString() {
        return "%s,%d,%d,%d,%s,%b".formatted(
                countryCode,
                enrolledMonth,
                enrolledYear,
                ageAtEnrollment,
                gender,
                previousProgrammingExperience);
    }
}
