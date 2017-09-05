package com.tw;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//Represents a tool for mathematical calculations
class Calculator {

    private static final int DEFAULT_EXPRESSION_VALUE = 0;

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private final BinaryOperationFactory binaryOperationFactory;
    private final OperatorPrecedenceFactory operatorPrecedenceFactory;

    Calculator(BinaryOperationFactory binaryOperationFactory, OperatorPrecedenceFactory operatorPrecedenceFactory) {
        this.binaryOperationFactory = binaryOperationFactory;
        this.operatorPrecedenceFactory = operatorPrecedenceFactory;
        this.operandStack = new Stack<>();
        this.operatorStack = new Stack<>();
    }

    int evaluate(Expression expression) {
        if (!expression.hasParentheses()) {
            return evaluateGivenExpression(expression);
        }
        return evaluateParenthesizedExpression(expression);
    }

    private int evaluateParenthesizedExpression(Expression expression) {
        while (expression.hasParentheses()) {
            Expression newExpression = formNewExpression(expression);
            if (newExpression.hasParentheses()) {
                return evaluate(newExpression);
            }
            return evaluateGivenExpression(newExpression);
        }
        return DEFAULT_EXPRESSION_VALUE;
    }

    private int evaluateGivenExpression(Expression expression) {
        List<Operand> operands = expression.operandList();
        List<Operator> operators = expression.operatorList();
        return evaluateBasedOn(operands.iterator(), operators.iterator());
    }

    private Expression formNewExpression(Expression expression) {
        int innerExpressionValue = evaluate(new Expression(expression.innerMostSubExpressionRepresentation()));
        String newExpressionRepresentation = expression.leftSubExpressionRepresentationUntilInnerMostOpenParentheses()
                + innerExpressionValue
                + expression.rightSubExpressionRepresentationFromInnerRightParentheses();
        return new Expression(newExpressionRepresentation);
    }

    private int evaluateBasedOn(Iterator<Operand> operands, Iterator<Operator> operators) {
        if (!operands.hasNext()) {
            return DEFAULT_EXPRESSION_VALUE;
        }
        evaluateUsingStacksBasedOn(operands, operators);
        return operandStack.peek().value();
    }

    private void evaluateUsingStacksBasedOn(Iterator<Operand> operands, Iterator<Operator> operators) {
        operandStack.push(operands.next());
        while (operands.hasNext()) {
            Operator currentOperator = operators.next();
            doOperationByComparingStackOperatorWithCurrentOperator(currentOperator);
            operandStack.push(operands.next());
            operatorStack.push(currentOperator);
        }
        doArithmeticOperationsAsLongAsOperatorsAreInOperatorStack();
    }

    private void doOperationByComparingStackOperatorWithCurrentOperator(Operator currentOperator) {
        while (isStackOperatorHasHigherPrecedenceThanCurrentOperator(currentOperator)) {
            doArithmeticOperation();
        }
    }

    private void doArithmeticOperationsAsLongAsOperatorsAreInOperatorStack() {
        while (!operatorStack.empty()) {
            doArithmeticOperation();
        }
    }

    private void doArithmeticOperation() {
        Operand firstOperand = operandStack.pop();
        Operand secondOperand = operandStack.pop();
        BinaryOperation operation = binaryOperationFactory.getOperation(operatorStack.pop(), secondOperand, firstOperand);
        operandStack.push(operation.evaluate());
    }

    private boolean isStackOperatorHasHigherPrecedenceThanCurrentOperator(Operator currentOperator) {
        if (operatorStack.empty()) {
            return false;
        }
        Operator stackTopOperator = operatorStack.peek();
        Precedence stackTopOperatorPrecedence = this.operatorPrecedenceFactory.getPrecedence(stackTopOperator);
        Precedence currentOperatorPrecedence = this.operatorPrecedenceFactory.getPrecedence(currentOperator);
        return stackTopOperatorPrecedence.hasHigherThan(currentOperatorPrecedence);
    }

}
