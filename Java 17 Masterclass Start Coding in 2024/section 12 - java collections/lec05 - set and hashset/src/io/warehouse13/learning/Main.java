package io.warehouse13.learning;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails =  ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);
        System.out.println("************************");
        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone contacts", phoneContacts);
        printData("Email contacts", emailContacts);

        System.out.println("************************");
        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        robinHood.addEmail("Sherwood Forest");
        System.out.println(robinHood);

        // Set Operations, Symmetric and Asymmetric results
        // union
        Set<Contact> unionEmailsAndPhones = new HashSet<>();
        unionEmailsAndPhones.addAll(emailContacts);
        unionEmailsAndPhones.addAll(phoneContacts);
        // we've lost elements during the union...
        printData("A ∪ B Union of emails and Phones", unionEmailsAndPhones);

        // intersect
        // we have same names, but keep emails or phones: symmetric set operation
        Set<Contact> intersectEmailsAndPhones = new HashSet<>(emailContacts);
        intersectEmailsAndPhones.retainAll(phoneContacts);
        printData("A ∩ Intersect of emails and phones", intersectEmailsAndPhones);

        Set<Contact> intersectPhonesAndEmails = new HashSet<>(phoneContacts);
        intersectPhonesAndEmails.retainAll(emailContacts);
        printData("A ∩ Intersect of phones and emails", intersectPhonesAndEmails);

        // Asymmetric differences (subtract deux sets): results won't have the same names
        Set<Contact> emailsMinusPhones = new HashSet<>(emailContacts);
        emailsMinusPhones.removeAll(phoneContacts);
        printData("emails - phones", emailsMinusPhones);

        Set<Contact> phonesMinusEmails = new HashSet<>(phoneContacts);
        phonesMinusEmails.removeAll(emailContacts);
        printData("phones - emails", phonesMinusEmails);

        // Symmetric differences
        Set<Contact> symmetricDiff1 = new HashSet<>(emailsMinusPhones);
        symmetricDiff1.addAll(phonesMinusEmails);
        printData("Symmetric difference", symmetricDiff1);


        Set<Contact> symmetricDiff2 = new HashSet<>(unionEmailsAndPhones);
        symmetricDiff2.removeAll(intersectEmailsAndPhones);
        printData("Symmetric difference", symmetricDiff2);
    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("----------------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------------");
        contacts.forEach(System.out::println);
    }
}
