package io.warehouse13.learning;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            emails.add(email);
        }
        if (phone > 0) {
            String p = String.valueOf(phone);
            p = "(%s) %s-%s".formatted(p.substring(0, 3), p.substring(3, 6),
                    p.substring(6));
            phones.add(p);
        }
    }

    public String getName() {
        return name;
    }

    public String getNameLastFirst() {
        return name.substring(name.indexOf(" ") + 1) + ", " +
                name.substring(0, name.indexOf(" "));
    }


    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContactData(Contact contact) {

        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
    //    Contact contact = (Contact) o;
    //    return Objects.equals(getName(), contact.getName()) &&
    //            Objects.equals(emails, contact.emails) &&
    //           Objects.equals(phones, contact.phones);
    //}

    //@Override
    //public int hashCode() {
    //    return Objects.hash(getName(), emails, phones);
    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
      Contact contact = (Contact) o;
      return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        // use a prime number as multiplier, we can use 33 (non prime)
        // Hash-based collections store elements in so-called buckets. A hash-based collection has a fixed number of
        // buckets. When you put an object in the hash-based collection, then it uses the hash code of the object to
        // determine in which bucket to put the object. In fact, I guess it uses the formula hashCode() % numberOfBuckets
        // to compute which bucket to put the object in. (% is the modulo-operator).
        // By making the hash code of objects a prime number (or a multiple of a prime number) the objects will be
        // distributed better over the buckets, because a prime number is not a multiple of the number of buckets (which
        // is a power of 2), so hashCode() % numberOfBuckets won't quickly cycle back to the same number (which means
        // the same bucket).
        return 31 * getName().hashCode();
    }

    public void addEmail(String companyName) {
        String[] names = name.split(" ");
        String email = "%c%s@%s.com"
                .formatted(
                        name.charAt(0),
                        names[names.length - 1],
                        companyName.replaceAll(" ", "").toLowerCase());
        if(!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email );
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {
        if(emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }
}
