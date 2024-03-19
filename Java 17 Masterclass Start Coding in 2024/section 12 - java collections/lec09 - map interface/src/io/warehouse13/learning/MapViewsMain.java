package io.warehouse13.learning;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone")
                .forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email")
                .forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        System.out.println("****************");
        Set<String> copyOfKey = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKey);

        if(contacts.containsKey("Linus Van Pelt"))
            System.out.println("Linus and I go way back ... So, of course I have info");

        System.out.println("****************");
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("****************");
        // remove from copy won't remove from original
        copyOfKey.remove("Linus Van Pelt");
        System.out.println(copyOfKey);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("****************");
        keysView.retainAll(List.of(
                "Linus Van Pelt",
                "Charlie Brown",
                "Robin Hood",
                "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("****************");
        keysView.clear();
        System.out.println("After clearing ");
        System.out.println(contacts);
        //System.out.println("After adding a key: Exception in thread main java.lang.UnsupportedOperationException");
        //keysView.add("Daffy Duck");
        //System.out.println(contacts);

        // repopulate
        System.out.println("****************");

        ContactData.getData("phone")
                .forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email")
                .forEach(c -> contacts.put(c.getName(), c));
        // the set is automatically repopulated
        System.out.println(keysView);
        System.out.println("****************");
        var values = contacts.values();
        values.forEach(System.out::println);


        System.out.println("****************");
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("***************");
        // alphabetical by last name list returned
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() +  ": " + c));

        System.out.println("***************");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("***************");
        HashSet<Contact> hashSet = new HashSet<>(values);
        hashSet.forEach(System.out::println);
        if(hashSet.size() < contacts.keySet().size())
            System.out.println("Duplicate values are in the Map");

        var nodeSet = contacts.entrySet();
        for(var node: nodeSet) {
            System.out.println(nodeSet.getClass().getName());
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " + node.getKey() + ": " + node.getValue());
            }
        }
    }
}
