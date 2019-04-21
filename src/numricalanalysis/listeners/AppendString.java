/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numricalanalysis.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed
 */
public class AppendString implements ActionListener {

    JTextField equ;
    

    public AppendString(JTextField equ) {
        this.equ = equ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();
        String s = temp.getText();
        equ.setText(equ.getText() + s);
    }

}
