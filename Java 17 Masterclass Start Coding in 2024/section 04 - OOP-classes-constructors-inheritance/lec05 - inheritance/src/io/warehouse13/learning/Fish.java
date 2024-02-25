package io.warehouse13.learning;

public class Fish extends Animal{

    private int gills;
    private int fins;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "small", weight);
        this.gills = gills;
        this.fins = fins;
    }


    public int getGills() {
        return gills;
    }

    public void setGills(int gills) {
        this.gills = gills;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    //behaviour
    private void moveMuscles() {
        System.out.println("Fish.moveMuscles() called - muscles moving ");
    }
    private void moveBackFin() {
        System.out.println("Fish.moveBackFin() called - backfin moving ");
    }
    private void swim(String speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }


}
