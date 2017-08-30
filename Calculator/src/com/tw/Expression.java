package com.tw;

import java.util.*;

//Represents an arithmetic expression
class Expression {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char PRODUCT = '*';
    private static final char DIVISION = '/';

    private final String representation;
    private final Set<Character> operatorSet;

    Expression(String representation) {
        this.representation = representation;
        this.operatorSet = new HashSet<>(Arrays.asList(PLUS, MINUS, PRODUCT, DIVISION));
    }

    List<Operand> operandList() {
        List<Operand> operandsList = new ArrayList<>();
        int number = 0;
        for (Character character : representation.toCharArray()) {
            if (this.operatorSet.contains(character)) {
                operandsList.add(new Operand(number));
                number = 0;
            } else {
                number = numberAfterAddingGivenDigitToPreviousNumber(number, character);
            }
        }
        operandsList.add(new Operand(number));
        return operandsList;
    }

    private int numberAfterAddingGivenDigitToPreviousNumber(int previousNumber, Character digit) {
        int power = 10;
        int powerTimesOfNumber = previousNumber * power;
        int valueOfDigit = Integer.parseInt(digit.toString());
        return powerTimesOfNumber + valueOfDigit;
    }

    List<Operator> operatorList() {
        return null;
    }

}
