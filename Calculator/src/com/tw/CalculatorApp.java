package com.tw;

//Represents entry point for application
public class CalculatorApp {

    public static void main(String[] args) {
        Expression expression = new Expression("1+2-3+10");
        Calculator calculator = new Calculator(expression);

        System.out.println(calculator.evaluate());
    }

}
