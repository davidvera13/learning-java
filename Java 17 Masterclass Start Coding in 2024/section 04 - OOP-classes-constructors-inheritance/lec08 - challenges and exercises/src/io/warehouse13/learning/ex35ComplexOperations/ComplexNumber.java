package io.warehouse13.learning.ex35ComplexOperations;

public class ComplexNumber {
    // Instance variables
    private double real;
    private double imaginary;

    // Constuctor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getter and Setter Methods
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Imaginary number math functions
    public void add(double real, double imaginary) {
        this.real = (this.real + real);
        this.imaginary = (this.imaginary + imaginary);
    }

    public void add(ComplexNumber complex) {
        this.real = (this.real + complex.real);
        this.imaginary = (this.imaginary + complex.imaginary);
    }

    public void subtract(double real, double imaginary) {
        this.real = (this.real - real);
        this.imaginary = (this.imaginary - imaginary);
    }

    public void subtract(ComplexNumber complex) {
        this.real = (this.real - complex.real);
        this.imaginary = (this.imaginary - complex.imaginary);
    }
}