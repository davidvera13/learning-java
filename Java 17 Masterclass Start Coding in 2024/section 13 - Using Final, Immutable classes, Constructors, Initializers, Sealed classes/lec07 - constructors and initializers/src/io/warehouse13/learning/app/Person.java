package io.warehouse13.learning.app;


// javap : https://docs.oracle.com/en/java/javase/17/docs/specs/man/javap.html
//
// > javap -p '.\out\production\lec07 - constructors and initializers\io\warehouse13\learning\app\Parent.class'
// public class io.warehouse13.learning.app.Parent {
//  private final java.lang.String name;
//  private final java.lang.String dateOfBirth;
//  protected final int siblings;
//  public io.warehouse13.learning.app.Parent();
//  public io.warehouse13.learning.app.Parent(java.lang.String, java.lang.String, int);
//  public java.lang.String getName();
//  public java.lang.String getDateOfBirth();
//  public java.lang.String toString();
//  static {};
//}

public record Person(String name, String dateOfBirth) {
    // Instance initializer is not allowed in record

    // canonical constructor: implicitly generated constructor
    //public Person(String name, String dateOfBirth) {
    //    this.name = name;
    //    this.dateOfBirth = dateOfBirth.replace("-", "/");
    //    // we can't reassign: properties are final
    //    // this.dateOfBirth = this.dateOfBirth.trim();
    //}

    public Person(Person p) {
        // we must use the canonical constructor
        this(p.name, p.dateOfBirth);
    }

    // compact constructor: short way to declare a canonical constructor
    public Person {
        if(dateOfBirth == null)
            throw new IllegalArgumentException("Date of birth is required");

        dateOfBirth = dateOfBirth.replace("-", "/");
    }


}
