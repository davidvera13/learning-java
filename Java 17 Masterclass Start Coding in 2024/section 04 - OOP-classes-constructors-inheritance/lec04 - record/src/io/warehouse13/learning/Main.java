package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        RecordStudent recordStudent = new
                RecordStudent("1", "John", "01/01/2001", "Learning Java");
        // no getter, use fieldname, no setter, immutable
        System.out.println(recordStudent.name());
        System.out.println(recordStudent.dateOfBirth());
        System.out.println("******************");


        for (int i = 1; i <= 5; i++) {
            RecordStudent s = new RecordStudent("S92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05/11/1985",
                    "Java Masterclass");
            System.out.println(s);
        }
    }
}

