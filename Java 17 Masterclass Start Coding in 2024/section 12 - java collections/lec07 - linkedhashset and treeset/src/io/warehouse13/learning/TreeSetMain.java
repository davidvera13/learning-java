package io.warehouse13.learning;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {

        List<Contact> emails =  ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        // Exception in thread "main" java.lang.ClassCastException:
        // class io.warehouse13.learning.Contact cannot be cast to class java.lang.Comparable
        // (io.warehouse13.learning.Contact is in unnamed module of loader 'app';
        // java.lang.Comparable is in module java.base of loader 'bootstrap')
        // NavigableSet<Contact> sorted = new TreeSet<>(phones);
        // sorted.forEach(System.out::println);

        // To avoid this error, we need a comparator: comparing by name
        Comparator<Contact> sort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(sort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);
        System.out.println("********************");

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(contact -> justNames.add(contact.getName()));
        System.out.println(justNames);
        System.out.println("********************");

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);
        System.out.println("********************");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        // contains duplicates but it is sorted
        fullList.forEach(System.out::println);
        System.out.println("********************");

        //Contact min = Collections.min(fullSet);
        //Contact max = Collections.max(fullSet);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());
        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.printf("min = %s first = %s %n", min.getName(), first.getName());
        System.out.printf("max = %s last = %s %n", max.getName(), last.getName());
        System.out.println("********************");

        NavigableSet<Contact> copy = new TreeSet<>(fullSet);
        // same result as with min and max but we remove value from the set
        System.out.println("first element using poll" + copy.pollFirst());
        System.out.println("last element using poll" + copy.pollLast());
        copy.forEach(System.out::println);
        System.out.println("********************");
        // closest match
        Contact daffy = new Contact("Daffy duck");
        Contact daisy = new Contact("Daisy duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            // results:
            // 1. daffy is in the tree set, so ceiling is returning the element
            // 2. daffy higher element is next element froom the navigable set
            // 3. daisy is not in the set, so it returns Linus from the set
            // 4. as Robin Hood is the last element, ceiling is equal to itself but won't have higher
            // 5. Snoopy is not in the liste (returns null)
            System.out.printf("Ceiling (%s): %s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("Higher (%s): %s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("********************");

        for (Contact c : List.of(daffy, daisy, last, archie)) {
            // results:
            // 1. if element is in the set, it returns the value of the set as floor
            // 2. If element is in the set, it returns the theoretical value that could be floor and lower
            // 2. if element is not in the set (daisy):
            System.out.printf("floor (%s): %s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower (%s): %s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println("********************");

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("********************");

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Remove element: " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("********************");
        fullSet.forEach(System.out::println);

        System.out.println("********************");
        Contact marian = new Contact("Maid Marian");
        var headSet = fullSet.headSet(marian);
        headSet.forEach(System.out::println);

        System.out.println("********************");
        headSet = fullSet.headSet(marian, true);
        headSet.forEach(System.out::println);

        System.out.println("********************");
        var tailset = fullSet.tailSet(marian);
        tailset.forEach(System.out::println);

        System.out.println("********************");
        Contact linus = new Contact("Linus Van Pelt");
        // var subset = fullSet.subSet(linus, marian);
        var subset = fullSet.subSet(linus, false, marian, true);
        subset.forEach(System.out::println);


    }
}
