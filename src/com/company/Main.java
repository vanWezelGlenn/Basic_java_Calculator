package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static Calculator calculator;
    public static ArrayList<String> tempKeypressStorage = new ArrayList<>();

    public static void main(String[] args) {
        calculator = new Calculator();
        setupGui();
    }

    /**
     * This method prepares the gui, creates a listener and adds it to all buttons.
     */
    private static void setupGui(){
        JFrame mainFrame = new JFrame();
        GridLayout mainGrid = new GridLayout();
        mainGrid.setColumns(2);
        mainGrid.setRows(1);
        mainFrame.setLayout(mainGrid);

        GridLayout grid1 = new GridLayout();
        grid1.setRows(5);
        grid1.setColumns(1);
        JPanel panel1 = new JPanel(grid1);
        GridLayout grid2 = new GridLayout();
        grid2.setRows(4);
        grid2.setColumns(3);
        JPanel panel2 = new JPanel(grid2);

        JPanel panel3 = new JPanel(new FlowLayout());

        //region defining Buttons
        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnEquals = new JButton("=");
        JButton btnDivide = new JButton("/");
        JButton btnMultiply = new JButton("X");
        JButton btnEmptySpaceLeft = new JButton("");
        JButton btnEmptySpaceRight = new JButton("");
        //endregion

        //region misc
        JTextArea txtOperationField = new JTextArea();
        txtOperationField.setLineWrap(false);
        txtOperationField.setEditable(false);

        btnEmptySpaceLeft.setVisible(false);
        btnEmptySpaceRight.setVisible(false);
        //endregion

        ActionListener jButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                if(btn.getText().equals("=")){
                    StringBuilder b = new StringBuilder();
                    for (String s :
                            tempKeypressStorage) {
                        b.append(s);
                    }
                    System.out.println(b.toString());
                    String result = parseOperationString(b.toString());
                    calculator.parseOperation(result);
                    txtOperationField.setText(String.valueOf(calculator.getResult()));
                    tempKeypressStorage.clear();
                }
                else{
                    tempKeypressStorage.add(btn.getText().toLowerCase());
                }
            }
            //region helper methods
            private String parseOperationString(String s) {
                //gebruik split om te zien of er spaties staan tussen de cijfers en de operators anders voeg ze toe
                //en return de string.
                StringBuilder subdivisions = new StringBuilder();
                String[] operation = s.split("");
                StringBuilder b = new StringBuilder();
                for(int i = 0; i < operation.length; i++)
                {
                    if (isNumeric(operation[i]) || operation[i].equals(".") || operation[i].equals(",")){ //if the given substring is a number, a coma or a point (enlgish vs european system) then append it.
                        b.append(operation[i]);
                    }
                    else{ // if it is not numeric or a comma, then it would be an operand (+ - * / or =), as such it needs to be subdivided
                        subdivisions.append(b.toString()); // add the number
                        subdivisions.append(" "); // add the blank space
                        subdivisions.append(operation[i]); // add the operand
                        subdivisions.append(" "); //add the blank space in front of the next number, in case there is no more number this will be trimmed elsewhere.
                        b = new StringBuilder();
                    }
                    if(i == operation.length - 1){ // if it is the last item, it must be added no matter what
                        subdivisions.append(b.toString());
                    }
                }
                return subdivisions.toString();
            }

            private boolean isNumeric(String s){
                if(s == null || s.equals("")){
                    return false;
                }
                return s.chars().allMatch(Character::isDigit);
            }
        };

        //region adding listeners
        btn0.addActionListener(jButtonListener);
        btn1.addActionListener(jButtonListener);
        btn2.addActionListener(jButtonListener);
        btn3.addActionListener(jButtonListener);
        btn4.addActionListener(jButtonListener);
        btn5.addActionListener(jButtonListener);
        btn6.addActionListener(jButtonListener);
        btn7.addActionListener(jButtonListener);
        btn8.addActionListener(jButtonListener);
        btn9.addActionListener(jButtonListener);
        btnMinus.addActionListener(jButtonListener);
        btnPlus.addActionListener(jButtonListener);
        btnMultiply.addActionListener(jButtonListener);
        btnDivide.addActionListener(jButtonListener);
        btnEquals.addActionListener(jButtonListener);
        //endregion

        //region adding the buttons
        panel1.add(btnPlus);
        panel1.add(btnMinus);
        panel1.add(btnMultiply);
        panel1.add(btnDivide);
        panel1.add(btnEquals);

        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);
        panel2.add(btn4);
        panel2.add(btn5);
        panel2.add(btn6);
        panel2.add(btn7);
        panel2.add(btn8);
        panel2.add(btn9);
        panel2.add(btnEmptySpaceLeft);
        panel2.add(btn0);
        panel2.add(btnEmptySpaceRight);

        panel3.add(txtOperationField);
        //endregion

        //region adding panes and packing the mainframe
        panel1.setBorder(new EmptyBorder(3,3,3,3));
        mainFrame.getContentPane().add(panel2, BorderLayout.CENTER);
        mainFrame.getContentPane().add(panel1, BorderLayout.EAST);
        mainFrame.getContentPane().add(panel3,BorderLayout.NORTH);


        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //endregion
    }
}
