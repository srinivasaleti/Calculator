package com.tw;

//Represents entry point for application
public class CalculatorApp {

    public static void main(String[] args) {
        BinaryOperationFactory binaryOperationFactory = new BinaryOperationFactory();
        OperatorPrecedenceFactory operatorPrecedenceFactory = new OperatorPrecedenceFactory();
        Calculator calculator = new Calculator(binaryOperationFactory, operatorPrecedenceFactory);
        Expression anotherExpression = new Expression("(1-(3*(2/2))+5+1)");
        calculator.evaluate(anotherExpression);
        System.out.println(calculator.evaluate(anotherExpression));
    }
}
