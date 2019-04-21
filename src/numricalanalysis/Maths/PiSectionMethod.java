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
public class PiSectionMethod extends EquationsPanel {

    JButton solve = super.input.jbcalculate;
    JTextField input = super.equationField;
    TextArea result = super.result;
    double x1;
    double x0;

    public PiSectionMethod() {
        super();
        solve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(solve(equationField.getText()));
            }
        });
    }

    private void getTerms() {
        String equation = input.getText();
        x0 = HelpingMethods.generateDouble();
        x1 = HelpingMethods.generateDouble();
        while (true) {
            LinkedList<String> list = HelpingMethods.toFuctions(equation);
            double test = HelpingMethods.calculateValue(list, x1);

            if (test > 0) {
                break;
            }
            x1 = HelpingMethods.generateDouble();

        }
        while (true) {
            LinkedList<String> list = HelpingMethods.toFuctions(equation);
            double test = HelpingMethods.calculateValue(list, x0);

            if (test < 0) {
                break;
            }
            x0 = HelpingMethods.generateDouble();

        }

    }

    @Override
    protected String solve(String equation) {
        double avr = 0;
        getTerms();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 1;
        while (true) {
            double average = (x1 + x0) / 2;
            LinkedList functions = HelpingMethods.toFuctions(equation);
            double equationValue = HelpingMethods.calculateValue(functions, average);
            double subtraction = Math.abs(x0 - x1);
            result.append("Let the x").append(i).append(" = ").append(x0).append(" and x").append(j).append(" = ").append(x1).append("\n");
            result.append("Then the average equals ").append(average).append("\n");
            result.append("Then the equation value = ").append(equationValue).append("\n");
            result.append("____________________________________________________________\n");
            if (subtraction < 0.00009) {
                break;
            }
            if (Double.toString(equationValue).startsWith("0.0000")) {
                break;
            } else if (equationValue > 0) {
                x1 = average;
                j++;
                avr = average;

            } else {
                x0 = average;
                avr = average;
                i++;
            }

        }
        String formatedAverage = String.format("%.4f", avr);

        result.append("Hence, the root is ").append(formatedAverage).append(" correct to four decimal places.\n");
        return result.toString();
    }

}
