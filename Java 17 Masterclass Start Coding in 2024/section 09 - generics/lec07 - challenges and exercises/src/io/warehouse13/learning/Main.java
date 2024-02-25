package io.warehouse13.learning;

import io.warehouse13.learning.model.Employee;
import io.warehouse13.learning.model.EngineeringStudent;
import io.warehouse13.learning.model.EngineeringStudentComparator;
import io.warehouse13.learning.model.Student;
import io.warehouse13.learning.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Main {
    // Change QueryList to extend ArrayList, removing the items field.
    // Add a student id field to the Student class, and Implement a way to compare Students,
    //    so that students are naturally ordered by a student id.
    // Implement at least one other mechanism for comparing Students by course or year, or for
    //    Engineering Students, by percent complete.
    //
    // Override the matchFieldValue method on the EngineeringStudent class, so that we return
    // students, not matched on percent complete equal to a value, but on percent less than
    // or equal to a submitted value.  Note: an Engineering Student should be searchable by the
    // same fields as Student as well.
    // Run  code for 25 random students, selecting students who are less than or equal to 50% done
    // their course, and print out the list, sorted in at least two ways, first by using List.sort
    // with the Comparator.naturalOrder() comparator, and then using your own Comparator, so first
    // by student id, as well as one of the other ways you selected.

    public static void main(String[] args) {
        QueryList<EngineeringStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new EngineeringStudent());
        }
        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        print(queryList);

        System.out.println();
        System.out.println("Matches");
        var matches = queryList
                .getMatches("percentComplete", "50")
                .getMatches("Course", "Python");

        matches.sort(new EngineeringStudentComparator());
        print(matches);
    }

    public static void print(List<?> students) {
        for(var student: students)
            System.out.println(student);
    }
}
