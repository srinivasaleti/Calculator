package com.tw;

//Represents entry point for application
public class CalculatorApp {

    public static void main(String[] args) {
        Expression expression = new Expression("2-4/2*3+5");
        Calculator calculator = new Calculator(new BinaryOperationFactory());

        System.out.println(calculator.evaluate(expression));
    }

}
