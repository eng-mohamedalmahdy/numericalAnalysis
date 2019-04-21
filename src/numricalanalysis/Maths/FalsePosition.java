/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numricalanalysis.Maths;

import guicomponents.EquationsPanel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed
 */
public class FalsePosition extends EquationsPanel {

    JButton solve = super.input.jbcalculate;
    JTextField input = super.equationField;
    TextArea result = super.result;
    double x1;
    double x0;
    double result0;
    double result1;

    public FalsePosition() {
        super();
        solve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getTerms();
                result.setText(solve(equationField.getText()));
            }
        });
    }

    @Override
    protected String solve(String equation) {
        double avr = 0;
        System.out.println("hi");
        System.out.println("x0 = " + x0);
        System.out.println("x1 = " + x1);
        System.out.println("result0 = " + result0);
        System.out.println("result1 = " + result1);
        //X*3+sin(X)-e^(X)
        StringBuilder resultBuilder = new StringBuilder();
        System.out.println("builder l = " + resultBuilder.length());
        int i = 0;
        int j = 1;
        int z = 0;
        while (true) {
            z++;
            System.out.println("z = " + z);
            System.out.println("hi im in the loop");
            double newValue;
            System.out.println("x0 = " + x0);
            System.out.println("x1 = " + x1);
            System.out.println("result0 = " + result0);
            System.out.println("result1 = " + result1);
            if (result1 - result0 != 0) {
                newValue = ((x0 * result1) - (x1 * result0)) / (result1 - result0);
                System.out.println("new value = " + newValue);
            } else {
                break;
            }

            LinkedList functions = HelpingMethods.toFuctions(equation);
            double equationValue = HelpingMethods.calculateValue(functions, newValue);
            System.out.println("equation value = " + equationValue);
            double subtraction = Math.abs(x0 - x1);
            resultBuilder.append("Let the x").append(i).append(" = ").append(x0).append(" and x").append(j).append(" = ").append(x1).append("\n");
            resultBuilder.append("Then the root equals ").append(newValue).append("\n");
            resultBuilder.append("Then the equation value = ").append(equationValue).append("\n");
            resultBuilder.append("____________________________________________________________\n");
            if (subtraction < 0.00009) {
                break;
            }
            if (Double.toString(equationValue).startsWith("0.0000")) {
                break;
            } else if (equationValue > 0) {
                x1 = newValue;
                result1 = equationValue;
                j++;
                avr = newValue;

            } else {
                x0 = newValue;
                result0 = equationValue;
                avr = newValue;
                i++;
            }
            if (z > 20) {
                return "";
            }
        }
        String formatedAverage = String.format("%.4f", x0);
        resultBuilder.append("Hence, the root is ").append(formatedAverage).append(" correct to four decimal places.\n");
        return resultBuilder.toString();

    }

    private void getTerms() {
        String equation = input.getText();
        if (HelpingMethods.generateDouble(equation)[0] > 0) {
            x1 = HelpingMethods.generateDouble(equation)[0];
            x0 = HelpingMethods.generateDouble(equation)[1];
            result1 = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), x1);
            result0 = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), x0);

        }else{
            if (HelpingMethods.generateDouble(equation)[1] > 0) {
            x1 = HelpingMethods.generateDouble(equation)[1];
            x0 = HelpingMethods.generateDouble(equation)[0];
            result1 = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), x1);
            result0 = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), x0);
        }

    }

    }}
