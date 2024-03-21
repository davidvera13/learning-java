package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Purchase;
import io.warehouse13.learning.domain.Student;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();
    public static void main(String[] args) {
        // creating course
        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course pmc = new Course("pmc101", "Python Master Class", "Python");
        Course amc = new Course("amc101", "Angular Master Class", "Angular");
        Course jsmc = new Course("jsmc101", "JavaScript Master Class", "JavaScript");


        addPurchase("John Steed", jmc, 120.99);
        addPurchase("John Steed", pmc, 90.99);
        addPurchase("John Steed", amc, 98.99);
        addPurchase("John Steed", jsmc, 98.99);

        addPurchase("Emma Peel", jmc, 11.87);

        addPurchase("Cathy Gale", jmc, 18.99);
        addPurchase("Cathy Gale", pmc, 19.99);
        addPurchase("Cathy Gale", jsmc, 25.99);

        addPurchase("Tara King", amc, 98.99);
        addPurchase("Tara King", jsmc, 98.99);

        addPurchase("Purdey", amc, 98.75);

        addPurchase("Mother", pmc, 119.25);
        addPurchase("Rhonda", pmc, 119.25);

        addPurchase("Georgie Price-Jones", jmc, 11.99);
        addPurchase("Lady Diana Forbes-Blakeney", pmc, 19.99);

        // print purchases
        purchases.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println("***************************");
        students.forEach((key, value) -> System.out.println(key + " : " + value));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
        for(Purchase purchase: purchases.values()) {
            datedPurchases.compute(
                    purchase.purchaseDate(),
                    (pDate, pList) -> {
                        List<Purchase> list = (pList == null) ? new ArrayList<>() : pList;
                        list.add(purchase);
                        return list;
                    });
        }
        System.out.println("***************************");
        datedPurchases.forEach((key, value) -> System.out.println(key + " : " + value));


        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);

        Map<LocalDate, List<Purchase>> week1purchases = datedPurchases.headMap(week1);
        Map<LocalDate, List<Purchase>> week2purchases = datedPurchases.tailMap(week1);
        System.out.println("***************************");
        System.out.println("Week 1");
        week1purchases.forEach((key, value) -> System.out.println("key: " + key + " \t\tValue: " + value));
        System.out.println("***************************");
        System.out.println("Week 2");
        week2purchases.forEach((key, value) -> System.out.println("key: " + key + " \t\tValue: " + value));

        // using display stats
        System.out.println("***************************");
        System.out.println("displayStats");
        displayStats(1, week1purchases);
        displayStats(2, week2purchases);

        System.out.println("***************************");
        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();
        // display in reverse order
        while (previousEntry != null) {
            List<Purchase> lastDaysData = previousEntry.getValue();
            System.out.println(lastDate + " \t\tPurchases: " + lastDaysData.size());
            LocalDate previousDate = datedPurchases.lowerKey(lastDate);
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = previousDate;
        }

        System.out.println("***************************");
        // same result as previously
        var reversed = datedPurchases.descendingMap();
        LocalDate firstDate = reversed.firstKey();
        //var nextEntry = reversed.firstEntry();
        var nextEntry = reversed.pollFirstEntry();
        while (nextEntry != null) {
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " \t\tPurchases: " +  lastDaysData.size());
            LocalDate nextDate = reversed.higherKey(firstDate);
            //nextEntry = reversed.higherEntry(firstDate);
            nextEntry = reversed.pollFirstEntry();
            firstDate = nextDate;
        }
        System.out.println("***************************");
        System.out.println("after poll ... navigablemap is empty");
        datedPurchases.forEach((key, value) -> System.out.println(key + " : " + value));

    }

    private static void addPurchase(String name, Course course, double price) {
        Student existingStudent = students.get(name);
        if(existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        //int day = purchases.size() + 1;
        int day = new Random().nextInt(1, 15);
        String key = course.courseId() + "-" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(),price, year, day);
        purchases.put(key, purchase);
    }

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData) {
        System.out.println("***************************");
        // sorted
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        periodData.forEach((key, value) -> {
            System.out.println("key: " + key + " \t\tValue: " + value);
            for(Purchase p: value)
                //weeklyCounts.merge(p.courseId(), 1, (prev, current) -> prev + current);
                weeklyCounts.merge(p.courseId(), 1, Integer::sum);
        });
        System.out.printf("Week %d purchases = %s%n", period, weeklyCounts);

    }
}
