package com.company;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Double> history = new ArrayList<>();
    ArrayList<Operation> operations = new ArrayList<>();

    public Calculator() {
    }

    public Boolean parseOperation(String input){
        try{
            //cleaning the input
            input = input.toLowerCase();
            input = input.trim();

            //splitting the string and checking if it
            // consists of 2 numbers and an operand
            String[] temp = input.split(" ");
            double numberOne = Double.parseDouble(temp[0]);
            double numberTwo = Double.parseDouble(temp[2]);
            char operand = temp[1].toCharArray()[0];

            //creating the operation
            Operation operation = new Operation(numberOne,numberTwo,operand);

            operations.add(operation);

            return true;
        }catch(Exception e){
            System.console().printf(e.getLocalizedMessage());
        }

        return false;
    }

    public double getResult(){
        Operation operation = operations.get(operations.size()-1);
        if(operation.resolve()) return operation.result;
        return 0;

    }


}
