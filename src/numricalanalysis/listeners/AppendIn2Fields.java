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
public class AppendIn2Fields implements ActionListener {

    JTextField first;
    JTextField second;
    static boolean up;

    public AppendIn2Fields(JTextField first, JTextField second, boolean up) {
        this.first = first;
        this.second = second;
        this.up = up;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
