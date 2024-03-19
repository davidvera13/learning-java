package io.warehouse13.learning;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("***************");
        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact:  fullList)
            // put replace existing value ...
            contacts.put(contact.getName(), contact);

        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));
        System.out.println("***************");
        // get map element by key
        System.out.println(contacts.get("Charlie Brown"));

        Contact defaultContact = new Contact("Chuck Norris");
        System.out.println(contacts.get("Chucky"));
        System.out.println(contacts.getOrDefault("Chucky", defaultContact));
        System.out.println("***************");
        contacts.clear();

        for (Contact contact: fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if(duplicate != null) {
                //System.out.println("Duplicate : " + duplicate);
                //System.out.println("Current   : " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));

        System.out.println("***************");
        contacts.clear();

        for (Contact contact:  fullList)
            // putIfAbsent don't replace existing value ...
            contacts.putIfAbsent(contact.getName(), contact);

        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));

        System.out.println("***************");
        contacts.clear();

        for (Contact contact:  fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if(duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }

        }
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));


        System.out.println("***************");
        contacts.clear();
        // this for each can be enhanced (see below)
        fullList.forEach(contact -> contacts.merge(
                contact.getName(),
                contact,
                (prev, curr) -> {
                    System.out.println("previous : " + prev);
                    System.out.println("current  : " + curr);
                    Contact merged = prev.mergeContactData(curr);
                    System.out.println("merged   : " + merged);
                    return merged;
                }));
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));

        System.out.println("***************");
        contacts.clear();
        // same code as below
        fullList.forEach(contact -> contacts.merge(
                contact.getName(),
                contact,
                Contact::mergeContactData));
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));

        // compute methods
        System.out.println("***************");
        String[] contactNames =  new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"};
        for (String contactName: contactNames) {
            contacts.compute(contactName, (k,v) -> new Contact(k));
        }
        // Daffy Duck was present, we overwrite the previous value...
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));


        // computeIfAbsent
        System.out.println("***************");
        contacts.clear();
        for (Contact contact:  fullList)
            // putIfAbsent don't replace existing value ...
            contacts.putIfAbsent(contact.getName(), contact);

        for (String contactName: contactNames) {
            contacts.computeIfAbsent(contactName, Contact::new);
        }
        // Dasisy and Scrooge were added... Daffy duck has not been touched
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));


        // computeIfpresent
        System.out.println("***************");

        for (String contactName: contactNames) {
            contacts.computeIfPresent(contactName, (k,v) -> {
                v.addEmail("Fun place");
                return v;
            });
        }
        contacts.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v ));

        // replaceAll: this example is not really efficient as we check on each entry of the map
        System.out.println("***************");
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });

        // replaceAll: this example is not really efficient as we check on each entry of the map
        System.out.println("***************");
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replaced = contacts.replace("Daisy Duck", daisy);
        System.out.println("Daisy J. Duck    : " + daisy);
        System.out.println("Replaced contact : " + replaced);
        contacts.forEach((k,v) -> System.out.println("key = " + k + "\tValue = " + v));

        System.out.println("***************");
        // Didn't match on both key Daisy Duck and value Daisy Duck: [DaisyDuck@funplace.com] []
        Contact updatedDaisy = replaced.mergeContactData(daisy);
        System.out.println("updated Daisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", replaced, updatedDaisy);
        if(success)
            System.out.println("Successfully replaced element");
        else
            System.out.printf("Didn't match on both key %s and value %s %n".formatted("Daisy Duck", replaced));

        contacts.forEach((k,v) -> System.out.println("key = " + k + " \tValue =" + v));

        System.out.println("***************");
        // Successfully replaced element
        success = contacts.replace("Daisy Duck", daisy, updatedDaisy);
        if(success)
            System.out.println("Successfully replaced element");
        else
            System.out.printf("Didn't match on both key %s and value %s %n".formatted("Daisy Duck", replaced));

        contacts.forEach((k,v) -> System.out.println("key = " + k + " \tValue =" + v));

        // remove ...
        System.out.println("***************");
        success = contacts.remove("Daisy Duck", daisy);
        if(success)
            System.out.println("Successfully removed element");
        else
            System.out.printf("Didn't match on both key %s and value %s %n"
                    .formatted("Daisy Duck", daisy));
        contacts.forEach((k,v) -> System.out.println("key = " + k + " \tValue =" + v));
    }
}
