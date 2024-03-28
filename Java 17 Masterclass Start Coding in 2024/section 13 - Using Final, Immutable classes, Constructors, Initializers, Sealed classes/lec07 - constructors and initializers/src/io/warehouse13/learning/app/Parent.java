package io.warehouse13.learning.app;

public class Parent {
    // if we make properties final, we have compiler errors :
    // for properties: Variable 'name' might not have been initialized
    // for setters: Cannot assign a value to final variable 'name'
    private final String name;
    private final String dateOfBirth;

    protected final int siblings;

    // we can use instance initializer block
    // static initializer is called just once when class is referenced or instantiated
    // we can have more than one static blockn
    // they're called in order of declaration
    static {
        //name = "John Doe";
        //dateOfBirth = "01/02/03";
        System.out.println("In Parent static initializer: Object being constructed");
    }

    public Parent() {
        this.name = "John Doe";
        this.dateOfBirth = "01/02/03";
        this.siblings = 2;
        System.out.println("In Parent's NoArgs Constructor");
    }

    public Parent(String name, String dateOfBirth, int siblings) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //    this.name = name;
    //}

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    //public void setDateOfBirth(String dateOfBirth) {
    //    this.dateOfBirth = dateOfBirth;
    //}

    @Override
    public String toString() {
        return "name='" + name + '\'' +", dateOfBirth='" + dateOfBirth+ '\'';
    }
}
