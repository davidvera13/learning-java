package io.warehouse13.learning.ex30SimpleCalculator;

public class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber (){
        return this.firstNumber;
    }

    public double getSecondNumber (){
        return this.secondNumber;
    }

    public void setFirstNumber (double firstNumber){
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber (double secondNumber){
        this.secondNumber = secondNumber;
    }
    public double getAdditionResult (){
        double addition = firstNumber + secondNumber;
        return addition;
    }
    public double getSubtractionResult (){
        double subtraction = firstNumber - secondNumber;
        return subtraction;
    }
    public  double getMultiplicationResult (){
        double multiplication = firstNumber * secondNumber;
        return multiplication;
    }
    public  double getDivisionResult (){
        if (secondNumber == 0){
            return 0;} else {
            double division = firstNumber/secondNumber;
            return division;
        }
    }
}
