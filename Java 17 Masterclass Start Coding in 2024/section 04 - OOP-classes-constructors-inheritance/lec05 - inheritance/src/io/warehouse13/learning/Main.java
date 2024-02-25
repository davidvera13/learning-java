package io.warehouse13.learning;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal();
        doAnimalStuff(animal, "fast");
        System.out.println("********************");

        Animal generic = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(generic, "slow");
        System.out.println("********************");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");
        System.out.println("********************");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        System.out.println("********************");

        Dog retriever = new Dog("Labrador Retriever", 65,
                "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");
        System.out.println("********************");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");
        System.out.println("********************");

        Fish goldie = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");
        System.out.println("********************");
    }

    public static void doAnimalStuff(Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
    }

}
