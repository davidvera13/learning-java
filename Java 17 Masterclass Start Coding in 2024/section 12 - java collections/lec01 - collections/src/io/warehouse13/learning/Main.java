package io.warehouse13.learning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        Collection<String> list = new HashSet<>();
        String[] names = { "Anna", "Bob", "Charles", "David", "edwin"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(List.of("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is is the list ? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is is the list ? " + list.contains("Gary"));

        // collection doesn't have sort method
        //list.sort();

    }
}
