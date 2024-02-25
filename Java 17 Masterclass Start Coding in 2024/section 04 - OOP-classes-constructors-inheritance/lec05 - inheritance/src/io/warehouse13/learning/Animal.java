package io.warehouse13.learning;

public class Animal {
    protected String type = "animal";
    private String size;
    private double weight;

    public Animal() {
    }

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    // behavior
    public void move(String speed) {
        System.out.println("Animal.move() called: " +  type + "  is moving " + speed);
    }

    public void makeNoise() {
        System.out.println("Animal.move() called: " +  type + " makes some kind of noise");
    }


    public void eat() {
        System.out.println("Animal.eat() called: " + type +   " is eating");
    }

}
