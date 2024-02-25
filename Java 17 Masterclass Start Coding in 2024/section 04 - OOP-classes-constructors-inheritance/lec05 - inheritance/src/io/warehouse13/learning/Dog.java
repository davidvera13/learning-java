package io.warehouse13.learning;

public class Dog extends Animal {
    private String earShape;
    private String tailShape;

    public Dog() {
        super("Mutt", "Big", 50);
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type,
                weight <  15 ? "small" : (weight < 35 ? "medium" : "large"),
                weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise() {
        if (type.equals("Wolf")) {
            System.out.print("Dog.makeNoise() called - Ow Wooooo! ");
        }
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        System.out.println("Dog.move() called");
        super.move(speed);
        // System.out.println("Dogs walk, run and wag their tail");
        if (speed == "slow") {
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
        System.out.println();
    }

    private void bark() {
        System.out.println("Dog.bark() called - Woof! ");
    }

    private void run() {
        System.out.println("Dog.run() called - Dog Running ");
    }

    private void walk() {
        System.out.println("Dog.walk() called - Dog Walking ");
    }

    private void wagTail() {
        System.out.println("Dog.wagTail() called - Tail Wagging ");
    }
}
