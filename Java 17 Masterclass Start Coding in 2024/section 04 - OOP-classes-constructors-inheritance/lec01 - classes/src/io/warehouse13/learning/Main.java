package io.warehouse13.learning;

public class Main {

    public static void main(String[] args) {
        // build an object using no params contructor
        Car car = new Car();
        car.describeCar();
        System.out.println("**************");

        Car porsche = new Car();
        porsche.setMake("Porsche");
        porsche.setModel("Carrera");
        porsche.setDoors(2);
        porsche.setConvertible(true);
        porsche.setColor("black");
        System.out.println("make = " + car.getMake());
        System.out.println("model = " + car.getModel());
        porsche.describeCar();
        System.out.println("**************");

        Car targa = new Car();
        targa.setMake("Porsche");
        targa.setModel("Targa");
        targa.setDoors(2);
        targa.setConvertible(false);
        targa.setColor("red");
        targa.describeCar();
        System.out.println("**************");

    }
}