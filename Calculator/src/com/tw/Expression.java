package com.tw;

import java.util.*;

//Represents an arithmetic expression
class Expression {

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSED_PARENTHESES = ')';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char PRODUCT = '*';
    private static final char DIVISION = '/';
    private static final int INITIAL_INDEX = 0;
    private static final int OFFSET = 1;

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

    List<Operator> operatorList() {
        List<Operator> operatorsList = new ArrayList<>();
        for (Character character : representation.toCharArray()) {
            if (operatorSet.contains(character)) {
                operatorsList.add(new Operator(character));
            }
        }
        return operatorsList;
    }

    private int numberAfterAddingGivenDigitToPreviousNumber(int previousNumber, Character digit) {
        int power = 10;
        int powerTimesOfNumber = previousNumber * power;
        int valueOfDigit = Integer.parseInt(digit.toString());
        return powerTimesOfNumber + valueOfDigit;
    }

    String leftSubExpressionRepresentationUntilInnerMostOpenParentheses() {
        return this.representation.substring(INITIAL_INDEX, innerMostOpenParenthesesIndex());
    }

    String rightSubExpressionRepresentationFromInnerRightParentheses() {
        return this.representation.substring(innerMostClosedParenthesesIndex() + OFFSET);
    }

    String innerMostSubExpressionRepresentation() {
        return this.representation.substring(innerMostOpenParenthesesIndex() + OFFSET,
                innerMostClosedParenthesesIndex());
    }

    private int innerMostOpenParenthesesIndex() {
        int index = INITIAL_INDEX;
        int innerMostParenthesesIndex = INITIAL_INDEX;
        while (index < this.representation.length()) {
            if (this.representation.charAt(index) == OPEN_PARENTHESIS) {
                innerMostParenthesesIndex = index;
            }
            index += OFFSET;
        }
        return innerMostParenthesesIndex;
    }

    private int innerMostClosedParenthesesIndex() {
        int index = INITIAL_INDEX;
        while (index < this.representation.length()) {
            if (this.representation.charAt(index) == CLOSED_PARENTHESES) {
                return index;
            }
            index += OFFSET;
        }
        return INITIAL_INDEX;
    }

}
