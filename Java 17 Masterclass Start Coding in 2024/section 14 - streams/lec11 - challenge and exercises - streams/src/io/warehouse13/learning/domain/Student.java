package io.warehouse13.learning.domain;

import java.time.LocalDate;
import java.util.*;

public class Student {
    private static long lastStudentId = 1;
    private final static Random random = new Random();

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;

    private final Map<String, CourseEngagement> engagements = new HashMap<>();

    public Student(
            String countryCode,
            int yearEnrolled,
            int ageEnrolled,
            String gender,
            boolean programmingExperience,
            Course... courses) { // allow to add one or more courses ...
        this.studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for (Course course: courses) {
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }

    public void addCourse(Course course) {
        addCourse(course, LocalDate.now());
    }
    public void addCourse(Course course, LocalDate enrollDate) {
        engagements.put(
                course.courseCode(),
                new CourseEngagement(course, enrollDate, "Enrollment"));
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagements() {
        return Map.copyOf(engagements);
    }

    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge() {
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode) {
        CourseEngagement engagement = engagements.get(courseCode);
        return  engagement == null ? 0 : engagement.getMonthsSinceActive();
    }

    public int getMonthsSinceActive() {
        int inactiveMonths =  (LocalDate.now().getYear() - 2014) * 12; // 2014 is min year
        for (String key : engagements.keySet()) {
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }
        return inactiveMonths;

    }

    public  double getPercentComplete (String courseCode) {
        var info = engagements.get(courseCode);
        return info == null ? 0 : info.getPercentComplete();
    }

    public void watchLecture(
            String courseCode,
            int lectureNumber,
            int month,
            int year
    ) {
        var activity = engagements.get(courseCode);
        if(activity != null)
            activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
    }


    private static String getRandomValue(String... data) {
        return data[random.nextInt(data.length)];
    }
    private static Course[] getRandomCourses(Course... courses) {
        int coursesCount = random.nextInt(1, courses.length);
        List<Course> courseList = new ArrayList<>(Arrays.asList(courses));
        Collections.shuffle(courseList);
        List<Course> selection = courseList.subList(0, coursesCount);
        return selection.toArray(new Course[0]);

    }

    public static Student getRandomStudent(Course... courses) {
        int maxYear  = LocalDate.now().getYear() + 1;
        Course[] randomCourses = getRandomCourses(courses);

        Student student = new Student(
                getRandomValue("AU", "CA", "CN", "GB", "IN", "UA", "US"),
                random.nextInt(2015, maxYear),
                random.nextInt(18, 90),
                getRandomValue("M", "F", "U"),
                random.nextBoolean(),
                randomCourses);



        for(Course course: randomCourses) {
            int currentLecture = random.nextInt(30, course.lectureCount());
            int year = random.nextInt(student.getYearEnrolled(), maxYear);
            int month = random.nextInt(1, 13);
            if(year == (maxYear - 1)) {
                if (month > LocalDate.now().getMonthValue())
                    month = LocalDate.now().getMonthValue();
            }
            student.watchLecture(course.courseCode(), currentLecture, month, year);
        }

        return student;

    }
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", countryCode='" + countryCode + '\'' +
                ", yearEnrolled=" + yearEnrolled +
                ", ageEnrolled=" + ageEnrolled +
                ", gender='" + gender + '\'' +
                ", programmingExperience=" + programmingExperience +
                ", engagements=" + engagements +
                '}';
    }
}
