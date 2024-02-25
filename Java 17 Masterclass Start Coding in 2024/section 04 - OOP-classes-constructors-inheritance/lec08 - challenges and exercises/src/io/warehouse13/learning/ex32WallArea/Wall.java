package io.warehouse13.learning.ex32WallArea;

public class Wall {
    private double width;
    private double height;
    public Wall() {
        System.out.println("no-arg constructor");
    }

    public Wall(double width, double height) {
        this.width = width;
        this.height = height;
        if (this.width<0) {
            this.width=0;
        }
        if (this.height<0) {
            this.height=0;
        }
    }

    public void setWidth(double width) {
        if (width<0) {
            this.width=0;
        }
        else {
            this.width = width;
        }
    }
    public double getWidth() {
        return this.width;
    }
    public void setHeight(double height) {
        if (height<0) {
            this.height=0;
        } else {
            this.height = height;
        }
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.width*this.height;
    }
}