package io.warehouse13.learning.ex40CarPolymorphism;

public class Main {
    public static class Renault extends Car {

        public Renault(int cylinders, String name) {
            super(cylinders, name);
        }

        public String startEngine() {
            // return " Holden -> startEngine()";
            return getClass().getSimpleName() + " -> startEngine()";
        }

        public String accelerate() {
            // return "Holden -> accelerate()";
            return getClass().getSimpleName() + " -> accelerate()";
        }

        public String brake() {
            // return "Holden -> brake()";
            return getClass().getSimpleName() + " -> brake()";
        }
    }

    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Car mitsubishi = new Mitsubishi(8, "Outlander 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(16, "Mustang");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(8, "Outlander 4WD");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());

        // inline class
        Car jaguar = new Car(12, "XJR") {
            @Override
            public String startEngine() {
                return "Jaguar -> startEngine()";
            }

            @Override
            public String accelerate() {
                return "Jaguar -> accelerate()";
            }

            @Override
            public String brake() {
                return "Jaguar -> brake()";
            }
        };
        System.out.println(jaguar.startEngine());
        System.out.println(jaguar.accelerate());
        System.out.println(jaguar.brake());

        Renault renault = new Renault(6, "R12");
        System.out.println(renault.startEngine());
        System.out.println(renault.accelerate());
        System.out.println(renault.brake());

        Peugeot peugeot = new Peugeot(6, "306");
        System.out.println(peugeot.startEngine());
        System.out.println(peugeot.accelerate());
        System.out.println(peugeot.brake());

    }
}

class Peugeot extends Car {

    public Peugeot(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}