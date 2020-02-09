package com.company;

public class Operation {
    public final double numberOne;
    public final double numberTwo;

    public final char operator;

    public  double result;

    public Operation(double numberOne, double numberTwo, char operator) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operator = operator;
    }

    public boolean resolve(){
        boolean succesful = false;
        switch (operator){
            case '+':
                result = numberOne + numberTwo;
                succesful = true;
                break;

            case '-':
                result = numberOne - numberTwo;
                succesful = true;
                break;

            case '/':
                result = numberOne / numberTwo;
                succesful = true;
                break;

            case ':':
                result = numberOne / numberTwo;
                succesful = true;
                break;

            case 'x':
                result = numberOne * numberTwo;
                succesful = true;
                break;

            case '*':
                result = numberOne * numberTwo;
                succesful = true;
                break;

            case '%':
                result = numberOne % numberTwo;
                succesful = true;
                break;

            default:
                break;
        }

        return succesful;
    }
}
