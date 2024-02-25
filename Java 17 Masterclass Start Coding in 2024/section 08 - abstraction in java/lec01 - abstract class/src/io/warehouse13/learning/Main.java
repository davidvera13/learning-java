package io.warehouse13.learning;

import io.warehouse13.learning.abstractions.Animal;
import io.warehouse13.learning.abstractions.Mammal;
import io.warehouse13.learning.abstractions.impl.Dog;
import io.warehouse13.learning.abstractions.impl.Fish;
import io.warehouse13.learning.abstractions.impl.Horse;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Wolf", "big", 10);
        dog.makeNoise();
        System.out.println("**************");
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Sheppard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 85));
        animals.add(new Dog("Pug", "small", 20));
        animals.add(new Horse("Clydesdale", "big", 450));
        System.out.println("**************");
        for (Animal animal: animals) {
            doAnimalStuff(animal);
            if(animal instanceof Mammal currentMammal)
                currentMammal.shedHair();
        }
    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slowly");
    }
}
