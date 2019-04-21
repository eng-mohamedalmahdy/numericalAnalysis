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
import javax.swing.JButton;
import javax.swing.JTextField;
import mathexpressionparser.Operation;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

/**
 *
 * @author Mohamed
 */
public class IterationMethod extends EquationsPanel {
    
    JTextField equation;
    TextArea result;
    JButton solve;
    
    public IterationMethod() {
        super();
        equation = super.equationField;
        result = super.result;
        solve = super.input.jbcalculate;
        solve.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String equationString = equation.getText();
                result.setText(equationString);
            }
        });
        
    }
    
    @Override
    protected String solve(String equation) {
        StringBuilder sb = new StringBuilder();
        double result = 0;
        try {
            while (true) {
                double testNumber = HelpingMethods.generateDouble();
                AbstractTreeBuilder tree = new AbstractTreeBuilder(equation.toLowerCase());
                tokenizer2.AbstractTreeBuilder treeValue = new tokenizer2.AbstractTreeBuilder(equation.toLowerCase());
                Operation drev = tree.getTree().getDerivative();
                ast.Operation drevValue = treeValue.getTree();
                String drevString = drev.toString();
                double drevNumericValue = drevValue.getNumericResult(testNumber);
                if (Math.abs(drevNumericValue) < 1) {
                    sb.append(drevString).append("\n");
                    sb.append("suppose that the intial value = ").append(drevNumericValue).append("\n");
                    result = drevNumericValue;
                    break;
                }
            }
            
        } catch (TokenizerException | tokenizer2.TokenizerException ex) {
            return sb.toString();
        }
        double newRoot = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), result);
        int i = 1;
        while (true) {
            
            if (newRoot - result <= 0.0000009) {
                sb.append("hence the root equals ");
                String root = String.format("%.4f", newRoot);
                sb.append(root).append("\n");
                break;
            }
            sb.append("X").append(i).append(" = ").append(result).append("\n");
            result = newRoot;
            newRoot = HelpingMethods.calculateValue(HelpingMethods.toFuctions(equation), newRoot);
            i++;
        }
        
        return sb.toString();
    }
    
}
