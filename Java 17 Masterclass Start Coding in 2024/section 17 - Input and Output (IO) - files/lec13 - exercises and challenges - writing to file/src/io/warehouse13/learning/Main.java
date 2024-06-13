package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
	public static void main(String[] args) {
		String delimiter = "," + System.lineSeparator();

		Course javaCourse = new Course(
				"JMC",
				"Java Master Class");
		Course pythonCourse = new Course(
				"PYC",
				"Python Master Class");

		String students = Stream.generate(() ->
				Student.getRandomStudent(javaCourse, pythonCourse))
				.limit(1000)
				.map(Student::toJson)
				.collect(Collectors.joining(delimiter, "[", "]"));

		System.out.println(students);

		Path path= Path.of("students.json");
		try {
			Files.writeString(path, students);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

