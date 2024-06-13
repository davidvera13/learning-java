package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		String header = """
				Student Id, Country code, enrolled year, Gender, \
				Experienced, course code, engagement month, engagement year, \
				engagement type""";

		Course javaCourse = new Course(
				"JMC",
				"Java Master Class");
		Course pythonCourse = new Course(
				"PYC",
				"Python Master Class");

		List<Student> students = Stream.generate(() ->
				Student.getRandomStudent(javaCourse, pythonCourse))
				.limit(25)
				.toList();

		// writing to a console ...
		System.out.println(header);
		students.forEach(student -> student.getEngagementRecords()
				.forEach(System.out::println));


		Path path;

		// writing to a file: we have just the 2 last lines ...
		path= Path.of("students1.csv");
		try {
			Files.writeString(path, header);
			for(Student student: students)
				Files.write(path, student.getEngagementRecords());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// we add StandardOpenOption param
		path= Path.of("students2.csv");
		try {
			Files.writeString(path, header);
			for(Student student: students)
				Files.write(path, student.getEngagementRecords(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// write using iterable
		path= Path.of("students3.csv");
		try {
			List<String> data = new ArrayList<>();
			data.add(header);
			for (Student student: students)
				data.addAll(student.getEngagementRecords());

			Files.write(path, data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// using buffer writer
		// note file is writting at once... we should flush the buffer
		path= Path.of("students4.csv");
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(header);
			int count = 0;
			for (Student student: students) {
				writer.newLine();
				for (var record : student.getEngagementRecords()) {
					writer.write(record);
					count++;
					if(count %5 == 0) {
						Thread.sleep(2000);
						System.out.print(".");
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}

		path= Path.of("students4b.csv");
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(header);
			int count = 0;
			for (Student student: students) {
				writer.newLine();
				for (var record : student.getEngagementRecords()) {
					writer.write(record);
					count++;
					if(count %5 == 0) {
						Thread.sleep(2000);
						System.out.print(".");
					}
					if(count %10 == 0)
						writer.flush();
				}
			}
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}


		// using FileWriter
		//path= Path.of("students5.csv");
		try(FileWriter writer = new FileWriter("students5.csv")) {
			writer.write(header);
			//writer.write(System.lineSeparator());
			for (Student student: students) {
				//writer.newLine();
				writer.write(System.lineSeparator());
				for (var record : student.getEngagementRecords()) {
					writer.write(record);
					//writer.write(System.lineSeparator());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try(PrintWriter writer = new PrintWriter("students6.csv")) {
			//writer.write(header);
			writer.println(header);
			for (Student student: students) {
				//writer.newLine();
				for (var record : student.getEngagementRecords()) {
					writer.println(record);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// formatting with printWritter
		try(PrintWriter writer = new PrintWriter("students7.csv")) {
			writer.println(header);
			for (Student student: students) {
				for (var record : student.getEngagementRecords()) {
					String[] recordData = record.split(",");
					writer.printf("%-12d%-5s%2d%4d%3d%-1s".formatted(
							student.getStudentId(),  					// Student Id
							student.getCountry(),  						// Country Code
							student.getEnrollmentYear(),			  	// Enrolled Year
							student.getEnrollmentMonth(),  				// Enrolled Month
							student.getEnrollmentAge(),  				// Age
							student.getGender()));  					// Gender
					writer.printf("%-1s",
							(student.hasExperience() ? 'Y' : 'N'));		// Experienced?
					writer.format("%-3s%10.2f%-10s%-4s%-30s",
							recordData[7],  							// Course Code
							student.getPercentComplete(recordData[7]),  // percentage xomplete
							recordData[8],  							// Engagement Month
							recordData[9],  							// Engagement Year
							recordData[10]); 							// Engagement Type
					writer.println();

				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}



}

